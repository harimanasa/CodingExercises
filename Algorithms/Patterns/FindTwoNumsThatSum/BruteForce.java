public class BruteForce {
public void bruteForce(){
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

 public static int[] findSum(int[] arr, int n) {
    int[] result = new int[2];
    //traversing the array
    for (int i = 0; i < arr.length; i++) {
     for (int j = i + 1; j < arr.length; j++) {
      //checking if sum of two values equals n
      if (arr[i] + arr[j] == n) {
       result[0] = arr[i];
       result[1] = arr[j];
       return result; // containing the two numbers
      }
     }
    }
    return arr;
}



}

