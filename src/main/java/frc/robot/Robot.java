package frc.robot;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private static final RobotContainer m_robotContainer = new RobotContainer();

  public Robot() {}

  public static RobotContainer getInstance(){
    return m_robotContainer;
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}
  
  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void teleopExit() {}