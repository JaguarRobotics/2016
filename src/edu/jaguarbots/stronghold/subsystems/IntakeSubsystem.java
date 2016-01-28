package edu.jaguarbots.stronghold.subsystems;

import edu.jaguarbots.stronghold.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Intake subsystem is designed to manipulate the roller-arm attached to the robot
 * 
 * @author Nathan Gawith
 * @since 2016
 * @version 2016
 * 
 */
public class IntakeSubsystem extends Subsystem
{
    private Victor       intakeMotor     = new Victor(RobotMap.pwmIntakeMotor);
    private Relay        positionMotor   = new Relay(RobotMap.pwmIntakePositionMotor);
    private Encoder      positionEncoder = new Encoder(RobotMap.intakePositionEncoderAChannel,
                    RobotMap.intakePositionEncoderBChannel);
    private DigitalInput limitSwitch     = new DigitalInput(RobotMap.intakeLimitSwitch);
    private int          bottomPosition;
    private int          topPosition;

    /**
     * Constructor for IntakeSubsytem
     */
    public IntakeSubsystem()
    {
        bottomPosition = getPositionEncoderValue();
    }

    /**
     * Runs the intake motor in the default direction
     */
    public void intakeMotorForward()
    {
        intakeMotor.set(1);
    }

    /**
     * Runs the intake motor in the opposite direction of the default direction
     */
    public void intakeMotorBackward()
    {
        intakeMotor.set(-1);
    }

    /**
     * Stops the intake motor
     */
    public void stopIntakeMotor()
    {
        intakeMotor.set(0);
    }
    
    /**
     * Resets the top and bottom positions
     */
    public void topReset()
    {
        topPosition = getPositionEncoderValue();
        bottomPosition = Math.abs(topPosition - bottomPosition); // TODO Math
                                                                 // appears to
                                                                 // be faulty,
                                                                 // should be
                                                                 // looked over
                                                                 // - could
                                                                 // return
                                                                 // positive
                                                                 // value when
                                                                 // needed value
                                                                 // is negative
        resetPositionEncoder();
        stopPositionMotor();
    }
    
    /**
     * Runs the position motor in the default direction
     */
    public void positionMotorUp()
    {
        positionMotor.set(Relay.Value.kForward);
    }
    
    /**
     * Runs the position motor in the opposite direction of the default
     * direction
     */
    public void positionMotorDown()
    {
        positionMotor.set(Relay.Value.kReverse);
    }
    
    /**
     * Returns the bottom position
     */
    public double getBottomPosition()
    {
        return bottomPosition;
    }
    
    /**
     * Returns the top position
     */
    public double getTopPosition()
    {
        return topPosition;
    }

    /**
     * Returns the limit switch value (boolean)
     */
    public boolean getLimitSwitch()
    {
        return limitSwitch.get();
    }

    /**
     * stops the position motor
     */
    public void stopPositionMotor()
    {
        positionMotor.set(Relay.Value.kOff);
    }

    /**
     * resets the position encoder
     */
    public void resetPositionEncoder()
    {
        positionEncoder.reset();
    }

    /**
     * gets the position encoder value
     */
    public int getPositionEncoderValue()
    {
        return positionEncoder.get();
    }

    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
