package time_converter;

import java.io.Serializable;

import cinema.Time;
import my_exeptions.My_exception;

public class TimeConverter implements Serializable{


	
/**
	 * 
	 */
	private static final long serialVersionUID = 4631046678842385276L;

//	timeConverterToMinutes	
	public int timeConverterToMinutes(Time time){
		
		return time.getHour()*60 + time.getMin();
	}

//	minutesConverterToTime
	public Time minutesConverterToTime(int minutes) throws My_exception{
		
		int hour = minutes / 60;
		int min = minutes % 60;
		
		return new Time(hour, min);
	}
	
	
	
	
	
	
}
