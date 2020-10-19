import java.util.Arrays;

public class No498 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1, 2, 3 },
            {4, 5, 6 },
            {7, 8, 9 }
        };
        System.out.println(Arrays.toString(new Solution().findDiagonalOrder(matrix)));
    }
    
    
    static class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            int[] res = new int[matrix[0].length * matrix.length];
            int i = 0, j = 0, up = 1, count = 0;
            while(count < matrix[0].length * matrix.length){
                if(i < 0) {
                    up = -1;
                    i -= up;
                }
                else if(i >= matrix.length){
                    up = 1;
                    i -= up;
                }
                if(j >= 0 && j < matrix[0].length && i >= 0 && i < matrix.length){
                    res[count] = matrix[i][j];
                    count++;
                }
                i -= up;
                j += up;
            }
            return res;
        }
    }
}
