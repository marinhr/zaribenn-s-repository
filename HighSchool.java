package i.University;

public class HighSchool extends School
	{

		public HighSchool(){}
		public HighSchool(int id, String name, String address) {
			super(id, name, address);
			tax = 50;
		}
	}