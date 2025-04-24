package frc.robot;

public class RobotContainer {

   public final CommandSwerveDrivetrain drivetrain = TunerConstants.createDrivetrain();
   
    private double MaxSpeed = TunerConstants.kSpeedAt12Volts.in(MetersPerSecond);
    private double MaxAngularRate = RotationsPerSecond.of(0.75).in(RadiansPerSecond);

    public final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
            .withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1) // Add a 10% deadband
            .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // Use open-loop control for drive motors

    private final Telemetry logger = new Telemetry(MaxSpeed);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        drivetrain.setDefaultCommand();
        drivetrain.registerTelemetry(logger::telemeterize);
    }
}