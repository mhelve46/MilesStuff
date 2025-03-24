// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.PoseSetter;
import frc.robot.Robot;
import frc.robot.commands.MoveElevator;
import frc.robot.commands.MoveShoulder;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Shoulder;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonStore extends SequentialCommandGroup {
  /** Creates a new AutonStore. */
  public AutonStore(Elevator m_elevator, Shoulder m_shoulder) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new InstantCommand(() -> Robot.getInstance().goalArrangementOthers(PoseSetter.Stored)),
      new MoveShoulder(m_shoulder),
      new MoveElevator(m_elevator),
      new InstantCommand(() -> Robot.getInstance().currentArrangementOthers(PoseSetter.Stored))
    );
  }
}
