package org.usd232.robotics.lights.simulator;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class FormulaBase
{
    static final Class<?> cls = Formula.class;
    private static Method[] methods = cls.getMethods();
    protected static ArrayList<String> names = new ArrayList<String>();

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
    public static Color patternFormula(long frame, int led, int maxLights, String pattern, String underPattern, Color custom1,
                    Color custom2)
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

    public FormulaBase()
    {
        super();
    }
}