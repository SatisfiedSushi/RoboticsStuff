package frc.robot;

import java.io.*;
import java.lang.reflect.Method;
import edu.wpi.first.wpilibj.Joystick;
import javax.swing.tree.ExpandVetoException;

import java.lang.Thread;

//import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ExampleCommand;

import java.lang.Enum;

public class UserInput{
    
    edu.wpi.first.wpilibj.XboxController controller;

    //public properties
    public boolean isAPressed, isBPressed, isXPressed, isYPressed, isRightTriggerPressed, isLeftTriggerPressed, isRightBumpPressed, isLeftBumpPressed, isDpadLeftPressed, isDpadRightPressed, isDpadDownPressed, isDPadUpPressed, isSelectPressed, isStartPressed, isJoystickLeftPressed, isJoystickRightPressed;
    public String joystickLeftDirection, joystickRightDirection;
    public double[] joystickLeftAxisValue, joystickRightAxisValue;
    public double leftTriggerAxisValue, rightTriggerAxisValue;

    public UserInput() {

        controller = new edu.wpi.first.wpilibj.XboxController(0);

        Run();
    }

    public void Run() {
        GetControllerButtons();
        GetControllerTriggers();
        GetControllerJoysticks();
        SetControllerValues();
    }

    private void SetControllerValues() {

        //Trigger axis values
        leftTriggerAxisValue = controller.getLeftTriggerAxis();

        rightTriggerAxisValue = controller.getRightTriggerAxis();

        //Joystick axis values
        joystickLeftAxisValue = new double[2];
        joystickLeftAxisValue[0] = controller.getLeftX();
        joystickLeftAxisValue[1] = controller.getLeftY();

        joystickRightAxisValue = new double[2];
        joystickRightAxisValue[0] = controller.getRightX();
        joystickRightAxisValue[1] = controller.getRightY();

    }

    private void GetControllerButtons() {

        if (controller.getAButton()) {
            isAPressed = true;
        } else {
            isAPressed = false;
        }

        if (controller.getBButton()) {
            isBPressed = true;
        } else {
            isBPressed = false;
        }

        if (controller.getXButton()) {
            isXPressed = true;
        } else {
            isXPressed = false;
        }

        if (controller.getYButton()) {
            isYPressed = true;
        } else {
            isYPressed = false;
        }

    }

    /*private void GetControllerDPadInput() {

    }*/

    private void GetControllerTriggers() {

        if (controller.getLeftTriggerAxis() > RobotSettings.leftTriggerDeadzone) {
            isLeftTriggerPressed = true;
        } else {
            isLeftTriggerPressed = false;
        }

        if (controller.getRightTriggerAxis() > RobotSettings.leftTriggerDeadzone) {
            isRightTriggerPressed = true;
        } else {
            isRightTriggerPressed = false;
        }

    }

    private void GetControllerJoysticks() {

        String xDirection = "null";
        String yDirection = "null";

        //Left joystick
        if (controller.getLeftX() < RobotSettings.leftJoystickDeadzone[0][0]) {
            xDirection = "left";
        } else if (controller.getLeftX() > RobotSettings.leftJoystickDeadzone[0][1]) {
            xDirection = "right";
        } else {
            xDirection = "null";
        }

        if (controller.getLeftY() < RobotSettings.leftJoystickDeadzone[1][0]) {
            yDirection = "down";
        } else if (controller.getLeftY() > RobotSettings.leftJoystickDeadzone[1][1]) {
            yDirection = "up";
        } else {
            yDirection = "null";
        }

        if (xDirection != "null" && yDirection != "null") {
            joystickLeftDirection =  yDirection + xDirection;
        } else if (xDirection == "null" && yDirection != "null") {
            joystickLeftDirection = yDirection;
        } else if (xDirection != "null" && yDirection == "null"){
            joystickLeftDirection = xDirection;
        } else {
            joystickLeftDirection = "null";
        }

        //Right joystick
        if (controller.getRightX() < RobotSettings.rightJoystickDeadzone[0][0]) {
            xDirection = "right";
        } else if (controller.getRightX() > RobotSettings.rightJoystickDeadzone[0][1]) {
            xDirection = "right";
        } else {
            xDirection = "null";
        }

        if (controller.getRightY() < RobotSettings.rightJoystickDeadzone[1][0]) {
            yDirection = "down";
        } else if (controller.getRightY() > RobotSettings.rightJoystickDeadzone[1][1]) {
            yDirection = "up";
        } else {
            yDirection = "null";
        }

        if (xDirection != "null" && yDirection != "null") {
            joystickRightDirection =  yDirection + xDirection;
        } else if (xDirection == "null" && yDirection != "null") {
            joystickRightDirection = yDirection;
        } else if (xDirection != "null" && yDirection == "null") {
            joystickRightDirection = xDirection;
        } else {
            joystickRightDirection = "null";
        }
        
    }

}
