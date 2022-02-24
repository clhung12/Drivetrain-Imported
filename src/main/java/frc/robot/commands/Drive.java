// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {

  private Drivetrain drivetrain;
  private Joystick joy;
  private int right;
  private int left;

  /** Creates a new DriveForward. */
  public Drive(Drivetrain driveIn, Joystick joyIn, int rightIn, int leftIn) {
    // Use addRequirements() here to declare subsystem dependencies.
    drivetrain = driveIn;

    joy = joyIn;
    right = rightIn;
    left = leftIn;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    while(joy.getRawAxis(right) == 0 && joy.getRawAxis(left) == 0)
    {
      drivetrain.setLeft(joy.getRawAxis(right));
      drivetrain.setRight(joy.getRawAxis(left));
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return joy.getRawAxis(right) == 0 && joy.getRawAxis(left) == 0;
  }
}
