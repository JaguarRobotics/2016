package edu.jaguarbots.stronghold.subsystems;

import edu.jaguarbots.stronghold.RobotMap;
import edu.jaguarbots.stronghold.commands.drive.DriveTank;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem
{
    private static Victor     leftDrive       = new Victor(RobotMap.leftDrive);
    private static Victor     rightDrive      = new Victor(RobotMap.rightDrive);
    private static RobotDrive robotDrive      = new RobotDrive(leftDrive, rightDrive);
    private Encoder           leftEncoder     = new Encoder(RobotMap.leftEncoderAChannel, RobotMap.leftEncoderBChannel);
    private Encoder           rightEncoder    = new Encoder(RobotMap.rightEncoderAChannel,
                    RobotMap.rightEncoderBChannel);
    private double            leftEncoderValue;
    private double            rightEncoderValue;
    private double[]          encoderValues   = { leftEncoderValue, rightEncoderValue };
    private double            bias            = 1;
    private boolean           inAdjustedDrive = false;
    private double            diameter        = 21; // TODO change to diameter of pulleys
    private static AnalogGyro gyro            = new AnalogGyro(RobotMap.gyro);
    private static Solenoid   gearSol         = new Solenoid(RobotMap.pwmGearSol);
    private double            leftMotorSpeed;
    private double            rightMotorSpeed;

    public double[] getMotorPowers()
    {
        double[] powers = new double[2];
        double lastLeftMotorSpeed = leftMotorSpeed;
        double lastRightMotorSpeed = rightMotorSpeed;
        double lastLeftEncoder = leftEncoderValue;
        double lastRightEncoder = rightEncoderValue;
        getEncoders();
        leftMotorSpeed = rightMotorSpeed = powers[0] = powers[1] = 1;
        double estimatedLeft = (leftEncoderValue - lastLeftEncoder) / lastLeftMotorSpeed;
        double estimatedRight = (rightEncoderValue - lastRightEncoder) / lastRightMotorSpeed;
        if (leftEncoderValue > rightEncoderValue)
        {
            powers[0] = leftMotorSpeed = rightEncoderValue / leftEncoderValue + estimatedRight / estimatedLeft - 1;
        }
        else if (leftEncoderValue < rightEncoderValue)
        {
            powers[1] = rightMotorSpeed = leftEncoderValue / rightEncoderValue + estimatedLeft / estimatedRight - 1;
        }
        return powers;
    }

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

    public void robotTurn(double speed)
    {
        robotDrive.tankDrive(-speed, speed);
    }

    public void robotStop()
    {
        robotDrive.tankDrive(0, 0);
    }

    public void gyroTurnToAngle(double angle, double speed)
    {
        if (angle < 0)
        {
            if (gyro.getAngle() > angle)
            {
                robotTurn(-speed);
            }
        }
        else if (angle > 0)
        {
            if (gyro.getAngle() < angle)
            {
                robotTurn(speed);
            }
        }
        robotStop();
    }

    public double getGyro()
    {
        return gyro.getAngle();
    }

    public void initDefaultCommand()
    {
        setDefaultCommand(new DriveTank());
    }

    public double getEncoderLeft()
    {
        return leftEncoder.getDistance();
    }

    public double getEncoderRight()
    {
        return rightEncoder.getDistance();
    }

    public static boolean getGearShift()
    {
        return gearSol.get();
    }

    public static void gearShiftOut()
    {
        gearSol.set(true);
    }

    public static void gearShiftIn()
    {
        gearSol.set(false);
    }
}
