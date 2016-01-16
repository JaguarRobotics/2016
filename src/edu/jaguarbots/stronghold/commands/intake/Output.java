package edu.jaguarbots.stronghold.commands.intake;

import edu.jaguarbots.stronghold.commands.CommandBase;
import edu.jaguarbots.stronghold.subsystems.IntakeSubsystem;

/**
 *
 */
public class Output extends CommandBase
{
    public Output()
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
        intakeSubsystem.startMotorBackward();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end()
    {
        intakeSubsystem.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    }
}
