
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.pneumatics.Pneumatics;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import static frc.robot.Constants.DriveConstants.*;

public class IntakeCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Intake intake;
    private final CommandXboxController controller;
    private final Pneumatics pneumatics;

    public IntakeCommand(Intake intake, CommandXboxController controller, Pneumatics pneumatics) {
        this.intake = intake;
        this.controller = controller;
        this.pneumatics = pneumatics;
        addRequirements(intake, pneumatics);
    }

    @Override
    public void initialize() {
        SmartDashboard.putNumber("Max Speed Intake (dashboard)", 0.4);
        SmartDashboard.putNumber("Max Speed Outtake (dashboard)", 0.8);

    }


    private double getOutMaxSpeed() {
        /*
         * return ((-joystick.getRawAxis(3) + 1) / 2)
         */
        return MAX_SPEED_INTAKE
                * (controller.a().getAsBoolean()
                        || pneumatics.getSolenoidState() == DoubleSolenoid.Value.kForward ? 1.0 : 0.4)
                * SmartDashboard.getNumber("Max Speed Outtake (dashboard)", 1.0);
    }

    private double getInMaxSpeed() {
        /*
         * return ((-joystick.getRawAxis(3) + 1) / 2)
         */
        return MAX_SPEED_INTAKE
                * 0.4
                * SmartDashboard.getNumber("Max Speed Intake (dashboard)", 1.0);
    }

    private double powerCurve(double input) {
        return (input > 0 ? 1 : -1) *
                input * input;
    }

    @Override
    public void execute() {
        var controllerY = controller.getLeftY();
        if (controller.y().getAsBoolean()) {
            pneumatics.setSolenoid(DoubleSolenoid.Value.kForward);
        }
        else {
            pneumatics.setSolenoid(DoubleSolenoid.Value.kReverse);
        }

        SmartDashboard.putNumber("controller", controllerY);

        if (Math.abs(controllerY) < 0.5) {
            intake.setSpeed(0);
            return;
        }

        var speed = (controllerY > 0 ? getInMaxSpeed() : getOutMaxSpeed()) *
                powerCurve(controllerY);

        intake.setSpeed(speed);
    }
}
