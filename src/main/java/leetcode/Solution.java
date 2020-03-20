package leetcode;

import java.util.*;

class Solution {

    public void threeSumClosest(int target) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        Integer[] arr = new Integer[nums.length];
        int len = 0;
        for (int i : nums) {
            arr[len++] = i;
        }
        System.out.println(Arrays.asList(arr));


    }

}
class Test{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,4};
        solution.threeSumClosest(1);
        System.out.println(Arrays.toString(nums));

    }
}