package edu.jaguarbots.stronghold.commands.shooter;

import edu.jaguarbots.stronghold.commands.CommandBase;

public class ShooterLetGo extends CommandBase
{
    private double wait;
    public ShooterLetGo()
    {
        requires(shooterSubsystem);
        this.wait =0.1;
    }
    @Override
    protected void initialize()
    {
        shooterSubsystem.shootFinal(wait);
    }
    
    @Override
    protected void execute()
    {
        // TODO Auto-generated method stub
        
    }    
    
    @Override
    protected boolean isFinished()
    {
        return true;
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
