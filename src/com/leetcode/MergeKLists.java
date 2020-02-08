package com.leetcode;

import com.leetcode.MergeTwoLists.ListNode;

/**
 * @author 明
 *合并K个排序链表
 *
 *合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6

归并分治思想：将多个ListNode的数组分成左右两份，分别进行排序，然后最后汇总在进行排序
 */

public class MergeKLists {

	public static ListNode mergeKLists(ListNode[] lists) {
		if(lists.length==0)
			 return null;
		return solve(lists, 0, lists.length-1);
		
	}
	
	public static ListNode merge(ListNode l1,ListNode l2) {
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		if(l1.val<l2.val) {
			l1.next=merge(l1.next, l2);
			return l1;
		}else {
			l2.next=merge(l1, l2.next);
			return l2;
		}
	}
	public static ListNode solve(ListNode[]arr,int left,int right) {
		if(left==right)
			return arr[left];
		
		int middle=(left+right)>>1;//右移1位等价于/2
		ListNode lNode = solve(arr, left, middle);
		ListNode rNode = solve(arr, middle+1, right);
		return merge(lNode, rNode);
		
	}
	
	public static void main(String[] args) {
		ListNode[] lists=new ListNode[3];
		ListNode listNode = new ListNode(1);
		listNode.next=new ListNode(4);
		listNode.next.next=new ListNode(5);
		
		ListNode listNode2=new ListNode(1);
		listNode2.next=new ListNode(3);
		listNode2.next.next=new ListNode(4);
		
		ListNode listNode3=new ListNode(2);
		listNode3.next=new ListNode(6);
		lists[0]=listNode;
		lists[1]=listNode2;
		lists[2]=listNode3;
		ListNode list =MergeKLists.mergeKLists(lists);
		while(lists!=null) {
			System.out.print(list.val+" ");
			list=list.next;
		}
	}
}
