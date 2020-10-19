import java.util.Arrays;

public class No977 {
    public static void main(String[] args) {
        int[] A = new int[]{-3,0,10};
        System.out.println(Arrays.toString(new Solution().sortedSquares(A)));
    }
    

    static class Solution{
        public int[] sortedSquares(int[] A){
            int[] res = new int[A.length];
            int pos = 0;
            while(A[pos] < 0)
                pos++;
            int neg = pos - 1;
            //neg , pos
            int count = 0;
            while(neg >= 0 && pos < A.length){
                if(A[neg] * A[neg] < A[pos] * A[pos]){
                    res[count++] = A[neg] * A[neg];
                    neg--;
                }else{
                    res[count++] = A[pos] * A[pos];
                    pos++;
                }
            }
            while(neg >= 0){
                res[count++] = A[neg] * A[neg];
                neg--;
            }
            while(pos < A.length){
                res[count++] = A[pos] * A[pos];
                pos++;
            }
            return res;
        }
    }


    static class Solution2{
        public int[] sortedSquares(int[] A){
            int[] res = new int[A.length];
            int j = 0;
            for(int i : A){
                res[j++] = i * i;
            }
            Arrays.sort(res);
            return res;
        }
    }
    //错误，原因（不明）
    static class Solution1 {
        public int[] sortedSquares(int[] A) {
            int[] res = new int[A.length];
            int neg = 0;
            while(neg + 1 < A.length && A[neg] * A[neg + 1] >= 0 && A[neg] <= 0)
                neg++;
            int pos = neg + 1, i = 0;
            while(pos < A.length || neg >= 0){
                if(pos >= A.length){
                    res[i] = A[neg] * A[neg];
                    neg--;
                    i++;
                    continue;
                }else if(neg < 0){
                    res[i] = A[pos] * A[pos];
                    pos++;
                    i++;
                    continue;
                }
                res[i++] = Math.min(A[pos] * A[pos], A[neg] * A[neg]);
                res[i++] = Math.max(A[pos] * A[pos], A[neg] * A[neg]);
                neg--;
                pos++;
            }
            return res;
        }
    }
}
