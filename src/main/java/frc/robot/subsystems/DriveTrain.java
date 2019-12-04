/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.TeleopDriveTrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DriveTrain extends Subsystem {

  final TalonSRX frontLeft = new TalonSRX(0);
	final TalonSRX rearLeft = new TalonSRX(1);
	final TalonSRX frontRight = new TalonSRX(2);
  final TalonSRX rearRight = new TalonSRX(3);
  final TalonSRX centerLeft = new TalonSRX(4);
  final TalonSRX centerRight = new TalonSRX(5);

  public DriveTrain(){
    frontRight.setInverted(true);
    centerRight.setInverted(true);
    rearRight.setInverted(true);
  }

  public void drive(double lSpeed, double rSpeed){
    frontLeft.set(ControlMode.PercentOutput, lSpeed);
    rearLeft.set(ControlMode.PercentOutput, lSpeed);
    centerLeft.set(ControlMode.PercentOutput, lSpeed);
		frontRight.set(ControlMode.PercentOutput, rSpeed);
    rearRight.set(ControlMode.PercentOutput, rSpeed);
    centerRight.set(ControlMode.PercentOutput, rSpeed);
  }

  public void switchInversions(){
    frontRight.setInverted(false);
    centerRight.setInverted(false);
    rearRight.setInverted(false);

    frontLeft.setInverted(true);
    centerLeft.setInverted(true);
    rearLeft.setInverted(true);
  }

  public void stopDrive(){
    drive(0,0);
  }

  public double getLeftPosition() {
    return centerLeft.getSelectedSensorPosition()*6*Math.PI/4096;
  }

  public double getRightPosition() {
    return centerRight.getSelectedSensorPosition()*6*Math.PI/4096;
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TeleopDriveTrain());
  }
}
