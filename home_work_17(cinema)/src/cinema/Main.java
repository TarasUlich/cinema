package cinema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
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

public class Main {

	private static final Scanner SC = new Scanner(System.in);
	
	public static void main(String[] args) throws My_exception, FileNotFoundException, IOException, ClassNotFoundException {
		
		
		Cinema cinema = new Cinema(new Time(6, 00), new Time(24, 0));
		cinema.cinemaStart();
		
		
		

		
		


		
		
		while(true){
			System.out.println(
					 "\n-------------------------------------------------------------"
					+ "\nPut 1 to add movie to schedule for all weak"
					+ "\nPut 2 to add seance"
					+ "\nPut 3 to remove movie"
					+ "\nPut 4 to remove seance"
					+ "\nPut 5 to print cinema"
					+ "\n-------------------------------------------------------------"
					+ "\n");
			
			
			switch (SC.nextLine()) {
			case "1":{
				cinema.addMovie();
				break;
			}
			case "2":{
				cinema.addSeanse();
				break;
			}
			case "3":{
				cinema.removeMovie();
				break;
			}
			case "4":{
				cinema.serelizCinema();
				break;
			}
			case "5":{
				cinema.decerializable();
				break;
			}
			case "6":{
				System.out.println(cinema);
				break;
			}
			default:
				break;
			}
			
			
			
		}
		
		
		
		
		
	
		
		
		
	
	}
	
}
