import java.util.Scanner;


public class MainBody {
	
	public static void main(String args[]){
		
		StringOperation stringoperation= new StringOperation();
		
		Scanner sc= new Scanner(System.in);
		
		int flag=0;
		
		while(flag==0){
			
			System.out.println("1.String Comapre\n2.String Reverse\n3.String reverse with case sensitive\n4.Longest word of String\n5.exit");
			
			int n1=sc.nextInt();
			
			switch(n1){
			
			case 1: 
				System.out.println("Enter first string");
				
				sc.nextLine();
				
				String string1=sc.nextLine();
				
				System.out.println("Enter second string");
				
				String string2=sc.nextLine();
				
				int a=stringoperation.stringCompare(string1 , string2);
				
				System.out.println(a +"\n");
				
				break;
			case 2:
				System.out.println("Enter string to be reverse");
				
				sc.nextLine();
				
				String string=sc.nextLine();

				String str=stringoperation.stringReverse(string);
				
				System.out.println(str);
				
				break;
			case 3:
				System.out.println("Enter string ");
				
				sc.nextLine();
				
				String string3=sc.nextLine();
				
				String str1=stringoperation.reverseWithCase(string3);
				
				System.out.println(str1);
				
				break;
			case 4:
				System.out.println("Enter string");
				
				sc.nextLine();
				
				String string4=sc.nextLine();
				
				String str2=stringoperation.longestWord(string4);
				
				System.out.println(str2);
				
				break;
				
			case 5: flag=1;
			break;
			}
		}
  sc.close();

	}
}
