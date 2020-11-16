import java.util.Scanner;
import java.io.PrintStream;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Lab6CISC3130 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		PrintStream op = new PrintStream("Lab#6output.txt");
		ArrayList FinalGrade = new ArrayList();
		op.println("Name  \t\t Labs\t Practice Problems \t Midterm Exams \t Final Exam \t || Final Grades \t || Letter Grade");
		char i;
		
		do {
			
			// Print Name
			System.out.println("Please enter the student's Last Name: ");
			String LName = sc.next();
			
			System.out.println("Please enter the student's First Name: ");
			String FName = sc.next();
			
			String Name = FName + " " + LName;
			
			// Total grade of Labs
			int totalLab = 0;
			int lg;
			
			for (int n = 1; n <= 7; n++) {
				System.out.println("Please enter Lab " + n + " grade: (enter 0 if the grade is not exist)");
				lg = sc.nextInt(); 
				totalLab += lg;
			}
			
			
			// Total grade of practice problems
			int totalPP = 0;
			int pg;
			
			for(int m = 1; m <= 8; m++) {
				System.out.println("Please enter Practice Problems " + m + " grade: (enter 0 if the grade is not exist)");
				pg = sc.nextInt(); 
				totalPP += pg;
			}
			
			
			// Total grade of mid-term exams
			int totalMT = 0;
			int mg;
			
			for (int o = 1; o <= 2; o++) {
				System.out.println("Please enter Midterm Exam " + o + " grade: (enter 0 if the grade is not exist)");
				mg = sc.nextInt(); 
				totalMT += mg;
			}
			
			
			// Grade of final exam
			System.out.println("Please enter the Final Exam grade: ");
			int FE = sc.nextInt();
			
			
			//Calculate the final grade 
			int total = totalLab + totalPP + totalMT + FE;
			
			// Change the final grade to a letter grade
			String LG;
			
			if (total >= 90) {
				LG = "A";
			} else if (total >= 80) {
				LG = "B";
			} else if (total >= 70) {
				LG = "C";
			} else if (total >= 60) {
				LG = "D";
			} else {
				LG = "F";
			}
			
			// Print out the information
			op.println(Name + "\t  " + totalLab + "\t\t" + totalPP + "\t\t  " + totalMT + "\t\t  " + FE + "\t\t || " + total + " \t\t\t ||" + LG);
			
			System.out.println("Press 'A' to continue, and Press other keys to end: ");
			i = sc.next().charAt(0);
					
		} while (i == 'A');
		
		op.close();

	}

}
