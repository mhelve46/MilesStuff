// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Claw;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class AlgaeClawDrop extends Command {
  private final Claw m_claw;

  /** Creates a new ClawDrop. */
  public AlgaeClawDrop(Claw subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.

    m_claw = subsystem;
    addRequirements(m_claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_claw.algaeRotateOutwards();
    m_claw.coralRotateOutwards();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_claw.algaeZero();
    m_claw.coralZero();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !m_claw.getAlgaeDetect() && !m_claw.getCoralDetect();
  }
}
