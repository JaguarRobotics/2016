package edu.jaguarbots.stronghold.commands;

import edu.jaguarbots.stronghold.OI;
import edu.jaguarbots.stronghold.Robot;
import edu.jaguarbots.stronghold.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class CommandBase extends Command
{
    public static OI oi;
    public static final DriveSubsystem driveSubsystem = new DriveSubsystem();  
    
    public CommandBase()
    {
        super();
    }
    
    public static void init() throws InterruptedException
    {
        oi = new OI();  
    }   
}
