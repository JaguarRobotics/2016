package org.usd232.robotics.lights.simulator;

import java.awt.Color;
import java.awt.Panel;
import java.awt.Rectangle;

public class OptionsPanel extends Panel
{
    /**
     * 
     */
    private static final long serialVersionUID = -3658690254638550704L;
    private Rectangle         color1Sample     = new Rectangle(0, 0, 0, 0);
    private Rectangle         color2Sample     = new Rectangle(0, 0, 0, 0);
    private Color             color1           = Color.BLACK;
    private Color             color2           = Color.WHITE;

    public OptionsPanel()
    {
        setVisible(true);
    }

    public Color getColor1()
    {
        return color1;
    }

    public void setColor1(Color color1)
    {
        this.color1 = color1;
    }

    public Color getColor2()
    {
        return color2;
    }

    public void setColor2(Color color2)
    {
        this.color2 = color2;
    }

    public Rectangle getColor1Sample()
    {
        return color1Sample;
    }

    public void setColor1Sample(Rectangle color1Sample)
    {
        this.color1Sample = color1Sample;
    }

    public Rectangle getColor2Sample()
    {
        return color2Sample;
    }

    public void setColor2Sample(Rectangle color2Sample)
    {
        this.color2Sample = color2Sample;
    }
}
