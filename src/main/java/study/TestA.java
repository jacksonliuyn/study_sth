package study;

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track,0);
        return res;
    }

  /**
   *
   * @author liuyunan
   * @date 2020/3/16
   * @param nums
   * @param track
   * @return
   */
    void backtrack(int[] nums, LinkedList<Integer> track,int j) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
//             做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track,i++);
            // 取消选择

            track.removeLast();

          System.out.println(System.identityHashCode(track));


        }
    }
}
class TestOne{
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permute(new int[]{1,2,3});
    }
}