package edu.jaguarbots.stronghold;

import edu.jaguarbots.stronghold.commands.Autonomous;
import edu.jaguarbots.stronghold.commands.CommandBase;
import edu.jaguarbots.stronghold.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
    public static final DriveSubsystem exampleSubsystem = new DriveSubsystem();
    Command                            autonomousCommand;
    //vars for auto
    SendableChooser positionChooser = new SendableChooser();
    int position;
    SendableChooser categoryChooser = new SendableChooser();
    int category;
    SendableChooser defenseChooser = new SendableChooser();
    boolean defense;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
        CommandBase.init();
        autonomousCommand = new Autonomous();
        positionChooser.addDefault("1", position = 1);
        positionChooser.addDefault("2", position = 2);
        positionChooser.addDefault("3", position = 3);
        positionChooser.addDefault("4", position = 4);
        positionChooser.addDefault("5", position = 5);
        SmartDashboard.putData("Position", positionChooser);
        
        categoryChooser.addDefault("low bar", category = 0);
        categoryChooser.addDefault("A", category = 1);
        categoryChooser.addDefault("B", category = 2);
        categoryChooser.addDefault("C", category = 3);
        categoryChooser.addDefault("D", category = 4);
        SmartDashboard.putData("Category", categoryChooser);
        
        defenseChooser.addDefault("gate, moat, drawbridge, and rockwall", defense = false);
        defenseChooser.addDefault("teetor-totter, steps, door, terrain", defense = true);
        SmartDashboard.putData("Defense", defenseChooser);
        
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit()
    {
    }

    public void disabledPeriodic()
    {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro You
     * can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    public void autonomousInit()
    {
        /*
         * String autoSelected = SmartDashboard.getString("Auto Selector",
         * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
         * = new MyAutoCommand(); break; case "Default Auto": default:
         * autonomousCommand = new ExampleCommand(); break; }
         */
        // schedule the autonomous command (example)
        autonomousCommand = new Autonomous(position, category, defense);
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit()
    {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic()
    {
        LiveWindow.run();
    }
}
