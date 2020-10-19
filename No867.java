import java.util.Arrays;

public class No867 {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1,2,3},{4,5,6}};
        for(int[] line : new Solution().transpose(A)){
            System.out.println(Arrays.toString(line));
        }
    }
    
    static class Solution {
        public int[][] transpose(int[][] A) {
            int[][] res = new int[A[0].length][A.length];
            for(int i = 0; i < A.length; i++){
                for(int j = 0; j < A[0].length; j++){
                    res[j][i] = A[i][j];
                }
            }
            return res;
        }
    }    
}
