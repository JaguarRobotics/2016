package edu.jaguarbots.stronghold.commands.climber;

import edu.jaguarbots.stronghold.commands.CommandBase;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * Retracts the climbing winch
 * @author Cody Moose
 * @since 2016
 */
public class Ascend extends CommandBase
{
//    TODO Add code for limit switch
    public Ascend()
    {
        requires(climberSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
        climberSubsystem.initMotor();
        climberSubsystem.motorForward();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return true; //climberSubsystem.getLimit() || oi.Manipulator.getY(Hand.kLeft) >= .7;
//        TODO add limit switch integration
    }

    // Called once after isFinished returns true
    protected void end()
    {
        climberSubsystem.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    }
}
