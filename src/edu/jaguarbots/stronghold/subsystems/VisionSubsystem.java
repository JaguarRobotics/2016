package edu.jaguarbots.stronghold.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.image.RGBImage;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.vision.AxisCamera;

// Based on HSL or Hue, Saturation and Luminance
public class VisionSubsystem extends Subsystem
{
    NetworkTable        table;
    double[]            area;
    double[]            centerX;
    double[]            centerY;
    double[]            width;
    double[]            height;
    /**
     * Returns if nothing is found in the array
     */
    double[]            defaultValue          = null;
    /**
     * Left target, in format {x, y, width, height, area}
     */
    double[]            leftTarget            = null;
    /**
     * Right target, in format {x, y, width, height, area}
     */
    double[]            rightTarget           = null;
    /**
     * Middle target, in format {x, y, width, height, area}
     */
    double[]            midTarget             = null;
    int                 numTargets            = 0;
    double              imageDPI              = 114;      // constant used
                                                          // based on
                                                          // size of
                                                          // image.
                                                          // Guess for now.
    double              viewAngle             = 18.7;     // AXIS M1011, to
                                                          // be
                                                          // determined
                                                          // for
                                                          // others.
    double              idealXRange[]         = { 5, 8 }; // Guess for now,
                                                          // to be
                                                          // determined
                                                          // through testing.
    double              idealHorizRange[]     = { 5, 8 };
    double              idealWidthHeightRatio = 11 / 7;   // width to height
                                                          // ratio of
                                                          // target]
    double ratioLimit = .75; //minimum score of ratio to be considered a target.
    ColorImage          image;
    AxisCamera          camera;
    private BinaryImage thresholdImage;
    private BinaryImage filteredImage;

    private class Scores
    {
        double aspectRatio;
    }
    
    private class Target
    {
        double centerX;
        double centerY;
        double width;
        double height;
        double area;
    }

    public VisionSubsystem()
    {
        //table = NetworkTable.getTable("GRIP/myContoursReport");
        try
        {
            image = new RGBImage("15.bmp");
        }
        catch (NIVisionException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Target[] target1 = getParticles(image);
        System.out.println(target1[0].centerX);
    }
    
    private boolean scoreCompare(Scores scores)
    {
        boolean isTarget = false;
        if(scores.aspectRatio > ratioLimit)
            isTarget = true;
        else isTarget = false;
        return isTarget;
    }

    public Target[] getParticles(ColorImage image)
    {
        Target [] targetArray = new Target[2];
        try
        {
            //image = camera.getImage();
            image.write("/image1.bmp");
            thresholdImage = image.thresholdRGB(214, 246, 226, 255, 221, 255); //filter out objects based on color.
            thresholdImage.write("/thresholdImage.bmp");
            filteredImage = thresholdImage.removeSmallObjects(true, 10);
            filteredImage.write("/filteredImage.bmp");
            Scores scores[] = new Scores[filteredImage.getNumberParticles()];
            
            if(filteredImage.getNumberParticles() > 0)
            {
                for(int i = 0; i<=filteredImage.getNumberParticles(); i++)
                {
                    ParticleAnalysisReport report = filteredImage.getParticleAnalysisReport(i);
                    scores[i] = new Scores();
                    scores[i].aspectRatio = scoreAspectRatio(report);
                    if(scoreCompare(scores[i]))
                    {
                        if(i == 0)
                        {
                            Target left = new Target();
                            left.area = report.particleArea;
                            left.centerX = report.center_mass_x_normalized;
                            left.centerY = report.center_mass_y_normalized;
                            left.height = report.boundingRectHeight;
                            left.width = report.boundingRectWidth;
                            targetArray[0] = left;
                        }
                        else if(i == 1)
                        {
                            Target mid = new Target();
                            mid.area = report.particleArea;
                            mid.centerX = report.center_mass_x_normalized;
                            mid.centerY = report.center_mass_y_normalized;
                            mid.height = report.boundingRectHeight;
                            mid.width = report.boundingRectWidth;
                            targetArray[1] = mid;
                        }
                        else if(i == 2)
                        {
                            Target right = new Target();
                            right.area = report.particleArea;
                            right.centerX = report.center_mass_x_normalized;
                            right.centerY = report.center_mass_y_normalized;
                            right.height = report.boundingRectHeight;
                            right.width = report.boundingRectWidth;
                            targetArray[2] = right;
                        }
                    }
                }
            }
        }
        catch (NIVisionException e)
        {
            e.printStackTrace();
        }
        return targetArray;
    }
    
    private double scoreAspectRatio(ParticleAnalysisReport report)
    {
        double widthHeightRatio = report.boundingRectWidth / report.boundingRectHeight;
        double score = widthHeightRatio / idealWidthHeightRatio;
        if (score > 1)
        {
            score = score - 1;
            score = 1 - score;
        }
        score *= 100;
        return score;
    }


    // For GRIP - I'm figuring out some stuff with GRIP, so we will see how it
    // goes.
    /**
     * @return an array of the target areas.
     */
    public double[] getArea()
    {
        area = table.getNumberArray("area", defaultValue);
        return area;
    }

    /**
     * @return an array of target center Xs
     */
    public double[] getCenterX()
    {
        centerX = table.getNumberArray("centerX", defaultValue);
        return centerX;
    }

    /**
     * @return array of target center Ys
     */
    public double[] getCenterY()
    {
        centerY = table.getNumberArray("centerY", defaultValue);
        return centerY;
    }

    /**
     * @return array of target widths.
     */
    public double[] getWidth()
    {
        width = table.getNumberArray("width", defaultValue);
        return width;
    }

    /**
     * @return array of target heights.
     */
    public double[] getHeight()
    {
        height = table.getNumberArray("height", defaultValue);
        return height;
    }

    /**
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
     * 
     * @return left target
     */
    public double[] getLeftTarget()
    {
        getCenterX();
        getCenterY();
        getWidth();
        getHeight();
        getArea();
        leftTarget = new double[] { centerX[0], centerY[0], width[0], height[0],
                        area[0] };
        return leftTarget;
    }

    /**
     * The targets are in the format {x, y, width, height, area}
     * 
     * @return mid target
     */
    public double[] getMidTarget()
    {
        getCenterX();
        getCenterY();
        getWidth();
        getHeight();
        getArea();
        midTarget = new double[] { centerX[1], centerY[1], width[1], height[1],
                        area[1] };
        return midTarget;
    }

    /**
     * The targets are in the format {x, y, width, height, area}
     * 
     * @return right target
     */
    public double[] getRightTarget()
    {
        getCenterX();
        getCenterY();
        getWidth();
        getHeight();
        getArea();
        rightTarget = new double[] { centerX[2], centerY[2], width[2],
                        height[2], area[2] };
        return rightTarget;
    }

    /**
     * @return X distance to target
     */
    public double getTargetXDistance(double[] target)
    {
        double xDistance = 0;
        for (int i = 0; i <= 5; i++) // converts array to inches.
            target[i] = target[i] / imageDPI;
        double width = target[3];
        xDistance = (width / 2) / Math.tan(viewAngle);
        return xDistance;
    }

    /**
     * @return Y distance to target
     */
    public double getTargetYDistance(double[] target)
    {
        double yDistance = 0;
        for (int i = 0; i <= 5; i++) // converts array to inches.
            target[i] = target[i] / imageDPI;
        double height = target[4];
        yDistance = (height / 2) / Math.tan(viewAngle);
        return yDistance;
    }

    /**
     * @param xDistance
     *            distance to target
     * @return true if needs to move up
     */
    public boolean aimUp(double xDistance)
    {
        boolean up = true;
        if (xDistance < idealXRange[0]) up = true;
        else if (xDistance >= idealXRange[0]) up = false;
        return up;
    }

    /**
     * @param xDistance
     *            distance to target
     * @return true if needs to move down
     */
    public boolean aimDown(double xDistance)
    {
        boolean down = true;
        if (xDistance > idealXRange[1]) down = true;
        else if (xDistance <= idealXRange[1]) down = false;
        return down;
    }

    public boolean aimRight(double horiz)
    {
        boolean right = true;
        if (horiz < idealHorizRange[0]) right = true;
        else if (horiz >= idealHorizRange[0]) right = false;
        return right;
    }

    public boolean aimLeft(double horiz)
    {
        boolean left = true;
        if (horiz < idealHorizRange[1]) left = true;
        else if (horiz >= idealHorizRange[1]) left = false;
        return left;
    }

    public void initDefaultCommand()
    {
    }
}
