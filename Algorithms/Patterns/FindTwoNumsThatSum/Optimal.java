import java.util.HashMap;

class CheckSum {
    public static int[] findSum(int[] arr, int n) {
     int[] result = new int[2];
     HashMap < Integer, Boolean > hmap = new HashMap <> (); // Create a hashmap
   
     for (int i = 0; i < arr.length; i++) {
      if (hmap.containsKey(arr[i])) // If a value from arr is present in hmap
      {
       result[0] = arr[i];
       result[1] = n - arr[i];
       return result;
      }
      else
      hmap.put(n - arr[i], true); // Store value - arr[i] if element is not present in arr
     }
     return result;
    }
   
    public static void main(String args[]) {
   
     int n = 9;
     int[] arr1 = {2, 4, 5, 7, 8};
      int[] arr2 = findSum(arr1, n);
     int num1 = arr2[0];
     int num2 = arr2[1];
   
     if ((num1 + num2) != n)
      System.out.println("Results not found!");
     else
      System.out.println("Sum of " + n + " found: " + num1 + " and " + num2);
    }
   }