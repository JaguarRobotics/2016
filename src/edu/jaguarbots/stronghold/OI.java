package edu.jaguarbots.stronghold;

import edu.jaguarbots.stronghold.commands.climber.Ascend;
import edu.jaguarbots.stronghold.commands.climber.Descend;
import edu.jaguarbots.stronghold.commands.climber.Grab;
import edu.jaguarbots.stronghold.commands.drive.GearShift;
import edu.jaguarbots.stronghold.commands.intake.Intake;
import edu.jaguarbots.stronghold.commands.intake.IntakeBottom;
import edu.jaguarbots.stronghold.commands.intake.IntakeTop;
import edu.jaguarbots.stronghold.commands.intake.Output;
import edu.jaguarbots.stronghold.commands.shooter.ShooterDown;
import edu.jaguarbots.stronghold.commands.shooter.ShooterFire;
import edu.jaguarbots.stronghold.commands.shooter.ShooterUp;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
    public OI()
    {
        Manipulator_R1.whileHeld(new Intake());
        Manipulator_L1.whileHeld(new Output());
        Manipulator_Select.whenPressed(new Grab());
        Manipulator_DpadLeft.whenPressed(new ShooterUp());
        Manipulator_DpadRight.whenPressed(new ShooterDown());
        Manipulator_DpadUp.whenPressed(new IntakeTop());
        Manipulator_DpadDown.whenPressed(new IntakeBottom());
        if (Manipulator.getY(Hand.kLeft) > .7) new Ascend();
        if (Manipulator.getY(Hand.kLeft) < -.7) new Descend();
        if (Manipulator.getY(Hand.kRight) > .7) new IntakeBottom();
        //Manipulator_R3.whenPressed(new IntakeMiddle());
        if (Manipulator.getY(Hand.kRight) < -.7) new IntakeTop();
        if (Manipulator_L2.get()) Manipulator_R2.whenPressed(new ShooterFire());
        Joystick1_Button1.whenPressed(new GearShift());
    }
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    /**
     * Left Joystick
     */
    public final Joystick Joystick1             = new Joystick(RobotMap.leftStick);
    /**
     * Right Joystick
     */
    public final Joystick Joystick2             = new Joystick(RobotMap.rightStick);
    /**
     * Manipulator gamepad
     */
    public final Joystick Manipulator           = new Joystick(RobotMap.manipulator);
    /**
     * Left Joystick trigger
     */
    public final Button   Joystick1_Button1     = new JoystickButton(Joystick1, 1);
    /**
     * Left Joystick button 2
     */
    public final Button   Joystick1_Button2     = new JoystickButton(Joystick1, 2);
    /**
     * Left Joystick button 3
     */
    public final Button   Joystick1_Button3     = new JoystickButton(Joystick1, 3);
    /**
     * Left Joystick button 4
     */
    public final Button   Joystick1_Button4     = new JoystickButton(Joystick1, 4);
    /**
     * Left Joystick button 5
     */
    public final Button   Joystick1_Button5     = new JoystickButton(Joystick1, 5);
    /**
     * Left Joystick button 6
     */
    public final Button   Joystick1_Button6     = new JoystickButton(Joystick1, 6);
    /**
     * Left Joystick button 7
     */
    public final Button   Joystick1_Button7     = new JoystickButton(Joystick1, 7);
    /**
     * Left Joystick button 8
     */
    public final Button   Joystick1_Button8     = new JoystickButton(Joystick1, 8);
    /**
     * Left Joystick button 9
     */
    public final Button   Joystick1_Button9     = new JoystickButton(Joystick1, 9);
    /**
     * Left Joystick button 10
     */
    public final Button   Joystick1_Button10    = new JoystickButton(Joystick1, 10);
    /**
     * Left Joystick button 11
     */
    public final Button   Joystick1_Button11    = new JoystickButton(Joystick1, 11);
    /**
     * Left Joystick button 12
     */
    public final Button   Joystick1_Button12    = new JoystickButton(Joystick1, 12);
    /**
     * Right Joystick trigger
     */
    public final Button   Joystick2_Button1     = new JoystickButton(Joystick2, 1);
    /**
     * Left Joystick button 2
     */
    public final Button   Joystick2_Button2     = new JoystickButton(Joystick2, 2);
    /**
     * Left Joystick button 3
     */
    public final Button   Joystick2_Button3     = new JoystickButton(Joystick2, 3);
    /**
     * Left Joystick button 4
     */
    public final Button   Joystick2_Button4     = new JoystickButton(Joystick2, 4);
    /**
     * Left Joystick button 5
     */
    public final Button   Joystick2_Button5     = new JoystickButton(Joystick2, 5);
    /**
     * Left Joystick button 6
     */
    public final Button   Joystick2_Button6     = new JoystickButton(Joystick2, 6);
    /**
     * Left Joystick button 7
     */
    public final Button   Joystick2_Button7     = new JoystickButton(Joystick2, 7);
    /**
     * Left Joystick button 8
     */
    public final Button   Joystick2_Button8     = new JoystickButton(Joystick2, 8);
    /**
     * Left Joystick button 9
     */
    public final Button   Joystick2_Button9     = new JoystickButton(Joystick2, 9);
    /**
     * Left Joystick button 10
     */
    public final Button   Joystick2_Button10    = new JoystickButton(Joystick2, 10);
    /**
     * Left Joystick button 11
     */
    public final Button   Joystick2_Button11    = new JoystickButton(Joystick2, 11);
    /**
     * Left Joystick button 12
     */
    public final Button   Joystick2_Button12    = new JoystickButton(Joystick2, 12);
    /**
     * Manipulator Select button
     */
    public final Button   Manipulator_Select    = new JoystickButton(Manipulator, 1);
    /**
     * Manipulator Left stick button. Press the stick to activate
     */
    public final Button   Manipulator_L3        = new JoystickButton(Manipulator, 2);
    /**
     * Manipulator Right stick button. Press the Stick to activate
     */
    public final Button   Manipulator_R3        = new JoystickButton(Manipulator, 3);
    /**
     * Manipulator Start button
     */
    public final Button   Manipulator_Start     = new JoystickButton(Manipulator, 4);
    /**
     * Manipulator Dpad up button
     */
    public final Button   Manipulator_DpadUp    = new JoystickButton(Manipulator, 5);
    /**
     * Manipulator Dpad right button
     */
    public final Button   Manipulator_DpadRight = new JoystickButton(Manipulator, 6);
    /**
     * Manipulator Dpad down button
     */
    public final Button   Manipulator_DpadDown  = new JoystickButton(Manipulator, 7);
    /**
     * Manipulator Dpad left button
     */
    public final Button   Manipulator_DpadLeft  = new JoystickButton(Manipulator, 8);
    /**
     * Manipulator Left trigger
     */
    public final Button   Manipulator_L2        = new JoystickButton(Manipulator, 9);
    /**
     * Manipulator Right trigger
     */
    public final Button   Manipulator_R2        = new JoystickButton(Manipulator, 10);
    /**
     * Manipulator Left bumper
     */
    public final Button   Manipulator_L1        = new JoystickButton(Manipulator, 11);
    /**
     * Manipulator Right bumper
     */
    public final Button   Manipulator_R1        = new JoystickButton(Manipulator, 12);
    /**
     * Manipulator Triangle button
     */
    public final Button   Manipulator_Triangle  = new JoystickButton(Manipulator, 13);
    /**
     * Manipulator Circle button
     */
    public final Button   Manipulator_Circle    = new JoystickButton(Manipulator, 14);
    /**
     * Manipulator X button
     */
    public final Button   Manipulator_X         = new JoystickButton(Manipulator, 15);
    /**
     * Manipulator Square button
     */
    public final Button   Manipulator_Square    = new JoystickButton(Manipulator, 16);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.s
    // // TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}
