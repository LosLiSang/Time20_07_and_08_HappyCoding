import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class No740{
    static class Solution {
        public static void main(String[] args) {
            new Solution().deleteAndEarn(new int[]{79,1,95,8,57,52,87,32,45,40,77,85,53,9,15,55,20,29,72,71,64,48,25,44,55,9,82,53,89,64,60,20,80,57,62,88,54,100,89,45,81,67,84,75,37,10,68,35,40,85,52,50,67,68,11,90,28,74,82,96,37,75,36,32,73,29,99,71,88,98,90,47,91,12,13,64,13,82,52,31,22,14,29,51,1,60,55,93,95,31,33,60,78,80,33,73,84,82,54,23});     
        }

        public int deleteAndEarn(int[] nums) {
            Arrays.sort(nums);
            int result = 0;
            Map<Integer, Integer> countMap = new HashMap<>();
            for(int i : nums){
                if(!countMap.containsKey(i)) countMap.put(i, i);
                else countMap.replace(i, countMap.get(i)+i);
            }
            int lastKey = -1;
            for(Entry<Integer, Integer> e : countMap.entrySet()){
                if(lastKey == e.getKey()-1 || lastKey == e.getKey()+1){
                    lastKey = e.getKey();
                    continue;
                }
                int i = 1, j = 1, odd = e.getValue(), even = 0;
                while(countMap.containsKey(e.getKey()+i) | countMap.containsKey(e.getKey()-j)){
                    if(countMap.containsKey(e.getKey()+i)){
                        if(i%2 == 1) even += e.getValue();
                        else if(i%2 == 0) odd += e.getValue();
                        i++;
                        
                    }
                    if(countMap.containsKey(e.getKey()-j)){
                        if(j%2 == 1) even += e.getValue();
                        else if(j%2 == 0) odd += e.getValue();
                        j++;
                    }
                }
                result += odd > even ? odd : even;
                lastKey = e.getKey();
            }
            System.out.println(result);
            return result;
        }
    }
}
