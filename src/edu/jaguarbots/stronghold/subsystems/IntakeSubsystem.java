package edu.jaguarbots.stronghold.subsystems;

import edu.jaguarbots.stronghold.RobotMap;
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
    private Victor intakeMotor = new Victor(RobotMap.pwmIntakeMotor);
    private Relay positionMotor = new Relay(RobotMap.pwmIntakePositionMotor);

    /*
     * Constructor for IntakeSubsytem
     */
    public IntakeSubsystem()
    {
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
        positionMotor.set(Relay.Value.kForward);
    }

    /*
     * runs the position motor in the opposite direction of the default direction
     */
    public void positionMotorDown()
    {
        positionMotor.set(Relay.Value.kReverse);
    }
    
    /*
     * stops the position motor
     */
    public void stopPositionMotor()
    {
        positionMotor.set(Relay.Value.kOff);
    }
    
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
