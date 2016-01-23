package edu.jaguarbots.stronghold.commands.climber;

import edu.jaguarbots.stronghold.commands.CommandBase;

/**
 * Extends the winch
 * @author Cody Moose
 * @since 2016
 */
public class Extend extends CommandBase
{
//    TODO Add code for limit switch
    public Extend()
    {
        requires(climbSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
        climbSubsystem.initMotor();
        climbSubsystem.motorBackward();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
//        TODO add limit switch integration
    }

    // Called once after isFinished returns true
    protected void end()
    {
        climbSubsystem.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    }
}
