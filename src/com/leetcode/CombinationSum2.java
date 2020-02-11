package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author 明
 *
 *给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 */
public class CombinationSum2 {

	List<List<Integer>> result=new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum2(int[] candidates,int target){
		
		if(candidates==null)
			return result;
		
		dfs(target, 0, new Stack<Integer>(), candidates);
		return result;
	}
	
	private void dfs(int target,int index,Stack<Integer> pre,int[] candidates) {
		if(target==0) {
			result.add(new ArrayList<>(pre));
			return;
		}
		
		for(int i=index;i<candidates.length;i++) {
//			if(candidates[i]>target) {
//				break;
//			}
			
			if(i>index && candidates[i]==candidates[i-1]) {
				continue;//这一步去重，这一步非常关键
			}
			if(candidates[i]<=target) {
				pre.push(candidates[i]);
				dfs(target-candidates[i], i+1, pre, candidates);
			    pre.pop();
			}	
		}
	}
	
	public static void main(String[] args) {
		int[]candidates= {10,1,2,7,6,1,5};
		Arrays.sort(candidates);//这一步非常关键
		List<List<Integer>> list = new CombinationSum2().combinationSum2(candidates, 8);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}
