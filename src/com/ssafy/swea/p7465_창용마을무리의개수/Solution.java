package com.ssafy.swea.p7465_창용마을무리의개수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M, num;
	static int[] parent;
	static HashSet<Integer> set;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++)
		{
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			set = new HashSet<Integer>();
			parent = new int[N+1];
			num = 0;
			for (int i = 1; i <= N; i++)
			{
				parent[i] = i;
			}
			
			for (int i = 0; i < M; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				if (find(A) != find(B))
				{
					union(A,B);
				}
			}
			for (int i = 1; i <= N; i++)
			{
				find(i);
			}
				
			for (int i = 1; i <= N; i++)
			{
				if (!set.contains(parent[i]))
				{
					set.add(parent[i]);
					num++;
				}
			}
			
			bw.append("#" + t + " " + num);
			bw.newLine();
		}
		
		br.close();
		bw.close();
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
			parent[pB] = pA;
		}
		else if (pB < pA)
		{
			parent[pA] = pB;
		}
	}
}
