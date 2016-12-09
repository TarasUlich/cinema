package sort;

import java.io.Serializable;
import java.util.Comparator;

import cinema.Seance;

public class SeanceSortByStartTime implements Comparator<Seance>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6944691121156094211L;

	@Override
	public int compare(Seance o1, Seance o2) {
//		int o1h = o1.getStartTime().getHour();
//		int o1m = o1.getStartTime().getMin();
//		
//		int o1StartTime = o1h*60 + o1m;
//		
//		int o2h = o1.getStartTime().getHour();
//		int o2m = o1.getStartTime().getMin();
//		
//		int o2StartTime = o2h*60 + o2m;
		
		
		
//		return o1StartTime - o2StartTime;
		
		
		return o1.getStartTime().getHour() - o2.getStartTime().getHour();
	}

}
