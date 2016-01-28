package edu.jaguarbots.stronghold.subsystems;

import edu.jaguarbots.stronghold.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for the mechanism to scale the castle in end game
 * 
 * @author Cody Moose
 * @since 2016
 * @version 2016
 */
public class ClimberSubsystem extends Subsystem
{
    private Relay    climberMotor = new Relay(RobotMap.pwmClimberMotor);
    private Solenoid climberSol   = new Solenoid(RobotMap.pwmClimberSol);
    private DigitalInput climberLimit = new DigitalInput(RobotMap.climberLimitSwitch);

    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    /**
     * Makes motor able to start running
     */
    public void initMotor()
    {
        climberMotor.startLiveWindowMode();
    }
    
    /**
     * Gets the value of the limit switch for the climbing mechanism
     * @return limit switch value
     */
    public boolean getLimit()
    {
        return climberLimit.get();
    }

    /**
     * Makes climber motor turn forward
     */
    public void motorForward()
    {
        climberMotor.set(Value.kForward);
        // TODO find out which direction is forward and which is backward
    }

    /**
     * Makes motor stop running
     */
    public void stopMotor()
    {
        climberMotor.stopMotor();
        climberMotor.stopLiveWindowMode();
    }

    /**
     * Makes climber motor turn backward
     */
    public void motorBackward()
    {
        climberMotor.set(Value.kReverse);
        // TODO find out which direction is forward and which is backward
    }

    /**
     * Extends climbing solenoid for reaching
     */
    public void solUp()
    {
        climberSol.set(true);
    }

    /**
     * Retracts climbing solenoid
     */
    public void solDown() // tentative, mechanical structure may not allow this
                          // to occur
    {
        climberSol.set(false);
    }
}
