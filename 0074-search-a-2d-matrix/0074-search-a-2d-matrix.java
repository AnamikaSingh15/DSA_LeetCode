class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int totalRow = matrix.length;
        int totalCol = matrix[0].length;
        int n = totalRow * totalCol;
        // 1D Array
        int s = 0;
        int e = n-1;
        // Binary search
        while(s<=e){
            int mid = s + (e-s)/2;
            //for 2D array
            int rowIndex = mid/totalCol;
            int colIndex = mid%totalCol;

            if(matrix[rowIndex][colIndex]==target){
                return true;
            }

            else if(matrix[rowIndex][colIndex]>target){
                //left
                e=mid-1;
            }
            else{
                //right
                s = mid+1;
            }
        }
    return false;
    }
}
