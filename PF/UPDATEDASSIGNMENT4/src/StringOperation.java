
import java.util.*;
/**
 * @author Admin
 *
 */
public class StringOperation {
	/**
	 * @param string1
	 * @param string2
	 * function comparing two strings return 1 if same and 0 if different
	 */
	public static int stringCompare(String string1, String string2){
		int len1 = string1.length();

		int len2 = string2.length();

		int flag = 0;

		if(len1!=len2)

			return 0;//return 0 if lengths are different
		else{
			for(int i=0 ;i < len1 ;i++){
				if(string1.charAt(i)!=string2.charAt(i)){
					flag=1;
					break;
				}else{
					flag=0;
				}
			}
		}

		if(flag==0){
			return 1;
		}
		else{
			return 0;
		}
	}
	/**
	 * @param string1
	 * function taking string input and returning reverse of string
	 */
	public static String stringReverse(String string1){
		String stringReverse = "";
		
		int len=string1.length();
		
		for(int i =( len-1 ) ; i >= 0 ; i--){
			stringReverse+=string1.charAt(i);
			
		}
		return stringReverse;

	}
	/**
	 * @param string
	 * function taking string input returning reverse of string and if letter is lower case then changing it into upper case and vice versa
	 */
	public static String reverseWithCase(String string){
		String str="";
		
		String string1=stringReverse(string);
		
		for(int i = 0 ; i < string1.length() ; i++){
			
			if(string1.charAt(i)>=65 && string1.charAt(i)<=90){
				
				str=str+ (char)(string1.charAt(i)+32);
				
			}if(string1.charAt(i)>=97 && string1.charAt(i)<=122){
				
				str=str+ (char)(string1.charAt(i)-32);
				
			} if(string1.charAt(i)==32){
				
				str=str+" ";
			}
		}
		return str;
	}
	/**
	 * @param string
	 * function returning longest word of string
	 */
	public static String longestWord(String string){
		string=string+" ";
		
		String word = "", large="";
		
		String[] words = new String[100];
		
		int length = 0;
		
		for(int i = 0; i < string.length(); i++){
			
			//Split the string into words
			if(string.charAt(i) != ' '){
				word = word + string.charAt(i);
			}
			else{
				//Add word to array words
				words[length] = word;
				//Increment length
				length++;
				//Make word an empty string
				word = "";
			}
		}
		//Initialize small and large with first word in the string
		large = words[0];

		//Determine largest word in the string
		for(int k = 0; k < length; k++){
			//If length of large is less than any word present in the string
			//Store value of word into large
			if(large.length() < words[k].length())
				large = words[k];
		}
		return large;
	}

}
