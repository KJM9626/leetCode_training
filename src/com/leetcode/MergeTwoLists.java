package com.leetcode;

/**
 * @author 明
 *合并两个有序链表
 *
 *将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

 */
public class MergeTwoLists {
	
	public static ListNode mergeTwoLists(ListNode l1,ListNode l2) {
		
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		
		if(l1.val<l2.val) {
			l1.next=mergeTwoLists(l1.next, l2);
			return l1;
		}else {
			l2.next=mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
	
	public static void main(String[] args) {
		ListNode listNode = new ListNode(0);
		listNode.next=new ListNode(2);
		listNode.next.next=new ListNode(5);
		
		ListNode listNode2=new ListNode(1);
		listNode2.next=new ListNode(3);
		listNode2.next.next=new ListNode(4);
		ListNode lists = MergeTwoLists.mergeTwoLists(listNode, listNode2);
		while(lists!=null) {
			System.out.print(lists.val+" ");
			lists=lists.next;
		}
	}
}
