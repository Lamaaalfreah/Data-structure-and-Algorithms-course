
package sorting;
public class Sorting 
{
    public static void main(String[] args) 
    {
     String[] Names = { "YAHYA", "HASAN", "EID", "MANAL", "BDOOR", "RAWIAH", "HAIFA",
     "AMJAD", "FAHAD", "OHOOD","MAHA", "SARA", "AMAL", "MEHAD", "ZAIN" };
     System.out.println("The Names before insertion Sort: ");
     for(int i= 0; i<Names.length; i++)
     System.out.print(Names[i] + " ");
     System.out.println();
     System.out.println("The Names after insertion Sort: "); 
     insertionSort(Names,Names.length-1);
     
     String[] Names2 = { "YAHYA", "HASAN", "EID", "MANAL", "BDOOR", "RAWIAH", "HAIFA",
     "AMJAD", "FAHAD", "OHOOD","MAHA", "SARA", "AMAL", "MEHAD", "ZAIN" };     
     System.out.println("The Names before quick Sort: ");
     for(int i= 0; i<Names2.length; i++)
     System.out.print(Names2[i] + " ");
     System.out.println();
     System.out.println("The Names after quick Sort: "); 
     quickSort(Names2,0,Names2.length-1);  
     for(int i= 0; i<Names2.length; i++)
     System.out.print(Names2[i] + " ");
     System.out.println();
     
     String[] Names3 = { "YAHYA", "HASAN", "EID", "MANAL", "BDOOR", "RAWIAH", "HAIFA",
     "AMJAD", "FAHAD", "OHOOD","MAHA", "SARA", "AMAL", "MEHAD", "ZAIN" };     
     System.out.println("The Names before merge Sort: ");
     for(int i= 0; i<Names3.length; i++)
     System.out.print(Names3[i] + " ");
     System.out.println();
     System.out.println("The Names after merge Sort: "); 
     mergeSort(Names3,0,Names3.length-1);
     for(int i= 0; i<Names3.length; i++)
     System.out.print(Names3[i] + " ");
     System.out.println();
    }// End of main. 
    
    public static void insertionSort(String[] A,int length)
    {
      for(int i = 1; i < length; i++) 
      {
      int j = i;
      String key = A[i];
          while ((j > 0) && (A[j-1].compareTo(key)>0))
          {
          A[j] = A[j-1];
          j--;
          }// End of while.
      A[j] = key;
      }// End of for loop.
      for(int i= 0; i<A.length; i++)
      System.out.print(A[i] + " "); 
      System.out.println();
    }// End of insertionSort.
    
    private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max)
    {
      if (min < max)
      {
      // create partitions
      int indexofpartition = partition(data, min, max);
      // sort the left partition (lower values)
      quickSort(data, min, indexofpartition - 1);
      // sort the right partition (higher values)
      quickSort(data, indexofpartition + 1, max);
      }// End of if.
     
    }// End of quickSort.
    
    private static <T extends Comparable<T>> int partition(T[] data, int min, int max)
    {
      T partitionelement;
      int left, right;
      int middle = (min + max) / 2;
      // use the middle data value as the partition element
      partitionelement = data[middle];
      // move it out of the way for now
      swap(data, middle, min);
      left = min;
      right = max;
      while (left < right)
      {
        // search for an element that is > the partition element
        while (left < right && data[left].compareTo(partitionelement) <= 0)
        left++;
       // search for an element that is < the partition element
       while (data[right].compareTo(partitionelement) > 0)
       right--;
       // swap the elements
       if (left < right)
       swap(data, left, right);
      }// End of while.
     // move the partition element into place
     swap(data, min, right);
     return right;
    }// End of partition.
    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2)
    {
        T temp = data[index1];
        data[index1]=data[index2];
        data[index2]=temp;
    }
    private static <T extends Comparable<T>> void mergeSort(T[] data, int min, int max)
    {
       if (min < max)
       {
       int mid = (min + max) / 2;
       mergeSort(data, min, mid);
       mergeSort(data, mid+1, max);
       merge(data, min, mid, max);
       }// End of if.
    }// End of mergeSort.
    
    private static <T extends Comparable<T>> void merge(T[] data, int first, int mid, int last)
    {
    T[] temp = (T[])(new Comparable[data.length]);
    int first1 = first, last1 = mid; // endpoints of first subarray
    int first2 = mid+1, last2 = last; // endpoints of second subarray
    int index = first1; // next index open in temp array
    // Copy smaller item from each subarray into temp until one
    // of the subarrays is exhausted
        while (first1 <= last1 && first2 <= last2)
        {
          if (data[first1].compareTo(data[first2]) < 0)
          {
          temp[index] = data[first1];
          first1++;
          }
          else
          {
          temp[index] = data[first2];
          first2++;
          }
          index++;
        }
        // Copy remaining elements from first subarray, if any
        while (first1 <= last1)
        {
        temp[index] = data[first1];
        first1++;
        index++;
        }
        // Copy remaining elements from second subarray, if any
        while (first2 <= last2)
        {
        temp[index] = data[first2];
        first2++;
        index++;
        }
        // Copy merged data into original array
        for (index = first; index <= last; index++)
        data[index] = temp[index];
        
    }// End of marge.
}// End of Sorting.
