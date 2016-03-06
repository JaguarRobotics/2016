package edu.jaguarbots.stronghold.commands.vision;

import com.ni.vision.NIVision;
//import com.ni.vision.NIVision.Image;

import edu.jaguarbots.stronghold.commands.CommandBase;
//import edu.wpi.first.wpilibj.CameraServer;
//import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 *
 */
public class DefaultCamera extends CommandBase {

	//Image frame;
	int session;
	
	int counter = 0;
	
	//CameraServer server;
	//USBCamera camera = new USBCamera("cam0");
    public DefaultCamera() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(visionSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//camera.openCamera();
    	//camera.startCapture();
    	//server = CameraServer.getInstance();
        //server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        //server.startAutomaticCapture(camera);
//    	frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
//        session = NIVision.IMAQdxOpenCamera("cam0",
//                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
//        NIVision.IMAQdxConfigureGrab(session);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	NIVision.IMAQdxStartAcquisition(session);
//        NIVision.IMAQdxGrab(session, frame, 1);
//    	camera.getImage(frame);
//        CameraServer.getInstance().setImage(frame);
    
//    	counter++;
//    	if (counter % 10 == 0){}
    		visionSubsystem.GetImage();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	NIVision.IMAQdxStopAcquisition(session);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
