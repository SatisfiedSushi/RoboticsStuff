// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.lang.Object;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.music.Orchestra;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.Filesystem.*;

public class MusicPlayer extends SubsystemBase {
  private Orchestra orchestra;
  private WPI_TalonFX m_left1, m_left2, m_right1, m_right2;


  /** Creates a new ExampleSubsystem. */
  public MusicPlayer() {
    orchestra = new Orchestra();

    m_left1 = new WPI_TalonFX(Constants.motor_left1);
    m_left2 = new WPI_TalonFX(Constants.motor_left2);
    m_right1 = new WPI_TalonFX(Constants.motor_right1);
    m_right2 = new WPI_TalonFX(Constants.motor_right2);

    m_left1.setNeutralMode(NeutralMode.Brake); // only one motor brakes on each side for a weaker brake effect
    m_left2.setNeutralMode(NeutralMode.Coast);
    m_right1.setNeutralMode(NeutralMode.Brake);
    m_right2.setNeutralMode(NeutralMode.Coast);

    m_left1.configOpenloopRamp(0.4); // limits acceleration, takes 0.4 seconds to accelerate from 0 to 100%
    m_left2.configOpenloopRamp(0.4); // (helps keep robot from rocking around violently every time driver stops)
    m_right1.configOpenloopRamp(0.4);
    m_right2.configOpenloopRamp(0.4);

    orchestra.addInstrument(m_left1);
    orchestra.addInstrument(m_left2);
    orchestra.addInstrument(m_right1);
    orchestra.addInstrument(m_right2);

    orchestra.loadMusic("/src/main/deploy/sickomode.chrp");
    if (!orchestra.isPlaying()) {
      orchestra.stop();
      System.out.println("Stopped");
    }
  }

  public void PlayMusic() {
    if (!orchestra.isPlaying()) {
      orchestra.play();
      System.out.println("Playing");
    }
  }

  public void StopMusic() {
    if (!orchestra.isPlaying()) {
      orchestra.stop();
      System.out.println("Stopped");
    }
  }
}
