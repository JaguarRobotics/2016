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
    private double[] adjustedDrive = null;
    private double leftEncoderValue;
    private double rightEncoderValue;
    private double[] encoderValues = {leftEncoderValue, rightEncoderValue};
    
    public double[] getEncoder()
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
    
    public double[] driveAdjusted(double left, double right)
    {
        double leftEnc = leftEncoder.getRaw();
        double rightEnc = rightEncoder.getRaw();
        double delta = leftEnc - rightEnc;
        if(delta >= 0)
        {
            left = left*.8;
        }
        else if(delta <= 0)
        {
            right = right*.8;
        }
        adjustedDrive = new double[] {left, right};
        return adjustedDrive;
    }
    
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
