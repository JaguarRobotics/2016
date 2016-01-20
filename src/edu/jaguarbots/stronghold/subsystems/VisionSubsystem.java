package edu.jaguarbots.stronghold.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

// Based on HSL or Hue, Saturation and Luminance
public class VisionSubsystem extends Subsystem
{
    NetworkTable table;
    double[]     area;
    double[]     centerX;
    double[]     centerY;
    double[]     width;
    double[]     height;
    double[]     defaultValue    = null; // returns
                                         // if
                                         // nothing
                                         // is
                                         // found
                                         // in
                                         // the
                                         // array
    double[]     leftTarget      = null;
    double[]     rightTarget     = null;
    double[]     midTarget       = null; // The
                                         // targets
                                         // are
                                         // in
                                         // the
                                         // format
                                         // {x,
                                         // y,
                                         // width,
                                         // height,
                                         // area}
    double[]     targetXDistance = null;
    double[]     targetYDistance = null;
    int          numTargets      = 0;

    public VisionSubsystem()
    {
        table = NetworkTable.getTable("GRIP/myContoursReport");
        centerX = getCenterX();
        System.out.println(centerX[0]);
    }

    // For GRIP - I'm figuring out some stuff with GRIP, so we will see how it
    // goes.
    public double[] getArea() // returns an array of target areas
    {
        area = table.getNumberArray("area", defaultValue);
        return area;
    }

    public double[] getCenterX() // returns array of target center Xs
    {
        centerX = table.getNumberArray("centerX", defaultValue);
        return centerX;
    }

    public double[] getCenterY() // returns array of target center Ys
    {
        centerY = table.getNumberArray("centerY", defaultValue);
        return centerY;
    }

    public double[] getWidth() // returns array of target widths
    {
        width = table.getNumberArray("width", defaultValue);
        return width;
    }

    public double[] getHeight() // returns array of target heights
    {
        height = table.getNumberArray("height", defaultValue);
        return height;
    }

    public int numTargets() // returns the number of targets
    {
        numTargets = area.length;
        if (numTargets > 3) System.out.println("Error! Too many targets");
        return numTargets;
    }

    public double[] getLeftTarget() // The targets are in the format {x, y,
                                    // width, height, area}
    {
        leftTarget = new double[] { centerX[0], centerY[0], width[0], height[0],
                        area[0] };
        return leftTarget;
    }

    public double[] getMidTarget()
    {
        midTarget = new double[] { centerX[1], centerY[1], width[1], height[1],
                        area[1] };
        return midTarget;
    }

    public double[] getRightTarget()
    {
        rightTarget = new double[] { centerX[2], centerY[2], width[2],
                        height[2], area[2] };
        return rightTarget;
    }

    public double[] getTargetXDistance()
    {
        return targetXDistance;
    }

    public double[] getTargetYDistance()
    {
        return targetYDistance;
    }

    public void initDefaultCommand()
    {
    }
}
