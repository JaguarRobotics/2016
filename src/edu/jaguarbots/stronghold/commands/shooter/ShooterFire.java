package edu.jaguarbots.stronghold.commands.shooter;

import edu.jaguarbots.stronghold.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

public class ShooterFire extends CommandBase

{

    /**
     * shoots the ball 
     */
    public ShooterFire()
    {
        requires(shooterSubsystem);
    }

    protected void initialize()
    {
        shooterSubsystem.startShooter();
		Timer.delay( .1);
        shooterSubsystem.solShoot();
        Timer.delay(.1);
    }
    
    protected void execute()
    {
    }    

    protected boolean isFinished()
    {
        return true;
    }
    
    protected void end()
    {
       shooterSubsystem.stopShooter();
       shooterSubsystem.solDontShoot(); 
    }   

    protected void interrupted()
    {
        // TODO Auto-generated method stub
        
    }
}
