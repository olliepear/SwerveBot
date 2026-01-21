package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Launcher extends SubsystemBase {
    public SparkMax leftLaunch = new SparkMax(Constants.LauncherConstants.kLeftLaunchMotor, MotorType.kBrushed);
    public SparkMax rightLaunch = new SparkMax(Constants.LauncherConstants.kRightLaunchMotor, MotorType.kBrushed);
    public SparkMax vertControl = new SparkMax(Constants.LauncherConstants.kAngleMotor, MotorType.kBrushed);

    public SparkClosedLoopController vertController = vertControl.getClosedLoopController();

    public AbsoluteEncoder vertEncoder = vertControl.getAbsoluteEncoder();
    double m_motorSpeed;

    public void ActivateIntake() {
        vertController.setReference(Constants.LauncherConstants.kGroundAngle, ControlType.kPosition);
        leftLaunch.set(Constants.LauncherConstants.kIntakeSpeed);
        rightLaunch.set(-Constants.LauncherConstants.kIntakeSpeed);
    }

    public void Stop() {
        leftLaunch.set(0);
        leftLaunch.set(0);
    }

    public void setLaunchAngle(double launchAngle) {
        vertController.setReference(launchAngle, ControlType.kPosition);
    }

    public double getLaunchAngle() {
        return vertEncoder.getPosition();
    }

    public void Launch(double launchAngle, double launchSpeed) {
        m_motorSpeed = (launchSpeed/Constants.LauncherConstants.kMaxMotorSpeed);

        leftLaunch.set(m_motorSpeed);
        rightLaunch.set(m_motorSpeed);

        vertController.setReference(launchAngle, ControlType.kPosition);
    }

}
