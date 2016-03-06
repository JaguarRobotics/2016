package edu.jaguarbots.stronghold.commands.shooter;

import edu.jaguarbots.stronghold.commands.CommandBase;

/**
 *
 */
public class ShooterControl extends CommandBase {

    public ShooterControl() {
    	requires(shooterSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(oi.Manipulator.getTrigger()){
    		shooterSubsystem.FireShooter();
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
