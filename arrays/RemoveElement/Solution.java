package leetcode.arrays.RemoveElement;

public class Solution {
     public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        int count = 0;
        if(nums.length == 1) return nums[0] == val ? 0 : 1;
        while (j < nums.length) {
           if(nums[j] == val)
            {  
                count++;              
                j++;
            }
            else{
                if(nums[i] == val)
                {
                    nums[i] = nums[j];
                    nums[j] = val;

                }
                    i++;
                    j++;
            }

        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2,2,2};
        int val = 2;
        int result = sol.removeElement(nums, val);
        System.out.println(result);
    }
}
