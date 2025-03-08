package frc.robot;

import java.util.TreeMap;

public class PoseSetter {

	public static final String Feeder = "Feeder";
	public static final String Zero = "Zero";
	public static final String Stored = "Stored";
	public static final String Ground = "Ground";
	public static final String Climb = "Climb";
	public static final String PreClimb = "PreClimb";
	public static final String PreZero = "PreZero";
	public static final String AlgaeRemove = "AlgaeRemove";

	public static final TreeMap<String, double[]> positionsMap = new TreeMap<String, double[]>() {
		private static final long serialVersionUID = 1L;
		{ // place to go to stage 1, stage 2, shoulder

			put("L1", new double[] {
					Constants.ElevatorConstants.stage1LowerLimit,
					Constants.ElevatorConstants.stage2LowerLimit,
					Constants.ShoulderConstants.shoulderLowerLimit,
			});

			put("L2", new double[] {
					Constants.ElevatorConstants.stage1LowerLimit,
					2.7,
					Constants.ShoulderConstants.shoulderLowerLimit,
			});

			put("L3", new double[] {
					1.47,
					5,
					Constants.ShoulderConstants.shoulderLowerLimit,
			});

			put("L4", new double[] {
					Constants.ElevatorConstants.stage1UpperLimit,
					Constants.ElevatorConstants.stage2UpperLimit,
					6,

			}); // dont use

			put(Feeder, new double[] {
					Constants.ElevatorConstants.stage1LowerLimit,
					1,
					120,
			});

			put(Zero, new double[] {
					Constants.ElevatorConstants.stage1LowerLimit,
					Constants.ElevatorConstants.stage2UpperLimit,
					Constants.ShoulderConstants.shoulderLowerLimit,

			});

			put(Stored, new double[] {
					Constants.ElevatorConstants.stage1LowerLimit,
					0.74,
	 				78,

			});

			put(Climb, new double[] {
					-1.25,
					Constants.ElevatorConstants.stage2LowerLimit,
					Constants.ShoulderConstants.shoulderUpperLimit,

			}); // dont use

			put(PreClimb, new double[] {
					1.0f,
					Constants.ElevatorConstants.stage2UpperLimit,
					Constants.ShoulderConstants.shoulderUpperLimit,

			}); // dont use

			put(PreZero, new double[] {
					Constants.ElevatorConstants.stage1UpperLimit / 4,
					Constants.ElevatorConstants.stage2UpperLimit,
					Constants.ShoulderConstants.shoulderLowerLimit,
			});

			put(AlgaeRemove + "L1", new double[] {
				Constants.ElevatorConstants.stage1LowerLimit,
				Constants.ElevatorConstants.stage2LowerLimit,
				12,
			}); //: should be the same for L2

			put(AlgaeRemove + "L2", new double[] {
					Constants.ElevatorConstants.stage1LowerLimit,
					Constants.ElevatorConstants.stage2LowerLimit,
					12,
			});

			put(AlgaeRemove + "L3", new double[] {
				Constants.ElevatorConstants.stage1LowerLimit,
				5,
				10,
		    });

			put(AlgaeRemove + "L4", new double[] {
				Constants.ElevatorConstants.stage1LowerLimit,
				5,
				10,
		    }); //: should be the same as L3

		}
	};

}