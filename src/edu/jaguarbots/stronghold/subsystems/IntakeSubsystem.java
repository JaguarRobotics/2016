package edu.jaguarbots.stronghold.subsystems;

import edu.jaguarbots.stronghold.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
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
    /**
     * This is the motor controller for the intake motor
     */
    private Victor       intakeMotor     = new Victor(RobotMap.pwmIntakeMotor);
    
    private Solenoid    intakeSol1 = new Solenoid(RobotMap.pwmIntakeSol1);
    
    private Solenoid    intakeSol2 = new Solenoid(RobotMap.pwmIntakeSol2);
    
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
    
//    /**
//     * Resets the top and bottom positions
//     */
//    public void topReset()
//    {
//        topPosition = getPositionEncoderValue();
//        bottomPosition = Math.abs(topPosition - bottomPosition); // TODO Math
//                                                                 // appears to
//                                                                 // be faulty,
//                                                                 // should be
//                                                                 // looked over
//                                                                 // - could
//                                                                 // return
//                                                                 // positive
//                                                                 // value when
//                                                                 // needed value
//                                                                 // is negative
//        resetPositionEncoder();
//        stopPositionMotor();
//    }
    
    public void intakeArmBottom()
    {
        intakeSol1.set(false);
        intakeSol2.set(false);
    }
    
    public void intakeArmMiddle(){
        intakeSol1.set(true);
        intakeSol2.set(false);
    }
    
    public void intakeArmTop()
    {
        intakeSol1.set(true);
        intakeSol2.set(true);
    }
    
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
