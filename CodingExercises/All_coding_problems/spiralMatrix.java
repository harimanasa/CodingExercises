class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        //validation
        if(matrix.length==0){
            return result;
        }
        
        //logic
        int m=matrix.length;
        int n=matrix[0].length;
        int top=0, bottom=m-1, left=0, right=n-1;
        
        while(left<=right && top<=bottom){
            //reading the first row
            if(left<=right && top<=bottom)
            {
            for(int i=left; i<=right; i++){
                result.add(matrix[top][i]);
            }
            top++;
            }   
            //reading the right column
            if(left<=right && top<=bottom){
            for(int i=top; i<=bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;
            }
            //reading the bottom row
            if(left<=right && top<=bottom){
            for(int i=right; i>=left; i--){
                result.add(matrix[bottom][i]);
            }
            bottom--;
            }
            //reading the left column
            if(left<=right && top<=bottom){
            for(int i=bottom; i>=top; i--){
                result.add(matrix[i][left]);
            }
            left++;
            }
        }
        return result;
        
    }
}