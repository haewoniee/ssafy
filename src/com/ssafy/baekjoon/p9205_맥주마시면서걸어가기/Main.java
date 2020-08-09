package com.ssafy.baekjoon.p9205_맥주마시면서걸어가기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int T, N, houseR, houseC, festR, festC, numBeers;
	static int[][] stores;
	static int[] visited;
	static boolean success;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++)
		{
			N = Integer.parseInt(br.readLine().trim());
			numBeers = 20;
			
			st = new StringTokenizer(br.readLine().trim());
			houseR = Integer.parseInt(st.nextToken());
			houseC = Integer.parseInt(st.nextToken());
			
			stores = new int[N][2];
			visited = new int[N];
			success = false;
			
			for (int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				stores[i][0] = Integer.parseInt(st.nextToken());
				stores[i][1] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine().trim());
			festR = Integer.parseInt(st.nextToken());
			festC = Integer.parseInt(st.nextToken());
			
			Queue<int[]> que = new LinkedList<int[]>();
			que.offer(new int[] {houseR, houseC});
			
			while (!que.isEmpty())
			{
				int[] cur = que.poll();
				
				//도착지 갈 수 있는지 보기
				if (manhattanD(cur[0], cur[1], festR, festC) <= numBeers * 50)
				{
					success = true;
					que.clear();
				}
				else
				{
					//갈 수 있는 편의점 BFS로 표시
					for (int i = 0; i < N; i++)
					{
						if (visited[i] == 0)
						{
							int d = manhattanD(cur[0], cur[1], stores[i][0], stores[i][1]);
							if (d <= numBeers * 50)
							{
								visited[i] = 1;
								que.add(new int[] {stores[i][0], stores[i][1]});
							}
						}
					}
					
					
				}
				
			}
			if (success)
			{
				System.out.println("happy");
			}
			else
			{
				System.out.println("sad");
			}

			
		}
		
		br.close();
		
	}
	
	static int manhattanD(int r1, int c1, int r2, int c2)
	{
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}

}
