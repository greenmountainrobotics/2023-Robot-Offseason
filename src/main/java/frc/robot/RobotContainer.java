
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.DriveAuto;
import org.littletonrobotics.junction.networktables.LoggedDashboardChooser;
import org.littletonrobotics.junction.networktables.LoggedDashboardNumber;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.drive.*;
import frc.robot.subsystems.intake.*;
import frc.robot.subsystems.imu.*;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Subsystems
  private final Drive drive;
  private final Intake intake;
  private final Imu imu;

  // Controller
  private final CommandXboxController joystick = new CommandXboxController(0);

  // Dashboard inputs
  private final LoggedDashboardChooser<Command> autoChooser = new LoggedDashboardChooser<>("Auto Choices");
  private final LoggedDashboardNumber flywheelSpeedInput = new LoggedDashboardNumber("Flywheel Speed", 1500.0);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    switch (Constants.currentMode) {
      // Real robot, instantiate hardware IO implementations
      case REAL:
        drive = new Drive(new DriveIOSparkMax());
        intake = new Intake(new IntakeIOSPX());
        imu = new imu(new ImuIOAHRS());
        // drive = new Drive(new DriveIOFalcon500());
        // flywheel = new Flywheel(new FlywheelIOFalcon500());
        break;

      // Sim robot, instantiate physics sim IO implementations
      case SIM:
        drive = new Drive(new DriveIOSim());
        intake = new Intake(new IntakeIOSim());
        imu = new imu(new ImuIOSim());
        break;

      // Replayed robot, disable IO implementations
      default:
        drive = new Drive(new DriveIO() {
        });
        intake = new Intake(new IntakeIO() {
        });
        imu = new imu(new ImuIO() {
        });

        break;
    }

    drive.setDefaultCommand(new ParallelCommandGroup(new JoystickDriveCommand(drive, joystick), new IntakeCommand(intake, joystick)));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
      if (SmartDashboard.getBoolean("Auto", true))
          return new AutoCommandGroup(imu, drive, intake, imu.getRoll());
      else
          //    return new AutoScoreCommand(intaksubsystem, robotDrive);
          //return new NewBalanceCommand(imu, robotDrive, roll);
          return new SequentialCommandGroup(new AutoScoreCommand(intaksubsystem, robotDrive), new RunCommand(() -> robotDrive.setSpeed(0.3, 0.3), robotDrive).withTimeout(3.5));  }
}
