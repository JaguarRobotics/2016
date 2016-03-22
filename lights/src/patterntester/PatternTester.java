package patterntester;

import java.awt.Color;

public class PatternTester
{
    public static int     lightsNum;
    public static String patternString;
    public static String underPatternString;
    public static SuperLights superLight;
    public static Color customColor1 = Color.BLACK;
    public static Color customColor2 = Color.WHITE;

    public static void main(String[] args)
    {
        new OptionWindow();
    }

    public static void setLightsInfo(int inlightsNum, String inPattern, String inUnderPattern, Color custom1, Color custom2)
    {
        lightsNum = inlightsNum;
        patternString = inPattern;
        customColor1 = custom1;
        customColor2 = custom2;
    }
    
    public static void makeLights(long frame){
        superLight = new SuperLights(lightsNum, patternString, underPatternString, customColor1, customColor2, frame);
    }
}
