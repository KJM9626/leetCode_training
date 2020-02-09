package com.leetcode;

/**
 * @author 明 搜索旋转排序数组
 *
 *         假设按照升序排序的数组在预先未知的某个点上进行了旋转。 (
 *         例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *         搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 你可以假设数组中不存在重复的元素。
 *         你的算法时间复杂度必须是 O(log n) 级别。//提示使用二分查找法 示例 1: 输入: nums =
 *         [4,5,6,7,0,1,2], target = 0 输出: 4 示例 2: 输入: nums = [4,5,6,7,0,1,2],
 *         target = 3 输出: -1 ===================================================
 *         假设按照升序排序的数组在预先未知的某个点上进行了旋转。 (
 *         例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *         编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。 示例 1: 输入: nums =
 *         [2,5,6,0,0,1,2], target = 0 输出: true 示例 2: 输入: nums =
 *         [2,5,6,0,0,1,2], target = 3 输出: false
 */

public class Search {

	public static int search(int[] nums, int target) {// 搜索有序且不重复
		if (nums == null || nums.length == 0)
			return -1;

		int start = 0;
		int end = nums.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[start] <= nums[mid]) {
				if (nums[start] <= target && nums[mid] > target) {
					end = mid - 1;
				}else {
					start = mid + 1;
				}
				
			}else{
				if (nums[mid] < target && nums[end] >= target) {
					start = mid + 1;
				}else {
					end = mid - 1;
				}
				
			}
		}
		return -1;
	}

	/*
	 * 关键是对于10111和11101这种情况，此种情况下nums[start]=nums[mid]，分不清到底是前面有序
	 * 还是后面有序，此时start++即可，相当于去掉一个重复的干扰项；请他情况跟上面的做法一样
	 */

	public static int searchTwo(int[] nums, int target) {// 搜索有序但重复
		if (nums == null || nums.length == 0)
			return -1;

		int start = 0;
		int end = nums.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[start] == nums[mid]) {
				start++;
				continue;
			}
			if (nums[start] < nums[mid]) {
				if (nums[start] <= target && nums[mid] > target) {
					end=mid-1;
				}
				start=mid+1;
			}else {
				if(nums[mid]<target&&nums[end]>=target) {
					start=mid+1;
				}
				end=mid-1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr=new int[] {4,5,6,7,0,1,2};
		int[] nums=new int[] {2,5,6,0,0,1,2};
		int target=0;
		int i = search(arr, target);
		int two = searchTwo(nums, target);
		System.out.println(i+"  "+two);
	}
}
