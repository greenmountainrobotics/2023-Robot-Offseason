package frc.robot.subsystems.drive;

import com.ctre.phoenix.sensors.Pigeon2;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.util.Units;

import static frc.robot.Constants.DriveConstants.*;

public class DriveIOSparkMax implements DriveIO {
  private final CANSparkMax leftLeader;
  private final CANSparkMax rightLeader;
  private final CANSparkMax leftFollower;
  private final CANSparkMax rightFollower;

  public DriveIOSparkMax() {
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
  public void updateInputs(DriveIOInputs inputs) {

  }

  @Override
  public void setVoltage(double leftVolts, double rightVolts) {
    leftLeader.setVoltage(leftVolts);
    rightLeader.setVoltage(rightVolts);
  }
}
