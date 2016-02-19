package edu.jaguarbots.stronghold.commands;

import edu.jaguarbots.stronghold.OI;
import edu.jaguarbots.stronghold.subsystems.DriveSubsystem;
import edu.jaguarbots.stronghold.subsystems.ClimberSubsystem;
import edu.jaguarbots.stronghold.subsystems.IntakeSubsystem;
import edu.jaguarbots.stronghold.subsystems.ShooterSubsystem;
import edu.jaguarbots.stronghold.subsystems.VisionSubsystem;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This is a class that establishes hierarchy and the ridiculous need to javadoc everything
 */
public abstract class CommandBase extends Command
{
    /**
     * This is the oi
     */
    public static OI                     oi;
    
    /**
     * This creates the drive subsystem
     */
    public static final DriveSubsystem   driveSubsystem  = new DriveSubsystem();
    
    /**
     * This creates the vision subsystem
     */
    public static final VisionSubsystem  visionSubsystem = new VisionSubsystem();
    
    /**
     * This creates the intake subsystem
     */
    public static final IntakeSubsystem  intakeSubsystem = new IntakeSubsystem();
    
    /**
     * This creates the shooter subsystem
     */
    public static final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
    
    /**
     * This creates the climber subsystem
     */
    public static final ClimberSubsystem climberSubsystem  = new ClimberSubsystem();

    public CommandBase()
    {
        super();
    }

    public static void init() throws InterruptedException
    {
        try {
        oi = new OI();
        } 
        catch(Exception e){
            e.printStackTrace();
        }
   }
}
