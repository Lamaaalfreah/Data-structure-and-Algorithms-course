
package searchinarray;

import java.util.Scanner;

public class SearchInArray 
{
    public static void main(String[] args) 
    {
    int arr[] = {5,10,7,2,1};
    Scanner read = new Scanner(System.in);
    System.out.println("Enter an integer number: ");
    int number = read.nextInt();
    if(Search(arr,0, arr.length-1 ,number))
        System.out.println("The number exist in array :) ");    
    else
        System.out.println("The number doesn't exist in array :( ");    
    }// end of main.

    public static boolean Search(int array[],int startIndex, int lastIndex, int number) 
    {
     if (startIndex==array.length) 
        return false;
     if(array[startIndex]==number)
        return true;
     else 
     return Search(array, startIndex+1, lastIndex, number); 
    }// end of Search.
    
}// end of SearchInArray.
