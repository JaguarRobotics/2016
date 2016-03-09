package edu.jaguarbots.stronghold.commands.intake;

import edu.jaguarbots.stronghold.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class IntakeUDControl extends CommandBase {

    double direction;
    boolean on = false;
    double state;
    Timer timer = new Timer();
    
    public IntakeUDControl() {
        requires(climberSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
        direction = oi.Manipulator.getY();
        if(direction > 0.7){
            new IntakeBottom();
        } else if(direction < -0.7){
            new IntakeTop();
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
