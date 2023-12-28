package frc.robot.subsystems.tankdrive;

import org.littletonrobotics.junction.AutoLog;

public interface TankDriveIO {
  @AutoLog
  public static class TankDriveIOInputs {
    public double leftPositionRad = 0.0;
    public double leftVelocityRadPerSec = 0.0;
    public double rightPositionRad = 0.0;
    public double rightVelocityRadPerSec = 0.0;
    public double gyroYawRad = 0.0;
  }

  /** Updates the set of loggable inputs. */
  public default void updateInputs(TankDriveIOInputs inputs) {
  }

  /** Run open loop at the specified voltage. */
  public default void setVoltage(double leftVolts, double rightVolts) {
  }
}
