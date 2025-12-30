package leetcode.arrays.ThreeSum;

import java.util.Arrays;

public class ClosestSolution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int closest = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == target)
                    return sum;
                int d = Math.abs(target - sum);

                if (closest == 0 || d < closest) {
                    closest = d;
                    result = sum;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

    public static void main(String[] var0) {
        ClosestSolution var1 = new ClosestSolution();
        int[] arra1 = new int[] { 2, 3, 8, 9, 10 };
        int target = 16;
        int var3 = var1.threeSumClosest(arra1, target);
        System.out.println(var3);
    }
}
