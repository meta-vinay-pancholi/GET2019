package grades;
import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		MarkSheet markSheet = new MarkSheet();
		int num = 0,flag = 0;
		while(num == 0) {
			if(flag != 0) {
				System.out.println("Enter number of students greater than zero");
			}
		        System.out.println("Enter number of students");
		        int num = new Scanner(System.in).nextInt();
			flag = 1;
		}
		float []grades = new float[num];
		for(int i=0 ; i < num ; i++) {
			System.out.println("Enter grade of "+ (i+1) +" student");
			grades[i] = new Scanner(System.in).nextFloat();
		}
		float average = marksheet.average(grades);
		float maxGrade = marksheet.maxGrade(grades);
		float minGrade = marksheet.minGrade(grades);
	        float perStudentPass = marksheet.percentageStudentPass(grades);
		
		System.out.println("Average of grades=" +average);
		System.out.println("Maximum grade is=" +maxGrade);
		System.out.println("Minimum grade is=" +minGrade);
		System.out.println("Percentage of students passed=" +perStudentPass+ "%");
	}
}
