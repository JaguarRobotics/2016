package edu.jaguarbots.stronghold.commands;

import edu.jaguarbots.stronghold.OI;
import edu.jaguarbots.stronghold.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class CommandBase extends Command
{
    public static OI oi;
    
    public CommandBase()
    {
        super();
    }
    
    public static void init() throws InterruptedException
    {
        oi = new OI();
    }   
}
