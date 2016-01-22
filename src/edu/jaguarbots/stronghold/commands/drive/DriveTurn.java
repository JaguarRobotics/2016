package edu.jaguarbots.stronghold.commands.drive;

import edu.jaguarbots.stronghold.commands.CommandBase;
import edu.jaguarbots.stronghold.subsystems.DriveSubsystem;

/**
 * Turns robot a specified angle left or right. Negative angles turn left.
 * @author Cody Moose
 * @version 2016
 * @since 2016
 *
 */
public class DriveTurn extends CommandBase
{
    private double turnAmount;
    
    /**
     * Turns robot a specified angle left or right.
     * @param turnAmount Angle to turn. Negative values cause a left turn.
     */
    public DriveTurn(double turnAmount){
        this.turnAmount = turnAmount;
    }

    @Override
    protected void initialize()
    {
        DriveSubsystem.gyroTurn(this.turnAmount);
        
    }

    @Override
    protected void execute()
    {
        
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void end()
    {
        
    }

    @Override
    protected void interrupted()
    {
        
    }
    
}
