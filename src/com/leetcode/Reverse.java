package com.leetcode;

/**
 * @author 明
 *整数反转
 *
 *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21

注意:
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
请根据这个假设，如果反转后整数溢出那么就返回 0。

 */
public class Reverse {
	
	public static int reverse(int x) {
		int result=0;
		while(x!=0) {
			int n=x%10;
			x/=10;
			result=result*10+n;
			if(result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE&&n>7)) return 0;
			if(result<Integer.MIN_VALUE/10||(result==Integer.MIN_VALUE&&n<-8)) return 0;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(reverse(321));
		System.out.println(reverse(-125));
	}
}
