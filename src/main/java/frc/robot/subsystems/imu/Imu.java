package frc.robot.subsystems.imu;

import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Imu extends SubsystemBase {
    private final ImuIO io;
    private final ImuIOInputsAutoLogged inputs = new ImuIOInputsAutoLogged();

    public Imu(ImuIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.getInstance().processInputs("IMU", inputs);
        
    }

    public double getRoll() {
        return io.getRoll();
    }

    public double getYaw() {
        return io.getYaw();
    }

    public double getPitch() {
        return io.getPitch();
    }

    public void reset() {
        io.reset();
    }
}
