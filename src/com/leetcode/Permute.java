package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ��
 *ȫ����
 *
 *����һ��û���ظ����ֵ����У����������п��ܵ�ȫ���С�

ʾ��:

����: [1,2,3]
���:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

public class Permute {

	List<List<Integer>> result=new ArrayList<List<Integer>>();
	
	public List<List<Integer>> permute(int[] nums){
		int len=nums.length;
		if(nums==null||len==0) {
			return result;
		}
		
		boolean[] used=new boolean[len];
		dfs(0, used,new Stack<Integer>(), nums);	
		return result;
	}
	
	/**
	 * @param dept ��ʾ��������ȣ�ʹ��dept������Ϊ�ݹ����ֹ��������dept==length��ʱ����ô�Ϳ��Է���������
	 * @param used ʹ��һ����������used����ʼ����ʱ��Ϊ false ��ʾ��Щ����û�б�ѡ�񣬵�����ѡ��һ������ʱ�򣬾ͽ�����������Ӧλ������Ϊ true �������ڿ�����һ��λ�õ�ʱ�򣬾��ܹ��� O(1)O(1) ��ʱ�临�Ӷ��ж�������Ƿ�ѡ���������һ�֡��Կռ任ʱ�䡱��˼�롣
	 * @param pre
	 * @param candidates
	 */
	public void dfs(int dept,boolean[]used,Stack<Integer> pre,int[] candidates) {
		if(dept==candidates.length) {
			result.add(new ArrayList<>(pre));
			return;
		}
		
		for(int i=0;i<candidates.length;i++) {
			if(!used[i]) {//����������������黹û�б�ʹ��
				pre.push(candidates[i]);
				used[i]=true;//ʹ�ù���������Ϊtrue
				dfs(dept+1, used, pre, candidates);
				used[i]=false;//״̬���ã����ݵ�ʱ��������Ϊfalse������һ�μ�����ʱ������ٴ�ʹ��
				pre.remove(dept);//���ڻ��ݣ�����Ҫ��������Ϊ��ʼֵ
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5};
		List<List<Integer>> list = new Permute().permute(nums);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
