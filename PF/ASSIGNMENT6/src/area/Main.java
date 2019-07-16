package area;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Area area=new Area();//Creation of object of Area class
		
		do{
			System.out.println("1.Triangle\n2.Rectangle\n3.Square\n4.Circle\n5.Exit");
			
			 int i=new Scanner(System.in).nextInt();
			 
			switch(i){
			
			case 1:
				System.out.println("Enter height and width of triangle");
				
				double height = new Scanner(System.in).nextDouble();
				
				double width = new Scanner(System.in).nextDouble();
				
				double result = area.triangle(height, width);
				
				System.out.println("Area of triangle is="+ result );
				
				break;
				
			case 2:
				System.out.println("Enter height and width of rectangle");
				
				double height1 = new Scanner(System.in).nextDouble();
				
				double width1 = new Scanner(System.in).nextDouble();
				
				double result1 = area.rectangle(height1,width1);
				
				System.out.println("Area of rectangle is="+ result1 );
				
				break;
				
			case 3:
				System.out.println("Enter side of square");
				
				double side=new Scanner(System.in).nextDouble();
				
				double result2 = area.square(side);
				
				System.out.println("Area of square is= "+result2 );
				
				break;
				
			case 4:
				System.out.println("Enter radius of circle");
				
				double radius = new Scanner(System.in).nextDouble();
				
				double result3 = area.circle(radius);
				
				System.out.println("Area of circle is="+ result3 );
				
				break;
				
			case 5:
				System.exit(0);
				
			}
		}while(true);
	}
}
