package edu.jaguarbots.stronghold.commands.intake;

import edu.jaguarbots.stronghold.commands.CommandBase;

/**
 * Moves the intake arm to the middle
 */
public class IntakeMiddle extends CommandBase
{
    public IntakeMiddle()
    {
        requires(intakeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        intakeSubsystem.intakeArmMiddle();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return true;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    }
}