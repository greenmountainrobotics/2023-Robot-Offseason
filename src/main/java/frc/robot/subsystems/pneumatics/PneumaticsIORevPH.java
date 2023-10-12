package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import static frc.robot.Constants.DriveConstants.*;

public class PneumaticsIORevPH implements PneumaticsIO {

    public static DoubleSolenoid.Value intakeUpState = DoubleSolenoid.Value.kForward;
    public static DoubleSolenoid.Value intakeDownState = DoubleSolenoid.Value.kReverse;

    private DoubleSolenoid doubleSolenoid;

    private DoubleSolenoid.Value solenoidState;

    private Compressor phCompressor;

    private boolean compressorEnabled;
    private boolean pressureSwitch;
    private double compressorCurrent;

    public PneumaticsIORevPH() {
        doubleSolenoid = new DoubleSolenoid(PNEUMATICS_ID, PneumaticsModuleType.REVPH,
                PNEUMATICS_FORWARD_CHANNEL, PNEUMATICS_REVERSE_CHANNEL);

         phCompressor = new Compressor(PNEUMATICS_ID, PneumaticsModuleType.REVPH);

         solenoidState = intakeDownState;
    }

    @Override
    public void setSolenoidState(DoubleSolenoid.Value solenoidState) {
        this.solenoidState = solenoidState;
        doubleSolenoid.set(solenoidState);
    }

    @Override
    public DoubleSolenoid.Value getSolenoidState() {
        return solenoidState;
    }

    @Override
    public boolean isCompressorEnabled() {
        return compressorEnabled;
    }

    @Override
    public boolean isPressureSwitch() {
        return pressureSwitch;
    }

    @Override
    public double getCompressorCurrent() {
        return compressorCurrent;
    }

    @Override
    public void updateVars() {
        compressorEnabled = phCompressor.isEnabled();
        pressureSwitch = phCompressor.getPressureSwitchValue();
        compressorCurrent = phCompressor.getCurrent();

        SmartDashboard.putBoolean("intakeUp", intakeUpState == this.solenoidState);
    }
}
