package edu.jaguarbots.stronghold;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
	//pwms
    public static final int leftDrive              = 0;
    public static final int rightDrive             = 1;
    public static final int pwmIntakeMotor         = 3;
    public static final int pwmShooterMotorRight        = 4;
    public static final int pwmShooterMotorLeft        = 5;

    //relays
    public static final int relayClimberMotor        = 1;
    
    public static final int solIntakeShort = 1;
    public static final int solIntakeLong = 2;
    public static final int solShooterAngle          = 3;
    public static final int solGearShift = 4;
    public static final int solClimber          = 5;
    public static final int solShooter          = 6;

    // digital ios
    public static final int leftEncoderAChannel    = 0;
    public static final int leftEncoderBChannel    = 1;
    public static final int rightEncoderAChannel   = 2;
    public static final int rightEncoderBChannel   = 3;
    public static final int intakePositionEncoderAChannel    = 4;
    public static final int intakePositionEncoderBChannel    = 5;
    public static final int climberLimitSwitch = 7;

    //spi
    public static final int gyro = 0;

    // joysticks
    public static final int leftStick              = 0;
    public static final int rightStick             = 1;
    public static final int manipulator            = 2;
    public static final int dioShooterWench        = 3;
}
