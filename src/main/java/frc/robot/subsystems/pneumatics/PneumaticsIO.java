package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.littletonrobotics.junction.AutoLog;

public interface PneumaticsIO {
    @AutoLog
    public static class PneumaticsIOInputs {
    }

    /** Updates the set of loggable inputs. */
    public default void updateInputs(PneumaticsIOInputs inputs) {
    }

    public default void setSolenoidState(DoubleSolenoid.Value solenoidState) {
    }

    public default DoubleSolenoid.Value getSolenoidState() {
        return DoubleSolenoid.Value.kOff;
    }

    public default boolean isCompressorEnabled() {
        return false;
    }

    public default boolean isPressureSwitch() {
        return false;
    }

    public default double getCompressorCurrent() {
        return 0.0f;
    }

    public default void updateVars() {
    }
}
