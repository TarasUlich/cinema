package cinema;

import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


import my_enums.Days;
import my_enums.Genre;
import my_exeptions.My_exception;
import sort.CinemaSortByNomberOfDay;
import sort.SeanceSortByStartTime;
import time_converter.TimeConverter;

public class Cinema implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2348236253101078090L;
	
	private static final Scanner SC = new Scanner(System.in); 
	
	private Map<Days, Schedule> map;
	private Time openTime;
	private Time closeTime;
	
	private Genre genre [] = Genre.values();
	private Days days [] = Days.values();
	
	public Cinema(Time openTime, Time closeTime) {
		
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.map = new TreeMap<Days, Schedule>(new CinemaSortByNomberOfDay());
	}
	
	
//	cinemaStart
	public void cinemaStart(){
		for (Days days2 : days) {
			map.put(days2, new Schedule());
		}
	}

	

	
	
	
//	addMovie	
	public void addMovie() throws My_exception{
		
		System.out.println("Print movie title:");
		String title = SC.next();
		System.out.println("Print ganre of movie:");
		String genr = SC.next();
		
		boolean b = true;
		for (Genre genre : this.genre) {
			if(genre.name().equalsIgnoreCase(genr)){
				
				
				System.out.println("Print duration of movie:");
				int timeDuration = SC.nextInt();
				System.out.println("Print hour of beginning");
				int hour = SC.nextInt();
				System.out.println("Print minutes of beginning");
				int min = SC.nextInt();
				
				Time startTime = new Time(hour, min);
				Movie movie = new Movie(title, timeDuration, genre);
				Seance seance = new Seance(movie, startTime);
				
				
				for (Days day : days) {
					if(map.get(day).getSeances().isEmpty()){
						map.get(day).addSeance(seance);
					}else if(checkSchedualForFreeTime(day, seance)){
//						map.get(day).addSeance(seance);
						
						map.get(day).getSeances().add(seance);
					}else{
						System.out.println("Film " + seance.getMovie().getTitle() + " wasnt added in " + day.name() + " because no time fot it!");
					}
					
						
						
			}
				
				
				System.out.println("New seance for all weak was added! "
						+ "\nSeance start on " + startTime.getHour() + ":" + startTime.getMin() + " every day.");
				b = false;
		
			}
		}
			
		
		if(b){
			System.out.println("Wrong ganre!");
		}
		
	}
	
//	addSeanse
	
	public void addSeanse() throws My_exception{
		System.out.println("Print movie title:");
		String title = SC.next();
		System.out.println("Print ganre of movie:");
		String genr = SC.next();
		
		boolean b = true;
		for (Genre genre : this.genre) {
			if(genre.name().equalsIgnoreCase(genr)){
				
				
				System.out.println("Print duration of movie:");
				int timeDuration = SC.nextInt();
				System.out.println("Print hour of beginning");
				int hour = SC.nextInt();
				System.out.println("Print minutes of beginning");
				int min = SC.nextInt();
				System.out.println("Print day for wich you fant add seanse");
				String sea = SC.next();
				
				Time startTime = new Time(hour, min);
				Movie movie = new Movie(title, timeDuration, genre);
				Seance seance = new Seance(movie, startTime);
				
				String s = "";
				boolean m = true;
				for (Days day : days) {
					if(checkSchedualForFreeTime(day, seance) && day.name().equalsIgnoreCase(sea)){
						map.get(day).addSeance(seance);
						
//						map.get(day).getSeances().add(seance);
						System.out.println("New seance for " + day.name() + " was added! "
								+ "\nSeance start on " + startTime.getHour() + ":" + startTime.getMin() + " every day.");
						m = false;
						s = day.name();
					}
				}
				
				if(m){
					System.out.println("Film " + seance.getMovie().getTitle() + " wasnt added in " + s + " because no time for it!");
				}
				b = false;
		
			}
		}
		
		if(b){
			System.out.println("No such ganre!");
		}
	}
	
//	removeMovie
	
	public void removeMovie(){

		System.out.println("Print day from wich you fant to remove movie");
		String sea = SC.next();
		
		boolean b = true;
		for (Days day : days) {
			if(day.name().equalsIgnoreCase(sea)){
				System.out.println("Print movie title wich you want to remove:");
				String title = SC.next();
				
				Iterator<Seance> iterator = map.get(day).getSeances().iterator();
				
				boolean m = true;
				while(iterator.hasNext()){
					Seance seance = iterator.next();
					
					if(seance.getMovie().getTitle().equalsIgnoreCase(title)){
						iterator.remove();
						System.out.println("Movie " + seance.getMovie().getTitle() + " was removed!");
						m = false;
					}
				}
				
				if(m){
					
					System.out.println("No such movie!");
				}
				b = false;
				
			}	
		}
		
		if(b){
			System.out.println("No such day!");
		}	
		
	}
	
//	checkSchedualForFreeTime
	public boolean checkSchedualForFreeTime(Days day, Seance seance) throws My_exception{
		
		TimeConverter converter = new TimeConverter();
		
		int minStartTime = converter.timeConverterToMinutes(seance.getStartTime());
		int minEndTime = converter.timeConverterToMinutes(seance.getEndTime());

		int minTimeOpen = converter.timeConverterToMinutes(openTime);
		int minCloseTime = converter.timeConverterToMinutes(closeTime);
		
		Set<Seance> set = map.get(day).getSeances();
		
		boolean b = true;
		for (Seance seance2 : set) {
			int minStartTime2 = converter.timeConverterToMinutes(seance2.getStartTime());
			int minEndTime2 = converter.timeConverterToMinutes(seance2.getEndTime());
			
			if((minStartTime > minStartTime2 && minStartTime < minEndTime2) 
					|| (minEndTime > minStartTime2 && minEndTime < minEndTime2)
					|| (minStartTime < minStartTime2 && minEndTime > minEndTime2)
					|| (minStartTime < minTimeOpen)
					|| (minStartTime > minCloseTime)
					|| (minEndTime > minCloseTime)
					|| (minEndTime < minTimeOpen)){
				b = false;
			}
		}
		
		return b;
		
	}
	


//	sereliz
	public void serelizCinema() throws IOException{
		FileOutputStream fileOutputStream = new FileOutputStream("map.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(map);
		objectOutputStream.flush();
		objectOutputStream.close();
	}
	
	
	public void decerializable() throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream("map.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Map<Days, Schedule> map = (Map<Days, Schedule>) objectInputStream.readObject();

		System.out.println(map);

	}



	@Override
	public String toString() {
		
		
		
		String s = 
				"\n"+"--------------------------------------------------"
				+ "\n"+"Cinema "
				+  "\n"+"		open in: " + openTime.getHour() + ":" + openTime.getMin() 
				+  "\n"+"		close in: " + closeTime.getHour() + ":" + closeTime.getMin()
				+  "\n"+"--------------------------------------------------";
		
		
		
		
		
		
		
		String s2 = "";
		for (Days days2 : days) {
			String s3 = "";
			for(Seance seance : map.get(days2).getSeances()){
				
				s3 =  "Movie name: " + seance.getMovie().getTitle() + 
						" Movie begin: " + seance.getStartTime().getHour() +":"+ seance.getStartTime().getMin() 
						+"\n"+s3;
			}
			
			s2 = 
				  "\n"+ days2.name() +"\n"+"--------------------------------------------------"
				  + "\n" + "      Seanses:"+"\n"  + s3  
				  +"\n"+"--------------------------------------------------"+s2
					;
			
		}
		
		
		
		
		return s + s2;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((closeTime == null) ? 0 : closeTime.hashCode());
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		result = prime * result + ((openTime == null) ? 0 : openTime.hashCode());
		return result;
	}


//	@Override
//	public String toString() {
//		return "Cinema [map=" + map + ", openTime=" + openTime + ", closeTime=" + closeTime + ", genre="
//				+ Arrays.toString(genre) + ", days=" + Arrays.toString(days) + "]";
//	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cinema other = (Cinema) obj;
		if (closeTime == null) {
			if (other.closeTime != null)
				return false;
		} else if (!closeTime.equals(other.closeTime))
			return false;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		if (openTime == null) {
			if (other.openTime != null)
				return false;
		} else if (!openTime.equals(other.openTime))
			return false;
		return true;
	}


	public Map<Days, Schedule> getMap() {
		return map;
	}


	public void setMap(Map<Days, Schedule> map) {
		this.map = map;
	}


	public Time getOpenTime() {
		return openTime;
	}


	public void setOpenTime(Time openTime) {
		this.openTime = openTime;
	}


	public Time getCloseTime() {
		return closeTime;
	}


	public void setCloseTime(Time closeTime) {
		this.closeTime = closeTime;
	}
	
	
	
	
	
	
}
