
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.tankdrive.*;
import frc.robot.subsystems.imu.*;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import static frc.robot.Constants.OIConstants.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Subsystems
  private final TankDrive drive;
  private final Imu imu;

  // Controller
  private final CommandJoystick joystick = new CommandJoystick(DRIVER_CONTROLLER_PORT);
  private final CommandXboxController controller = new CommandXboxController(OPERATOR_CONTROLLER_PORT);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    switch (Constants.currentMode) {
      // Real robot, instantiate hardware IO implementations
      case REAL:
        drive = new TankDrive(new TankDriveIOSparkMax());
        imu = new Imu(new ImuIOAHRS());
        break;

      // Sim robot, instantiate physics sim IO implementations
      case SIM:
        drive = new TankDrive(new TankDriveIOSim());
        imu = new Imu(new ImuIOSim());
        break;

      // Replayed robot, disable IO implementations
      default:
        drive = new TankDrive(new TankDriveIO() {
        });
        imu = new Imu(new ImuIO() {
        });

        break;
    }
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
      if (SmartDashboard.getBoolean("Auto", true)) {
        return Commands.none();
      }
      else {
        return Commands.none();
      }
  }
}
