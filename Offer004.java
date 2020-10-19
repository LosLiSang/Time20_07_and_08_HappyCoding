
public class Offer004{
    public static void main(String[] args) {
        int[][] m = new int[][]{
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
           };
        // int[][] m = new int[][]{{}};
        // System.out.println(m.equals(new int[][]{{}}));
        // System.out.println(Arrays.equals(m, new int[][]{{}}));
        System.out.println(new Solution().findNumberIn2DArray(m, 17));
    }
    //时间复杂度(O(log(mn)))
    static class Solution{
        public boolean findNumberIn2DArray(int[][] matrix, int target){
            if(matrix.length == 0) return false;
            int col = matrix[0].length-1, row = 0;
            while(col >= 0 && row < matrix.length){
                // System.out.println(matrix[row][col]);
                if(matrix[row][col] == target) return true;
                else if(matrix[row][col] > target) col -= 1;
                else if(matrix[row][col] < target) row += 1;
            }
            return false;
        }
    }


    //时间复杂度O(nlog(m))
    static class Solution2{
        public boolean findNumberIn2DArray(int[][] matrix, int target){
            // int start = 0, end = left_border(matrix, target);
            for(int i = 0; i < matrix.length; i++){
                if(binarySearch(matrix[i], target) != -1) return true;
            }
            return false;
        }
        private int binarySearch(int[] row, int target){
            int left = 0, right = row.length - 1;
            while(left <= right){
                int mid = left + (right - left)/2;
                System.out.println(String.format("Two left:%d right:%d mid:%d", left, right, mid));
                if(row[mid] > target) right = mid-1;
                else if(row[mid] < target) left = mid+1;
                else if(row[mid] == target) return mid;
            }
            return -1;
        }
        // private int left_border(int[][] matrix, int target){
        //     int left = 0, right = matrix.length;
        //     while(left < right){
                
        //         int mid = (left + right)/2;
        //         System.out.println(String.format("One left:%d right:%d mid:%d", left, right, mid));
        //         if(matrix[0][mid] > target) right = mid;
        //         else if(matrix[0][mid] < target) left = mid + 1;
        //         else if(matrix[0][mid] == target) right = mid;
        //     }
        //     System.out.println(left);
        //     return left;
        // }
    }



    //失败作
    static class Solution1 {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if(matrix.equals(new int[][]{})) return false;
            int col_start = 0, col_end = matrix.length-1, row_start = 0, row_end = matrix.length-1;
            int i;
            while(col_start != col_end || row_end != row_start){
                for(i = col_end; i >= col_start; i--){
                    if(matrix[row_start][i] < target){
                        col_end = i;
                        break;
                    }
                    else if(matrix[row_start][i] == target) return true;
                }
                if(i == col_start-1) return false;
                for(i = row_end; i >= row_start; i--){
                    if(matrix[i][col_end] < target){
                        row_end = i;
                        break;
                    }
                    else if(matrix[i][col_end] == target) return true;
                }
                if(i == row_start-1) return false;
                for(i = row_start; i <= row_end; i++){
                    if(matrix[i][col_end] > target){
                        row_start = i;
                        break;
                    }
                    else if(matrix[i][col_end] == target) return true;
                }
                if(i == row_end+1) return false;
                for(i = col_start; i <= col_end; i++){
                    if(matrix[row_end][i] > target){
                        col_start = i;
                        break;
                    }
                    else if(matrix[row_end][i] == target) return true;
                }
                if(i == col_end+1) return false;
            }
            return false;
        }

    }
}