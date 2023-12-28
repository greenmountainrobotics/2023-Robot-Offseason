package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.imu.Imu;
import frc.robot.subsystems.tankdrive.Drive;

import static frc.robot.Constants.AutoConstants.ANGLESTOP;


public class AutoMovePastChargeCommand extends CommandBase {
    private final Imu iMUSubsystem;
    private final Drive tankDriveSubsystem;
    private double initialAngle;
    private int count;

    public AutoMovePastChargeCommand(Imu iMUSubsystem, Drive tankDriveSubsystem, double startpoint) {
        this.iMUSubsystem = iMUSubsystem;
        this.tankDriveSubsystem = tankDriveSubsystem;
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.iMUSubsystem, this.tankDriveSubsystem);
        initialAngle = startpoint;
        count = 0;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        tankDriveSubsystem.drivePercent(0.3, 0.3);
        if (iMUSubsystem.getRoll() < initialAngle + 3 && iMUSubsystem.getRoll() > initialAngle - 3) {
            count++;
        } else {
            count = 0;
        };
        SmartDashboard.putNumber("count", count);
    }

    @Override
    public boolean isFinished() {
        return count > 15;
    }

    @Override
    public void end(boolean interrupted) {
        tankDriveSubsystem.drivePercent(0.0, 0.0);
        SmartDashboard.putBoolean("AutoMoveToCharge", false);
    }
}
