// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Shoulder;
import frc.robot.subsystems.Wrist;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ZeroAll extends SequentialCommandGroup {
  /** Creates a new Store. */
  public ZeroAll(Shoulder shoulder, Elevator Elevator, Wrist Wrist, Claw Claw) {
    // Add Commands here:
    addCommands(
        new MoveWrist(Wrist).withTimeout(2),
        new MoveElevator(Elevator).withTimeout(4),
        new MoveShoulder(shoulder).withTimeout(3),
        new ClawIntake(Claw).withTimeout(2),
        new InstantCommand(() -> Robot.getInstance().currentArrangementOthers()));

  }

}
