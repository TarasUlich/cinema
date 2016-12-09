package cinema;

import java.io.Serializable;

import my_exeptions.My_exception;

public class Time implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -403627730511427050L;
	
	private int hour;
	private int min;
	
	
	public Time(int hour, int min) throws My_exception {
		if(min < 0 || min > 60){
			throw new My_exception("Wrong time! Max min -> 60");
		}else{
			this.min = min;
		}
		if(hour < 0 || hour > 24){
			throw new My_exception("Wrong time! Max hour -> 24");
		}else{
			this.hour = hour;
		}
		
		
	}
	

	
	

	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public int getHour() {
		return hour;
	}


	public void setHour(int hour) {
		this.hour = hour;
	}


	


	@Override
	public String toString() {
		return "Time [hour=" + hour + ", min=" + min + "]";
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + min;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (min != other.min)
			return false;
		return true;
	}
	
	
	
	

	
}
