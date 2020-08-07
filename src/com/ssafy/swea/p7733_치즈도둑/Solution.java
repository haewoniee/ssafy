package com.ssafy.swea.p7733_치즈도둑;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int T, N, mx;
	static int[][] map, dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++)
		{
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			visited = new boolean[N][N];
			mx = 1;
			for (int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int d = 0; d <= 100 && d <= N*N; d++)
			{
				clear();
				int cnt = 0;
				for (int i = 0; i < N; i++)
				{
					for (int j = 0; j < N; j++)
					{
						if (!visited[i][j] && map[i][j] > d)
						{
							cnt++;
							visited[i][j] = true;
							DFS(i, j, d);
						}
					}
				}
				mx = Math.max(mx, cnt);
			}
			bw.append("#" + t + " " + mx + "\n");
		}
		
		bw.close();
		br.close();
	}
	
	static void DFS(int r, int c, int day)
	{
		for (int i = 0; i < 4; i++)
		{
			int newR = r + dir[i][0];
			int newC = c + dir[i][1];
			if (newR >= 0 && newR < N && newC >= 0 && newC < N)
			{
				if (!visited[newR][newC] && map[newR][newC] > day)
				{
					visited[newR][newC] = true;
					DFS(newR, newC, day);
				}
			}
		}
		
	}
	
	static void clear()
	{
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				visited[i][j] = false;
			}
		}
	}

}
