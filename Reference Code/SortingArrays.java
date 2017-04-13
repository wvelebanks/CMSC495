import java.util.ArrayList;

//********************************************************************
//
//  Demonstrates the selection sort and insertion sort algorithms.
//********************************************************************

public class SortingArrays
{
   //-----------------------------------------------------------------
   //  Sorts the specified array of objects using the selection
   //  sort algorithm.
   //-----------------------------------------------------------------
   public static void selectionSort (ArrayList<Employee> list)
   {
      int min;
      Employee temp;

      for (int index = 0; index < list.size(); index++)
      {
         min = index;
         for (int scan = index+1; scan < list.size(); scan++)
            if (list.get(scan).compareTo(list.get(index)) < 0)
               min = scan;

         // Swap the values
         temp = list.get(min);
         list.set(min, list.get(index)); 
         list.set(index, temp);
      }
   }

   //-----------------------------------------------------------------
   //  Sorts the specified array of objects using the insertion
   //  sort algorithm.
   //-----------------------------------------------------------------
   public static void insertionSort (ArrayList<Employee> list)
   {
      for (int index = 1; index < list.size(); index++)
      {
         Employee key = list.get(index);
         int position = index;

         //  Shift larger values to the right
         while (position > 0 && key.compareTo(list.get(position-1)) < 0)
         {
            list.set(position, list.get(position-1));
            position--;
         }
            
         list.set(position, key);
      }
   }
}
