package edu.jaguarbots.stronghold.subsystems;

import edu.jaguarbots.stronghold.RobotMap;
import edu.jaguarbots.stronghold.commands.shooter.ShooterControl;
import edu.jaguarbots.stronghold.commands.shooter.ShooterFire;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * this is the shooter subsystem class, it contains methods for shooter
 */
public class ShooterSubsystem extends Subsystem
{
    private Victor       shooterMotor     = new Victor(RobotMap.pwmShooterMotor);
    private Solenoid     shooterPushSol   = new Solenoid(RobotMap.solShooter);
    private Solenoid     shooterSolAngle   = new Solenoid(RobotMap.solShooterAngle);

    public void startShooter()
    {
        shooterMotor.set(-1);
    }

    public void stopShooter()
    {
        shooterMotor.set(0);
    }

    public void takeInBall()
    {
        shooterMotor.set(0.5);
    }
    public void solShoot()
    {
        shooterPushSol.set(true);
    }

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

    public void FireShooter(){
    	new ShooterFire();
    }
    public void initDefaultCommand()
    {
    	setDefaultCommand(new ShooterControl());
    }
}
//