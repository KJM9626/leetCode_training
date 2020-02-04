package com.leetcode;

import com.leetcode.MergeTwoLists.ListNode;

/**
 * @author 明
 *两数相加
 *给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

 */



public class AddTwoNumbers {
	
	static class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			val=x;
		}
	} 
	public static ListNode addTwoNumbers(ListNode l1,ListNode l2) {
		
		ListNode head=new ListNode(0);
		ListNode p=l1;
		ListNode q=l2;
		ListNode curr=head;
		int carry=0;//carry表示两节点相加的进位
		while(p!=null||q!=null) {
			int x=(p!=null)?p.val:0;
			int y=(q!=null)?q.val:0;
			int sum=carry+x+y;
			carry=sum/10;
			curr.next=new ListNode(sum%10);//表示相加后新增节点的数字
			curr=curr.next;
			if(p!=null) p=p.next;
			if(q!=null) q=q.next;
		}
		if(carry>0) {
			curr.next=new ListNode(carry);
		}
		return head.next;
	}
	
	public static void main(String[] args) {
		ListNode listNode = new ListNode(3);
		listNode.next=new ListNode(4);
		listNode.next.next=new ListNode(2);
		
		ListNode listNode2=new ListNode(4);
		listNode2.next=new ListNode(6);
		listNode2.next.next=new ListNode(7);
		ListNode lists = AddTwoNumbers.addTwoNumbers(listNode, listNode2);
		while(lists!=null) {
			System.out.print(lists.val+" ");
			lists=lists.next;
		
	}
	}
}
