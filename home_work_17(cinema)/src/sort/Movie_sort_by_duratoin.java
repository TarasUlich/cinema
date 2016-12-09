package sort;

import java.io.Serializable;
import java.util.Comparator;

import cinema.Movie;

public class Movie_sort_by_duratoin implements Comparator<Movie>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3296465491214046826L;

	@Override
	public int compare(Movie o1, Movie o2) {
		
		return o1.getTimeDuration() - o2.getTimeDuration();
	}

	
	
}
