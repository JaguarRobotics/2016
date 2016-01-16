package edu.jaguarbots.stronghold.subsystems;

import edu.jaguarbots.stronghold.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem
{
    /*
     * the motor that sucks in the ball
     */
    private Victor intakeMotor = new Victor(RobotMap.pwmIntakeMotor);

    /*
     * Constructor for IntakeSubsytem
     */
    public IntakeSubsystem()
    {
    }

    /*
     * runs the intake motor in the default direction
     */
    public void startMotorForward()
    {
        intakeMotor.set(1);
    }

    /*
     * runs the intake motor in the opposite direction of the default direction
     */
    public void startMotorBackward()
    {
        intakeMotor.set(-1);
    }

    /*
     * stops the intake motor
     */
    public void stopMotor()
    {
        intakeMotor.set(0);
    }

    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
