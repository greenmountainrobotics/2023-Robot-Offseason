package frc.robot.subsystems.imu;

public class ImuIOSim implements ImuIO {
    @Override
    public void updateInputs(ImuIOInputs inputs) {
    }

    @Override
    public double getRoll() {
        return 0.0;
    }

    @Override
    public double getYaw() {
        return 0.0;
    }

    @Override
    public double getPitch() {
        return 0.0;
    }

    @Override
    public void reset() {
    }
}
