package sort;

import java.io.Serializable;
import java.util.Comparator;

import my_enums.Days;

public class CinemaSortByNomberOfDay implements Comparator<Days>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2374427947499145456L;

	@Override
	public int compare(Days o1, Days o2) {
		
		return o1.getNomberOfDay() - o2.getNomberOfDay();
	}

}
