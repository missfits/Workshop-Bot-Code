/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

public class DriveTime extends TimedCommand {

  public DriveTime(double timeout) {
    super(timeout);
    requires(Robot.driveTrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.driveTrain.drive(0.5,0.5);
  }

  @Override
  protected void end() {
    Robot.driveTrain.stopDrive();
  }

  @Override
  protected void interrupted() {
    Robot.driveTrain.stopDrive();
  }
}
