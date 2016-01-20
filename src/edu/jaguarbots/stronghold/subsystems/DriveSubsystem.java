package edu.jaguarbots.stronghold.subsystems;

import edu.jaguarbots.stronghold.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem
{
    private Victor leftDrive = new Victor(RobotMap.leftDrive);    
    private Victor rightDrive = new Victor(RobotMap.rightDrive);
    private RobotDrive robotDrive = new RobotDrive(leftDrive, rightDrive);
    private Encoder leftEncoder = new Encoder(RobotMap.leftEncoderAChannel, RobotMap.leftEncoderBChannel);
    private Encoder rightEncoder = new Encoder(RobotMap.rightEncoderAChannel, RobotMap.rightEncoderBChannel);
    private double leftEncoderValue;
    private double rightEncoderValue;
    private double[] encoderValues = {leftEncoderValue, rightEncoderValue};
    private double bias = 1;
    private double constant = .2;
    private boolean inAdjustedDrive = false;
    
    public void resetEncoders(boolean left, boolean right)
    {
        if (left)
            leftEncoder.reset();
        if (right)
            rightEncoder.reset();
    }
    
    public void startEncoders()
    {
    } 
    
    public double[] getEncoders()
    {
        leftEncoderValue = leftEncoder.getDistance();
        rightEncoderValue = rightEncoder.getDistance();
        encoderValues = new double[] {leftEncoderValue, rightEncoderValue};
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
        if(delta > 0)  //if left is faster than right
        {
            bias = Math.abs((rightEnc/(leftEnc + delta))); //adjust bias
            left = left*bias;   //reduce left power
        }
        else if(delta < 0) //if right is faster than left
        {
            bias = Math.abs((leftEnc/(rightEnc - delta))); //adjust bias
            right = right*bias; //if left is faster than right
        }
        robotDrive.tankDrive(left, right);
    }
    
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
