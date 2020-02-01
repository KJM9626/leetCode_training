package com.leetcode;

/**
 * @author 明
 *回文数
 *
 *判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

 */
public class IsPalindrome {

	public static boolean isPalindrome(int x) {
		if(x<0||(x%10==0&&x!=0)) 
			return false;
		
		int result=0;
		while(x>result) {
			int n=x%10;
			result=result*10+n;
			x/=10;
		}
		return x==result||x==result/10;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(12));
		System.out.println(isPalindrome(121));
	}
}
