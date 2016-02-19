package edu.jaguarbots.stronghold.subsystems;

import edu.jaguarbots.stronghold.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * this is the shooter subsystem class, it contains methods for shooter
 */
public class ShooterSubsystem extends Subsystem
{
    /**
     * its the shooter left motor
     */
    private Victor       shooterMotorLeft     = new Victor(RobotMap.pwmShooterMotorRight);
    /**
     * its the shooter right motor
     */
    private Victor       shooterMotorRight     = new Victor(RobotMap.pwmShooterMotorLeft);

    /**
     * its the shooter firing solenoid
     */
    private Solenoid     shooterPushSol   = new Solenoid(RobotMap.solShooter);
    /**
     * its the shooter angle solenoid
     */
    private Solenoid     shooterSolAngle   = new Solenoid(RobotMap.solShooterAngle);
    
    private double intakeSpeed = -.25;
    /**
     * starts the motors for shooting
     */
    public void startShooter()
    {
        shooterMotorRight.set(1);
        shooterMotorLeft.set(1);
    }

    /**
     * stops the shooting motors
     */
    public void stopShooter()
    {
        shooterMotorRight.set(0);
        shooterMotorRight.set(0);
    }

    /**
     * stops the shooting motors
     */
    public void takeInBall()
    {
        shooterMotorRight.set(intakeSpeed);
        shooterMotorRight.set(intakeSpeed);
    }
    /**
     * moves the Solenoid that actually shoots the ball
     */
    public void solShoot()
    {
        shooterPushSol.set(true);
    }

    /**
     * moves the Solenoid that actually shoots the ball back to a non-shooting postion
     */
    public void solDontShoot()
    {
        shooterPushSol.set(false);
    }
    /**
     * moves the Solenoid up to a 45 degree angle
     */
    public void ShooterAngleUp()
    {
    	shooterSolAngle.set(true);
    }
    /**
     * moves the Solenoid down allowing it to shoot into the low goal
     */
    public void ShooterAngleDown()
    {
    	shooterSolAngle.set(false);
    }

    /**
     * it does nothing its the default command
     */
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
//