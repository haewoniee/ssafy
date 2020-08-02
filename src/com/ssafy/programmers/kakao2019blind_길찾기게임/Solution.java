package com.ssafy.programmers.kakao2019blind_길찾기게임;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	static int idx;
	
	static class Node {
		int r, c, nodeNum;
		Node left, right;
		
		Node(int r, int c, int nodeNum)
		{
			this.r = r;
			this.c = c;
			this.nodeNum = nodeNum;
		}
		
		void add(int rNew, int cNew, int nodeNum)
		{
			//왼쪽에 넣을지 오른쪽에 넣을지 정하기
			if (rNew < r)
			{
				//왼쪽
				//왼쪽 Node가 null이면 만들어서 넣어주기
				if (this.left == null)
				{
					this.left = new Node(rNew, cNew, nodeNum);
				}
				else
				{
					//아니면 왼쪽노드의 add함수에 넣기
					this.left.add(rNew, cNew, nodeNum);
				}
			}
			else
			{
				//오른쪽
				//오른쪽 Node가 null이면 만들어서 넣어주기
				if (this.right == null)
				{
					this.right = new Node(rNew, cNew, nodeNum);
				}
				else
				{
					//아니면 오른쪽노드의 add함수에 넣기
					this.right.add(rNew, cNew, nodeNum);
				}
			}
		}

		public void preOrder(int[] res) {
			res[idx] = nodeNum;
			idx++;
			if (this.left != null)
			{
				this.left.preOrder(res);
			}
			if (idx < res.length && res[idx] > 0)
			{
				idx++;
			}
			if (this.right != null)
			{
				this.right.preOrder(res);
			}
		}

		public void postOrder(int[] res) {
			if (this.left != null)
			{
				this.left.postOrder(res);
			}
			if (idx < res.length && res[idx] > 0)
			{
				idx++;
			}
			if (this.right != null)
			{
				this.right.postOrder(res);
			}
			if (idx < res.length && res[idx] > 0)
			{
				idx++;
			}
			res[idx] = nodeNum;
			idx++;
		}
	}

	public static void main(String[] args) {

		Solution s = new Solution();
		int[][] nodeinfo = new int[][] {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		System.out.println(Arrays.toString(s.solution(nodeinfo)));
	}
	
    public int[][] solution(int[][] nodeinfo) {
    	int[][] newNodeInfo = new int[nodeinfo.length][3];
    	for (int i = 0; i < nodeinfo.length; i++) {
    		newNodeInfo[i] = new int[] {nodeinfo[i][0], nodeinfo[i][1], i+1};
    	}
    	
    	Arrays.sort(newNodeInfo, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0] && o1[1] == o1[1])
				{
					return 0;
				}
				if (o1[1] < o2[1] || (o1[1] == o2[1] && o1[0] < o2[0]))
				{
					return 1;
				}
				else
				{
					return -1;
				}
			}
    	});
    	Node root = new Node(newNodeInfo[0][0], newNodeInfo[0][1], newNodeInfo[0][2]);
        for (int i = 1; i < nodeinfo.length; i++)
        {
        	root.add(newNodeInfo[i][0], newNodeInfo[i][1], newNodeInfo[i][2]);
        }
    	
    	int[][] answer = new int[2][nodeinfo.length];
		root.preOrder(answer[0]);
		idx = 0;
		root.postOrder(answer[1]);
        return answer;
    }

}
