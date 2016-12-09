package cinema;

import java.io.Serializable;

import my_exeptions.My_exception;
import time_converter.TimeConverter;

public class Seance implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7777542915955433309L;
	
	private static final TimeConverter CONVERTER = new TimeConverter();
	
	private Movie movie;
	private Time startTime;
	private Time endTime;
	
	
	
	
	public Seance(Movie movie, Time startTime) throws My_exception {
		
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = getEndTime();
		
	}
	
	
	
	public Time getEndTime() throws My_exception{
		
		Time t = this.startTime;
		int min = t.getMin() + CONVERTER.timeConverterToMinutes(t);
		
		Time time = CONVERTER.minutesConverterToTime(min);
		
		return  time;
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "Seance [movie=" + movie + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		Seance other = (Seance) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}



	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public Time getStartTime() {
		return startTime;
	}


	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}





	


	


	
	
}
