
package palindrome;
import java.util.Scanner;
public class Palindrome 
{

    public static void main(String[] args)
    {
        String str;
        Scanner read = new Scanner(System.in);
        System.out.println("Enter a string: ");
        str = read.nextLine();
        System.out.println("original: " + str + "; a palindrom?: " + isPalindrome(str));
    }// end of main.
    
    public static boolean isPalindrome(String str)
    {     
    if(str.length()==0||str.length()==1)
    return true;
    
    if(str.charAt(0)==str.charAt(str.length()-1))  
    return isPalindrome(str.substring(1,str.length()-1));
    
    else 
    return false; 
    }// end of isPalindrome.
}// end of Palindrome.







