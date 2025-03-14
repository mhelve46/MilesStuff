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
	public static final String AlgaeGrab = "AlgaeRemove";
	public static final String Processor = "Processor";
	public static final String LowAlgaeGrab = "LowAlgaeGrab";

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
					1.9,
					Constants.ShoulderConstants.shoulderLowerLimit,
			});

			put("L3", new double[] {
					1.47,
					4.1,
					Constants.ShoulderConstants.shoulderLowerLimit,
			});

			put("L4", new double[] {
					Constants.ElevatorConstants.stage1UpperLimit,
					Constants.ElevatorConstants.stage2UpperLimit,
					6,

			});

			put(Feeder, new double[] {
					Constants.ElevatorConstants.stage1LowerLimit,
					2.05,
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

			});

			put(PreClimb, new double[] {
					1.0f,
					Constants.ElevatorConstants.stage2UpperLimit,
					Constants.ShoulderConstants.shoulderUpperLimit,

			});

			put(PreZero, new double[] {
					Constants.ElevatorConstants.stage1UpperLimit / 4,
					Constants.ElevatorConstants.stage2UpperLimit,
					Constants.ShoulderConstants.shoulderLowerLimit,
			});

			put(AlgaeGrab + "L1", new double[] {
				Constants.ElevatorConstants.stage1LowerLimit,
				Constants.ElevatorConstants.stage2LowerLimit,
				12,
			});

			put(AlgaeGrab + "L2", new double[] {
					Constants.ElevatorConstants.stage1LowerLimit,
					Constants.ElevatorConstants.stage2LowerLimit,
					12,
			});

			put(AlgaeGrab + "L3", new double[] {
				Constants.ElevatorConstants.stage1LowerLimit,
				Constants.ElevatorConstants.stage2UpperLimit,
				10,
		    });

			put(AlgaeGrab + "L4", new double[] {
				Constants.ElevatorConstants.stage1LowerLimit,
				5,
				10,
		    });

			put(Processor, new double[]{
				Constants.ElevatorConstants.stage1LowerLimit,
				Constants.ElevatorConstants.stage2LowerLimit,
				0
			});

			put(LowAlgaeGrab, new double[] {
				Constants.ElevatorConstants.stage1LowerLimit,
				Constants.ElevatorConstants.stage2LowerLimit,
				130,
		    });

		}
	};

}