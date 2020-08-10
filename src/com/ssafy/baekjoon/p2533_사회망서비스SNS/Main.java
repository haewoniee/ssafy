package com.ssafy.baekjoon.p2533_사회망서비스SNS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] parent;
	
	static class Node {
		int num;
		ArrayList<Node> children;
		
		Node(int num)
		{
			this.num = num;
			children = new ArrayList<Node>();
		}
		
		void add(int from, int to)
		{
			if (from == num)
			{
				children.add(new Node(to));
			}
			else
			{
				for (Node child : children)
				{
					if (child.num == from) {
						child.add(from, to);
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		parent = new int[N+1];
		StringTokenizer st = null;
		init_parent();
		Node root = new Node(1);
		for (int i = 1; i <= N-1; i++)
		{
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			root.add(from, to);
		}
		
		
		br.close();
	}

	static void init_parent()
	{
		for (int i = 1; i <= N; i++)
		{
			parent[i] = i;
		}
	}
	
	static void union(int a, int b)
	{
		int aP = find(a);
		int bP = find(b);
		if (aP == bP)
		{
			return;
		}
		else if (aP < bP)
		{
			parent[bP] = aP;
			parent[b] = aP;
		}
		else
		{
			parent[aP] = bP;
			parent[a] = bP;
		}
	}
	
	static int find(int num)
	{
		if (num == parent[num])
		{
			return num;
		}
		return parent[num] = find(parent[num]);
	}
}
