package frc.robot;

import java.util.TreeMap;

public class PoseSetter {
    	public static final TreeMap<String, double[]> positionsMap = new TreeMap<String, double[]>() {
		private static final long serialVersionUID = 1L;
			// TODO tune values
			{   // place to go to   stage 1, stage 2, shoulder, wrist
				put( "L1", new double[] { 0, 5, 270, 0 });
				put( "L2", new double[] { 0, 10, 270, 90 });
				put( "L3", new double[] { 5, 10, 270, 90 });
				put( "L4", new double[] { 10, 10, 180, 90 });
				put( "Feeder", new double[] { 0, 5, 90, 90});
				put( "Zero", new double[] { 0, 10, 0, 0});
				put( "Stored", new double[] { 0, 5, 30, 0});
				put( "Ground", new double[] { 0, 10, 300, 0});
				put( "Climb" , new double[] { -5, 0, 300, 0,});

		}
	};

}
