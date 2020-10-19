import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class No056 {
    public static void main(String[] args) {
        int[][] intervals = {
            {1,4},{2,3},{8,10},{10,18}
        };
        new Solution().merge(intervals);
    }


    static class MyComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] > o2[0]) return 1;
            else if(o1[0] < o2[0]) return -1;
            else return 0;
        }
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, new MyComparator());
            List<int[]> r = new ArrayList<>();
            for(int i = 0; i < intervals.length; i++){
                int right = intervals[i][1];
                for(int j = i + 1; j <= intervals.length; j++){
                    if(j == intervals.length){
                        r.add(new int[]{intervals[i][0], right});
                        i = j - 1;
                        break;
                    }
                    if(right < intervals[j][0]){
                        r.add(new int[]{intervals[i][0], right});
                        i = j - 1;
                        break;
                    }
                    right = right > intervals[j][1] ? right : intervals[j][1];
                }
            }
            int[][] res = new int[r.size()][2];
            r.toArray(res);
            return res;
        }
    }
}
