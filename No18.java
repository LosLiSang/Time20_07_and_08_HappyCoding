
public class No18 {
    
}

class Solution9 {
    // public int maxArea(int[] height) {
    //     int result = 0;
    //     for(int i = 0; i < height.length; i++){
    //         for(int j = j + 1; j < height.length; j++){
    //             int temp = (height[i] < height[j] ? height[i] : height[j]) * (j - i);
    //             result = result > temp ? result : temp;
    //         }
    //     }
    //     return result;
    // }


    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int result = 0;
        while(i != j){
            int temp = (height[i] < height[j] ? height[i++] : height[j--]) * (j - i);
            result = result > temp ? result : temp;
        }
        return result;
    }
}