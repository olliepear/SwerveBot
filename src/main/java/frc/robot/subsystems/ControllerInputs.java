package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class ControllerInputs extends SubsystemBase{
    public ControllerInputs() {}
    static XboxController xboxController1 = new XboxController(OperatorConstants.kDriverControllerPort);
    public boolean TriggerIsDown() {
      return false;
    }
            
}