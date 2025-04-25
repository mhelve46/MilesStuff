package frc.robot;

public class Robot extends TimedRobot {
  private static final RobotContainer m_robotContainer = new RobotContainer();

  public Robot() {}

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }
}
