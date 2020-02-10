package com.leetcode;

/**
 * @author 明
 *
 *给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 */

public class SearchRange {

	private int extremeInsertionIndex(int[] nums,int target,boolean left) {
		int lo=0;
		int hi=nums.length;
		while(lo<hi) {
			int mid=(hi+lo)>>1;
		if(nums[mid]>target||left&&nums[mid]==target) {
			hi=mid;
		}else {
			lo=mid+1;
		}
		}
		return lo;
	}
	public int[] searchRange(int[] nums,int target) {
		int[] targetRange=new int[] {-1,-1};
		int leftIndex=extremeInsertionIndex(nums, target, true);
		if(leftIndex==nums.length||nums[leftIndex]!=target) {
			//搜索最左边都越界或者左边到最后一个都搜索不到
			return targetRange;
		}else {
			targetRange[0]=leftIndex;
			targetRange[1]=extremeInsertionIndex(nums, target, false)-1;
		}
			
		return targetRange;
	}
	
	public static void main(String[] args) {
		int[] nums= {5,7,7,8,8,10};
		int[] searchRange = new SearchRange().searchRange(nums, 8);
		for(int i:searchRange) {
			System.out.print(i+" ");
		}
	}
}
