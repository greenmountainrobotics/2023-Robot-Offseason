package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.imu.Imu;
import frc.robot.subsystems.tankdrive.Drive;

import static frc.robot.Constants.AutoConstants.ANGLESTOP;


public class AutoMoveBackToChargeCommand extends CommandBase {
    private final Imu iMUSubsystem;
    private final Drive tankDriveSubsystem;
    private double initialAngle;

    public AutoMoveBackToChargeCommand(Imu iMUSubsystem, Drive tankDriveSubsystem) {
        this.iMUSubsystem = iMUSubsystem;
        this.tankDriveSubsystem = tankDriveSubsystem;
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.iMUSubsystem, this.tankDriveSubsystem);
    }

    @Override
    public void initialize() {
        initialAngle = iMUSubsystem.getRoll();
    }

    @Override
    public void execute() {
        tankDriveSubsystem.drivePercent(-0.5, -0.5);
    }

    @Override
    public boolean isFinished() {
        return iMUSubsystem.getRoll() > initialAngle + ANGLESTOP;
    }

    @Override
    public void end(boolean interrupted) {
        tankDriveSubsystem.drivePercent(0.0, 0.0);
        SmartDashboard.putBoolean("AutoMoveToCharge", false);
    }
}
