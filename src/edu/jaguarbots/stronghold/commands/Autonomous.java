package edu.jaguarbots.stronghold.commands;

import edu.jaguarbots.stronghold.commands.drive.DriveFix;
import edu.jaguarbots.stronghold.commands.drive.DriveTurn;
import edu.jaguarbots.stronghold.commands.drive.EncoderDrive;
import edu.jaguarbots.stronghold.commands.intake.IntakeDown;
import edu.jaguarbots.stronghold.commands.intake.IntakeUp;
import edu.jaguarbots.stronghold.commands.shooter.ShooterFire;
import edu.jaguarbots.stronghold.commands.shooter.ShooterUp;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup
{

/*    
    Category A - Portcullis (gate): false; Cheval De Frise (Teetor totter): true;
    Category B - Moat:              false; Ramparts (steps):                true;
    Category C - Drawbridge:        false; Sally Port (door):               true;
    Category D - Rockwall (Bar):    false; Rough Terrain:                   true;
    
    for int robotPosition - From lowbar then left.
    Lowbar:     1
                2
                3
                4
                5

    for int category
    low 0
    A   1
    B   2
    C   3
    D   4
*/  
    
   
    public Autonomous()
    {
        addSequential(new EncoderDrive(5));
    }
    
    public Autonomous(boolean spyShoot)
    {
        if(spyShoot)
        {
            addSequential(new DriveTurn(30));
            addSequential(new ShooterUp());
            addSequential(new ShooterFire());
        }
        else
            addSequential(new EncoderDrive(-5));
    }
    
    public Autonomous(int robotPosition, int category, boolean defense)
    {
       addSequential(new EncoderDrive(5));
        
       if(category == 0)
       {
           addSequential(new EncoderDrive(3));
       }
        
       if(category == 1 && defense == false)
       {
           addSequential(new IntakeDown());
           addSequential(new IntakeUp());
           addSequential(new EncoderDrive(2));
           addSequential(new IntakeDown());
       }
       
       if(category == 1 && defense == true)
       {
           addSequential(new IntakeDown());
           addSequential(new EncoderDrive(2));
       }
       
       if(category == 2 || category == 4)
       {
           addSequential(new EncoderDrive(4));
           addSequential(new DriveFix(0));
       }
       
       if(category == 3)
       {
           System.out.println("error! We cannot cross this defense in autonomous");
       }
       
       if(robotPosition == 1)
       {
           addSequential(new DriveTurn(45)); //45 degress
       }
       
       if(robotPosition == 2)
       {
           addSequential(new DriveTurn(30)); //30 degrees
       }
       
       if(robotPosition == 4)
       {
           addSequential(new DriveTurn(-30)); //-30 degrees
       }
       
       if(robotPosition == 5)
       {
           addSequential(new DriveTurn(-45)); //-45 degrees
       }
       
           addSequential(new ShooterUp());
           addSequential(new ShooterFire());
       
  
    }
}
