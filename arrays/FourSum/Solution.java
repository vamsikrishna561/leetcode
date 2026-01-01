package leetcode.arrays.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length;i++)
        {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<nums.length;j++)
            {
            if (j > i+1 && nums[j] == nums[j-1]) continue;
            int k = j+1;
            int l = nums.length-1;
            while(k<l)
            {
                long sum = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l];
                if (sum < target) {
                    k++;
                } else if (sum > target) {
                    l--;
                } else {
                    results.add(Arrays.asList(nums[i],nums[j], nums[k++], nums[l--]));
                    while (k < l && nums[k] == nums[k - 1]) k++;
                }
            }
            }
        }
        
        return results;  
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> result = sol.fourSum(nums, target);
        System.out.println(result);
    }
}
