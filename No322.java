

//不会
public class No322 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[][] comList = new int[coins.length][];
            for(int i = 0; i < coins.length; i++){
                comList[i] = new int[amount/coins[i] + 1];
                comList[i][0] =0;
                
            }
            return 0;
            
        }
    }
}