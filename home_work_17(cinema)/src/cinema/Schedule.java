package cinema;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import my_enums.Days;
import my_exeptions.My_exception;
import sort.SeanceSortByStartTime;
import time_converter.TimeConverter;

public class Schedule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8594400225308410438L;
	
	
	private Set<Seance> seances;
	
	
	public Schedule() {
		
		this.seances = new TreeSet<Seance>(new SeanceSortByStartTime());
	}



//  addSeance
	public void addSeance(Seance seance){
		seances.add(seance);
	}
	
	

//	removeSeance
	public void removeSeance(Seance seance){
		
		if(seances.contains(seance)){
			seances.remove(seance);
		}else{
			System.out.println("No such seance!");
		}
		
	}

	
	
	
	public Schedule(Set<Seance> seances) {
		super();
		this.seances = seances;
	}



	public Set<Seance> getSeances() {
		return seances;
	}




	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}




	@Override
	public String toString() {
		return "Schedule [seances=" + seances + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seances == null) ? 0 : seances.hashCode());
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
		Schedule other = (Schedule) obj;
		if (seances == null) {
			if (other.seances != null)
				return false;
		} else if (!seances.equals(other.seances))
			return false;
		return true;
	}
	
	
	
	
}
