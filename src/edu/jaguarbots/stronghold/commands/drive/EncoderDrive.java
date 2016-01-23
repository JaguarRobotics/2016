package edu.jaguarbots.stronghold.commands.drive;

import edu.jaguarbots.stronghold.commands.CommandBase;

public class EncoderDrive extends CommandBase
{
    private double distance;
    private double speed = .7;
    private boolean end;
    
    public EncoderDrive(double distance)
    {
        requires(driveSubsystem);
        this.distance=distance;
        end = false;
    }
    
    public EncoderDrive(double distance, double speed)
    {
        requires(driveSubsystem);
        this.distance=distance;
        this.speed = speed;
        end = false;
    }
    protected void initialize()
    {
        driveSubsystem.startEncoders();
        driveSubsystem.resetEncoders(true, true);
        driveSubsystem.driveTank(speed, speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        if (driveSubsystem.getEncoderLeft() >= distance || driveSubsystem.getEncoderRight() >= distance)
        { 
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
        driveSubsystem.driveTank(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    }
}
