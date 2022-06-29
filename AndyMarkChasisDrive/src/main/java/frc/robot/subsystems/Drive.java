// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.io.*;
import java.lang.reflect.Method;
import edu.wpi.first.wpilibj.Joystick;
import javax.swing.tree.ExpandVetoException;

import java.lang.Thread;

import frc.robot.UserInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.RobotSettings;
import frc.robot.UserInput;
import frc.robot.commands.ExampleCommand;

import java.nio.channels.SocketChannel;
import java.lang.Enum;

public class Drive extends SubsystemBase {

  UserInput input; 

  public Drive() {
    
    RunLoop();
  }

  private void RunLoop() {
    input = new UserInput();
    while (true) {
      input.Run();
      if (input.isRightTriggerPressed) {
        MoveForward(input.rightTriggerAxisValue);
      } else if (input.isLeftTriggerPressed) {
        MoveBackward(input.leftTriggerAxisValue);
      }

      if (input.joystickLeftDirection == "left" || input.joystickLeftDirection == "upleft" || input.joystickLeftDirection == "downleft") {
        TurnLeft(input.joystickLeftAxisValue[0]);
      } else if (input.joystickLeftDirection == "right" || input.joystickLeftDirection == "upright" || input.joystickLeftDirection == "downright") {
        TurnRight(input.joystickLeftAxisValue[0]);
      }
    }
  }

  private void MoveForward(double axis) {
    System.out.println("Right trigger's axis = " + axis);
  }

  private void MoveBackward(double axis) {
    if (axis > 0){
      System.out.println("Left trigger's axis = " + axis);
    }
    
  }

  private void TurnLeft(double axis) {
    if (axis < -0.1){
      System.out.println("Left Joystick X axis = " + axis);
    }
    
  }

  private void TurnRight(double axis) {
    if (axis > 0.1){
      System.out.println("Left Joystick X axis = " + axis);
    }
    
  }

}
