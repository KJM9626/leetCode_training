package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author 明
 *给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */

public class CombinationSum {

	List<List<Integer>> result=new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum(int[] candidates,int target){
		if(candidates==null)
			return result;
		
		dfs(target, 0, new Stack<Integer>(), candidates);
		return result;
	}
	
	//深度遍历
	private void dfs(int target,int index,Stack<Integer> pre,int[] candidates) {
		if(target==0) {//等于0说明结果符合要求
			result.add(new ArrayList<>(pre));
			return;
		}
		
		//遍历，index为本分支上一节点的减数的下标
		for(int i=index;i<candidates.length;i++) {
			if(candidates[i]<=target) {//如果减数小于等于目标值，则符合要求
				pre.push(candidates[i]);//符合要求的减数入栈
				dfs(target-candidates[i], i, pre, candidates);
				pre.pop();//每次回溯将最后一个加入的元素删除
			}
		}
	}
	
	public static void main(String[] args) {
		int [] candidates= {5,2,3};
//		Arrays.sort(candidates);
		CombinationSum sum = new CombinationSum();
		List<List<Integer>> list = sum.combinationSum(candidates, 8);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}
