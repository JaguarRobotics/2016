package edu.jaguarbots.stronghold.commands;

import edu.jaguarbots.stronghold.OI;
import edu.jaguarbots.stronghold.subsystems.ClimberSubsystem;
import edu.jaguarbots.stronghold.subsystems.DriveSubsystem;
import edu.jaguarbots.stronghold.subsystems.IntakeSubsystem;
import edu.jaguarbots.stronghold.subsystems.ShooterSubsystem;
import edu.jaguarbots.stronghold.subsystems.VisionSubsystem;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class CommandBase extends Command
{
    public static OI                     oi;
    public static final DriveSubsystem   driveSubsystem  = new DriveSubsystem();
    public static final VisionSubsystem  visionSubsystem = new VisionSubsystem();
    public static final IntakeSubsystem  intakeSubsystem = new IntakeSubsystem();
    public static final ShooterSubsystem shooterSubsytem = new ShooterSubsystem();
    public static final ClimberSubsystem climbSubsystem  = new ClimberSubsystem();

    public CommandBase()
    {
        super();
    }

    public static void init()
    {
        try {
        oi = new OI();
        } 
        catch(Exception e){
            e.printStackTrace();
        }
   }
}
