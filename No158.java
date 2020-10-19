public class No158 {
    public static void main(String[] args) {
        int[] flowerbed = new int[]{1,0,0,0,1};
        System.out.println(new Solution().canPlaceFlowers(flowerbed, 1));
    }

    static class Solution{
        public boolean canPlaceFlowers(int[] flowerbed, int n){
            int[] f = new int[flowerbed.length+2]; 
            f[0] = 0;
            f[flowerbed.length + 1] = 0;
            System.arraycopy(flowerbed, 0, f, 1, flowerbed.length);
            for(int i = 1; i < flowerbed.length + 1; i++){
                if(f[i] == 0 && f[i-1] == 0 && f[i+1] == 0){
                    n--;
                    f[i] = 1;
                }
            }
            if(n <= 0) return true;
            return false;
        }
    }
    static class Solution1 {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            boolean res = false;
            for(int i = 0; i < flowerbed.length; i++){
                if(i == 0){
                    if(flowerbed[1] == 0 && flowerbed[0] == 0){
                        n--;
                        flowerbed[i] = 1;
                    }
                }else if(i == flowerbed.length - 1){
                    if(flowerbed[i-1] == 0 && flowerbed[i] == 0){
                        n--;
                        flowerbed[i] = 1;
                    }
                }else if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0 && flowerbed[i] == 0){
                    n--;
                    flowerbed[i] = 1;
                }
            }
            if(n <= 0) res = true;
            return res;
        }
    }
}
