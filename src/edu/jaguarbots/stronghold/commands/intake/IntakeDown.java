package edu.jaguarbots.stronghold.commands.intake;

import edu.jaguarbots.stronghold.commands.CommandBase;

/**
 * Moves the intake arm down
 */
public class IntakeDown extends CommandBase
{
    public IntakeDown()
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
        intakeSubsystem.positionMotorDown();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return intakeSubsystem.getPositionEncoderValue() <= intakeSubsystem.getBottomPosition();
    }

    // Called once after isFinished returns true
    protected void end()
    {
        intakeSubsystem.stopPositionMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
        intakeSubsystem.stopPositionMotor();
    }
}
