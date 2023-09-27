package frc.robot.subsystems.intake;

import static frc.robot.Constants.DriveConstants.*;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeIOSPX implements IntakeIO {
    private final VictorSPX rightMotor;
    private final VictorSPX leftMotor;

    private double speed;

    public IntakeIOSPX () {
        rightMotor = new VictorSPX(RIGHT_INTAKE_ID);
        leftMotor = new VictorSPX(LEFT_INTAKE_ID);
        speed = 0;
    }

    @Override
    public void updateInputs(IntakeIOInputs inputs) {
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
        SmartDashboard.putNumber("Intake Speed", this.speed);
        this.speed = SmartDashboard.getNumber("Intake Speed", 0.0);

        rightMotor.set(VictorSPXControlMode.PercentOutput, this.speed);
        leftMotor.set(VictorSPXControlMode.PercentOutput, this.speed);
    }

    @Override
    public double getSpeed() {
        return speed;
    }

}
