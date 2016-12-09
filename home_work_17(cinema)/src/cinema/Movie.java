package cinema;



import java.io.Serializable;

import my_enums.Genre;
import my_exeptions.My_exception;

public class Movie implements Serializable{

/*	*//**
	 * 
	 *//*
	private static final long serialVersionUID = -8184113739912755672L;*/
	
	private String title;
	private int timeDuration;
	private Genre genre;
	
	
	
	
	public Movie(String title, int timeDuration, Genre genre) throws My_exception {
		
		this.title = title;
		if(timeDuration  >= 5*60){
			throw  new My_exception("Too long film!");
		}else{
			this.timeDuration = timeDuration;
		}
		
		this.genre = genre;
	}


	
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getTimeDuration() {
		return timeDuration;
	}


	public void setTimeDuration(int timeDuration) {
		this.timeDuration = timeDuration;
	}


	public Genre getGenre() {
		return genre;
	}


	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return "Movie [title=" + title + ", timeDuration=" + timeDuration + ", genre=" + genre + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + timeDuration;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Movie other = (Movie) obj;
		if (genre != other.genre)
			return false;
		if (timeDuration != other.timeDuration)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}



	
	
}
