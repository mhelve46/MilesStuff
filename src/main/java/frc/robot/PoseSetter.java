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

	public static final TreeMap<String, double[]> positionsMap = new TreeMap<String, double[]>() {
		private static final long serialVersionUID = 1L;
		{ // place to go to stage 1, stage 2, shoulder, wrist
			// IF NO SHOULDER ROTATION
			put("L1", new double[] {
					Constants.ElevatorConstants.stage1LowerLimit,
					Constants.ElevatorConstants.stage2LowerLimit,
					10, 
					Constants.WristConstants.rotationHorizontalAlligned
			});

			put("L2", new double[] {
					Constants.ElevatorConstants.stage1LowerLimit,
					Constants.ElevatorConstants.stage2LowerLimit,
					10,
					Constants.WristConstants.rotationVerticalAlligned
			});

			put("L3", new double[] {
					Constants.ElevatorConstants.stage1LowerLimit,
					2.2,
					10,
					Constants.WristConstants.rotationVerticalAlligned
			});

			put("L4", new double[] {
					Constants.ElevatorConstants.stage1UpperLimit,
					Constants.ElevatorConstants.stage2UpperLimit,
					6,
					Constants.WristConstants.rotationVerticalAlligned

			}); // dont use
		
		// IF SHOULDER WORKS
		// 	put("L1", new double[] {
		// 		Constants.ElevatorConstants.stage1LowerLimit,
		// 		1,
		// 		-30,
		// 		Constants.WristConstants.rotationHorizontalAlligned
		// });

		// put("L2", new double[] {
		// 		Constants.ElevatorConstants.stage1LowerLimit,
		// 		2.3,
		// 		-28,
		// 		Constants.WristConstants.rotationVerticalAlligned
		// });

		// put("L3", new double[] {
		// 		1.5,
		// 		Constants.ElevatorConstants.stage2UpperLimit,
		// 		-28,
		// 		Constants.WristConstants.rotationVerticalAlligned
		// });

		// put("L4", new double[] {
		// 		Constants.ElevatorConstants.stage1UpperLimit,
		// 		Constants.ElevatorConstants.stage2UpperLimit,
		// 		6,
		// 		Constants.WristConstants.rotationVerticalAlligned

		// }); // dont use


		// THESE ARE THE SAME REGARDLESS OF SHOULDER LOCK/ROT

			put(Feeder, new double[] {
					Constants.ElevatorConstants.stage1LowerLimit,
					Constants.ElevatorConstants.stage2LowerLimit + 1.5,
					-61,
					Constants.WristConstants.rotationVerticalAlligned
			});

			put(Zero, new double[] {
					Constants.ElevatorConstants.stage1LowerLimit,
					Constants.ElevatorConstants.stage2UpperLimit,
					Constants.ShoulderConstants.shoulderLowerLimit,
					Constants.WristConstants.rotationHorizontalAlligned

			});

			put(Stored, new double[] {
					Constants.ElevatorConstants.stage1LowerLimit,
					Constants.ElevatorConstants.stage2LowerLimit,
					-103,
					Constants.WristConstants.rotationHorizontalAlligned

			});

			put(Ground, new double[] {
					Constants.ElevatorConstants.stage1LowerLimit,
					Constants.ElevatorConstants.stage2UpperLimit,
					Constants.ShoulderConstants.shoulderUpperLimit,
					Constants.WristConstants.rotationHorizontalAlligned

			}); // dont use

			put(Climb, new double[] {
					-1.25,
					Constants.ElevatorConstants.stage2LowerLimit,
					Constants.ShoulderConstants.shoulderUpperLimit,
					Constants.WristConstants.rotationHorizontalAlligned
			}); // dont use
			
			put(PreClimb, new double[] {
					1.0f,
					Constants.ElevatorConstants.stage2UpperLimit,
					Constants.ShoulderConstants.shoulderUpperLimit,
					Constants.WristConstants.rotationHorizontalAlligned
			}); // dont use

			put(PreZero, new double[] {
				Constants.ElevatorConstants.stage2UpperLimit / 4,
				Constants.ElevatorConstants.stage2UpperLimit,
				Constants.ShoulderConstants.shoulderLowerLimit,
				Constants.WristConstants.rotationHorizontalAlligned
			});

		}
	};

}