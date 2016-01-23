package edu.jaguarbots.stronghold.subsystems;

import edu.jaguarbots.stronghold.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem
{
    /*
     * the motor that sucks in the ball
     */
    private Victor       intakeMotor     = new Victor(RobotMap.pwmIntakeMotor);
    private Relay        positionMotor   = new Relay(RobotMap.pwmIntakePositionMotor);
    private Encoder      positionEncoder = new Encoder(RobotMap.intakePositionEncoderAChannel,
                    RobotMap.intakePositionEncoderBChannel);
    private DigitalInput limitSwitch     = new DigitalInput(RobotMap.intakeLimitSwitch);
    private int          bottomPosition;
    private int          topPosition;

    /*
     * Constructor for IntakeSubsytem
     */
    public IntakeSubsystem()
    {
        bottomPosition = getPositionEncoderValue();
    }

    /*
     * runs the intake motor in the default direction
     */
    public void intakeMotorForward()
    {
        intakeMotor.set(1);
    }

    /*
     * runs the intake motor in the opposite direction of the default direction
     */
    public void intakeMotorBackward()
    {
        intakeMotor.set(-1);
    }

    /*
     * stops the intake motor
     */
    public void stopIntakeMotor()
    {
        intakeMotor.set(0);
    }

    /*
     * runs the position motor in the default direction
     */
    public void positionMotorUp()
    {
        if (limitSwitch.get() == true)
        {
            topPosition = getPositionEncoderValue();
            bottomPosition = Math.abs(topPosition - bottomPosition);
            resetPositionEncoder();
        }
        stopPositionMotor();
    }

    /*
     * runs the position motor in the opposite direction of the default
     * direction
     */
    public void positionMotorDown()
    {
        if (getPositionEncoderValue() == bottomPosition)
        {
            stopPositionMotor();
        }
        else
        {
            positionMotor.set(Relay.Value.kReverse);
        }
    }

    /*
     * stops the position motor
     */
    public void stopPositionMotor()
    {
        positionMotor.set(Relay.Value.kOff);
    }

    /*
     * resets the position encoder
     */
    public void resetPositionEncoder()
    {
        positionEncoder.reset();
    }

    /*
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
