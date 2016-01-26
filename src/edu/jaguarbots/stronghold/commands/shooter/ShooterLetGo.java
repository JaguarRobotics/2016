package edu.jaguarbots.stronghold.commands.shooter;

import edu.jaguarbots.stronghold.commands.CommandBase;

public class ShooterLetGo extends CommandBase
{
    boolean end;
    public ShooterLetGo()
    {
        requires(shooterSubsystem);
    }
    @Override
    protected void initialize()
    {
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
