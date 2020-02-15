package com.leetcode;

/**
 * @author 明
 *
 *最后一个单词的长度
 *
 *给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。

如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。

 

示例:

输入: "Hello World"
输出: 5

1,从字符串末尾开始向前遍历，其中主要有两种情况
2,第一种情况，以字符串"Hello World"为例，从后向前遍历直到遍历到头或者遇到空格为止，即为最后一个单词"World"的长度5
3,第二种情况，以字符串"Hello World "为例，需要先将末尾的空格过滤掉，再进行第一种情况的操作，即认为最后一个单词为"World"，长度为5
4,所以完整过程为先从后过滤掉空格找到单词尾部，再从尾部向前遍历，找到单词头部，最后两者相减，即为单词的长度
5,时间复杂度：O(n)，n为结尾空格和结尾单词总体长度

 */

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		int end=s.length()-1;
		while(end>=0&&s.charAt(end)==' ')//这是第一第二种情况的考虑;注意末位是空格的情况容易忽略
			end--;
		
		int start=end;
		while(start>=0&&s.charAt(start)!=' ')
			start--;
		return end-start;
	}
	
	public static void main(String[] args) {
		String s1="hello world   ";
		String s2="he a b cde";
		LengthOfLastWord word = new LengthOfLastWord();
		int l1 = word.lengthOfLastWord(s1);
		int l2 = word.lengthOfLastWord(s2);
		System.out.println(l1+"  "+l2);
		
	}

}
