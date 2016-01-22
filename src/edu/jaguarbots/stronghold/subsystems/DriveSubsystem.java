package edu.jaguarbots.stronghold.subsystems;

import edu.jaguarbots.stronghold.RobotMap;
import edu.jaguarbots.stronghold.commands.drive.DriveTank;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class DriveSubsystem extends Subsystem
{
    private static Victor     leftDrive       = new Victor(RobotMap.leftDrive);
    private static Victor     rightDrive      = new Victor(RobotMap.rightDrive);
    private static RobotDrive robotDrive      = new RobotDrive(leftDrive, rightDrive);
    private Encoder    leftEncoder     = new Encoder(RobotMap.leftEncoderAChannel, RobotMap.leftEncoderBChannel);
    private Encoder    rightEncoder    = new Encoder(RobotMap.rightEncoderAChannel, RobotMap.rightEncoderBChannel);
    private double     leftEncoderValue;
    private double     rightEncoderValue;
    private double[]   encoderValues   = { leftEncoderValue, rightEncoderValue };
    private double     bias            = 1;
    private boolean    inAdjustedDrive = false;
    private double     diameter        = 21;
    private static AnalogGyro gyro            = new AnalogGyro(10000);                                                    // TODO
                                                                                                                   // Add
                                                                                                                   // pwm
                                                                                                                   // or
                                                                                                                   // whatever
                                                                                                                   // for
                                                                                                                   // Gyro

    public void resetEncoders(boolean left, boolean right)
    {
        if (left) leftEncoder.reset();
        if (right) rightEncoder.reset();
    }

    public void startEncoders()
    {
        leftEncoder.setDistancePerPulse(Math.PI * diameter / 360);
        rightEncoder.setDistancePerPulse(Math.PI * diameter / 360);
    }

    public double[] getEncoders()
    {
        leftEncoderValue = leftEncoder.getDistance();
        rightEncoderValue = rightEncoder.getDistance();
        encoderValues = new double[] { leftEncoderValue, rightEncoderValue };
        return encoderValues;
    }

    public void driveTank(double left, double right)
    {
        if (Math.abs(left) == 1 && Math.abs(right) == 1 && left == right)
        {
            if (!inAdjustedDrive)
            {
                inAdjustedDrive = true;
                resetEncoders(true, true);
                // reset encoders
            }
            driveAdjusted(left, right);
        }
        else
        {
            inAdjustedDrive = false;
            robotDrive.tankDrive(left, right);
        }
    }

    public void driveAdjusted(double left, double right)
    {
        double leftEnc = leftEncoder.getRaw();
        double rightEnc = rightEncoder.getRaw();
        double delta = leftEnc - rightEnc;
        if (delta > 0) // if left is faster than right
        {
            bias = Math.abs((rightEnc / (leftEnc + delta))); // adjust bias
            left = left * bias; // reduce left power
        }
        else if (delta < 0) // if right is faster than left
        {
            bias = Math.abs((leftEnc / (rightEnc - delta))); // adjust bias
            right = right * bias; // if left is faster than right
        }
        robotDrive.tankDrive(left, right);
    }

    public static void robotTurn(int direction)
    {
        if (direction == -1 || direction == 1) robotDrive.tankDrive(-direction, direction);
        // direction = -1: left turn
        // direction = 1: right turn
    }

    public static void robotStop()
    {
        robotDrive.tankDrive(0, 0);
    }
    
    public static double gyroGetAngle(){
        return gyro.getAngle();
    }

    public static void gyroTurnToAngle(double angle)
    {
        if (angle < 0)
        {
            while (gyro.getAngle() > angle)
            {
                robotTurn(-1);
            }
        }
        else if (angle > 0)
        {
            while (gyro.getAngle() < angle)
            {
                robotTurn(1);
            }
        }
        robotStop();
    }
    
    public static void gyroTurn(double turnAmount)
    {
        double toAngle = gyro.getAngle() + turnAmount;
        gyroTurnToAngle(toAngle);
    }

    public void initDefaultCommand()
    {
        setDefaultCommand(new DriveTank());
    }
}
