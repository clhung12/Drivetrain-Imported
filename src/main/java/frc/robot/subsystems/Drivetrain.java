// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  
  private TalonSRX topLeft;
  private TalonSRX topRight;
  private TalonSRX bottomLeft;
  private TalonSRX bottomRight;
  

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    topLeft = new TalonSRX(19);
    topRight = new TalonSRX(16);
    bottomLeft = new TalonSRX(7);
    bottomRight = new TalonSRX(61);
    

  }

  public void runForward(double axis)
  {
    double speed = Math.abs(axis)*0.5;
    setRight(speed);
    setLeft(speed);
  }

  public void runBackward(double axis)
  {
    double speed = -Math.abs(axis)*0.5;
    setRight(speed);
    setLeft(speed);
  }
  
  /*
  public void turnLeft(double axis)
  {
    double speed = Math.abs(axis)*0.5;
    setRight(-speed);
    setLeft(speed);
  }

  public void turnLeft(double axis)
  {
    double speed = Math.abs(axis)*0.5;
    setRight(speed);
    setLeft(-speed);
  }
  */

  public void setRight(double speed)
  {
    setSpeed(topRight, speed*0.5);
    setSpeed(bottomRight, speed*0.5);
  }
  public void setLeft(double speed)
  {
    setSpeed(topLeft, speed*0.5);
    setSpeed(bottomLeft, speed*0.5);
  }

  public void stop()
  {
    setRight(0);
    setLeft(0);
  }

  public void setSpeed(TalonSRX motor, double speed){
    motor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
