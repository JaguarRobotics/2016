package edu.jaguarbots.stronghold.subsystems;

import edu.jaguarbots.stronghold.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Intake subsystem is designed to manipulate the roller-arm attached to the
 * robot
 * 
 * @author Nathan Gawith
 * @since 2016
 * @version 2016
 */
public class IntakeSubsystem extends Subsystem
{
    /**
     * This is the motor controller for the intake motor
     */
    private Victor   intakeMotor = new Victor(RobotMap.pwmIntakeMotor);
    /**
     * This is the first motor controller for the position of the intake
     * mechanism
     */
    private Solenoid intakeSol1  = new Solenoid(RobotMap.solIntakeShort);
    /**
     * This is the second motor controller for the position of the intake
     * mechanism
     */
    private Solenoid intakeSol2  = new Solenoid(RobotMap.solIntakeLong);

    /**
     * Constructor for IntakeSubsytem
     */
    public IntakeSubsystem()
    {
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
    /*
     * public void topReset() { topPosition = getPositionEncoderValue();
     * bottomPosition = Math.abs(topPosition - bottomPosition); // TODO Math //
     * appears to // be faulty, // should be // looked over // - could // return
     * // positive // value when // needed value // is negative
     * resetPositionEncoder(); stopPositionMotor(); }
     */

    /**
     * Moves the intake arm to the bottom
     */
    public void intakeArmBottom()
    {
        intakeSol1.set(false);
        intakeSol2.set(false);
    }
    
    /**
     * Moves the intake arm to the middle
     */
    public void intakeArmMiddle()
    {
        intakeSol1.set(true);
        intakeSol2.set(false);
    }

    /**
     * Moves the intake arm to the top
     */
    public void intakeArmTop()
    {
        intakeSol1.set(true);
        intakeSol2.set(true);
    }

    /**
     * Nothing is in initDefauldCommand
     */
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
//