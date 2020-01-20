package i.University;

import java.util.ArrayList;
import java.util.Random;

public class GenerateRandom 
	{
		 ArrayList<String> listOfAddresses;
		public GenerateRandom(){
			
			listOfAddresses = new ArrayList<>();
		    listOfAddresses.add("Studentska 1");
		    listOfAddresses.add("Gen. Kolev 2");
		    listOfAddresses.add("Slivnitsa 3");
		    listOfAddresses.add("Vladislav Varnenchik 4");
		    listOfAddresses.add("Tsar Osvoboditel 5");
		}
		
	Random r = new Random();
	
    public double generateGrade()
    	{
    	return 2.0 + (6.0 - 2.0) * r.nextDouble();
    	}
    
    public String getAddresses(int index)
    {
    	return listOfAddresses.get(index);
    }
    
}
