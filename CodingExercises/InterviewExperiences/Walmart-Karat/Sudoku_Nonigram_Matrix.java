import java.io.*;
import java.util.*;
import javafx.util.Pair;

/**
A nonogram is a logic puzzle, similar to a crossword, in which the player is given a blank grid and an instruction for each row and each column. The player has to color each row and column using the corresponding instruction. Each cell can be either black or white, which we will represent as 'B' for black and 'W' for white.

+------------+
| W  W  W  W |
| B  W  W  W |
| B  W  B  B |
| W  W  B  W |
| B  B  W  W |
+------------+

For each row and column, the corresponding instruction gives the lengths of contiguous runs of black ('B') cells. For example, the instruction [ 2, 1 ] for a specific row indicates that there must be a run of two black cells, followed later by another run of one black cell, and the rest of the row is filled with white cells.

These are valid solutions: [ W, B, B, W, B ] and [ B, B, W, W, B ] and also [ B, B, W, B, W ]
This is not valid: [ W, B, W, B, B ] since the runs are not in the correct order.
This is not valid: [ W, B, B, B, W ] since the two runs of Bs are not separated by Ws.

Your job is to write a function to validate a possible solution against a set of instructions. Given a 2D matrix representing a player's solution; and instructions for each row along with additional instructions for each column; return True or False according to whether both sets of instructions match.

Example solution matrix:

validateNonogram(matrix1, rows1_1, columns1_1) => True

matrix1 ->
                                 rows1_1
                +------------+     
                | W  W  W  W | <-- []
                | B  W  W  W | <-- [1]
                | B  W  B  B | <-- [1,2]
                | W  W  B  W | <-- [1]
                | B  B  W  W | <-- [2]
                +------------+
                  ^  ^  ^  ^
                  |  |  |  |
               [2,1] | [2] |
  columns1_1        [1]   [1]
       

Example instructions #2

(same matrix as above)
rows1_2    =  [], [], [1], [1], [1,1]
columns1_2 =  [2], [1], [2], [1]
validateNonogram(matrix1, rows1_2, columns1_2) => False

The second, third and last rows and the first column do not match their respective instructions.

All Test Cases:
validateNonogram(matrix1, rows1_1, columns1_1) => True
validateNonogram(matrix1, rows1_2, columns1_2) => False
validateNonogram(matrix1, rows1_3, columns1_3) => False
validateNonogram(matrix1, rows1_4, columns1_4) => False
validateNonogram(matrix1, rows1_5, columns1_5) => False
validateNonogram(matrix1, rows1_6, columns1_6) => False
validateNonogram(matrix1, rows1_7, columns1_7) => False
validateNonogram(matrix1, rows1_8, columns1_8) => False
validateNonogram(matrix2, rows2_1, columns2_1) => False
validateNonogram(matrix2, rows2_2, columns2_2) => False
validateNonogram(matrix2, rows2_3, columns2_3) => False
validateNonogram(matrix2, rows2_4, columns2_4) => False
validateNonogram(matrix2, rows2_5, columns2_5) => True
validateNonogram(matrix2, rows2_6, columns2_6) => False
validateNonogram(matrix3, rows3_1, columns3_1) => True
validateNonogram(matrix3, rows3_2, columns3_2) => False

n: number of rows in the matrix
m: number of columns in the matrix
*/

public class Solution {
  public static void main(String[] argv) {
    char[][] matrix1 = {
      {'W','W','W','W'},
      {'B','W','W','W'},
      {'B','W','B','B'},
      {'W','W','B','W'},
      {'B','B','W','W'}};

    int[][] rows1_1 = {{},{1},{1,2},{1},{2}};
    int[][] columns1_1 = {{2,1},{1},{2},{1}};

    int[][] rows1_2 = {{},{},{1},{1},{1,1}};
    int[][] columns1_2 = {{2},{1},{2},{1}};

    int[][] rows1_3 = {{},{1},{3},{1},{2}};
    int[][] columns1_3 = {{3},{1},{2},{1}};

    int[][] rows1_4 = {{},{1,1},{1,2},{1},{2}};
    int[][] columns1_4 = {{2,1},{1},{2},{1}};

    int[][] rows1_5 = {{},{1},{1},{1},{2}};
    int[][] columns1_5 = {{2,1},{1},{2},{1}};

    int[][] rows1_6 = {{},{1},{2,1},{1},{2}};
    int[][] columns1_6 = {{2,1},{1},{2},{1}};

    int[][] rows1_7 = {{},{1},{1,2},{1},{2,1}};
    int[][] columns1_7 = {{2,1},{1},{2},{1}};

    int[][] rows1_8 = {{1},{1},{1,2},{1},{2}};
    int[][] columns1_8 = {{2,1},{1},{2},{1}};

    char[][] matrix2 = {
      {'W','W'},
      {'B','B'},
      {'B','B'},
      {'W','B'}};

    int[][] rows2_1 = {{},{2},{2},{1}};
    int[][] columns2_1 = {{1,1},{3}};

    int[][] rows2_2 = {{},{2},{2},{1}};
    int[][] columns2_2 = {{3},{3}};

    int[][] rows2_3 = {{},{},{},{}};
    int[][] columns2_3 = {{},{}};

    int[][] rows2_4 = {{},{2},{2},{1}};
    int[][] columns2_4 = {{2,1},{3}};

    int[][] rows2_5 = {{},{2},{2},{1}};
    int[][] columns2_5 = {{2},{3}};

    int[][] rows2_6 = {{},{2},{2},{1}};
    int[][] columns2_6 = {{2},{1,1}};

    char[][] matrix3 = {
      {'B','W','B','B','W','B'}};

    int[][] rows3_1 = {{1,2,1}};
    int[][] columns3_1 = {{1},{},{1},{1},{},{1}};

    int[][] rows3_2 = {{1,2,2}};
    int[][] columns3_2 = {{1},{},{1},{1},{},{1}};
    
    System.out.println(isNonogram(matrix1, rows1_1, columns1_1));
    
  }
  
  
  public static boolean isNonogram(char[][] grid, int[][] rows_1, int[][] columns_1){
    int m = grid.length;
    int n = grid[0].length;
    //row
    for(int i=0; i<m; i++){ //for each row
      int counter = 0;
      int[] rowInstr = rows_1[i];
      int l =0;
      
      
      for(int j=0; j<n; j++){ //for each column
        if(grid[i][j] == 'B'){
           counter++;
        } else{
          int rowInstrCounter = rowInstr[l];
          if(counter != rowInstrCounter) return false;
          counter = 0;
          l++;
        }
      }
      // System.out.println();
    }
    
    for(int j=0; j<n; j++){ //for each COLUMN
    int counter = 0;
      int[] colInstr = columns_1[i];
      int l =0;
    
    
      for(int i=0; i<m; i++){ //for each ROW
        if(grid[i][j] == 'B'){
           counter++;
        } else{
          int colInstrCounter = colInstr[l];
          if(counter != colInstrCounter) return false;
          counter = 0;
          l++;
        }
      }
    }
    }
  }
  
  /*public static boolean isSubSudoko(int[][] grid){
    int n = grid.length;
    // int n = grid[0].length;
    
    HashSet<Integer> set = new HashSet<>();
    for(int k=1; k<=n; k++){
      // System.out.println(i);
      set.add(k);
    }
    
    
    for(int i=0; i<n; i++){ //for each row
      for(int j=0; j<n; j++){ //for each column
        if(set.contains(grid[i][j])){
          set.remove(grid[i][j]);
        }
        else {
          // System.out.print(grid[i][j] + " ");
          return false;
          }
      }
      System.out.println();
      for(int k=1; k<=n; k++){
      // System.out.println(i);
      set.add(k);
    }
    }
    
    for(int j=0; j<n; j++){ //for each COLUMN
      for(int i=0; i<n; i++){ //for each ROW
        if(set.contains(grid[i][j])){
          set.remove(grid[i][j]);
        }
        else {
          // System.out.print(grid[i][j] + " ");
          return false;
          }
      }
      System.out.println();
      for(int k=1; k<=n; k++){
      // System.out.println(i);
      set.add(k);
    }
    }
    
    
    return true;
  }*/
  
