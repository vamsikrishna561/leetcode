package leetcode.arrays.MedianofTwoSortedArrays;

public class Solution {
      public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int low = 0;
        int high = nums1.length;
        int totalLeft = (nums1.length + nums2.length + 1) / 2;
        if(nums1.length > 0 && nums2.length > 0) {
            while (low <= high) {
            int partitionNums1 = (low + high) / 2;
            int partitionNums2 = totalLeft - partitionNums1;

            int maxLeftNums1 = (partitionNums1 <= 0) ? Integer.MIN_VALUE : nums1[partitionNums1 - 1];
            int minRightNums1 = (partitionNums1 >= nums1.length) ? Integer.MAX_VALUE : nums1[partitionNums1];

            int maxLeftNums2 = (partitionNums2 <= 0) ? Integer.MIN_VALUE : nums2[partitionNums2 - 1];
            int minRightNums2 = (partitionNums2 >= nums2.length) ? Integer.MAX_VALUE : nums2[partitionNums2];

            if (maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2.0;
                } else {
                    return Math.max(maxLeftNums1, maxLeftNums2);
                }
            } else if (maxLeftNums1 > minRightNums2) {
                high = high - 1;
            } else {
                low = low + 1;
            }              
        }
        }
        else if(nums1.length == 0 && nums2.length > 0) {
            if(nums2.length % 2 == 0) {
                return (nums2[nums2.length/2 - 1] + nums2[nums2.length/2]) / 2.0;
            } else {
                return nums2[nums2.length/2];
            }
        }
        else if(nums2.length == 0 && nums1.length > 0) {
            if(nums1.length % 2 == 0) {
                return (nums1[nums1.length/2 - 1] + nums1[nums1.length/2]) / 2.0;
            } else {
                return nums1[nums1.length/2];
            }
        }   
        
        return 0.0;
    }

      public static void main(String[] var0) {
      Solution var1 = new Solution();
      int[] arra1 = new int[]{1, 3};
      int[] arra2 = new int[]{2};
      double var3 = var1.findMedianSortedArrays(arra1, arra2);
      System.out.println(var3);
   }
}
