package edu.jaguarbots.stronghold.commands.vision;

import edu.jaguarbots.stronghold.commands.CommandBase;

/**
 *
 */
public class AimHorizontal extends CommandBase
{
    private boolean left;
    private boolean right;
    private double horizDistance;
    private double[] target;
    public AimHorizontal()
    {
        requires(visionSubsystem);
        requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        target = visionSubsystem.getLeftTarget();
        horizDistance = target[1];
        left = visionSubsystem.aimLeft(horizDistance);
        right = visionSubsystem.aimRight(horizDistance);
        if(left == true)
        {
            driveSubsystem.driveAdjusted(-.4, .4);
        }
        if(right == true)
        {
            driveSubsystem.driveAdjusted(.4, -.4);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return !left && !right;
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
