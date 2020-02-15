package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author �� ����һ���ɰ����ظ����ֵ����У��������в��ظ���ȫ���С�
 * 
 *         ʾ��:
 * 
 *         ����: [1,1,2] ���: [ [1,1,2], [1,2,1], [2,1,1] ]
 */

public class PermuteUnique {

	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		int len = nums.length;
		if (nums == null || len == 0)
			return result;

		
		boolean[] used = new boolean[len];
		dfs(0, used, new Stack<Integer>(), nums);
		return result;
	}

	public void dfs(int dept, boolean[] used, Stack<Integer> pre, int[] candidates) {

		if (dept == candidates.length) {
			result.add(new ArrayList<>(pre));
			return;
		}

		for (int i = 0; i < candidates.length; i++) {
			 if(!used[i]) {
				 if (i > 0 && candidates[i] == candidates[i - 1]&&!used[i-1]) {
					 //!used[i-1]����ǳ���Ҫ���� used[i - 1] �ոձ�������ʱ���֦��˵���������ᱻѡ������һ�����ظ�����"��֦"
						continue;
					}
				 
				used[i] = true;
				pre.push(candidates[i]);
				dfs(dept + 1, used, pre, candidates);
				used[i]=false;//״̬����
				pre.remove(dept);//!!!�ص㣺���ڻ��ݣ�����Ҫ��������Ϊ��ʼֵ
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1,2,1 };
		Arrays.sort(nums);
		List<List<Integer>> list = new PermuteUnique().permuteUnique(nums);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));

		}
	}
}
