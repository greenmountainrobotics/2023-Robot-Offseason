// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final Mode currentMode = Mode.REAL;

  public static enum Mode {
    /** Running on a real robot. */
    REAL,

    /** Running a physics simulator. */
    SIM,

    /** Replaying from a log file. */
    REPLAY
  }

  public static final class DriveConstants {
    public static final int LEFT_MOTOR_1_ID = 3;
    public static final int LEFT_MOTOR_2_ID = 4;
    public static final int RIGHT_MOTOR_1_ID = 1;
    public static final int RIGHT_MOTOR_2_ID = 2;

    public static final int RIGHT_INTAKE_ID = 5;
    public static final int LEFT_INTAKE_ID = 6;

    public static final int LEFT_SERVO_PORT = 0;
    public static final int RIGHT_SERVO_PORT = 1;

    public static final double MAX_SPEED = 1.0;
    public static final double MAX_SPEED_INTAKE = 1.0;

    public static final int PNEUMATICS_FORWARD_CHANNEL = 0;
    public static final int PNEUMATICS_REVERSE_CHANNEL = 1;

    public static final int PNEUMATICS_ID = 21;
  }

  public static final class OIConstants {
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OPERATOR_CONTROLLER_PORT = 1;
  }

 public static final class AutoConstants {
    public static final double kP = 0.02;
    public static final double kI = 0;
    public static final double kD = 0;
    public static final double AUTOROBOTSPEED = 0.23;
    public static final double ANGLESTOP = 10;
    public static final double ANGLE_ACCEPTED_ERROR = 3.0;
    public static final long MOVEMENT_TIME = 2000;
    public static final long SHOOTING_TIME = 1000;
  }
}
