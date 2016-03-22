package patterntester;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 * The window that holds the lights. Simply closing this window will not end the
 * program - currently, you have to click the red stop button in the console of
 * Eclipse
 * 
 * @author Cody Moose
 * @since 2016
 * @version 1.0
 */
public class SuperLights extends JFrame implements KeyListener
{
    /**
     * 
     */
    private static final long      serialVersionUID = -5979072011660582375L;
    /**
     * Amount of lights in simulation
     */
    public static int              maxLights        = 40;
    /**
     * The time at which the simulator was started in miliseconds. Used for
     * refresh rate.
     */
    private static final long      START_TIME       = System.currentTimeMillis();
    /**
     * The optimal fps to keep the simulator running at.
     */
    private static final int       OPTIMAL_FPS      = 60;
    /**
     * Amount of miliseconds between each frame at optimal frame rate
     */
    private static final double    SKIP_TICKS       = 1000 / OPTIMAL_FPS;
    /**
     * The time at which the next simulator tick should occur
     */
    private static double          nextGameTick     = START_TIME + SKIP_TICKS;
    /**
     * How many ticks to sleep each cycle to keep with the optimal FPS
     */
    private static double          sleepTicks       = 0;
    /**
     * Array of lights
     */
    private static Rectangle[]     rectLights;
    /**
     * Dimension that holds the height and width of the screen
     */
    private static final Dimension SCREEN_SIZE      = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * What frame the lights are currently on
     */
    public static long                   frame            = 0;
    private String                 patternString;
    private String                 underPatternString;
    private Color                  customColor1     = Color.BLACK;
    private Color                  customColor2     = Color.WHITE;
    

    /**
     * Sets the properties of the window and the lights
     * 
     * @param inMaxLights
     *            the amount of lights to be used in the simulator
     */
    public SuperLights(int inMaxLights, String inPatternString, String inUnderPatternString, Color custom1, Color custom2, long inFrame)
    {
        frame = inFrame;
        setAlwaysOnTop(true);
        setUndecorated(true);
        maxLights = inMaxLights;
        patternString = inPatternString;
        patternString = inUnderPatternString;
        rectLights = new Rectangle[maxLights];
        customColor1 = custom1;
        customColor2 = custom2;
        setSize((int) SCREEN_SIZE.getWidth(), (int) (SCREEN_SIZE.getWidth() / inMaxLights));
        setLocation(0, 0);
        setVisible(true);
        addKeyListener(this);
        for (int i = 0; i < maxLights; i++)
        {
            rectLights[i] = new Rectangle((int) (((float) getWidth() / maxLights) * i), 0,
                            (int) ((float) getWidth() / maxLights) + 1, (int) ((float) getWidth() / maxLights));
        }
    }
    
    public void setInfo(int inMaxLights, String inPatternString, String inUnderPatternString, Color custom1, Color custom2, long inFrame){
        frame = inFrame;
        maxLights = inMaxLights;
        patternString = inPatternString;
        underPatternString = inUnderPatternString;
        rectLights = new Rectangle[maxLights];
        customColor1 = custom1;
        customColor2 = custom2;
        setSize((int) SCREEN_SIZE.getWidth(), (int) (SCREEN_SIZE.getWidth() / inMaxLights));
        setLocation(0, 0);
        setVisible(true);
        for (int i = 0; i < maxLights; i++)
        {
            rectLights[i] = new Rectangle((int) (((float) getWidth() / maxLights) * i), 0,
                            (int) ((float) getWidth() / maxLights) + 1, (int) ((float) getWidth() / maxLights));
        }
    }

    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < maxLights; i++)
        {
            g2.setPaint(Formula.patternFormula(frame, i, maxLights, patternString, underPatternString, customColor1, customColor2));
            g2.fillRect(rectLights[i].x, rectLights[i].y, rectLights[i].width, rectLights[i].height);
            g2.setPaint(Color.BLACK);
            g2.drawRect(rectLights[i].x, rectLights[i].y, rectLights[i].width, rectLights[i].height - 1);
        }
        frame++;
        sleepUntilNextFrame();
        repaint();
    }

    /**
     * Causes the simulator to sleep until the next frame that is in line with
     * the optimal fps so that it does not go too fast.
     */
    private void sleepUntilNextFrame()
    {
        nextGameTick += SKIP_TICKS;
        sleepTicks = nextGameTick - System.currentTimeMillis();
        if (sleepTicks >= 0)
        {
            try
            {
                Thread.sleep((long) sleepTicks);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
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
        }
    }
}
