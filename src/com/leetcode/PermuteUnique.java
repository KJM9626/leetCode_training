package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author 明 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 *         示例:
 * 
 *         输入: [1,1,2] 输出: [ [1,1,2], [1,2,1], [2,1,1] ]
 */

public class PermuteUnique {

	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		int len = nums.length;
		if (nums == null || len == 0)
			return result;

		
		boolean[] used = new boolean[len];
		dfs(0, used, new Stack<Integer>(), nums);
		return result;
	}

	public void dfs(int dept, boolean[] used, Stack<Integer> pre, int[] candidates) {

		if (dept == candidates.length) {
			result.add(new ArrayList<>(pre));
			return;
		}

		for (int i = 0; i < candidates.length; i++) {
			 if(!used[i]) {
				 if (i > 0 && candidates[i] == candidates[i - 1]&&!used[i-1]) {
					 //!used[i-1]这里非常重要，在 used[i - 1] 刚刚被撤销的时候剪枝，说明接下来会被选择，搜索一定会重复，故"剪枝"
						continue;
					}
				 
				used[i] = true;
				pre.push(candidates[i]);
				dfs(dept + 1, used, pre, candidates);
				used[i]=false;//状态重置
				pre.remove(dept);//!!!重点：由于回溯，所以要将层数减为初始值
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1,2,1 };
		Arrays.sort(nums);
		List<List<Integer>> list = new PermuteUnique().permuteUnique(nums);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));

		}
	}
}
