package edu.jaguarbots.stronghold.subsystems;


import edu.jaguarbots.stronghold.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
    
    private DigitalInput shooter = new DigitalInput(RobotMap.pwmShooterMotor);

        private DigitalInput shooterMotor = new DigitalInput(RobotMap.pwmShooterMotor);
    private Solenoid solShooter = new Solenoid(RobotMap.pwmSolShooter);

    public void startMotor()
    {
        shooterMotor.startLiveWindowMode();
    }

    public void stopMotor()
    {
        shooterMotor.stopLiveWindowMode();
    }
    
    public void solUp ()
    {
        solShooter.set(true);
    }

    public void solDown()
    {
        solShooter.set(false);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
