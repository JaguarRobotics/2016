package edu.jaguarbots.stronghold.subsystems;

import edu.jaguarbots.stronghold.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem
{
    private Talon leftDrive = new Talon(RobotMap.leftDrive);    
    private Talon rightDrive = new Talon(RobotMap.rightDrive);
    private RobotDrive robotDrive = new RobotDrive(leftDrive, rightDrive);
    private Encoder leftEncoder = new Encoder(RobotMap.leftEncoderAChannel, RobotMap.leftEncoderBChannel);
    private Encoder rightEncoder = new Encoder(RobotMap.rightEncoderAChannel, RobotMap.rightEncoderBChannel);
    private double leftEncoderValue;
    private double rightEncoderValue;
    private double[] encoderValues = {leftEncoderValue, rightEncoderValue};
    private double bias = 1;
    private double constant = .2;
    
    public void resetEncoders(boolean left, boolean right)
    {
        if (left)
            leftEncoder.reset();
        if (right)
            rightEncoder.reset();
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
        robotDrive.tankDrive(left, right);
    }
    
    public void driveAdjusted(double left, double right)
    {
        resetEncoders(true, true);
        double leftEnc = leftEncoder.getRaw();
        double rightEnc = rightEncoder.getRaw();
        double delta = leftEnc - rightEnc;
        if(delta >= 0)  //if left is faster than right
        {
            bias = Math.abs((rightEnc/leftEnc) - constant); //adjust bias
            left = left*bias;   //reduce left power
        }
        else if(delta <= 0) //if right is faster than left
        {
            bias = Math.abs((leftEnc/rightEnc) - constant); //adjust bias
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
