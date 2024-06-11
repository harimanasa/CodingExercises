// /*
//  * Click `Run` to execute the snippet below!
//  */

// import java.io.*;
// import java.net.HttpURLConnection;
// import java.util.*;

// /*
//  * To execute Java, please define "static void main" on a class
//  * named Solution.
//  *
//  * If you need more classes, simply define them inline.
//  */

// class Solution {
//   public static void main(String[] args) {
//     String url = "https://jsonplaceholder.typicode.com/posts/1/comments";
//     HttpURLConnection con = (HttpURLConnection) url.openConnection();
//     int responseCode =  con.getResponseCode();
    
//     if(responseCode == HttpURLConnection.HTTP_OK){
//       BufferedReader readerIn = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
//       StringBuilder response = new StringBuilder();

//     }
//   }
// }

// Excercise: 2

//     *
//    ***
//   *****
//  *******
// *********


public class Solution{
  // public static void main(String... args){
  //   int start = 1;
  //   StringBuilder pattern = new StringBuilder();
  //   pattern.append("*");
  //   System.out.println(pattern.toString());

  //   while(start<=4){
  //      pattern.append("*").append(("*"));
  //       System.out.println(pattern.toString());
  //       start++;
  //   }
  public static void main(String... args){
    char arr[]={' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' '};
    int start = 3, end = 5;
    int count = 1;
    System.out.println(String.copyValueOf(arr));
    while(count<=4 && start>=0 && end<=arr.length-1){
      arr[start]='*';
      arr[end]='*';
      System.out.println(String.copyValueOf(arr));
      start--;
      end++;
      count++;
    }
  }

}