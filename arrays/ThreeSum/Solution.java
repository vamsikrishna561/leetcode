package leetcode.arrays.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            if (nums[i] > 0)
                break;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    results.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                }
            }
        }

        return results;
    }

    public static void main(String[] var0) {
        Solution var1 = new Solution();
        int[] arra1 = new int[] { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0 };
        var var3 = var1.threeSum(arra1);
        System.out.println(var3);
    }

}
