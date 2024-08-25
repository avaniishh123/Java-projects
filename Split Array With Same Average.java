import java.util.Arrays;

class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();

        Arrays.sort(nums);

        for (int size = 1; size <= n / 2; size++) {
            if (totalSum * size % n == 0) {
                int target = totalSum * size / n;
                if (canPartition(nums, size, target, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean canPartition(int[] nums, int size, int target, int start) {
        if (size == 0) {
            return target == 0;
        }

        for (int i = start; i <= nums.length - size; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > target) {
                break;
            }

            if (canPartition(nums, size - 1, target - nums[i], i + 1)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sol.splitArraySameAverage(nums1));  // Output: true

        int[] nums2 = {3, 1};
        System.out.println(sol.splitArraySameAverage(nums2));  // Output: false
    }
}  