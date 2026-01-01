package leetcode.arrays.RemoveDuplicateSortedArray;

public class Solution {
     public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        int count = 0;
        while(i<j && j<nums.length){
            if(nums[i] == nums[j])
            {
                count++;
                j++;
            }
            else{
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return nums.length - count;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2,2};
        int result = sol.removeDuplicates(nums);
        System.out.println(result);
    }
}
