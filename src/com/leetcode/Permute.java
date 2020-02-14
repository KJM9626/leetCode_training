package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 明
 *全排列
 *
 *给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

public class Permute {

	List<List<Integer>> result=new ArrayList<List<Integer>>();
	
	public List<List<Integer>> permute(int[] nums){
		int len=nums.length;
		if(nums==null||len==0) {
			return result;
		}
		
		boolean[] used=new boolean[len];
		dfs(0, used,new Stack<Integer>(), nums);	
		return result;
	}
	
	/**
	 * @param dept 表示遍历的深度，使用dept用来作为递归的终止条件，当dept==length的时候，那么就可以返回数组了
	 * @param used 使用一个布尔数组used，初始化的时候都为 false 表示这些数还没有被选择，当我们选定一个数的时候，就将这个数组的相应位置设置为 true ，这样在考虑下一个位置的时候，就能够以 O(1)O(1) 的时间复杂度判断这个数是否被选择过，这是一种“以空间换时间”的思想。
	 * @param pre
	 * @param candidates
	 */
	public void dfs(int dept,boolean[]used,Stack<Integer> pre,int[] candidates) {
		if(dept==candidates.length) {
			result.add(new ArrayList<>(pre));
			return;
		}
		
		for(int i=0;i<candidates.length;i++) {
			if(!used[i]) {//表明数组中这个数组还没有被使用
				pre.push(candidates[i]);
				used[i]=true;//使用过后将其设置为true
				dfs(dept+1, used, pre, candidates);
				used[i]=false;//状态重置，回溯的时候将其设置为false，待下一次检索的时候可以再次使用
				pre.remove(dept);//由于回溯，所以要将层数减为初始值
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5};
		List<List<Integer>> list = new Permute().permute(nums);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
