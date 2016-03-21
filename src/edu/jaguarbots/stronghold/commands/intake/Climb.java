package edu.jaguarbots.stronghold.commands.intake;

import edu.jaguarbots.stronghold.commands.CommandBase;
//
///**
// * Drives the robot in teleop based on left and right joystick inputs.
// */
//public class Climb extends CommandBase
//{
//    public Climb()
//    {
//        requires(climberSubsystem);
//    }
//
//    double climb;
//
//    // Called just before this Command runs the first time
//    protected void initialize()
//    {
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute()
//    {
//        climb = oi.Manipulator.getPOV();
//        climberSubsystem.ascendDescend(climb);
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished()
//    {
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end()
//    {
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted()
//    {
//    }
//}
