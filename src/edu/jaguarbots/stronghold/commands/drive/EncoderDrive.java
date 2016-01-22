package edu.jaguarbots.stronghold.commands.drive;

import edu.jaguarbots.stronghold.commands.CommandBase;

public class EncoderDrive extends CommandBase
{
    private double distance;
    private boolean end;
    
    public EncoderDrive(double distance)
    {
        requires(driveSubsystem);
        this.distance=distance;
        end = false;
    }
    protected void initialize()
    {
        driveSubsystem.resetEncoders(true, true);
        driveSubsystem.driveTank(1, 1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        if (driveSubsystem.getEncoderLeft() < distance || driveSubsystem.getEncoderRight() < distance)
        {
            driveSubsystem.driveTank(0, 0);
            end=true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return end;
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
