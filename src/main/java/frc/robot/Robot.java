// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;



/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {

  SparkMax M0 = new SparkMax(1, MotorType.kBrushless);
  SparkMax M1 = new SparkMax(2, MotorType.kBrushless);
  SparkMax M2 = new SparkMax(3, MotorType.kBrushless);
  SparkMax M3 = new SparkMax(4, MotorType.kBrushless);
  SparkMax M4 = new SparkMax(5, MotorType.kBrushless);
  SparkMax M5 = new SparkMax(6, MotorType.kBrushless);
  SparkMax M6 = new SparkMax(7, MotorType.kBrushless);
  SparkMax M7 = new SparkMax(8, MotorType.kBrushless);

  double ampMinutesUsed = 0;
 
  private Command m_autonomousCommand;

  private final RobotContainer m_robotContainer;
  
  public Robot() {
    m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override

  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
