package edu.jaguarbots.stronghold.commands.intake;

import edu.jaguarbots.stronghold.commands.CommandBase;

/**
 * Spins the intake motor so that a ball can be pulled in
 */
public class Intake extends CommandBase
{
    public Intake()
    {
        requires(intakeSubsystem);
        requires(shooterSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        intakeSubsystem.intakeMotorForward();
        shooterSubsystem.takeInBall();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return true;//!oi.Manipulator_L1.get();
    }

    // Called once after isFinished returns true
    protected void end()
    {
        intakeSubsystem.stopIntakeMotor();
        shooterSubsystem.stopShooter();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
        intakeSubsystem.stopIntakeMotor();
    }
}
