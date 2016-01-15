package edu.jaguarbots.stronghold.commands.drive;

import edu.jaguarbots.stronghold.commands.CommandBase;

/**
 *
 */
public class DriveTank extends CommandBase
{
    public DriveTank()
    {
        requires(driveSubsystem);
    }

    double left;
    double right;
    // Called just before this Command runs the first time
    protected void initialize()
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        left = oi.leftStick.getY();
        right = oi.rightStick.getY();
        driveSubsystem.driveTank(left, right);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
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
