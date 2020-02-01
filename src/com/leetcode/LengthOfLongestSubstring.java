package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 明
 *无重复字符的最长子串
 *
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 */
public class LengthOfLongestSubstring {
	
	public static int resolve1(String s) {
		int n=s.length();
		Set<Character> set=new HashSet<Character>();
		int answer=0,i=0,j=0;
		while(i<n && j<n) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				answer=Math.max(answer, j-i);
			}
			else {
				set.remove(s.charAt(i++));//否则下一次将以i++开始为基数
			}
		}
			return answer;	
	}

	public static int resolve2(String s) {
		
		
		return 0;
	}
}
