package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class PneumaticsIOSim implements PneumaticsIO {
    
    public void updateInputs(PneumaticsIOInputs inputs) {
    }

    public void setSolenoidState(DoubleSolenoid.Value solenoidState) {
    }

    public DoubleSolenoid.Value getSolenoidState() {
        return DoubleSolenoid.Value.kOff;
    }

    public boolean isCompressorEnabled() {
        return false;
    }

    public boolean isPressureSwitch() {
        return false;
    }

    public double getCompressorCurrent() {
        return 0.0f;
    }

    public void updateVars() {
    }
}
