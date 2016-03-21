package edu.jaguarbots.stronghold.commands.shooter;

import edu.jaguarbots.stronghold.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class ShooterControl extends CommandBase {

	double run;
	boolean on = false;
	double state;
	Timer timer = new Timer();
	
    public ShooterControl() {
    	requires(shooterSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	run = oi.Manipulator.getZ();
    	if(run < -.5)
    	{
    		on = true;
    	}
    	if(on)
    	{
    		state = 1;
            timer.start();
            if (state == 1 || state == 3)
            {
            	if (timer.get() > 2)
            	{
            		state++;
            	}
            }
            else if (state == 2)
            {
            	shooterSubsystem.solShoot();
            	state++;
            	timer.reset();
            }
            on = false;
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
