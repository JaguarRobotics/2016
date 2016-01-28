package edu.jaguarbots.stronghold.subsystems;

import edu.jaguarbots.stronghold.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem
{
    // private DigitalInput shooter = new DigitalInput(
    // RobotMap.pwmShooterMotor);
    private DigitalInput shooterMotor = new DigitalInput(
                    RobotMap.pwmShooterMotor);
    private Solenoid     shooterSol   = new Solenoid(RobotMap.pwmShooterSol);
    private DigitalInput limitSwitch = new DigitalInput(RobotMap.shooterLimitSwitch);
/**
 * starts the motor for shooting
 */
    public void startMotor()
    {
        shooterMotor.startLiveWindowMode();
    }

    /**
     * stops the motor for shooting
     */
    public void stopMotor()
    {
        shooterMotor.stopLiveWindowMode();
    }

    /**
     * moves the Solenoid up to a 45 degree angle
     */
    public void solUp()
    {
        shooterSol.set(true);
    }

    /**
     * moves the Solenoid down allowing it to shoot into the low goal
     */
    public void solDown()
    {
        shooterSol.set(false);
    }
    
    /**
     * starts shooting and wenches it back until it his a limit switch 
     * @return false when the shooter is not at the limit switch 
     * return true when the shooter is at the limit switch
     */
    public boolean wenchMotor()
    {
        if (limitSwitch.get() == false)
        {
            startMotor();
            return false;
        }else{
        stopMotor();
        return true;
        }
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
