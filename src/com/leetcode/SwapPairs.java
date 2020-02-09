package com.leetcode;

/**
 * @author 明
 *给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.

 */

public class SwapPairs {

	public static ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		
		ListNode firstNode=head;//第一个节点指向头结点
		ListNode secondNode=head.next;//第二个节点指向next节点
		
		firstNode.next=swapPairs(secondNode.next);
		secondNode.next=firstNode;
		return secondNode;//注意secondNode现在已经是第一个节点了
	}
}
