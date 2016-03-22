// \
package org.usd232.robotics.lights.simulator;

// \
import java.awt.Color;

// \
public class Formula extends FormulaBase
// \
{
    // \
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
    // \
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
    // \
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
    // \
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
    // \
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
    // \
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
    // \
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
    // \
    @Pattern(getName = "White", isPattern = true)
    public static Color pattern7(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        return new Color(255, 255, 255);
    }

    /**
     * RGB bars chasing each other
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    // \
    @Pattern(getName = "RGB Chasers", isPattern = true)
    public static Color pattern8(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        return new Color((frame / 8 + led) % 9 < 3 ? 255 : 0,
                        (frame / 8 + led) % 9 >= 3 && (frame / 8 + led) % 9 <= 5 ? 255 : 0,
                        (frame / 8 + led) % 9 > 5 ? 255
                                        : 0);
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
    // \
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
    // \
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
    // \
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
    // \
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
    // \
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
    // \
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
    // \
    @Pattern(getName = "R-G-B-R MGrad", isPattern = true)
    public static Color pattern16(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        int max = maxLights;
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
    // \
    @Pattern(getName = "R-G-B-R Grad", isPattern = true)
    public static Color pattern17(long grame, int led, int maxLights, Color custom1, Color custom2)
    {
        int max = maxLights;
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
    // \
    @Pattern(getName = "R-G-R Grad", isPattern = true)
    public static Color pattern19(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        int max = maxLights;
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
    // \
    @Pattern(getName = "G-B-G Grad", isPattern = true)
    public static Color pattern20(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        int max = maxLights;
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
    // \
    @Pattern(getName = "R-B-R Grad", isPattern = true)
    public static Color pattern21(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        int max = maxLights;
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
    // \
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
    // \
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
    // \
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
    // \
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
    // \
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
    // \
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
    // \
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
    // \
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
    // \
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
    // \
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
    // \
    @Pattern(getName = "Strobe", isPattern = true)
    public static Color pattern33(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
        if (frame % 2 == 1)
        {
            color = new Color(255, 255, 255);
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
    // \
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
    // \
    @Pattern(getName = "Patriot Strobe", isPattern = true)
    public static Color pattern35(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(255, 0, 0);
        if (frame % 3 == 1)
        {
            color = new Color(255, 255, 255);
        }
        else if (frame % 3 == 2) color = new Color(0, 0, 255);
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
    // \
    @Pattern(getName = "Template - Do Not Use", isPattern = true)
    public static Color pattern36(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        Color color = new Color(0, 0, 0);
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
    // \
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
    // \
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
    // \
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
    // \
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
    // \
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
    // \
    @Pattern(getName = "Custom Solid", isPattern = true)
    public static Color pattern47(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        return custom1;
    }

    /**
     * Moving rainbow gradient
     * 
     * @param frame
     *            what frame is currently being drawn
     * @param led
     *            the LED that is currently being drawn
     * @param maxLights
     *            max amount of lights
     * @return the color to paint the current LED
     */
    // \
    @Pattern(getName = "Rainbow MGrad", isPattern = true)
    public static Color pattern48(long frame, int led, int maxLights, String underPattern, Color custom1, Color custom2)
    {
        double operantLED = led;
        // double operantLED = (frame / 2 + led) % maxLights;
        Color color = new Color(0, 0, 0);
        if (operantLED <= (double) maxLights / 6.)
        {
            double greenDiff = 200. / (maxLights / 6);
            int green = (int) (operantLED * greenDiff);
            if (green > 255) green = 255;
            if (green < 0) green = 0;
            color = new Color(255, green, 0);
        }
        else if (operantLED <= (double) maxLights / 3.)
        {
            double activeLED = operantLED - ((double) maxLights / 6.);
            double greenDiff = 55. / (maxLights / 6);
            int green = 200 + (int) (activeLED * greenDiff);
            if (green > 255) green = 255;
            if (green < 0) green = 0;
            color = new Color(255, green, 0);
        }
        else if (operantLED <= (double) maxLights / 2.)
        {
            double activeLED = operantLED - ((double) maxLights / 3.);
            double redDiff = 255. / (maxLights / 6);
            int red = 255 - (int) (activeLED * redDiff);
            if (red > 255) red = 255;
            if (red < 0) red = 0;
            color = new Color(red, 255, 0);
        }
        else if (operantLED <= 2 * (double) maxLights / 3.)
        {
            double activeLED = operantLED - ((double) maxLights / 2.);
            double greenDiff = -255. / (maxLights / 6);
            double blueDiff = 255. / (maxLights / 6);
            int green = 255 + (int) (activeLED * greenDiff);
            if (green > 255) green = 255;
            if (green < 0) green = 0;
            int blue = (int) (activeLED * blueDiff);
            if (blue > 255) blue = 255;
            if (blue < 0) blue = 0;
            color = new Color(0, green, blue);
        }
        else if (operantLED <= 5 * (double) maxLights / 6.)
        {
            double activeLED = operantLED - (2. * (double) maxLights / 3.);
            double redDiff = 153. / (maxLights / 6);
            double blueDiff = 102. / (maxLights / 6);
            int red = (int) (activeLED * redDiff);
            if (red > 255) red = 255;
            if (red < 0) red = 0;
            int blue = 255 - (int) (activeLED * blueDiff);
            if (blue > 255) blue = 255;
            if (blue < 0) blue = 0;
            color = new Color(red, 0, blue);
        }
        else
        {
            double activeLED = operantLED - (5. * (double) maxLights / 6.);
            double redDiff = 102. / (maxLights / 6);
            double blueDiff = 153. / (maxLights / 6);
            int red = 153 + (int) (activeLED * redDiff);
            if (red > 255) red = 255;
            if (red < 0) red = 0;
            int blue = 153 - (int) (activeLED * blueDiff);
            if (blue > 255) blue = 255;
            if (blue < 0) blue = 0;
            color = new Color(red, 0, blue);
        }
        return color;
    }
    // \
}
