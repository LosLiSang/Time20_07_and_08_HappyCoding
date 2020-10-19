public class No064 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };

        System.out.println(new Solution().minPathSum(grid));
    }
    static class Solution {
        public int minPathSum(int[][] grid) {

            int[][] storage = new int[grid.length][grid[0].length];
            storage[0][0] = grid[0][0];
            for(int i = 1; i < grid.length; i++)
                storage[i][0] = grid[i][0] + storage[i-1][0];
            for(int i = 1; i < grid[0].length; i++)
                storage[0][i] = grid[0][i] + storage[0][i-1];
            for(int i = 1; i < grid.length; i++){
                for(int j = 1; j < grid[0].length; j++){
                    storage[i][j] = Math.min(storage[i][j-1], storage[i-1][j]) + grid[i][j];
                }
            }
            return storage[grid.length-1][grid[0].length-1];
        }
    }
}
