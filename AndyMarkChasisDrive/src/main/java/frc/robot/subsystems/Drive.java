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

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import java.nio.channels.SocketChannel;
import java.lang.Enum;

public class Drive extends SubsystemBase {

  

  private WPI_VictorSPX m_left1, m_left2, m_right1, m_right2;

  DifferentialDrive drive;

  public Drive() {
      m_left1 = new WPI_VictorSPX(RobotSettings.leftMotor1Id);
      m_left2 = new WPI_VictorSPX(RobotSettings.leftMotor2Id);
      m_right1 = new WPI_VictorSPX(RobotSettings.rightMotor1Id);
      m_right2 = new WPI_VictorSPX(RobotSettings.rightMotor2Id);

      m_right1.setInverted(true);
      m_right2.setInverted(true);

      m_left1.setNeutralMode(NeutralMode.Coast);
      m_left2.setNeutralMode(NeutralMode.Coast);
      m_right1.setNeutralMode(NeutralMode.Coast);
      m_right2.setNeutralMode(NeutralMode.Coast);

      //taken from Andrew
      m_left1.configOpenloopRamp(0.7); // limits acceleration, takes 0.4 seconds to accelerate from 0 to 100%
      m_left2.configOpenloopRamp(0.7); // (helps keep robot from rocking around violently every time driver stops)
      m_right1.configOpenloopRamp(0.7);
      m_right2.configOpenloopRamp(0.7);

      //you can also create motor controller group
      m_left2.follow(m_left1);
      m_right2.follow(m_right2);

      drive = new DifferentialDrive(m_left1, m_right1);     
      
  }

  public void MoveForward(double axis) {
    System.out.println("Right trigger's axis = " + axis);
    drive.arcadeDrive(axis, 0);
  }

  public void MoveBackward(double axis) {
    if (axis > 0){
      System.out.println("Left trigger's axis = " + axis);
      drive.arcadeDrive(axis, 0);
    }
    
    
  }

  public void TurnLeft(double axis) {
    if (axis < -0.1){
      System.out.println("Left Joystick X axis = " + axis);
      drive.arcadeDrive(0, axis);
    }
    
    
  }

  public void TurnRight(double axis) {
    if (axis > 0.1){
      System.out.println("Left Joystick X axis = " + axis);
      drive.arcadeDrive(0, axis);
    }
    
  }

}
