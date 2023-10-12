package frc.robot.subsystems.pneumatics;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.pneumatics.PneumaticsIO.PneumaticsIOInputs;

public class Pneumatics extends SubsystemBase {

    public final PneumaticsIO io;
    public final PneumaticsIOInputsAutoLogged inputs = new PneumaticsIOInputsAutoLogged();

    public Pneumatics(PneumaticsIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.getInstance().processInputs("Pneumatics", inputs);
        io.updateVars();
    }

    public void setSolenoid(DoubleSolenoid.Value v) {
        io.setSolenoidState(v);
    }

    public DoubleSolenoid.Value getSolenoidState() {
        return io.getSolenoidState();
    }

    public boolean isCompressorEnabled() {
        return io.isCompressorEnabled();
    }

    public boolean isPressureSwitch() {
        return io.isPressureSwitch();
    }

    public double getCompressorCurrent() {
        return io.getCompressorCurrent();
    }

}
