package i.University;

import java.util.ArrayList;

public class University extends School {

	protected ArrayList<Student> listOfUniversities;
	
	public University(){}
	public University(int id, String name, String address) 
	{
		super(id, name, address);
		tax=100;
	}
		
}
