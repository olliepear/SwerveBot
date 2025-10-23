package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControllerInputs extends SubsystemBase{
    public ControllerInputs() {}
    static XboxController xboxController1 = new XboxController(0);
    public boolean TriggerIsDown() {
      return false;
    }
            
}