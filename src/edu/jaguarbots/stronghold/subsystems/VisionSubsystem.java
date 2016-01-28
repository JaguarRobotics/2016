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
    
    /**
     * Returns if nothing is found in the array
     */
    double[]     defaultValue    = null;
    
    /**
     * Left target, in format {x, y, width, height, area}
     */
    double[]     leftTarget      = null;
    
    /**
     * Right target, in format {x, y, width, height, area}
     */
    double[]     rightTarget     = null;
    
    /**
     * Middle target, in format {x, y, width, height, area}
     */
    double[]     midTarget       = null; 
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
    /**
     * 
     * @return an array of the target areas.
     */
    public double[] getArea()
    {
        area = table.getNumberArray("area", defaultValue);
        return area;
    }

    /**
     * 
     * @return an array of target center Xs
     */
    public double[] getCenterX()
    {
        centerX = table.getNumberArray("centerX", defaultValue);
        return centerX;
    }

    /**
     * 
     * @return array of target center Ys
     */
    public double[] getCenterY()
    {
        centerY = table.getNumberArray("centerY", defaultValue);
        return centerY;
    }

    /**
     * 
     * @return array of target widths.
     */
    public double[] getWidth()
    {
        width = table.getNumberArray("width", defaultValue);
        return width;
    }

    /**
     * 
     * @return array of target heights.
     */
    public double[] getHeight()
    {
        height = table.getNumberArray("height", defaultValue);
        return height;
    }

    /**
     * 
     * @return number of targets.
     */
    public int numTargets()
    {
        numTargets = area.length;
        if (numTargets > 3) System.out.println("Error! Too many targets");
        return numTargets;
    }

    /**
     * The targets are in the format {x, y, width, height, area}
     * @return left target
     */
    public double[] getLeftTarget()
    {
        leftTarget = new double[] { centerX[0], centerY[0], width[0], height[0],
                        area[0] };
        return leftTarget;
    }

    /**
     * The targets are in the format {x, y, width, height, area}
     * @return mid target
     */
    public double[] getMidTarget()
    {
        midTarget = new double[] { centerX[1], centerY[1], width[1], height[1],
                        area[1] };
        return midTarget;
    }

    /**
     * The targets are in the format {x, y, width, height, area}
     * @return right target
     */
    public double[] getRightTarget()
    {
        rightTarget = new double[] { centerX[2], centerY[2], width[2],
                        height[2], area[2] };
        return rightTarget;
    }

    /**
     * 
     * @return X distance to targets in array 
     */
    public double[] getTargetXDistance() //TODO algorithm to calculate it.
    {
        return targetXDistance;
    }

    /**
     * 
     * @return Y distance to targets in array
     */
    public double[] getTargetYDistance() //TODO algorithm to calculate
    {
        return targetYDistance;
    }

    public void initDefaultCommand()
    {
    }
}
