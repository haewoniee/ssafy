package com.ssafy.swea.p1233_사칙연산유효성검사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T = 10, N;
	
	static class Node {
		Node left, right;
		int nodeNum;
		String data;
		
		public Node(int nodeNum, String data) {
			this.left = null;
			this.right = null;
			this.nodeNum = nodeNum;
			this.data = data;
		}
		
		public void add(String data, int nodeNum)
		{
			//왼쪽 자식이 비었으면 왼쪽부터 넣기
			if (left == null)
			{
				left = new Node(nodeNum, data);
			}
			else if (right == null)
			{
				right = new Node(nodeNum, data);
			}
			else
			{
				//왼쪽 자식의 자식들이 다 안찼으면 왼쪽에 넣기
				if (left.left == null || left.right == null)
				{
					left.add(data, nodeNum);
				}
				else if (right.left == null || right.right == null)
				{
					right.add(data, nodeNum);
				}
				else
				{
					left.add(data, nodeNum);
				}
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;
		
		for (int t = 1; t <= 10; t++)
		{
			N = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine().trim());
			st.nextToken();
			Node root = new Node(1, st.nextToken());
			for (int i = 2; i <= N; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				st.nextToken();
				root.add(st.nextToken(), i);
			}
			int a = 1;
		}
		br.close();
	}

}
