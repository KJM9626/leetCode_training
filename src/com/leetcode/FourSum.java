package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

import javax.swing.event.ListSelectionEvent;

/**
 * @author 明
 *四数之和
 *
 *给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

 */

public class FourSum {
	
	public static List<List<Integer>> fourSum(int[]nums,int target){
		
		List<List<Integer>> answer=new ArrayList<List<Integer>>();
		int len=nums.length;
		if(nums==null||len<4)
			return answer;
		
		Arrays.sort(nums);
		for(int i=0;i<len-3;i++) {
			int min=nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
			if(min>target) break;
			int max=nums[i]+nums[len-1]+nums[len-2]+nums[len-3];
			if(max<target) continue;//继续查找
			if(i>0&&nums[i]==nums[i-1])
				continue;//去重，继续查找
			for(int j=i+1;j<len-2;j++) {
				int m=j+1;
				int n=len-1;
				if(j>i+1&&nums[j]==nums[j-1]) 
					continue;
			while(m<n) {
				if(nums[i]+nums[j]+nums[m]+nums[n]==target) {
					answer.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
					while(m<n&&nums[m]==nums[m+1]) m++;
					while(m<n&&nums[n]==nums[n-1]) n--;
					m++;
					n--;
				}
				else if (nums[i]+nums[j]+nums[m]+nums[n]<target) 
					m++;
				else if (nums[i]+nums[j]+nums[m]+nums[n]>target) 
					n--;
			}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int nums[]= {1, 0, -1, 0, -2, 2};
		List<List<Integer>> fourSum = fourSum(nums, 0);
		System.out.println(fourSum);
	}
}
