import java.util.List;
import java.util.ArrayList;

public class No27 {
    static class Solution {
        public static void main(String[] args) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            list1.add(1);
            list1.add(2);
            list2.add(1);
            list2.add(2);
            List<List<Integer>> list3 = new ArrayList<>();
            list3.add(list1);
            System.out.println(list3.contains(list2));
            System.out.println(list1 == list2);
            System.out.println(list1.equals(list2));
        }
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if(nums.length == 0) return result;
    
            boolean[] used = new boolean[nums.length];
            List<Integer> temp = new ArrayList<Integer>();
            backtrack(nums.length, result, temp, nums, used);
            return result;
        }
        
        private void backtrack(int n, List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used){
            if(temp.size() == n){
                List<Integer> tList = new ArrayList<Integer>(temp);
                if(!result.contains(tList))
                    result.add(new ArrayList<>(temp));
                return;
            }else{
                for(int i = 0; i < nums.length; i++){
                    if(!used[i]){
                        temp.add(nums[i]);
                        used[i] = true;
                        backtrack(n, result, temp, nums, used);
                        used[i] = false;
                        temp.remove(temp.size() - 1);
                    }
                    
                }
            }        
        }
    }
}