/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveDistance extends Command {
  double initialDist, goalDist, currentDist;

  public DriveDistance(double inches) {
    requires(Robot.driveTrain);
    goalDist = inches;
  }

  @Override
  protected void initialize() {
    initialDist = Robot.driveTrain.getLeftPosition();
  }

  @Override
  protected void execute() {
    Robot.driveTrain.drive(0.5, 0.5);
    currentDist = Robot.driveTrain.getLeftPosition() - initialDist;
  }

  @Override
  protected boolean isFinished() {
    return currentDist >= goalDist;
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
