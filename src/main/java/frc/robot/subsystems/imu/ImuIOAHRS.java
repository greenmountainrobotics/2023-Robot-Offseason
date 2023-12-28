package frc.robot.subsystems.imu;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

public class ImuIOAHRS implements ImuIO {
    private final AHRS ahrs;
    private long prevTime;

    private double rollZero;
    private double yawZero;
    private double pitchZero;

    public ImuIOAHRS() {
        prevTime = 0;
        ahrs = new AHRS(SPI.Port.kMXP);
        this.reset();
    }

    @Override
    public double getRoll() {
        return ahrs.getRoll() - rollZero;
    }

    @Override
    public double getYaw() {
        return ahrs.getYaw() - yawZero;
    }

    @Override
    public double getPitch() {
        return ahrs.getPitch() - pitchZero;
    }

    @Override
    public void reset() {
        rollZero = ahrs.getRoll();
        yawZero = ahrs.getYaw();
        pitchZero = ahrs.getPitch();
    }
}
