package frc.robot.subsystems.tankdrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import static frc.robot.Constants.DriveConstants.*;

public class TankDriveIOSparkMax implements TankDriveIO {
  private final CANSparkMax leftLeader;
  private final CANSparkMax rightLeader;
  private final CANSparkMax leftFollower;
  private final CANSparkMax rightFollower;

  public TankDriveIOSparkMax() {
    leftLeader = new CANSparkMax(LEFT_MOTOR_1_ID, MotorType.kBrushed);
    rightLeader = new CANSparkMax(RIGHT_MOTOR_1_ID, MotorType.kBrushed);
    leftFollower = new CANSparkMax(LEFT_MOTOR_2_ID, MotorType.kBrushed);
    rightFollower = new CANSparkMax(RIGHT_MOTOR_2_ID, MotorType.kBrushed);

    leftLeader.restoreFactoryDefaults();
    rightLeader.restoreFactoryDefaults();
    leftFollower.restoreFactoryDefaults();
    rightFollower.restoreFactoryDefaults();

    leftLeader.setInverted(true);
    rightLeader.setInverted(false);
    leftFollower.follow(leftLeader, false);
    rightFollower.follow(rightLeader, false);

    leftLeader.enableVoltageCompensation(12.0);
    rightLeader.enableVoltageCompensation(12.0);

    leftLeader.burnFlash();
    rightLeader.burnFlash();
    leftFollower.burnFlash();
    rightFollower.burnFlash();
  }

  @Override
  public void updateInputs(TankDriveIOInputs inputs) {

  }

  @Override
  public void setVoltage(double leftVolts, double rightVolts) {
    leftLeader.setVoltage(leftVolts);
    rightLeader.setVoltage(rightVolts);
  }
}
