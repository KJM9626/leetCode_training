package com.leetcode;

/**
 * @author 明
 *最长回文子串
 *
 *给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

 */
public class LongestPalindrome {

	public static String longestPalindrome(String s) {
		
		if(s.equals("")) 
			return "";
		 
		String orgin=s;
		String reverse=new StringBuffer(s).reverse().toString();
		int length=s.length();
		int[][]arr=new int[length][length];
		int maxLen=0;
		int maxEnd=0;
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				if(orgin.charAt(i)==reverse.charAt(j)) {
					if(i==0||j==0) {
						arr[i][j]=1;
					}else {
						arr[i][j]=arr[i-1][j-1]+1;
					}
				}
				if(arr[i][j]>maxLen) {
					int beforeReverse=length-1-j;//倒置前的下标
					if(beforeReverse+arr[i][j]-1==i) {//判断下标是否对应
						maxLen=arr[i][j];
						maxEnd=i;
					}
				}
			}
		}
		return s.substring(maxEnd-maxLen+1, maxEnd+1);
	}
	
//	public static void say(int n) {
//		for(int i=0;i<n;i++) 
//			for(int j=0;j<n;j++) {
//				System.out.println(i+" "+j);
//			}
//	}
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE+"  "+Integer.MIN_VALUE);
		
//		say(5);
	}
}
