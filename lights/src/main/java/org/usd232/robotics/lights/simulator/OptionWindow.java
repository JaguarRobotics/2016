package org.usd232.robotics.lights.simulator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OptionWindow extends JFrame implements KeyListener
{
    /**
     * 
     */
    private static final long serialVersionUID = -1863196624729165596L;
    /**
     * Panel that holds everything in the window
     */
    private Panel             optionsPanel     = new Panel();
    private Label             lightsLbl        = new Label("Lights:");
    /**
     * Used to decide how many lights are to be used
     */
    private JTextField        lightTextBox     = new JTextField(3);
    private Label             patternLbl       = new Label("Pattern:");
    /**
     * String array of the pattern options to be used in patternDropDown
     * 
     * @see org.usd232.robotics.lights.simulator.OptionWindow#patternDropDown
     */
    private String[]          dropDownOptions;
    /**
     * Drop down used to select pattern to be used
     */
    private JComboBox<String> patternDropDown;
    /**
     * Drop down used to select underlying pattern to be used
     */
    private JComboBox<String> patternDropDown2;
    /**
     * Confirms selections and activates pattern with specified parameters
     */
    private JButton           enterBtn         = new JButton("Enter");
    /**
     * Slider used to choose red value of RGB of first custom color
     * 
     * @see org.usd232.robotics.lights.simulator.OptionWindow#customColor1
     */
    private JSlider           redSlider1       = new JSlider(0, 255);
    /**
     * Slider used to choose green value of RGB of first custom color
     * 
     * @see org.usd232.robotics.lights.simulator.OptionWindow#customColor1
     */
    private JSlider           greenSlider1     = new JSlider(0, 255);
    /**
     * Slider used to choose blue value of RGB of first custom color
     * 
     * @see org.usd232.robotics.lights.simulator.OptionWindow#customColor1
     */
    private JSlider           blueSlider1      = new JSlider(0, 255);
    /**
     * Slider used to choose red value of RGB of second custom color
     * 
     * @see org.usd232.robotics.lights.simulator.OptionWindow#customColor2
     */
    private JSlider           redSlider2       = new JSlider(0, 255);
    /**
     * Slider used to choose green value of RGB of second custom color
     * 
     * @see org.usd232.robotics.lights.simulator.OptionWindow#customColor2
     */
    private JSlider           greenSlider2     = new JSlider(0, 255);
    /**
     * Slider used to choose blue value of RGB of second custom color
     * 
     * @see org.usd232.robotics.lights.simulator.OptionWindow#customColor2
     */
    private JSlider           blueSlider2      = new JSlider(0, 255);
    /**
     * First custom color, used in customizable patterns
     */
    private Color             customColor1     = Color.BLACK;
    /**
     * Second custom color, used in customizable patterns
     */
    private Color             customColor2     = Color.WHITE;
    /**
     * Button used to display first custom color. If clicked, it randomizes the
     * color
     * 
     * @see org.usd232.robotics.lights.simulator.OptionWindow#customColor1
     */
    private JButton           sampleButton1    = new JButton();
    /**
     * Button used to display second custom color. If clicked, it randomizes the
     * color
     * 
     * @see org.usd232.robotics.lights.simulator.OptionWindow#customColor2
     */
    private JButton           sampleButton2    = new JButton();
    /**
     * Causes colors and color sample buttons to update upon sliders changing
     */
    private ChangeListener    sliderChange     = new ChangeListener()
                                               {
                                                   @Override
                                                   public void stateChanged(ChangeEvent e)
                                                   {
                                                       customColor1 = new Color(redSlider1.getValue(),
                                                                       greenSlider1.getValue(), blueSlider1.getValue());
                                                       sampleButton1.setForeground(customColor1);
                                                       sampleButton1.setBackground(customColor1);
                                                       sampleButton1.setBounds(color1Sample);
                                                       customColor2 = new Color(redSlider2.getValue(),
                                                                       greenSlider2.getValue(), blueSlider2.getValue());
                                                       sampleButton2.setForeground(customColor2);
                                                       sampleButton2.setBackground(customColor2);
                                                       sampleButton2.setBounds(color2Sample);
                                                   }
                                               };
    /**
     * Rectangle used for the dimensions of first sample button
     * 
     * @see org.usd232.robotics.lights.simulator.OptionWindow#sampleButton1
     */
    private Rectangle         color1Sample     = new Rectangle(0, 0, 0, 0);
    /**
     * Rectangle used for the dimensions of second sample button
     * 
     * @see org.usd232.robotics.lights.simulator.OptionWindow#sampleButton2
     */
    private Rectangle         color2Sample     = new Rectangle(0, 0, 0, 0);
    private long              frame            = 0;

    public OptionWindow()
    {
        Formula.setMethodNames();
        dropDownOptions = new String[FormulaBase.names.size()];
        for (int i = 0; i < FormulaBase.names.size(); i++)
        {
            dropDownOptions[i] = FormulaBase.names.get(i);
        }
        patternDropDown = new JComboBox<>(dropDownOptions);
        patternDropDown2 = new JComboBox<>(dropDownOptions);
        addKeyListener(this);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(500, 475);
        setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - (getHeight() - 50) / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        add(optionsPanel);
        lightsLbl.setSize(150, 30);
        optionsPanel.add(lightsLbl);
        lightTextBox.setToolTipText("How many lights to be used");
        lightTextBox.setText("40");
        lightTextBox.setSize(300, 30);
        lightTextBox.setHorizontalAlignment(JTextField.CENTER);
        lightTextBox.addKeyListener(this);
        optionsPanel.add(lightTextBox);
        patternLbl.setSize(300, 30);
        optionsPanel.add(patternLbl);
        patternDropDown.setSize(300, 30);
        patternDropDown.setSelectedIndex(0);
        patternDropDown.setSelectedItem(patternDropDown.getItemAt(0));
        patternDropDown.addKeyListener(this);
        optionsPanel.add(patternDropDown);
        patternDropDown2.setSize(300, 30);
        patternDropDown2.setSelectedIndex(0);
        patternDropDown2.setSelectedItem(patternDropDown2.getItemAt(0));
        patternDropDown2.addKeyListener(this);
        optionsPanel.add(patternDropDown2);
        redSlider1.setSize(256, 10);
        redSlider1.setVisible(true);
        redSlider1.setBackground(Color.RED);
        redSlider1.addChangeListener(sliderChange);
        redSlider1.addKeyListener(this);
        optionsPanel.add(redSlider1);
        greenSlider1.setSize(256, 10);
        greenSlider1.setVisible(true);
        greenSlider1.setBackground(Color.GREEN);
        greenSlider1.addChangeListener(sliderChange);
        greenSlider1.addKeyListener(this);
        optionsPanel.add(greenSlider1);
        blueSlider1.setSize(256, 10);
        blueSlider1.setVisible(true);
        blueSlider1.setBackground(Color.BLUE);
        blueSlider1.addChangeListener(sliderChange);
        blueSlider1.addKeyListener(this);
        optionsPanel.add(blueSlider1);
        redSlider2.setSize(256, 10);
        redSlider2.setVisible(true);
        redSlider2.setBackground(Color.RED);
        redSlider2.addChangeListener(sliderChange);
        redSlider2.addKeyListener(this);
        optionsPanel.add(redSlider2);
        greenSlider2.setSize(256, 10);
        greenSlider2.setVisible(true);
        greenSlider2.setBackground(Color.GREEN);
        greenSlider2.addChangeListener(sliderChange);
        greenSlider2.addKeyListener(this);
        optionsPanel.add(greenSlider2);
        blueSlider2.setSize(256, 10);
        blueSlider2.setVisible(true);
        blueSlider2.setBackground(Color.BLUE);
        blueSlider2.addChangeListener(sliderChange);
        blueSlider2.addKeyListener(this);
        optionsPanel.add(blueSlider2);
        sampleButton1.setVisible(true);
        sampleButton1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                Random r = new Random();
                redSlider1.setValue(r.nextInt(255));
                greenSlider1.setValue(r.nextInt(255));
                blueSlider1.setValue(r.nextInt(255));
                customColor1 = new Color(redSlider1.getValue(), greenSlider1.getValue(), blueSlider1.getValue());
                sampleButton1.setForeground(customColor1);
                sampleButton1.setBackground(customColor1);
            }
        });
        sampleButton1.addKeyListener(this);
        optionsPanel.add(sampleButton1);
        sampleButton2.setVisible(true);
        sampleButton2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                Random r = new Random();
                redSlider2.setValue(r.nextInt(255));
                greenSlider2.setValue(r.nextInt(255));
                blueSlider2.setValue(r.nextInt(255));
                customColor2 = new Color(redSlider2.getValue(), greenSlider2.getValue(), blueSlider2.getValue());
                sampleButton2.setForeground(customColor2);
                sampleButton2.setBackground(customColor2);
            }
        });
        sampleButton2.addKeyListener(this);
        optionsPanel.add(sampleButton2);
        enterBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                frame = SuperLights.frame;
                customColor1 = new Color(redSlider1.getValue(), greenSlider1.getValue(), blueSlider1.getValue());
                customColor2 = new Color(redSlider2.getValue(), greenSlider2.getValue(), blueSlider2.getValue());
                if (PatternTester.superLight == null)
                {
                    PatternTester.setLightsInfo(Integer.valueOf(lightTextBox.getText()),
                                    (String) patternDropDown.getSelectedItem(), (String) patternDropDown2.getSelectedItem(), customColor1, customColor2);
                    PatternTester.makeLights(frame);
                }
                PatternTester.superLight.setInfo(Integer.valueOf(lightTextBox.getText()),
                                (String) patternDropDown.getSelectedItem(), (String) patternDropDown2.getSelectedItem(), customColor1, customColor2, frame);
            }
        });
        enterBtn.setEnabled(true);
        enterBtn.setVisible(true);
        enterBtn.setSize(300, 50);
        enterBtn.addKeyListener(this);
        optionsPanel.add(enterBtn);
        setVisible(true);
        // SET PLACES HERE
        lightsLbl.setLocation(getWidth() / 2 - lightsLbl.getWidth() / 2, 0);
        lightTextBox.setLocation(getWidth() / 2 - lightTextBox.getWidth() / 2,
                        lightsLbl.getHeight() + lightsLbl.getY());
        patternLbl.setLocation(getWidth() / 2 - patternLbl.getWidth() / 2,
                        (int) (lightTextBox.getHeight() + (1.5 * lightTextBox.getHeight())));
        patternDropDown.setLocation(getWidth() / 2 - patternDropDown.getWidth() / 2,
                        patternLbl.getHeight() + patternLbl.getY());
        patternDropDown2.setLocation(getWidth() / 2 - patternDropDown2.getWidth() / 2,
                        (int) (patternDropDown.getY() + (1.2 * patternDropDown.getHeight())));
        redSlider1.setLocation(getWidth() / 2 - redSlider1.getWidth() / 2,
                        (int) (patternDropDown2.getY() + (1.5 * patternDropDown2.getHeight())));
        greenSlider1.setLocation(getWidth() / 2 - greenSlider1.getWidth() / 2,
                        redSlider1.getY() + redSlider1.getHeight() + 5);
        blueSlider1.setLocation(getWidth() / 2 - blueSlider1.getWidth() / 2,
                        greenSlider1.getY() + greenSlider1.getHeight() + 5);
        color1Sample = new Rectangle(redSlider1.getWidth() + redSlider1.getX() + 15,
                        redSlider1.getY() + redSlider1.getHeight() / 2,
                        (getWidth() - 15) - (redSlider1.getWidth() + redSlider1.getX() + 15),
                        (blueSlider1.getY() - blueSlider1.getHeight() / 2)
                                        - (redSlider1.getY() + redSlider1.getHeight() / 2));
        redSlider2.setLocation(getWidth() / 2 - redSlider2.getWidth() / 2,
                        (int) (blueSlider1.getY() + (3 * blueSlider1.getHeight())));
        greenSlider2.setLocation(getWidth() / 2 - greenSlider2.getWidth() / 2,
                        redSlider2.getY() + redSlider2.getHeight() + 5);
        blueSlider2.setLocation(getWidth() / 2 - blueSlider2.getWidth() / 2,
                        greenSlider2.getY() + greenSlider2.getHeight() + 5);
        color2Sample = new Rectangle(redSlider2.getWidth() + redSlider2.getX() + 15,
                        redSlider2.getY() + redSlider2.getHeight() / 2,
                        (getWidth() - 15) - (redSlider2.getWidth() + redSlider2.getX() + 15),
                        (blueSlider2.getY() - blueSlider2.getHeight() / 2)
                                        - (redSlider2.getY() + redSlider2.getHeight() / 2));
        sampleButton1.setForeground(
                        new Color(redSlider1.getValue() - 1, greenSlider1.getValue() - 1, blueSlider1.getValue() - 1));
        sampleButton1.setBackground(
                        new Color(redSlider1.getValue() - 1, greenSlider1.getValue() - 1, blueSlider1.getValue() - 1));
        sampleButton1.setBounds(color1Sample);
        sampleButton2.setForeground(
                        new Color(redSlider2.getValue() - 1, greenSlider2.getValue() - 1, blueSlider2.getValue() - 1));
        sampleButton2.setBackground(
                        new Color(redSlider2.getValue() - 1, greenSlider2.getValue() - 1, blueSlider2.getValue() - 1));
        sampleButton2.setBounds(color2Sample);
        enterBtn.setLocation(getWidth() / 2 - enterBtn.getWidth() / 2, (getHeight() - 50) - enterBtn.getHeight());
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_ENTER:
                enterBtn.doClick();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_ENTER:
                enterBtn.doClick();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_ENTER:
                enterBtn.doClick();
                break;
        }
    }
}
