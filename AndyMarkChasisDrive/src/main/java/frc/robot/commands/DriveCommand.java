package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.UserInput;
import frc.robot.subsystems.Drive;

public class DriveCommand extends CommandBase {
    
    UserInput input; 

    Drive drive;

    public DriveCommand() {
        input = new UserInput();
        drive = RobotContainer.m_drive;
    }

    @Override
    public void execute() {
        input.Run();
        if (input.isRightTriggerPressed) {
            drive.MoveForward(input.rightTriggerAxisValue);
        } else if (input.isLeftTriggerPressed) {
            drive.MoveBackward(input.leftTriggerAxisValue);
        }

        if (input.joystickLeftDirection == "left" || input.joystickLeftDirection == "upleft" || input.joystickLeftDirection == "downleft") {
            drive.TurnLeft(input.joystickLeftAxisValue[0]);
        } else if (input.joystickLeftDirection == "right" || input.joystickLeftDirection == "upright" || input.joystickLeftDirection == "downright") {
            drive.TurnRight(input.joystickLeftAxisValue[0]);
        }
    }

}
