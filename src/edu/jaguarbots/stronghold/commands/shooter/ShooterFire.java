package edu.jaguarbots.stronghold.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.jaguarbots.stronghold.commands.CommandBase;

public class ShooterFire extends CommandBase

{

    /**
     * its the boolean variable that ends this command
     */
    private boolean end;
    /**
     * shoots the ball and rewenches the shooter
     */
    public ShooterFire()
    {
        requires(shooterSubsystem);
    }
    @Override
    protected void initialize()
    {
        shooterSubsystem.startMotor();
        Timer.delay(.1);
    }
    
    @Override
    protected void execute()
    {
        end = shooterSubsystem.wenchMotor();    
    }    

    @Override
    protected boolean isFinished()
    {
        return end;
    }
    
    @Override
    protected void end()
    {
        // TODO Auto-generated method stub
        
    }   

    @Override
    protected void interrupted()
    {
        // TODO Auto-generated method stub
        
    }
}
