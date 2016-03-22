package patterntester;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Formula
{
    static final Class<?>    cls     = Formula.class;
    private static Method[]  methods = cls.getMethods();
    static ArrayList<String> names   = new ArrayList<String>();

    /**
     * Manages the patterns and uses the one specified
     * 
     * @param frame
     *            the frame currently being drawn
     * @param led
     *            the light currently being drawn
     * @param maxLights
     *            the amount of lights in the simulator
     * @return the color of the light currently being drawn
     */
    public static Color patternFormula(long frame, int led, int maxLights, String pattern, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
        for (int i = 0; i < methods.length; i++)
        {
            Class<?>[] types = { long.class, int.class, int.class, String.class, Color.class, Color.class };
            if (methods[i].getReturnType() == Color.class && methods[i].getName() != null
                            && methods[i].getName() != "patternFormula"
                            && methods[i].getAnnotation(Pattern.class) != null
                            && methods[i].getAnnotation(Pattern.class).getName() == pattern
                            && methods[i].getParameterTypes()[0] == types[0]
                            && methods[i].getParameterTypes()[1] == types[1]
                            && methods[i].getParameterTypes()[2] == types[2]
                            && methods[i].getParameterTypes()[3] == types[3]
                            && methods[i].getParameterTypes()[4] == types[4])
            {
                try
                {
                    color = (Color) methods[i].invoke(null, frame, led, maxLights, underPattern, custom1, custom2);
                }
                catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return color;
    }

    public static void setMethodNames()
    {
        for (int i = 0; i < methods.length; i++)
        {
            if (methods[i].getReturnType() == Color.class && methods[i].getName() != null
                            && methods[i].getName() != "patternFormula")
            {
                if (methods[i].getAnnotation(Pattern.class) != null)
                    names.add(methods[i].getAnnotation(Pattern.class).getName());
            }
        }
        names.sort(String.CASE_INSENSITIVE_ORDER);
    }

    @Pattern(getName = "Split Chasers", isPattern = true)
    public static Color pattern0(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        return new Color((frame / 8 + led) % 6 == 0 ? 255 : 0, (frame / 8 + led) % 6 == 1 ? 255 : 0,
                        (frame / 8 + led) % 6 == 2 ? 255 : 0);
    }

    /**
     * Red
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Red", isPattern = true)
    public static Color pattern1(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        return new Color(255, 0, 0);
    }

    /**
     * Yellow
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Yellow", isPattern = true)
    public static Color pattern2(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        return new Color(255, 255, 0);
    }

    /**
     * Green
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Green", isPattern = true)
    public static Color pattern3(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        return new Color(0, 255, 0);
    }

    /**
     * Cyan
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Cyan", isPattern = true)
    public static Color pattern4(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        return new Color(0, 255, 255);
    }

    /**
     * Blue
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Blue", isPattern = true)
    public static Color pattern5(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        return new Color(0, 0, 255);
    }

    /**
     * Magenta
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Magenta", isPattern = true)
    public static Color pattern6(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        return new Color(255, 0, 255);
    }

    /**
     * White
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "White", isPattern = true)
    public static Color pattern7(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        return new Color(255, 255, 255);
    }

    public static Color pattern8(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        return new Color((frame / 8 + led) % 9 < 3 ? 255 : 0,
                        (frame / 8 + led) % 9 >= 3 && (frame / 8 + led) % 9 <= 5 ? 255 : 0,
                        (frame / 8 + led) % 9 > 5 ? 255 : 0);
    }

    /**
     * Static gradient from red to blue
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "R-B Grad", isPattern = true)
    public static Color pattern9(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double colorDiff = 255. / maxLights;
        int colorValue = (int) (colorDiff * led);
        return new Color(255 - colorValue, 0, colorValue);
    }

    /**
     * Static gradient from red to green
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "R-G Grad", isPattern = true)
    public static Color pattern10(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double colorDiff = 255. / maxLights;
        int colorValue = (int) (colorDiff * led);
        return new Color(255 - colorValue, colorValue, 0);
    }

    /**
     * Static gradient from green to blue
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "G-B Grad", isPattern = true)
    public static Color pattern11(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double colorDiff = 255. / maxLights;
        int colorValue = (int) (colorDiff * led);
        return new Color(0, 255 - colorValue, colorValue);
    }

    /**
     * Moving gradient from red to blue
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "R-B MGrad", isPattern = true)
    public static Color pattern12(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double colorDiff = 255. / maxLights;
        int colorValue = ((int) (colorDiff * (led + (double) frame / 8))) % 255;
        return new Color(255 - colorValue, 0, colorValue);
    }

    /**
     * Moving gradient from green to blue
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "G-B MGrad", isPattern = true)
    public static Color pattern13(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double colorDiff = 255. / maxLights;
        int colorValue = ((int) (colorDiff * (led + (double) frame / 8))) % 255;
        return new Color(0, 255 - colorValue, colorValue);
    }

    /**
     * Moving gradient from red to green
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "R-G MGrad", isPattern = true)
    public static Color pattern14(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double colorDiff = 255. / maxLights;
        int colorValue = ((int) (colorDiff * (led + (double) frame / 8))) % 255;
        return new Color(255 - colorValue, colorValue, 0);
    }

    /**
     * Moving gradient from red to green to blue to red
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "R-G-B-R MGrad", isPattern = true)
    public static Color pattern16(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double max = maxLights;
        double operantLED = (frame / 8 + led) % max;
        Color color = new Color(0, 0, 0);
        double colorDiff = 255. / (max / 3);
        if (operantLED <= max / 3)
        {
            int red = 255 - (int) (operantLED * colorDiff);
            if (red > 255) red = 255;
            if (red < 0) red = 0;
            int green = (int) (operantLED * colorDiff);
            if (green > 255) green = 255;
            if (green < 0) green = 0;
            int blue = 0;
            color = new Color(red, green, blue);
        }
        else if (operantLED <= 2 * max / 3)
        {
            double activeLED = ((frame / 8 + led) % max) - (max / 3);
            int red = 0;
            int green = 255 - (int) (activeLED * colorDiff);
            if (green > 255) green = 255;
            if (green < 0) green = 0;
            int blue = (int) (activeLED * colorDiff);
            if (blue > 255) blue = 255;
            if (blue < 0) blue = 0;
            color = new Color(red, green, blue);
        }
        else if (operantLED > 2 * max / 3)
        {
            double activeLED = ((frame / 8 + led) % max) - (2 * max / 3);
            int red = (int) (activeLED * colorDiff);
            if (red > 255) red = 255;
            if (red < 0) red = 0;
            int green = 0;
            int blue = 255 - (int) (activeLED * colorDiff);
            if (blue > 255) blue = 255;
            if (blue < 0) blue = 0;
            color = new Color(red, green, blue);
        }
        return color;
    }

    /**
     * Static gradient from red to green to blue to red
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "R-G-B-R Grad", isPattern = true)
    public static Color pattern17(long grame, int led, int maxLights, Color custom1, Color custom2)
    {
        double max = maxLights;
        Color color = new Color(0, 0, 0);
        double colorDiff = 255. / (max / 3);
        if (led <= max / 3)
        {
            int red = 255 - (int) (led * colorDiff);
            if (red > 255) red = 255;
            if (red < 0) red = 0;
            int green = (int) (led * colorDiff);
            if (green > 255) green = 255;
            if (green < 0) green = 0;
            int blue = 0;
            color = new Color(red, green, blue);
        }
        else if (led <= 2 * max / 3)
        {
            double activeLED = led - (max / 3);
            int red = 0;
            int green = 255 - (int) (activeLED * colorDiff);
            if (green > 255) green = 255;
            if (green < 0) green = 0;
            int blue = (int) (activeLED * colorDiff);
            if (blue > 255) blue = 255;
            if (blue < 0) blue = 0;
            color = new Color(red, green, blue);
        }
        else if (led > 2 * max / 3)
        {
            double activeLED = led - (2 * max / 3);
            int red = (int) (activeLED * colorDiff);
            if (red > 255) red = 255;
            if (red < 0) red = 0;
            int green = 0;
            int blue = 255 - (int) (activeLED * colorDiff);
            if (blue > 255) blue = 255;
            if (blue < 0) blue = 0;
            color = new Color(red, green, blue);
        }
        return color;
    }

    /**
     * Static gradient from red to green to red
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "R-G-R Grad", isPattern = true)
    public static Color pattern19(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double max = maxLights;
        Color color = new Color(0, 0, 0);
        double colorDiff = 255. / (max / 2);
        if (led <= max / 2)
        {
            int red = 255 - (int) (led * colorDiff);
            if (red > 255) red = 255;
            if (red < 0) red = 0;
            int green = (int) (led * colorDiff);
            if (green > 255) green = 255;
            if (green < 0) green = 0;
            int blue = 0;
            color = new Color(red, green, blue);
        }
        else if (led > max / 2)
        {
            double activeLED = led - (max / 2);
            int red = (int) (activeLED * colorDiff);
            if (red > 255) red = 255;
            if (red < 0) red = 0;
            int green = 255 - (int) (activeLED * colorDiff);
            if (green > 255) green = 255;
            if (green < 0) green = 0;
            int blue = 0;
            color = new Color(red, green, blue);
        }
        return color;
    }

    /**
     * Static gradient from green to blue to green
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "G-B-G Grad", isPattern = true)
    public static Color pattern20(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double max = maxLights;
        Color color = new Color(0, 0, 0);
        double colorDiff = 255. / (max / 2);
        if (led <= max / 2)
        {
            int red = 0;
            int green = 255 - (int) (led * colorDiff);
            if (green > 255) green = 255;
            if (green < 0) green = 0;
            int blue = (int) (led * colorDiff);
            if (blue > 255) blue = 255;
            if (blue < 0) blue = 0;
            color = new Color(red, green, blue);
        }
        else if (led > max / 2)
        {
            double activeLED = led - (max / 2);
            int red = 0;
            int green = (int) (activeLED * colorDiff);
            if (green > 255) green = 255;
            if (green < 0) green = 0;
            int blue = 255 - (int) (activeLED * colorDiff);
            if (blue > 255) blue = 255;
            if (blue < 0) blue = 0;
            color = new Color(red, green, blue);
        }
        return color;
    }

    /**
     * Static gradient from red to blue to red
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "R-B-R Grad", isPattern = true)
    public static Color pattern21(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double max = maxLights;
        Color color = new Color(0, 0, 0);
        double colorDiff = 255. / (max / 2);
        if (led <= max / 2)
        {
            int red = 255 - (int) (led * colorDiff);
            if (red > 255) red = 255;
            if (red < 0) red = 0;
            int green = 0;
            int blue = (int) (led * colorDiff);
            if (blue > 255) blue = 255;
            if (blue < 0) blue = 0;
            color = new Color(red, green, blue);
        }
        else if (led > max / 2)
        {
            double activeLED = led - (max / 2);
            int red = (int) (activeLED * colorDiff);
            if (red > 255) red = 255;
            if (red < 0) red = 0;
            int green = 0;
            int blue = 255 - (int) (activeLED * colorDiff);
            if (blue > 255) blue = 255;
            if (blue < 0) blue = 0;
            color = new Color(red, green, blue);
        }
        return color;
    }

    /**
     * White chasers that go back and forth
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Chasers", isPattern = true)
    public static Color pattern22(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
        if ((frame / 2 % (2 * maxLights)) >= maxLights)
        {
            if ((maxLights - (frame / 2 % maxLights) == led) || (maxLights - (frame / 2 % maxLights) == led + 1)
                            || (maxLights - (frame / 2 % maxLights) == led - 1))
            {
                color = new Color(255, 255, 255);
            }
        }
        else if (((frame / 2 % maxLights) == led) || ((frame / 2 % maxLights) == led + 1)
                        || ((frame / 2 % maxLights) == led - 1))
        {
            color = new Color(255, 255, 255);
        }
        return color;
    }

    /**
     * Chasers with colors that reveal what the used pattern is at those pixels
     * at that point in time
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Custom X Chasers", isPattern = true)
    public static Color pattern23(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
        if ((frame / 2 % (2 * maxLights)) >= maxLights)
        {
            if ((maxLights - (frame / 2 % maxLights) == led) || (maxLights - (frame / 2 % maxLights) == led + 1)
                            || (maxLights - (frame / 2 % maxLights) == led - 1))
            {
                color = patternFormula(frame, led, maxLights, underPattern, "White", custom1, custom2);
            }
        }
        else if (((frame / 2 % maxLights) == led) || ((frame / 2 % maxLights) == led + 1)
                        || ((frame / 2 % maxLights) == led - 1))
        {
            color = patternFormula(frame, led, maxLights, underPattern, "White", custom1, custom2);
        }
        return color;
    }

    /**
     * White to black fade
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "White-Black Fade", isPattern = true)
    public static Color pattern24(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
        int colorVal = 0;
        if ((frame * 2) % 512 >= 256)
        {
            colorVal = (int) (255 - ((frame * 2) % 256));
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(colorVal, colorVal, colorVal);
        }
        else
        {
            colorVal = (int) ((frame * 2) % 256);
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(colorVal, colorVal, colorVal);
        }
        return color;
    }

    /**
     * Red to black fade
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "R-Black Fade", isPattern = true)
    public static Color pattern25(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
        int colorVal = 0;
        if ((frame * 2) % 512 >= 256)
        {
            colorVal = (int) (255 - ((frame * 2) % 256));
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(colorVal, 0, 0);
        }
        else
        {
            colorVal = (int) ((frame * 2) % 256);
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(colorVal, 0, 0);
        }
        return color;
    }

    /**
     * Green to black fade
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "G-Black Fade", isPattern = true)
    public static Color pattern26(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
        int colorVal = 0;
        if ((frame * 2) % 512 >= 256)
        {
            colorVal = (int) (255 - ((frame * 2) % 256));
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(0, colorVal, 0);
        }
        else
        {
            colorVal = (int) ((frame * 2) % 256);
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(0, colorVal, 0);
        }
        return color;
    }

    /**
     * Blue to black fade
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "B-Black Fade", isPattern = true)
    public static Color pattern27(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
        int colorVal = 0;
        if ((frame * 2) % 512 >= 256)
        {
            colorVal = (int) (255 - ((frame * 2) % 256));
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(0, 0, colorVal);
        }
        else
        {
            colorVal = (int) ((frame * 2) % 256);
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(0, 0, colorVal);
        }
        return color;
    }

    /**
     * Yellow to black fade
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Y-Black Fade", isPattern = true)
    public static Color pattern28(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
        int colorVal = 0;
        if ((frame * 2) % 512 >= 256)
        {
            colorVal = (int) (255 - ((frame * 2) % 256));
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(colorVal, colorVal, 0);
        }
        else
        {
            colorVal = (int) ((frame * 2) % 256);
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(colorVal, colorVal, 0);
        }
        return color;
    }

    /**
     * Magenta to black fade
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "M-Black Fade", isPattern = true)
    public static Color pattern29(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
        int colorVal = 0;
        if ((frame * 2) % 512 >= 256)
        {
            colorVal = (int) (255 - ((frame * 2) % 256));
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(colorVal, 0, colorVal);
        }
        else
        {
            colorVal = (int) ((frame * 2) % 256);
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(colorVal, 0, colorVal);
        }
        return color;
    }

    /**
     * Static gradient from green to magenta
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "G-M Grad", isPattern = true)
    public static Color pattern30(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double colorDiff = 255. / maxLights;
        int colorValue = (int) (colorDiff * led);
        return new Color(colorValue, 255 - colorValue, colorValue);
    }

    /**
     * Static gradient from red to cyan
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "R-C Grad", isPattern = true)
    public static Color pattern31(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double colorDiff = 255. / maxLights;
        int colorValue = (int) (colorDiff * led);
        return new Color(255 - colorValue, colorValue, colorValue);
    }

    /**
     * Static gradient from blue to yellow
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "B-Y Grad", isPattern = true)
    public static Color pattern32(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double colorDiff = 255. / maxLights;
        int colorValue = (int) (colorDiff * led);
        return new Color(colorValue, colorValue, 255 - colorValue);
    }

    /**
     * Strobe
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Strobe", isPattern = true)
    public static Color pattern33(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = Color.BLACK;
        if (frame % 2 == 1)
        {
            color = Color.WHITE;
        }
        return color;
    }

    /**
     * Static black to white gradient
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "White-Black Grad", isPattern = true)
    public static Color pattern34(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double colorDiff = 255. / maxLights;
        int colorValue = (int) (colorDiff * led);
        return new Color(255 - colorValue, 255 - colorValue, 255 - colorValue);
    }

    /**
     * Patriotic Strobe
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Patriot Strobe", isPattern = true)
    public static Color pattern35(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = Color.RED;
        if (frame % 3 == 1)
        {
            color = Color.WHITE;
        }
        else if (frame % 3 == 2) color = Color.BLUE;
        return color;
    }

    /**
     * Template
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Template - Do Not Use", isPattern = true)
    public static Color pattern36(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = Color.BLACK;
        return color;
    }

    /**
     * Red-Cyan Fade
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "R-C Fade", isPattern = true)
    public static Color pattern37(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
        int colorVal = 0;
        if ((frame * 2) % 512 >= 256)
        {
            colorVal = (int) (255 - ((frame * 2) % 256));
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(colorVal, 255 - colorVal, 255 - colorVal);
        }
        else
        {
            colorVal = (int) ((frame * 2) % 256);
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(colorVal, 255 - colorVal, 255 - colorVal);
        }
        return color;
    }

    /**
     * Blue-Yellow Fade
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "B-Y Fade", isPattern = true)
    public static Color pattern38(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
        int colorVal = 0;
        if ((frame * 2) % 512 >= 256)
        {
            colorVal = (int) (255 - ((frame * 2) % 256));
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(255 - colorVal, 255 - colorVal, colorVal);
        }
        else
        {
            colorVal = (int) ((frame * 2) % 256);
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(255 - colorVal, 255 - colorVal, colorVal);
        }
        return color;
    }

    /**
     * Green-Magenta Fade
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "G-M Fade", isPattern = true)
    public static Color pattern39(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
        int colorVal = 0;
        if ((frame * 2) % 512 >= 256)
        {
            colorVal = (int) (255 - ((frame * 2) % 256));
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(255 - colorVal, colorVal, 255 - colorVal);
        }
        else
        {
            colorVal = (int) ((frame * 2) % 256);
            if (colorVal > 255) colorVal = 255;
            if (colorVal < 0) colorVal = 0;
            color = new Color(255 - colorVal, colorVal, 255 - colorVal);
        }
        return color;
    }

    /**
     * Custom Fade
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Custom Fade", isPattern = true)
    public static Color pattern40(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
        double redDiff = (custom2.getRed() - custom1.getRed()) / 255d;
        double greenDiff = (custom2.getGreen() - custom1.getGreen()) / 255d;
        double blueDiff = (custom2.getBlue() - custom1.getBlue()) / 255d;
        double redVal = 0;
        double greenVal = 0;
        double blueVal = 0;
        if ((frame * 2) % 512 >= 256)
        {
            redVal = custom1.getRed() + (redDiff * ((frame * 2) % 256));
            if (redVal > 255) redVal = 255;
            if (redVal < 0) redVal = 0;
            greenVal = custom1.getGreen() + (greenDiff * ((frame * 2) % 256));
            if (greenVal > 255) greenVal = 255;
            if (greenVal < 0) greenVal = 0;
            blueVal = custom1.getBlue() + (blueDiff * ((frame * 2) % 256));
            if (blueVal > 255) blueVal = 255;
            if (blueVal < 0) blueVal = 0;
            color = new Color((int) redVal, (int) greenVal, (int) blueVal);
        }
        else
        {
            redVal = custom2.getRed() - redDiff * ((frame * 2) % 256);
            if (redVal > 255) redVal = 255;
            if (redVal < 0) redVal = 0;
            greenVal = custom2.getGreen() - greenDiff * ((frame * 2) % 256);
            if (greenVal > 255) greenVal = 255;
            if (greenVal < 0) greenVal = 0;
            blueVal = custom2.getBlue() - blueDiff * ((frame * 2) % 256);
            if (blueVal > 255) blueVal = 255;
            if (blueVal < 0) blueVal = 0;
            color = new Color((int) redVal, (int) greenVal, (int) blueVal);
        }
        return color;
    }

    /**
     * Custom Gradient
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Custom Grad", isPattern = true)
    public static Color pattern41(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double redDiff = (custom2.getRed() - custom1.getRed()) / (float) maxLights;
        double greenDiff = (custom2.getGreen() - custom1.getGreen()) / (float) maxLights;
        double blueDiff = (custom2.getBlue() - custom1.getBlue()) / (float) maxLights;
        double redValue = custom1.getRed() + redDiff * led;
        double greenValue = custom1.getGreen() + greenDiff * led;
        double blueValue = custom1.getBlue() + blueDiff * led;
        return new Color((int) redValue, (int) greenValue, (int) blueValue);
    }

    /**
     * Custom Gradient C1-C2-C1
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Custom DGrad", isPattern = true)
    public static Color pattern42(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double redDiff = (custom2.getRed() - custom1.getRed()) / ((float) maxLights / 2.);
        double greenDiff = (custom2.getGreen() - custom1.getGreen()) / ((float) maxLights / 2.);
        double blueDiff = (custom2.getBlue() - custom1.getBlue()) / ((float) maxLights / 2.);
        double redValue = 0;
        double greenValue = 0;
        double blueValue = 0;
        if (led < (float) maxLights / 2.)
        {
            redValue = custom1.getRed() + redDiff * led;
            if(redValue > 255) redValue = 255;
            if(redValue < 0) redValue = 0;
            greenValue = custom1.getGreen() + greenDiff * led;
            if(greenValue > 255) greenValue = 255;
            if(greenValue < 0) greenValue = 0;
            blueValue = custom1.getBlue() + blueDiff * led;
            if(blueValue > 255) blueValue = 255;
            if(blueValue < 0) blueValue = 0;
        }
        else if (led >= (float) maxLights / 2.)
        {
            redValue = custom2.getRed() - redDiff * (led % ((float)maxLights / 2.));
            if(redValue > 255) redValue = 255;
            if(redValue < 0) redValue = 0;
            greenValue = custom2.getGreen() - greenDiff * (led % ((float)maxLights / 2.));
            if(greenValue > 255) greenValue = 255;
            if(greenValue < 0) greenValue = 0;
            blueValue = custom2.getBlue() - blueDiff * (led % ((float)maxLights / 2.));
            if(blueValue > 255) blueValue = 255;
            if(blueValue < 0) blueValue = 0;
        }
        return new Color((int) redValue, (int) greenValue, (int) blueValue);
    }

    /**
     * Custom Moving Gradient
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Custom MGrad", isPattern = true)
    public static Color pattern43(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double redDiff = (custom2.getRed() - custom1.getRed()) / (float) maxLights;
        double greenDiff = (custom2.getGreen() - custom1.getGreen()) / (float) maxLights;
        double blueDiff = (custom2.getBlue() - custom1.getBlue()) / (float) maxLights;
        double redValue = custom1.getRed() + redDiff * ((led + (double) frame / 8) % maxLights);
        double greenValue = custom1.getGreen() + greenDiff * ((led + (double) frame / 8) % maxLights);
        double blueValue = custom1.getBlue() + blueDiff * ((led + (double) frame / 8) % maxLights);
        return new Color((int) redValue, (int) greenValue, (int) blueValue);
    }

    /**
     * Custom Moving Gradient C1-C2-C1
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Custom DMGrad", isPattern = true)
    public static Color pattern44(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double redDiff = (custom2.getRed() - custom1.getRed()) / ((float) maxLights / 2.);
        double greenDiff = (custom2.getGreen() - custom1.getGreen()) / ((float) maxLights / 2.);
        double blueDiff = (custom2.getBlue() - custom1.getBlue()) / ((float) maxLights / 2.);
        double redValue = 0;
        double greenValue = 0;
        double blueValue = 0;
        if (((led + (double) frame / 8) % maxLights) < (float) maxLights / 2.)
        {
            redValue = custom1.getRed() + redDiff * ((led + (double) frame / 8) % maxLights);
            if(redValue > 255) redValue = 255;
            if(redValue < 0) redValue = 0;
            greenValue = custom1.getGreen() + greenDiff * ((led + (double) frame / 8) % maxLights);
            if(greenValue > 255) greenValue = 255;
            if(greenValue < 0) greenValue = 0;
            blueValue = custom1.getBlue() + blueDiff * ((led + (double) frame / 8) % maxLights);
            if(blueValue > 255) blueValue = 255;
            if(blueValue < 0) blueValue = 0;
        }
        else if (((led + (double) frame / 8) % maxLights) >= (float) maxLights / 2.)
        {
            redValue = custom2.getRed() - redDiff * (((led + (double) frame / 8) % maxLights) % ((float)maxLights / 2.));
            if(redValue > 255) redValue = 255;
            if(redValue < 0) redValue = 0;
            greenValue = custom2.getGreen() - greenDiff * (((led + (double) frame / 8) % maxLights) % ((float)maxLights / 2.));
            if(greenValue > 255) greenValue = 255;
            if(greenValue < 0) greenValue = 0;
            blueValue = custom2.getBlue() - blueDiff * (((led + (double) frame / 8) % maxLights) % ((float)maxLights / 2.));
            if(blueValue > 255) blueValue = 255;
            if(blueValue < 0) blueValue = 0;
        }
        return new Color((int) redValue, (int) greenValue, (int) blueValue);
    }

    /**
     * Custom color chasers that go back and forth on black background
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Custom Chasers", isPattern = true)
    public static Color pattern45(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
        if ((frame / 2 % (2 * maxLights)) >= maxLights)
        {
            if ((maxLights - (frame / 2 % maxLights) == led) || (maxLights - (frame / 2 % maxLights) == led + 1)
                            || (maxLights - (frame / 2 % maxLights) == led - 1))
            {
                color = custom1;
            }
        }
        else if (((frame / 2 % maxLights) == led) || ((frame / 2 % maxLights) == led + 1)
                        || ((frame / 2 % maxLights) == led - 1))
        {
            color = custom1;
        }
        return color;
    }

    /**
     * Custom color chasers that go back and forth on custom background
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "DCustom Chasers", isPattern = true)
    public static Color pattern46(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = custom2;
        if ((frame / 2 % (2 * maxLights)) >= maxLights)
        {
            if ((maxLights - (frame / 2 % maxLights) == led) || (maxLights - (frame / 2 % maxLights) == led + 1)
                            || (maxLights - (frame / 2 % maxLights) == led - 1))
            {
                color = custom1;
            }
        }
        else if (((frame / 2 % maxLights) == led) || ((frame / 2 % maxLights) == led + 1)
                        || ((frame / 2 % maxLights) == led - 1))
        {
            color = custom1;
        }
        return color;
    }

    /**
     * Solid custom color
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Custom Solid", isPattern = true)
    public static Color pattern47(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        return custom1;
    }

    /**
     * Custom Fade between black and underlying pattern
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "Custom X Fade", isPattern = true)
    public static Color pattern48(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color xCustom1 = Color.BLACK;
        Color xCustom2 = patternFormula(frame, led, maxLights, underPattern, "White", custom1, custom2);
        Color color = new Color(0, 0, 0);
        double redDiff = (xCustom2.getRed() - custom1.getRed()) / 255d;
        double greenDiff = (xCustom2.getGreen() - custom1.getGreen()) / 255d;
        double blueDiff = (xCustom2.getBlue() - custom1.getBlue()) / 255d;
        double redVal = 0;
        double greenVal = 0;
        double blueVal = 0;
        if ((frame * 2) % 512 >= 256)
        {
            redVal = xCustom1.getRed() + (redDiff * ((frame * 2) % 256));
            if (redVal > 255) redVal = 255;
            if (redVal < 0) redVal = 0;
            greenVal = xCustom1.getGreen() + (greenDiff * ((frame * 2) % 256));
            if (greenVal > 255) greenVal = 255;
            if (greenVal < 0) greenVal = 0;
            blueVal = xCustom1.getBlue() + (blueDiff * ((frame * 2) % 256));
            if (blueVal > 255) blueVal = 255;
            if (blueVal < 0) blueVal = 0;
            color = new Color((int) redVal, (int) greenVal, (int) blueVal);
        }
        else
        {
            redVal = xCustom2.getRed() - redDiff * ((frame * 2) % 256);
            if (redVal > 255) redVal = 255;
            if (redVal < 0) redVal = 0;
            greenVal = xCustom2.getGreen() - greenDiff * ((frame * 2) % 256);
            if (greenVal > 255) greenVal = 255;
            if (greenVal < 0) greenVal = 0;
            blueVal = xCustom2.getBlue() - blueDiff * ((frame * 2) % 256);
            if (blueVal > 255) blueVal = 255;
            if (blueVal < 0) blueVal = 0;
            color = new Color((int) redVal, (int) greenVal, (int) blueVal);
        }
        return color;
    }

    /**
     * Custom Fade between black and underlying pattern
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    @Pattern(getName = "DCustom X Fade", isPattern = true)
    public static Color pattern49(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color xCustom1 = patternFormula(frame, led, maxLights, underPattern, "White", custom1, custom2);
        Color xCustom2 = patternFormula(frame, led, maxLights, underPattern, "White", custom1, custom2);
        Color color = new Color(0, 0, 0);
        double redDiff = (xCustom2.getRed() - custom1.getRed()) / 255d;
        double greenDiff = (xCustom2.getGreen() - custom1.getGreen()) / 255d;
        double blueDiff = (xCustom2.getBlue() - custom1.getBlue()) / 255d;
        double redVal = 0;
        double greenVal = 0;
        double blueVal = 0;
        if ((frame * 2) % 512 >= 256)
        {
            redVal = xCustom1.getRed() + (redDiff * ((frame * 2) % 256));
            if (redVal > 255) redVal = 255;
            if (redVal < 0) redVal = 0;
            greenVal = xCustom1.getGreen() + (greenDiff * ((frame * 2) % 256));
            if (greenVal > 255) greenVal = 255;
            if (greenVal < 0) greenVal = 0;
            blueVal = xCustom1.getBlue() + (blueDiff * ((frame * 2) % 256));
            if (blueVal > 255) blueVal = 255;
            if (blueVal < 0) blueVal = 0;
            color = new Color((int) redVal, (int) greenVal, (int) blueVal);
        }
        else
        {
            redVal = xCustom2.getRed() - redDiff * ((frame * 2) % 256);
            if (redVal > 255) redVal = 255;
            if (redVal < 0) redVal = 0;
            greenVal = xCustom2.getGreen() - greenDiff * ((frame * 2) % 256);
            if (greenVal > 255) greenVal = 255;
            if (greenVal < 0) greenVal = 0;
            blueVal = xCustom2.getBlue() - blueDiff * ((frame * 2) % 256);
            if (blueVal > 255) blueVal = 255;
            if (blueVal < 0) blueVal = 0;
            color = new Color((int) redVal, (int) greenVal, (int) blueVal);
        }
        return color;
    }
}
