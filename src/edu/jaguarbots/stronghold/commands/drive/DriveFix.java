package edu.jaguarbots.stronghold.commands.drive;

import edu.jaguarbots.stronghold.commands.CommandBase;
import edu.jaguarbots.stronghold.subsystems.DriveSubsystem;

/**
 * Takes robot angle before doing something, and realigns robot afterwards
 * @author Cody Moose
 * @version 2016
 * @since 2016
 *
 */
public class DriveFix extends CommandBase
{
    private double startAngle;
    public DriveFix(double startAngle)
    {
        requires(driveSubsystem);

        this.startAngle = startAngle;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        DriveSubsystem.gyroTurnToAngle(startAngle);

        if(DriveSubsystem.gyroGetAngle() == startAngle)
            isFinished();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return (DriveSubsystem.gyroGetAngle() == startAngle);
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
