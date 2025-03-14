package frc.robot.subsystems;

import java.util.Optional;

import com.ctre.phoenix6.Utils;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.LimelightHelpers;

public class Vision extends SubsystemBase {

    private static final Vision m_Vision = new Vision();
    public boolean tempDisable = false;
    private double timestampToReEnable;
    private String _limelightName = Constants.VisionConstants.limeLightName;

    public static Vision getInstance() {
        return m_Vision;
    }

    public Vision() {
        
        LimelightHelpers.setCameraPose_RobotSpace(_limelightName, -0.09, 0, 0.44, 0, 0,0);
        // LimelightHelpers.setCameraPose_RobotSpace(Constants.VisionConstants.limeLightName, -0.09, 0.22, 0.49, 0, -5,0); // not normal one
        LimelightHelpers.setCameraPose_RobotSpace(Constants.VisionConstants.limeLightName2, -0.093, 0, 0.44, 0, 21, 0);
    }

    @Override
    public void periodic() {
        if (timestampToReEnable < Utils.getCurrentTimeSeconds() && tempDisable == true){
            tempDisable = false; 
        }
        SmartDashboard.putBoolean("tempDisable", tempDisable);
    }

    public Alliance MyAlliance() {
        Optional<Alliance> ally = DriverStation.getAlliance();
        if (ally.isPresent()) {
            return ally.get() == Alliance.Red ? Alliance.Red : Alliance.Blue;
        } else {
            return null;
        }
    }

    // public boolean AllianceTargetAquired() {
        // boolean targetAquired = LimelightHelpers.getTV(_limelightName);
        // if (targetAquired) {
        //     int targetID = (int) LimelightHelpers.getFiducialID(_limelightName);
        //     if ((targetID >= 0) && (targetID <= 16))
        //         return (MyAlliance() == _tagApproches.TagAlliance(targetID));
        //     else
        //         return false;
        // }
        // return false;
    // }

    public void tempDisable(double seconds) {
        tempDisable = true;
        double currentTime = Utils.getCurrentTimeSeconds();
        timestampToReEnable = currentTime + seconds;
    }
}