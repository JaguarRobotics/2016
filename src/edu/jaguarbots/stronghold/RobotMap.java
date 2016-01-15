package edu.jaguarbots.stronghold;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
//  pwms
    public static final int leftDrive = 0;
    public static final int rightDrive = 1;
    public static final int pwmIntakeMotor = 500;
    
//  digital ios
    public static final int leftEncoderAChannel = 0;
    public static final int leftEncoderBChannel = 1;
    public static final int rightEncoderAChannel = 2;
    public static final int rightEncoderBChannel = 3;
    public static final int iDontKnowIfINeedADigitalIOThingForTheIntakeMechanism = 500;
    
//  joysticks
    public static final int leftStick = 0;
    public static final int rightStick = 1;
    public static final int manipulator = 2;
}
