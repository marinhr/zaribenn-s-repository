package i.University;

import java.util.ArrayList;

public class Student implements Comparable<Object>
	{
		private String studentName;
		private int studentAge;
		private String studentGender;
		private int studentEntityId;
		private double studentAvgGrade;

		public Student(String studentName, int studentAge, String studentGender, int studentEntityId,
				double studentAvgGrade) {
			this.studentName = studentName;
			this.studentAge = studentAge;
			this.studentGender = studentGender;
			this.studentEntityId = studentEntityId;
			this.studentAvgGrade = studentAvgGrade;
		}

		public Student() {}

		@Override
		public String toString() {
			return "Student [studentName=" + studentName + ", studentAge=" + studentAge + ", studentGender="
					+ studentGender + ", studentEntityId=" + studentEntityId + ", studentGrade=" + studentAvgGrade
					+ "]";
		}

		public String getStudentName() {
			return studentName;
		}

		public int getStudentAge() {
			return studentAge;
		}

		public String getStudentGender() {
			return studentGender;
		}

		public int getStudentEntityId() {
			return studentEntityId;
		}

		public double getStudentAvgGrade() {
			return studentAvgGrade;
		}

		// Calculate the tax that each student has to pay
		public double calcTax(ArrayList<HighSchool> highSchool, ArrayList<University> uni,
				ArrayList<Student> students) 
		{
			HighSchool highSchool1 = new HighSchool();
			University uni1 = new University();
			if (studentEntityId <= 3) {
				highSchool1 = highSchool.get(studentEntityId - 1);
				return (studentAge / highSchool1.calcAverageGrade(students) * 100) + highSchool1.getTax();
			} else {
				uni1 = uni.get(studentEntityId - 4);
				return (studentAge / uni1.calcAverageGrade(students) * 100) + uni1.getTax();
			}
		}

		@Override
		public int compareTo(Object o) 
		{
			if (this.getStudentAvgGrade() < ((Student) o).getStudentAvgGrade())
				return 1;
			else if (this.getStudentAvgGrade() > ((Student) o).getStudentAvgGrade())
				return -1;
			return 0;
		}

	}
