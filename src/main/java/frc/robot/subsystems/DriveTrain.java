package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.ADIS16448_IMU;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class DriveTrain extends SubsystemBase {
    
    static SparkMax frontRightMotor = new SparkMax(Constants.driveConstants.FRONT_RIGHT_MOTOR, MotorType.kBrushless);
    static SparkMax frontLeftMotor = new SparkMax(Constants.driveConstants.FRONT_LEFT_MOTOR, MotorType.kBrushless);
    static SparkMax frontRightMotorAngle = new SparkMax(Constants.driveConstants.FRONT_RIGHT_MOTOR_ANGLE, MotorType.kBrushless);
    static SparkMax frontLeftMotorAngle = new SparkMax(Constants.driveConstants.FRONT_LEFT_MOTOR_ANGLE, MotorType.kBrushless);

    static SparkMax backRightMotor = new SparkMax(Constants.driveConstants.BACK_RIGHT_MOTOR, MotorType.kBrushless);
    static SparkMax backLeftMotor = new SparkMax(Constants.driveConstants.BACK_LEFT_MOTOR, MotorType.kBrushless);
    static SparkMax backRightMotorAngle = new SparkMax(Constants.driveConstants.BACK_RIGHT_MOTOR_ANGLE, MotorType.kBrushless);
    static SparkMax backLeftMotorAngle = new SparkMax(Constants.driveConstants.BACK_LEFT_MOTOR_ANGLE, MotorType.kBrushless);

    static ADIS16448_IMU gyro = new ADIS16448_IMU(); // ADIS16448 plugged into the MXP port

    public static RelativeEncoder frmEncoder = frontRightMotorAngle.getEncoder();
    public static RelativeEncoder flmEncoder = frontLeftMotorAngle.getEncoder();
    public static RelativeEncoder brmEncoder = backRightMotorAngle.getEncoder();   
    public static RelativeEncoder blmEncoder = backLeftMotorAngle.getEncoder();

    public static void FRMsetV(double speed) {
        if (speed >= -1 && speed <= 1)
        {
            frontRightMotor.set(speed);
        }
         else
        {
            frontRightMotor.set(0);
        }
    }

    public static void FLMsetV(double speed) {
        if (speed >= -1 && speed <= 1)
        {
            frontLeftMotor.set(speed);
        }
         else
        {
            frontLeftMotor.set(0);
        }
    }

    public static void BRMsetV(double speed) {
        if (speed >= -1 && speed <= 1)
        {
            backRightMotor.set(speed);
        }
         else
        {
            backRightMotor.set(0);
        }
    }

    public static void BLMsetV(double speed) {
        if (speed >= -1 && speed <= 1)
        {
            backLeftMotor.set(speed);
        }
        else
        {
           backLeftMotor.set(0);
        }
    }

    // input angle measure variables and find out how to measure them

    public static void FRMsetA(double angle) {
        if (angle >= ((frmEncoder.getPosition() % 1)/360 + Constants.SwerveConstants.turnThreshold - gyro.getAngle() * Constants.robotConstants.fieldCentricMode) ){
            frontRightMotorAngle.set(Constants.SwerveConstants.AngleChange);
        }
        if (angle <= ((frmEncoder.getPosition() % 1)/360 - Constants.SwerveConstants.turnThreshold - gyro.getAngle() * Constants.robotConstants.fieldCentricMode) ){
            frontRightMotorAngle.set(-Constants.SwerveConstants.AngleChange);
        }
        else {
            frontRightMotorAngle.set(0);
        }
    }       

    public static void FLMsetA(double angle) {
        if (angle >= ((flmEncoder.getPosition() % 1)/360 + Constants.SwerveConstants.turnThreshold - gyro.getAngle() * Constants.robotConstants.fieldCentricMode) ){
            frontLeftMotorAngle.set(Constants.SwerveConstants.AngleChange);
        }
        if (angle <= ((flmEncoder.getPosition() % 1)/360 - Constants.SwerveConstants.turnThreshold - gyro.getAngle() * Constants.robotConstants.fieldCentricMode) ){
            frontLeftMotorAngle.set(-Constants.SwerveConstants.AngleChange);
        }
        else {
            frontLeftMotorAngle.set(0);
        }
    }       
    public static void BRMsetA(double angle) {
        if (angle >= ((brmEncoder.getPosition() % 1)/360 + Constants.SwerveConstants.turnThreshold - gyro.getAngle() * Constants.robotConstants.fieldCentricMode) ){
            backRightMotorAngle.set(Constants.SwerveConstants.AngleChange);
        }
        if (angle <= ((brmEncoder.getPosition() % 1)/360 - Constants.SwerveConstants.turnThreshold - gyro.getAngle() * Constants.robotConstants.fieldCentricMode) ){
            backRightMotorAngle.set(-Constants.SwerveConstants.AngleChange);
        }
        else {
            backRightMotorAngle.set(0);
        }
    }   
    public static void BLMsetA(double angle) {
        if (angle >= ((blmEncoder.getPosition() % 1)/360 + Constants.SwerveConstants.turnThreshold - gyro.getAngle() * Constants.robotConstants.fieldCentricMode) ){
            backLeftMotorAngle.set(Constants.SwerveConstants.AngleChange);
        }
        if (angle <= ((blmEncoder.getPosition() % 1)/360 - Constants.SwerveConstants.turnThreshold - gyro.getAngle() * Constants.robotConstants.fieldCentricMode) ){
            backLeftMotorAngle.set(-Constants.SwerveConstants.AngleChange);
        }
        else {
            backLeftMotorAngle.set(0);
        }
    }   
    public static void setA(double angle) {
        if ((blmEncoder.getPosition() % 1)/360 - angle <= 180) {
            backLeftMotorAngle.set(Constants.SwerveConstants.AngleChange);
        }
        if (Constants.SwerveConstants.turnThreshold() >= (blmEncoder.getPosition() % 1)/360 - angle >= 180) {
            backLeftMotorAngle.set(-Constants.SwerveConstants.AngleChange);
        }    
    }            
}

