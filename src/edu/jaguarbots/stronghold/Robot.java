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
    // vars for auto
    SendableChooser                    positionChooser  = new SendableChooser();
    SendableChooser                    goalChooser      = new SendableChooser();
    SendableChooser                    defenseChooser   = new SendableChooser();

    public enum Defense
    {
        Portcullis, Cheval, Moat, Ramparts, Rockwall, Terrain, Low
    }

    public enum Position
    {
        One, Two, Three, Four, Five
    }

    public enum Goal
    {
        Left, Middle, Right
    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
        CommandBase.init();
        positionChooser.addDefault("One", Position.One);
        positionChooser.addObject("Two", Position.Two);
        positionChooser.addObject("Three", Position.Three);
        positionChooser.addObject("Four", Position.Four);
        positionChooser.addObject("Five", Position.Five);
        SmartDashboard.putData("Position", positionChooser);
        goalChooser.addObject("Left", Goal.Left);
        goalChooser.addObject("Middle", Goal.Middle);
        goalChooser.addObject("Right", Goal.Right);
        SmartDashboard.putData("Goal", goalChooser);
        defenseChooser.addDefault("Portcullis", Defense.Portcullis);
        defenseChooser.addObject("Cheval De Frise", Defense.Cheval);
        defenseChooser.addObject("Moat", Defense.Moat);
        defenseChooser.addObject("Ramparts", Defense.Ramparts);
        defenseChooser.addObject("Rockwall", Defense.Rockwall);
        defenseChooser.addObject("Rough Terrain", Defense.Terrain);
        defenseChooser.addObject("Low Bar", Defense.Low);
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
        Position position = (Position) positionChooser.getSelected();
        Goal goal = (Goal) goalChooser.getSelected();
        Defense defense = (Defense) defenseChooser.getSelected();
        autonomousCommand = new Autonomous(defense, position, goal);
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
