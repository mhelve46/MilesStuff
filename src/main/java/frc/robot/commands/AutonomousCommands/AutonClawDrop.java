// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Algae;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class AutonClawDrop extends Command {
  private final Claw m_claw;
  private final Algae m_algae;

  /** Creates a new ClawDrop. */
  public AutonClawDrop(Claw subsystem, Algae subsystem2) {
    // Use addRequirements() here to declare subsystem dependencies.

    m_claw = subsystem;
    m_algae = subsystem2;
    addRequirements(m_claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_claw.coralRotateOutwards();
    m_algae.algaeRotateOutwards();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_claw.coralZero();
    m_algae.algaeZero();
    if (Robot.COMMAND_DEBUG) System.out.println("end claw");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !Robot.getInstance().getCoralDetect() && !Robot.getInstance().getAlgaeDetect();
  }
}