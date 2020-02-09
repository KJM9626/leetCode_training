package com.leetcode;

public class RemoveElement {

	public static int removeElement(int[]arr,int val) {
		if(arr==null||arr.length==0) {
			return 0;
		}
		
		int i=0;
		for(int j=0;j<arr.length;j++) {
			if(arr[j]!=val) {
				arr[i]=arr[j];
				i++;
			}
		}
		return i;
	}
	
	public static void main(String[] args) {
		int[] arr=new int[] {0,1,2,2,3,0,4,2,3};
		int val=2;
		int element = removeElement(arr, val);
		System.out.println(element);
		
		String str="hello";
		String string="ll";
		int indexOf = str.indexOf(string);
		System.out.println(indexOf);
	}
}
