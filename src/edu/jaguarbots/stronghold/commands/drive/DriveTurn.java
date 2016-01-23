package edu.jaguarbots.stronghold.commands.drive;

import edu.jaguarbots.stronghold.commands.CommandBase;
import edu.jaguarbots.stronghold.subsystems.DriveSubsystem;

/**
 * Turns robot a specified angle left or right. Negative angles turn left.
 * 
 * @author Cody Moose
 * @version 2016
 * @since 2016
 */
public class DriveTurn extends CommandBase
{
    private double turnAmount;
    private double angle;

    /**
     * Turns robot a specified angle left or right.
     * 
     * @param turnAmount
     *            Angle to turn. Negative values cause a left turn.
     */
    public DriveTurn(double turnAmount)
    {
        requires(driveSubsystem);
        this.turnAmount = turnAmount;
    }

    @Override
    protected void initialize()
    {
        angle = turnAmount + driveSubsystem.getGyro();
    }

    @Override
    protected void execute()
    {
        if(turnAmount>0)
            driveSubsystem.robotTurn(.7);
        if(turnAmount<0)
            driveSubsystem.robotTurn(-.7);
    }

    @Override
    protected boolean isFinished()
    {
        return driveSubsystem.getGyro()>=turnAmount;
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
