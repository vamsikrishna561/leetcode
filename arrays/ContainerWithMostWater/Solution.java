package leetcode.arrays.ContainerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
        int left= 0;
        int right= height.length - 1;
        int result = 0;
        while(left<right)
        {
            int minHeight = Math.min(height[left], height[right]);
            int area = (right- left) * minHeight;
            if(result < area)
            result = area;
            if(height[left] < height[right])
            left = left + 1;
            else
            right = right -1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = sol.maxArea(height);
        System.out.println(result);
    }
}