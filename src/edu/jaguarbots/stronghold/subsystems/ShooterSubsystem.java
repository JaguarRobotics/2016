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
    // private DigitalInput shooter = new DigitalInput(
    // RobotMap.pwmShooterMotor);
    /**
     * its the shooter motor
     */
    private Victor       shooterMotor     = new Victor(RobotMap.pwmShooterMotor);

    /**
     * its the solenoid
     */
    //
    private Solenoid     shooterPushSol   = new Solenoid(RobotMap.solShooter);
    private Solenoid     shooterSolAngle   = new Solenoid(RobotMap.solShooterAngle);
    /**
     * its the solenoid
     */
    //private Solenoid     shooterSolFire   = new Solenoid(RobotMap.pwmShooterSol);
//    /**
//     * its the limit switch for the shooter
//     */
//    private DigitalInput limitSwitch  = new DigitalInput(
//                    RobotMap.shooterLimitSwitch);

    /**
     * starts the motor for shooting
     */
    public void startShooter()
    {
        shooterMotor.set(-1);
    }

    /**
     * stops the motor for shooting
     */
    public void stopShooter()
    {
        shooterMotor.set(0);
    }

    public void takeInBall()
    {
        shooterMotor.set(0.5);
    }
    /**
     * moves the Solenoid up to a 45 degree angle
     */
    public void solShoot()
    {
        shooterPushSol.set(true);
    }

    /**
     * moves the Solenoid down allowing it to shoot into the low goal
     */
    public void solDontShoot()
    {
        shooterPushSol.set(false);
    }

    public void ShooterAngleUp()
    {
    	shooterSolAngle.set(true);
    }
    
    public void ShooterAngleDown()
    {
    	shooterSolAngle.set(false);
    }
    /**
     * starts shooting and wenches it back until it his a limit switch
     * 
     * @return false when the shooter is not at the limit switch return true
     *         when the shooter is at the limit switch
     */
//    public boolean wenchMotor()
//    {
//        if (limitSwitch.get() == false)
//        {
//            startMotor();
//            return false;
//        }
//        else
//        {
//            stopMotor();
//            return true;
//        }
//    }

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