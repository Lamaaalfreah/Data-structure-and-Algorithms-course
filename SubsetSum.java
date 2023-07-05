
package subsetsum;
import java.util.Scanner;

public class SubsetSum 
{
    public static void main(String[] args) 
    {
    int arr[] = {5,10,7,2,1};
    Scanner read = new Scanner(System.in);
    System.out.println("Enter an integer number: ");
    int target = read.nextInt();
    if(haveSubsetSum(arr, 0 , target))
        System.out.println("There is a subset of numbers that sums to the number you entered :) ");    
    else
        System.out.println("There isn't a subset of numbers that sums to the number you entered :( ");    
    }// end of main.
    
    public static boolean haveSubsetSum(int nums[], int start, int target) 
    {
    final int x = nums.length;
     if (start == x) 
     {
      return target == 0;
     }   
     if (start > 0 && nums[start] == 1 && (nums[start- 1] % 5) == 0 ) 
     {
       return haveSubsetSum(nums, start + 1,target);
     }
     if (haveSubsetSum(nums, start + 1,target - nums[start])) 
     {
       return true;
     } 
     if ((nums[start] % 5) != 0 & haveSubsetSum(nums, start + 1,target)) 
     {
     return true;
     }
     return false;        
    }// end of haveSubsetSum.
}// end of SubsetSum.
