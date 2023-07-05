
package powerandcrazysum;

import java.util.Scanner;

public class PowerAndCrazySum 
{
    public static void main(String[] args) 
    {
    Scanner read = new Scanner(System.in);
    System.out.println("Enter an integer number betwen 1 and 9: ");
    int num = read.nextInt();
    System.out.println("The crazy sum of the number is :) =  " + crazySum(num)); 
    }// end of main.
    
    public static int crazySum(int num) 
    { 
    if (num == 1)
    return 1;
    else
    return power(num, num) + crazySum(num-1);
    }//end of crazySum.  
    
    public static int power(int base, int exp) 
    {
    int pow;
    // if the exponent is 0, set pow to 1
    // otherwise set pow to base*base^(exp-1) 
    if (exp == 0)
    return 1;
    return base * power(base, --exp);
    }//end of power.    
}//end of PowerAndCrazySum.



