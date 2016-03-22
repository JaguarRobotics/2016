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
                                                       customColor2 = new Color(redSlider2.getValue(),
                                                                       greenSlider2.getValue(), blueSlider2.getValue());
                                                       sampleButton2.setForeground(customColor2);
                                                       sampleButton2.setBackground(customColor2);
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
        setResizable(true);
        add(optionsPanel);
        optionsPanel.add(lightsLbl);
        lightTextBox.setToolTipText("How many lights to be used");
        lightTextBox.setText("40");
        lightTextBox.setHorizontalAlignment(JTextField.CENTER);
        lightTextBox.addKeyListener(this);
        optionsPanel.add(lightTextBox);
        optionsPanel.add(patternLbl);
        patternDropDown.setSelectedIndex(0);
        patternDropDown.setSelectedItem(patternDropDown.getItemAt(0));
        patternDropDown.addKeyListener(this);
        optionsPanel.add(patternDropDown);
        patternDropDown2.setSelectedIndex(0);
        patternDropDown2.setSelectedItem(patternDropDown2.getItemAt(0));
        patternDropDown2.addKeyListener(this);
        optionsPanel.add(patternDropDown2);
        redSlider1.setVisible(true);
        redSlider1.setBackground(Color.RED);
        redSlider1.addChangeListener(sliderChange);
        redSlider1.addKeyListener(this);
        optionsPanel.add(redSlider1);
        greenSlider1.setVisible(true);
        greenSlider1.setBackground(Color.GREEN);
        greenSlider1.addChangeListener(sliderChange);
        greenSlider1.addKeyListener(this);
        optionsPanel.add(greenSlider1);
        blueSlider1.setVisible(true);
        blueSlider1.setBackground(Color.BLUE);
        blueSlider1.addChangeListener(sliderChange);
        blueSlider1.addKeyListener(this);
        optionsPanel.add(blueSlider1);
        redSlider2.setVisible(true);
        redSlider2.setBackground(Color.RED);
        redSlider2.addChangeListener(sliderChange);
        redSlider2.addKeyListener(this);
        optionsPanel.add(redSlider2);
        greenSlider2.setVisible(true);
        greenSlider2.setBackground(Color.GREEN);
        greenSlider2.addChangeListener(sliderChange);
        greenSlider2.addKeyListener(this);
        optionsPanel.add(greenSlider2);
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
                                    (String) patternDropDown.getSelectedItem(),
                                    (String) patternDropDown2.getSelectedItem(), customColor1, customColor2);
                    PatternTester.makeLights(frame);
                }
                PatternTester.superLight.setInfo(Integer.valueOf(lightTextBox.getText()),
                                (String) patternDropDown.getSelectedItem(), (String) patternDropDown2.getSelectedItem(),
                                customColor1, customColor2, frame);
            }
        });
        enterBtn.setEnabled(true);
        enterBtn.setVisible(true);
        enterBtn.addKeyListener(this);
        optionsPanel.add(enterBtn);
        setVisible(true);
        invalidate();
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
