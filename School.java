package i.University;

import java.util.ArrayList;
import java.util.List;

public abstract class School{
	private int id;
	private String name;
	private String address;
	protected int tax;
	
	public School(){}
	public School(int id, String name, String address) 
	{
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getTax() {
		return tax;
	}

	@Override
	public String toString() 
	{
		return "School [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	//Method for calculate the average grade of students 
	public double calcAverageGrade(ArrayList<Student> list)
	{
		double sum = 0.0;
		int studentsCount = 0;
		for(Student student : list)
		{
			if (student.getStudentEntityId() == id)
			{
				sum+= student.getStudentAvgGrade();
				studentsCount++;
			}
				
		}
		try
		{
			if (studentsCount!=0.0)
				return sum/studentsCount;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sum/studentsCount;
	}
}


