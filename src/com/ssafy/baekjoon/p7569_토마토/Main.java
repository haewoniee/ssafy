package com.ssafy.baekjoon.p7569_토마토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] dir = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
	static int M, N, H;
	static int[][][] tomatoes;
	static boolean[][][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomatoes = new int[N][M][H];
		visited = new boolean[N][M][H];
		
		Queue<int[]> que = new LinkedList<int[]>();
		
		for (int h = 0; h < H; h++)
		{
			for (int n = 0; n < N; n++)
			{
				st = new StringTokenizer(br.readLine().trim());
				for (int m = 0; m < M; m++)
				{
					tomatoes[n][m][h] = Integer.parseInt(st.nextToken());
					if (tomatoes[n][m][h] == 1)
					{
						que.offer(new int[] {n,m,h});
					}
				}
			}
		}

		int day = 0;
		while (!que.isEmpty())
		{
			int size = que.size();
			boolean flag = false;
			for (int i = 0; i < size; i++)
			{
				int[] cur = que.poll();
				for (int j = 0; j < 6; j++)
				{
					int nextN = cur[0] + dir[j][0];
					int nextM = cur[1] + dir[j][1];
					int nextH = cur[2] + dir[j][2];
					if (nextM >= 0 && nextM < M &&
							nextN >= 0 && nextN < N &&
							nextH >= 0 && nextH < H)
					{
						if (!visited[nextN][nextM][nextH])
						{
							visited[nextN][nextM][nextH] = true;
							if (tomatoes[nextN][nextM][nextH] == 0)
							{
								tomatoes[nextN][nextM][nextH] = 1;
								que.offer(new int[] {nextN, nextM, nextH});
								flag = true;
							}
						}
					}
				}
			}
			if (flag)
				day++;
		}
		
		boolean flag = true;
		
		for (int h = 0; h < H && flag; h++)
		{
			for (int n = 0; n < N && flag; n++)
			{
				for (int m = 0; m < M; m++)
				{
					if (tomatoes[n][m][h] == 0)
					{
						day = -1;
						flag = false;
						break;
					}
				}
			}
		}
		
		System.out.println(day);
		
		br.close();
	}

}
