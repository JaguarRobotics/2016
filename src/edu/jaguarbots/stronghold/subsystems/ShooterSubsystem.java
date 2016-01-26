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

    public void startMotor()
    {
        shooterMotor.startLiveWindowMode();
    }

    public void stopMotor()
    {
        shooterMotor.stopLiveWindowMode();
    }

    public void solUp()
    {
        shooterSol.set(true);
    }

    public void solDown()
    {
        shooterSol.set(false);
    }
    
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

    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
