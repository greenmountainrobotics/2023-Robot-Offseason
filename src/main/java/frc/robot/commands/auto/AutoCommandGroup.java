package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.imu.Imu;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.tankdrive.Drive;

public class AutoCommandGroup extends SequentialCommandGroup {

    public AutoCommandGroup(Imu imu, Drive tank, Intake intake, double startpoint) {
        addCommands(
                new InstantCommand(imu::reset, imu),
                new AutoScoreCommand(intake, tank),
                new AutoMoveToChargeCommand(imu, tank),
                new AutoMovePastChargeCommand(imu, tank, startpoint).withTimeout(4),
                new WaitCommand(0.5),
                new InstantCommand(imu::reset, imu),
                new AutoMoveBackToChargeCommand(imu, tank),
                new AutoBalanceCommand(imu, tank, startpoint));
    }
}
