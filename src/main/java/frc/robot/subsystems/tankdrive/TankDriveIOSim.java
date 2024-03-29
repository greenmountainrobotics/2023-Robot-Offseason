package frc.robot.subsystems.tankdrive;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;

public class TankDriveIOSim implements TankDriveIO {
  private DifferentialDrivetrainSim sim = DifferentialDrivetrainSim.createKitbotSim(KitbotMotor.kDualCIMPerSide,
      KitbotGearing.k10p71, KitbotWheelSize.kSixInch, null);

  @Override
  public void updateInputs(TankDriveIOInputs inputs) {
    sim.update(0.02);
    inputs.leftPositionRad = sim.getLeftPositionMeters() / TankDrive.WHEEL_RADIUS_METERS;
    inputs.leftVelocityRadPerSec = sim.getLeftVelocityMetersPerSecond() / TankDrive.WHEEL_RADIUS_METERS;
    inputs.rightPositionRad = sim.getRightPositionMeters() / TankDrive.WHEEL_RADIUS_METERS;
    inputs.rightVelocityRadPerSec = sim.getRightVelocityMetersPerSecond() / TankDrive.WHEEL_RADIUS_METERS;
    inputs.gyroYawRad = sim.getHeading().getRadians() * -1;
  }

  @Override
  public void setVoltage(double leftVolts, double rightVolts) {
    sim.setInputs(MathUtil.clamp(leftVolts, -12.0, 12.0), MathUtil.clamp(rightVolts, -12.0, 12.0));
  }
}
