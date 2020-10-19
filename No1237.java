import java.util.List;
import java.util.ArrayList;

public class No1237 {
    /*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
    public static void main(String[] args) {
        System.out.println(new Solution().findSolution(new CustomFunction(), 5));
    }
 
    static class CustomFunction {
        public int f(int x, int y){
            return x * y;
        }   
    }

    
    static class Solution {
        public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
            List<List<Integer>> result = new ArrayList<>();
            for(int i = 1; i <= 1000; i++){
                List<Integer> ele = new ArrayList<>(2);
                ele.add(i);
                int left = 1, right = 1000;
                while(left <= right){
                    int mid = (left + right)/2;
                    if(customfunction.f(i, mid) == z){
                        ele.add(mid);
                        result.add(new ArrayList<>(ele));
                        break;
                    }else if(customfunction.f(i, mid) > z) right = mid-1;
                    else if(customfunction.f(i, mid) < z) left = mid + 1;
                }
            }
            return result;
        }
    }
}
