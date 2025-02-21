// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.ctre.phoenix6.controls.VoltageOut;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.system.Discretization;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Claw extends SubsystemBase {
  /** Creates a new Claw. */

  private SparkMax clawMotor;

  public Claw() {

    clawMotor = new SparkMax(18, SparkLowLevel.MotorType.kBrushless);

    SparkMaxConfig NewSparkMaxConfig = new SparkMaxConfig();
    clawMotor.configure(NewSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    NewSparkMaxConfig.inverted(false);
    NewSparkMaxConfig.idleMode(IdleMode.kBrake);
    NewSparkMaxConfig.smartCurrentLimit(10, 10);

  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Claw Holding", getClawHoldingDetector());

  }

  public void rotateInwards() {
    clawMotor.set(.7);
  }

  public void rotateOutwards() {
    clawMotor.set(-1);
  }

  public void zero() {
    clawMotor.set(0);
  }

  public boolean getClawHoldingDetector() {
      return Robot.getInstance().getCoralDetect();
  }

}
