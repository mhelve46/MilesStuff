// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Claw extends SubsystemBase {
  /** Creates a new Claw. */

  private SparkMax clawMotor;
  private AnalogInput clawHoldingDetector;

  public Claw() {

    clawMotor = new SparkMax(18, SparkLowLevel.MotorType.kBrushless);

    SparkMaxConfig NewSparkMaxConfig = new SparkMaxConfig();
    clawMotor.configure(NewSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    NewSparkMaxConfig.inverted(false);
    NewSparkMaxConfig.idleMode(IdleMode.kCoast);

    clawHoldingDetector = new AnalogInput(0);
    addChild("ClawHoldingDetector", clawHoldingDetector);

  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Claw Holding", getClawHoldingDetector());
    SmartDashboard.putNumber("Distance (Volts)", getVoltage());
    SmartDashboard.putNumber("Distance (real)", getDistance());

  }

  public void rotateInwards() {
    clawMotor.set(0.10);
  }

  public void rotateOutwards() {
    clawMotor.set(-0.10);
  }

  public void zero() {
    clawMotor.set(0);
  }

  public boolean getClawHoldingDetector() {
    // clawHoldingDetector.getValue
    // if (getDistance() < 3) {
    if (getVoltage() < 3.8) {
      return true;
    } else
      return false;
  }

  public double getVoltage() {
    return clawHoldingDetector.getVoltage();
  }

  public double getDistance() {
    double distance = getVoltage() * Constants.ClawConstants.VOLTS_TO_DIST + 1.0;
    return distance;
  }
}
