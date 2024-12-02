/**
 * 
 * We run a loop where row ranges from 0 to n / 2.

    Within this loop, we run a nested loop where col ranges from row to n - row - 1. These loops traverse the groups of four cells in the matrix. In this nested loop, we perform three swaps:

        The value of the top-left cell is swapped with the value of the top-right cell.

        The value of the top-left cell is swapped with the value of the bottom-right cell.

        The value of the top-left cell is swapped with the value of the bottom-left cell.

    The current group of four cells has been rotated by 90 degrees. We now move to the next iteration of the outer loop to rotate the next group.

We repeat the process above until the whole matrix has been rotated.
 */

public class Matrix_RotateMatrix {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for(int i = 0; i<m; i++){ //transpose i.e., anti-clockwise 
            for(int j = i; j<n; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<m; i++){
            for(int j = 0; j<n/2; j++){ //flip horizontally
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-1-j];
                matrix[i][m-1-j] = temp;
            }
        }
    }
}