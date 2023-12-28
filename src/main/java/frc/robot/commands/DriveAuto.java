package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import frc.robot.subsystems.tankdrive.TankDrive;

public class DriveAuto extends SequentialCommandGroup {
  private static final double drivePercent = 0.5;
  private static final double driveDuration = 3.0;

  /**
   * Creates a new DriveAuto, which drives forward for three seconds.
   */
  public DriveAuto(TankDrive drive) {
    addCommands(
        new StartEndCommand(() -> drive.drivePercent(drivePercent, drivePercent), drive::stop, drive)
            .withTimeout(driveDuration)
    );
  }
}
