package frc.robot.subsystems.imu;

import org.littletonrobotics.junction.AutoLog;

public interface ImuIO {
    @AutoLog
    public static class ImuIOInputs {
    }

    public default void updateInputs(ImuIOInputs inputs) {
    }

    public default double getRoll() {
        return 0.0;
    }

    public default double getYaw() {
        return 0.0;
    }

    public default double getPitch() {
        return 0.0;
    }

    public default void reset() {
    }
}
