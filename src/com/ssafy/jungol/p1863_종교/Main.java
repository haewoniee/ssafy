package com.ssafy.jungol.p1863_종교;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N, M, mx;
	private static int[] parent;
	private static boolean[] found;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		found = new boolean[N+1];
		mx = 0;
		for (int i = 1; i <= N; i++)
		{
			parent[i] = i;
		}
		
		for (int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine().trim());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			if (find_set(first) != find_set(second))
			{
				union(first, second);				
			}
		}
		for (int i = 1; i <= N; i++)
		{
			if (!found[i])
			{
				int cnt = 0;
				for (int j = i; j <= N; j++)
				{
					if (parent[i] == parent[j])
					{
						found[j] = true;
						cnt++;						
					}
				}
				mx = Math.max(mx, cnt);
			}
		}
		System.out.println(mx);
		br.close();
	}
	
	static int find_set(int a)
	{
		if (a == parent[a])
		{
			return a;
		}
		return parent[a] = find_set(parent[a]);
	}
	
	static void union(int a, int b)
	{
		int parentA = find_set(a);
		int parentB = find_set(b);
		if (parentA < parentB)
		{
			parent[b] = parentA;
			parent[parentB] = parentA;
		}
		else
		{
			parent[a] = parentB;
			parent[parentA] = parentB;
		}
	}

}
