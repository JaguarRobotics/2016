package edu.jaguarbots.stronghold.subsystems;

import edu.jaguarbots.stronghold.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for the climbing mechanism
 * @author Cody Moose
 * @since 2016
 */
public class ClimberSubsystem extends Subsystem
{
    private DigitalInput climber = new DigitalInput(RobotMap.pwmClimberMotor);

    @Override
    protected void initDefaultCommand()
    {
        // TODO Auto-generated method stub
    }
}
