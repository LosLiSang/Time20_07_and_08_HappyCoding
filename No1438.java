import java.util.LinkedList;
import java.util.Deque;
import java.util.TreeMap;

public class No1438 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,2,2,4,4,2,2};
        System.out.println(new Solution().longestSubarray(nums, 0));
    }
    //单调队列
    static class Solution {
        public int longestSubarray(int[] nums, int limit) {
            int res = 0;
            Deque<Integer> max_Deque = new LinkedList<>();
            Deque<Integer> min_Deque = new LinkedList<>();
            int left = 0;
            for(int right = 0; right < nums.length; right++){
                while(!max_Deque.isEmpty() && max_Deque.getLast() < nums[right]) 
                    max_Deque.pollLast();
                while(!min_Deque.isEmpty() && min_Deque.getLast() > nums[right]) 
                    min_Deque.pollLast();
                max_Deque.addLast(nums[right]);
                min_Deque.addLast(nums[right]);
                while(max_Deque.getFirst() - min_Deque.getFirst() > limit){
                    if(max_Deque.getFirst() == nums[left]) max_Deque.pollFirst();
                    if(min_Deque.getFirst() == nums[left]) min_Deque.pollFirst();
                    left++;
                }
                res = Math.max(res, right - left + 1);
            }
            return res;
        }
    }

    //BST
    static class Solution2{
        public int longestSubarray(int[] nums, int limit) {
            int res = 0;
            int n = nums.length;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int l = 0;
            for (int r = 0; r < n; r++) {
                map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
                while (map.lastKey() - map.firstKey() > limit) {
                    map.put(nums[l], map.get(nums[l]) - 1);
                    if (map.get(nums[l]) == 0) map.remove(nums[l]);
                    l++;
                }
                res = Math.max(res, r - l + 1);
            }
            return res;
        }
    }
    //滑动窗口
    static class Solution1 {
        public int longestSubarray(int[] nums, int limit) {
            int result = 1;
            int right = 0;
            while(right < nums.length){
                for(int left = right - 1; left >= 0; left--){
                    int max = max(nums, left, right);
                    int min = min(nums, left, right);
                    if(max - min > limit) break;
                    result = result > right - left + 1 ? result : right - left + 1;
                }
                right++;
            }
            return result;
        }
        private int max(int[] nums, int left, int right){
            int result = nums[left];
            for(int i = left+1; i <= right; i++)
                result = result > nums[i] ? result : nums[i];
            return result;
        } 
        private int min(int[] nums, int left, int right){
            int result = nums[left];
            for(int i = left+1; i <= right; i++)
                result = result < nums[i] ? result : nums[i];
            return result;
        }
        
    }

}
