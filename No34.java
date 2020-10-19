import java.util.Arrays;


public class No34 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            { 5, 1, 9,11},
            { 2, 4, 8,10},
            {13, 3, 6, 7},
            {15,14,12,16}
        };
        new Solution().rotate(matrix);
        for(int[] t : matrix){
            System.out.println(Arrays.toString(t));
        }
        
    }
    static class Solution {
        public void rotate(int[][] matrix) {
            int len = matrix.length;
            for(int i = 0; i < len/2; i++){
                for(int j = i; j < len-i-1; j++){
                    int temp = matrix[j][len-1-i];
                    matrix[j][len-1-i] = matrix[i][j];
                    matrix[i][j] = matrix[len-1-j][i];
                    matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
                    matrix[len-1-i][len-1-j] = temp;
                }
            }
            
        }
    }
}