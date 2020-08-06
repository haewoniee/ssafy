package com.ssafy.swea.p3124_최소스패닝트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

	static int T, V, E;
	static long sum;
	static int[][] edges;
	static int[] distances;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++)
		{
			st = new StringTokenizer(br.readLine().trim());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edges = new int[E][3];
			distances = new int[V+1];
			parent = new int[V+1];
			sum = 0;
			
			for (int i = 1; i <= V; i++)
			{
				distances[i] = Integer.MAX_VALUE;
				parent[i] = i;
			}

			for (int i = 0; i < E; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				edges[i] = new int[] {C, A, B};
			}
			
			Arrays.sort(edges, new Comparator<int[]>()
			{
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			for (int[] e : edges)
			{
				if (find(e[1]) != find(e[2]))
				{
					union(e[1],e[2]);
					sum += e[0];
				}
			}
			
			
			System.out.println("#" + t + " " + sum);
		}
		
		br.close();
	}

	static int find(int a)
	{
		if (parent[a] == a)
		{
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b)
	{
		int pA = find(a);
		int pB = find(b);
		if (pA < pB)
		{
			parent[b] = pA;
			parent[pB] = pA;
		}
		else if (pB < pA)
		{
			parent[a] = pB;
			parent[pA] = pB;
		}
	}
}
