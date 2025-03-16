// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANdi;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Claw extends SubsystemBase {
  /** Creates a new Claw. */

  private SparkMax coralClawMotor;
  private SparkMax algaeClawMotor;
  private CANdi clawCandi;
  private DigitalInput coralSwitch;
  private DigitalInput algaeSwitch;

  public Claw() {

    clawCandi = new CANdi(30, "rio");
    coralSwitch = new DigitalInput(1);
    algaeSwitch = new DigitalInput(2);

    coralClawMotor = new SparkMax(18, SparkLowLevel.MotorType.kBrushless);
    SparkMaxConfig CoralSparkMaxConfig = new SparkMaxConfig();
    CoralSparkMaxConfig.inverted(true);
    CoralSparkMaxConfig.idleMode(IdleMode.kBrake);
    CoralSparkMaxConfig.smartCurrentLimit(10, 10);
    coralClawMotor.configure(CoralSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    algaeClawMotor = new SparkMax(17, SparkLowLevel.MotorType.kBrushless);
    SparkMaxConfig AlgaeSparkMaxConfig = new SparkMaxConfig();
    AlgaeSparkMaxConfig.inverted(true);
    AlgaeSparkMaxConfig.idleMode(IdleMode.kBrake);
    AlgaeSparkMaxConfig.smartCurrentLimit(5, 10);
    algaeClawMotor.configure(AlgaeSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Coral", getCoralDetect());
    SmartDashboard.putBoolean("Algae", getAlgaeDetect());
  }
  public Boolean getCoralDetect() {
    return !clawCandi.getS2Closed().getValue();
  }

  public Boolean getAlgaeDetect() {
    return !clawCandi.getS1Closed().getValue();
  }

  public void coralRotateInwards() {
    coralClawMotor.set(.5);
  }

  public void algaeRotateInwards() {
    coralClawMotor.set(.5);
  }

  public void coralRotateOutwards() {
    coralClawMotor.set(-1);
  }

  public void algaeRotateOutwards() {
    coralClawMotor.set(-1);
  }

  public void coralZero() {
    coralClawMotor.set(0);
  }

  public void algaeZero() {
    coralClawMotor.set(0);
  }

 

}
