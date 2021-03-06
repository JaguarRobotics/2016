package edu.jaguarbots.stronghold.commands.drive;

import edu.jaguarbots.stronghold.commands.CommandBase;
import edu.jaguarbots.stronghold.subsystems.DriveSubsystem;

/**
 *
 */
public class GearShiftLow extends CommandBase {

    public GearShiftLow() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	DriveSubsystem.gearShiftIn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
