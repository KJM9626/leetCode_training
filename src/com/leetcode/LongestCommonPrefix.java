package com.leetcode;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author 明
 *最长公共前缀
 *
 *编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。

 */


public class LongestCommonPrefix {

	public static String longestCommonPrefix(String []strs) {
		if(strs.length==0)
			return null;
		
		String first=strs[0];
		for(int i=1;i<strs.length;i++) {
			while(strs[i].indexOf(first)!=0) {
				//不等于0表示a不包含b
				first=first.substring(0, first.length()-1);
				if(first.length()==0)
					return "";
			}
		}
		return first;
	}
	
	public static void main(String[] args) {
		String[] strs= {"lee","leetcode","leab","leets"};
		String longestCommonPrefix = longestCommonPrefix(strs);
		System.out.println(longestCommonPrefix);
	}
	
}
