package edu.jaguarbots.stronghold.commands.shooter;

import edu.jaguarbots.stronghold.commands.CommandBase;


public class ShooterUp extends CommandBase
{
    /**
     * moves the shooter up
     */
    public ShooterUp()
    {
        requires(shooterSubsystem);
    }

    @Override
    protected void initialize()
    {
        shooterSubsystem.ShooterAngleUp();
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
