package cinema;

import java.io.*;


public class Sereliz {

	private File file;
	
	
	
	public Sereliz(String fileName) {
		
		file = new File(fileName);
	}
	
	

	public void serelizIn(Cinema cinema) throws FileNotFoundException, IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, true));
		
		oos.writeObject(cinema);
		oos.flush();
//		oos.close();
	}
	
	public Object serelizOut() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		
		
		
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			
			Object object = (Object) ois.readObject();
			
	//		ois.close();
			return object;
		
	}
	
}
