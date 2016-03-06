package edu.jaguarbots.stronghold.commands.shooter;

//import java.util.Date;

import edu.jaguarbots.stronghold.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

public class ShooterFire extends CommandBase

{
    int state = 0;
    Timer timer = new Timer();
    
    /**
     * its the boolean variable that ends this command
     */
//    private boolean end;
    /**
     * shoots the ball and rewenches the shooter
     */
    public ShooterFire()
    {
        requires(shooterSubsystem);
    }

    protected void initialize()
    {
        shooterSubsystem.startShooter();
        state = 1;
        timer.start();
    }
    
    protected void execute()
    {
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
    }    

    protected boolean isFinished()
    {
        return state == 4;
    }
    
    protected void end()
    {
       shooterSubsystem.stopShooter();
       shooterSubsystem.solDontShoot(); 
       timer.stop();
       timer.reset();
    }   

    protected void interrupted()
    {
    }
}
