package com.ssafy.swea.p1238_Contact;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static ArrayList<ArrayList<Integer>> fromTo = new ArrayList<ArrayList<Integer>>();
	static int[] visited = new int[101];
	static int T = 10, N, st, mx;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		for (int i = 0; i < 101; i++)
		{
			fromTo.add(new ArrayList<Integer>());
		}

		for (int t = 1; t <= T; t++)
		{
			token = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(token.nextToken());
			clear();
			st = Integer.parseInt(token.nextToken());
			mx = st;
			token = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N/2; i++)
			{
				int from = Integer.parseInt(token.nextToken());
				int to = Integer.parseInt(token.nextToken());
				fromTo.get(from).add(to);
			}
			Queue<Integer> que = new LinkedList<Integer>();
			que.offer(st);
			visited[st] = 1;
			while (!que.isEmpty())
			{
				int size = que.size();
				int curMax = 0;
				boolean found = false;
				for (int i = 0; i < size; i++)
				{
					int cur = que.poll();
					for (int to : fromTo.get(cur))
					{
						if (visited[to] == 0)
						{
							visited[to] = 1;
							que.add(to);
							curMax = Math.max(curMax, to);
							found = true;
						}
					}
				}
				if (found)
				{
					mx = curMax;
				}
			}
			
			System.out.println("#" + t + " " + mx);
			
		}
		
		
		
		br.close();
	}
	
	static void clear() 
	{
		for (int i = 0; i < 101; i++)
		{
			visited[i] = 0;
			fromTo.set(i,new ArrayList<Integer>());
		}
	}

}
