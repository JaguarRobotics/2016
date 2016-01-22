package edu.jaguarbots.stronghold;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    // pwms
    // all of the pwms with numbers in the 500s are temporary because we don't
    // know those numbers yet
    public static final int leftDrive              = 0;
    public static final int rightDrive             = 1;
    public static final int pwmIntakeMotor         = 500;
    public static final int pwmIntakePositionMotor = 501;
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
    public static final int pwmShooterMotor        = 502;
    // temporary pwm value you can change if you want
    public static final int pwmClimberMotor        = 503;
    // temporary pwm value you can change if you want
    public static final int pwmShooterSol          = 504;
    // temporary pwm value you can change if you want
    public static final int pwmClimberSol          = 505;
    public static final int digitalIOGyro          = 506;
    // temporary pwm value you can change if you want
    // digital ios
    public static final int leftEncoderAChannel    = 0;
    public static final int leftEncoderBChannel    = 1;
    public static final int rightEncoderAChannel   = 2;
    public static final int rightEncoderBChannel   = 3;
    public static final int intakePositionEncoderAChannel    = 4;
    public static final int intakePositionEncoderBChannel    = 4;
    // joysticks
    public static final int leftStick              = 0;
    public static final int rightStick             = 1;
    public static final int manipulator            = 2;
    public static final int dioShooterWench        = 3;
}
