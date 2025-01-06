public class LinearSearch {
        public static int linearSearch(int s, int[] arr, int arrSize) {
         if (arrSize <= 0) // Sanity check
          return -1;
       
         for (int i = 0; i < arrSize; i++)
          if (arr[i] == s)
           return i; // If found return index
         return -1; // Return -1 otherwise
        }
        public static void main(String args[]) {
         int arr[] = {5,4,1,410,5,95,4,-100,20,0};
         int arrSize = 10;
         int key = 0;
         Helper obj = new Helper();
         System.out.println("Given Array");
         obj.printArray(arr, arrSize);
       
         int index = linearSearch(key, arr, arrSize);
         if (index != -1)
          System.out.println("Your key \"" + key + "\" is found at index \"" + index + "\"");
         else
          System.out.println(key + " not found in the array: ");
       
        }
}
