// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class RobotSettings {

    //Drive Type
    public static String driveType = "Arcade";

    //Controller Bindings
    public static String moveForwards = "rightTrigger";
    public static String moveBackwards = "leftTrigger";

    public static String turnRight = "leftJoystick";
    public static String turnLeft = "leftJoystick";

    //Controller Deadzones
    public static double rightTriggerDeadzone = 0.2;
    public static double leftTriggerDeadzone = 0.2;

    public static double[][] rightJoystickDeadzone = {{-0.2, 0.2}, {-0.2, 0.2}}; //{X Left Deadzone, X Right Deadzone}, {Y Down Deadzone, Y Up Deadzone}
    public static double[][] leftJoystickDeadzone = {{-0.2, 0.2}, {-0.2, 0.2}}; //{X Left Deadzone, X Right Deadzone}, {Y Down Deadzone, Y Up Deadzone}
    
    //Motor Ids
    public static int leftMotor1Id = 1;
    public static int leftMotor2Id = 4;

    public static int rightMotor1Id = 2;
    public static int rightMotor2Id = 3;
}
