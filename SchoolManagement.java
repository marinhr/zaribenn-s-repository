package i.University;

import java.util.ArrayList;
import java.util.Collections;

public class SchoolManagement

	{
		ArrayList<Student> listOfStudents = new ArrayList<>();
		ArrayList<HighSchool> listOfHighSchools = new ArrayList<>();
		ArrayList<University> listOfUniversities = new ArrayList<>();
		GenerateRandom rand = new GenerateRandom();
		public double avgGrade;
		public double allGrades;
		Student student;
		int numberOfStudentsPerEntity = 10;

		//Method for Adding students to high school
		public void addStudent() 
		{

			int schoolEntityId = 1;
			for (int i = 1; i < 31; i++) {
				if (i % 2 == 0)
					student = new Student("Student" + i, 18, "Male", schoolEntityId, rand.generateGrade());
				else
					student = new Student("Student" + i, 18, "Female", schoolEntityId, rand.generateGrade());
				System.out.println(student);
				listOfStudents.add(student);
				allGrades += student.getStudentAvgGrade();
				avgGrade = allGrades / i;
				System.out.println("Hello, " + student.getStudentName() + " and welcome to "
						+ listOfHighSchools.get(student.getStudentEntityId() - 1).getName());
				if (i % 10 == 0 && i != 1)
					schoolEntityId++;
			}
		}
		//Method for adding students to universities
		public void addStudentToUni() 
		{
			int uniEntityId = 4;
			for (int i = 31; i < 51; i++) 
			{
				if (i % 2 == 0)
					student = new Student("Student" + i, 18, "Male", uniEntityId, rand.generateGrade());
				else
					student = new Student("Student" + i, 18, "Female", uniEntityId, rand.generateGrade());
				System.out.println(student);
				listOfStudents.add(student);
				System.out.println("Hello, " + student.getStudentName() + " and welcome to " + listOfUniversities
						.get(student.getStudentEntityId() - (listOfHighSchools.size() + 1)).getName());
				if (i % 10 == 0 && i != 1) 
					uniEntityId++;
			}
		}
		//Method for adding high schools
		public void addHighSchools() 
		{
			GenerateRandom random = new GenerateRandom();
			HighSchool highschool;
			for (int i = 1; i < 4; i++) 
			{
				highschool = new HighSchool(i, "HighSchool" + i, random.getAddresses(i));
				listOfHighSchools.add(highschool);
			}
		}
		//Method for adding universities
		public void addUniversities() 
		{
			GenerateRandom random = new GenerateRandom();
			University university;
			for (int i = 1; i < 3; i++) 
			{
				university = new University(i, "University" + i, random.getAddresses(i));
				listOfUniversities.add(university);
			}
		}
		//Method for calculate all the student grades
		public void calcAllStudentsGrades() {

			for(int i=0;i<3;i++)
			{
				System.out.printf("Average grades for HighSchool %d:\n %.2f\n", i+1,listOfHighSchools.get(i).calcAverageGrade(listOfStudents));
			}
			for(int i=0;i<2;i++)
			{
				System.out.printf("Average grade for University %d:\n%.2f\n", i+1, listOfUniversities.get(i).calcAverageGrade(listOfStudents));
			}

		}
		//Method for calculating all the income for all schools and who the top contributer is
		public void allIncome()
		{
			double totalIncome = 0.0;
			double maxIncome = 0.0;
			Student student1= new Student(); 
			for(Student student : listOfStudents)
			{
				double taxes= student.calcTax(listOfHighSchools, listOfUniversities, listOfStudents);;
				if (maxIncome < taxes){
					maxIncome = totalIncome;
					student1 = student;
				}
				totalIncome += taxes;
			}
			
			System.out.printf("Total income: %.2f\n", totalIncome);
			System.out.println("Top contributer: "+ student1.getStudentName() + " - " + student.calcTax(listOfHighSchools, listOfUniversities, listOfStudents));
		}

		// Define the student with best average grade
		public Student topStudent() {
			Collections.sort(listOfStudents);
			Student topStudent = listOfStudents.get(0);
			return topStudent;
		}
		//Define the best student from other gender 
		public void topStudentByGender() 
		{
			for (int i = 0; i < listOfStudents.size(); i++) 
			{
				if (!listOfStudents.get(i).getStudentGender().equals(topStudent().getStudentGender())) 
				{
					System.out.println("Top student from other gender:\n " + listOfStudents.get(i));
					break;
				}
			}
		}

		public ArrayList<Student> getStudentsList() {
			return listOfStudents;
		}

		public ArrayList<HighSchool> getHighSchoolList() {
			return listOfHighSchools;
		}

		public ArrayList<University> getUniversitiesList() {
			return listOfUniversities;
		}
	}
