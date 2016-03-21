package edu.jaguarbots.stronghold.commands.vision;

import edu.jaguarbots.stronghold.commands.CommandBase;

/**
 *
 */
public class AimVertical extends CommandBase
{
    private boolean up;
    private boolean down;
    private double xDistance;
    private double[] target;
    public AimVertical()
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
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
        xDistance = target[0];
        xDistance = visionSubsystem.getTargetXDistance(target);
        up = visionSubsystem.aimUp(xDistance);
        down = visionSubsystem.aimDown(xDistance);
//        if(up == true)
//        {
//            driveSubsystem.driveAdjusted(.4, .4);
//        }
//        if(down == true)
//        {
//            driveSubsystem.driveAdjusted(-.4, -.4);
//        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return !up && !down;
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
