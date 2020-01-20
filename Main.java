package i.University;

public class Main {

	public static void main(String[] args) {
		
		SchoolManagement schoolManagement = new SchoolManagement();
				
		schoolManagement.addHighSchools();
		schoolManagement.addUniversities();
		schoolManagement.addStudent();
		schoolManagement.addStudentToUni();
		schoolManagement.calcAllStudentsGrades();
		System.out.println("Top performing student "+ schoolManagement.topStudent());
		schoolManagement.topStudentByGender();
		schoolManagement.allIncome();
	}
}