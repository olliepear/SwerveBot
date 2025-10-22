package frc.robot.commands;

//import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class SwerveDrive {

    public void initialize() {

        DriveTrain.FRMsetV(0);
        DriveTrain.FLMsetV(0);
        DriveTrain.BRMsetV(0);
        DriveTrain.BLMsetV(0);

        DriveTrain.FRMsetA(0);
        DriveTrain.FLMsetA(0);
        DriveTrain.BRMsetA(0);
        DriveTrain.BLMsetA(0);

    }

    

    public void execute() {
        //double driverAxisX = RobotContainer.XBOX_CONTROLLER.getRawAxis(4);
        double driverAxisY = RobotContainer.XBOX_CONTROLLER.getRawAxis(5);
        double driverAxisZ = RobotContainer.XBOX_CONTROLLER.getRawAxis(0);

        //needs testing but should work as swerve drive math

        //DriveTrain.FRMsetV(Math.sqrt((driverAxisX+driverAxisZ) * (driverAxisX+driverAxisZ) + (driverAxisY-driverAxisZ) * (driverAxisY-driverAxisZ))/Constants.robotConstants.MOVE_SPEED);
        //DriveTrain.FLMsetV(Math.sqrt((driverAxisX+driverAxisZ) * (driverAxisX+driverAxisZ) + (driverAxisY+driverAxisZ) * (driverAxisY+driverAxisZ))/Constants.robotConstants.MOVE_SPEED);
        //DriveTrain.BRMsetV(Math.sqrt((driverAxisX-driverAxisZ) * (driverAxisX-driverAxisZ) + (driverAxisY-driverAxisZ) * (driverAxisY-driverAxisZ))/Constants.robotConstants.MOVE_SPEED);
        //DriveTrain.BLMsetV(Math.sqrt((driverAxisX-driverAxisZ) * (driverAxisX-driverAxisZ) + (driverAxisY+driverAxisZ) * (driverAxisY+driverAxisZ))/Constants.robotConstants.MOVE_SPEED);

        //DriveTrain.FRMsetA(Math.atan((driverAxisX+driverAxisZ)/(driverAxisY-driverAxisZ) * 180 / 3.141592));
        //DriveTrain.FLMsetA(Math.atan((driverAxisX+driverAxisZ)/(driverAxisY+driverAxisZ) * 180 / 3.141592));
        //DriveTrain.BRMsetA(Math.atan((driverAxisX-driverAxisZ)/(driverAxisY-driverAxisZ) * 180 / 3.141592));
        //DriveTrain.BLMsetA(Math.atan((driverAxisX-driverAxisZ)/(driverAxisY+driverAxisZ) * 180 / 3.141592));
        DriveTrain.FRMsetV(driverAxisY);
        DriveTrain.FLMsetV(driverAxisY);
        DriveTrain.BRMsetV(driverAxisY);
        DriveTrain.BLMsetV(driverAxisY);

        DriveTrain.FRMAsetV(driverAxisZ);
        DriveTrain.FLMAsetV(driverAxisZ);
        DriveTrain.BRMAsetV(driverAxisZ);
        DriveTrain.BLMAsetV(driverAxisZ);
    }

    public void end(boolean interrupted) {
        initialize();
    }

    public boolean isFinished() {
        return false;
    }
}
