package edu.jaguarbots.stronghold.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.jaguarbots.stronghold.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
    
    private DigitalInput intakeMotor = new DigitalInput(RobotMap.pwmIntakeMotor);
    
    public void startMotor()
    {
        intakeMotor.startLiveWindowMode();
    }

    public void stopMotor()
    {
        intakeMotor.stopLiveWindowMode();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

