package com.ssafy.baekjoon.p1113_수영장만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean busted;
	static int[][] map, visited, filled, dir = {{1,0},{-1,0},{0,1},{0,-1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		filled = new int[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N; i++)
		{
			char[] inp = br.readLine().trim().toCharArray();
			for (int j = 0; j < M; j++)
			{
				map[i][j] = inp[j] - '0';
			}
		}
		
		
		for (int h = 9; h >= 1; h--)
		{
			visited = new int[N][M];

			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < M; j++)
				{
					if (visited[i][j] == 0 && filled[i][j] == 0)
					{
						busted = false;
						visited[i][j] = 1;
						flood(i,j,h);						
					}
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++)
			{
				sum += filled[i][j];
			}
		}
		System.out.println(sum);
		br.close();
	}
	
	static void flood(int r, int c, int h)
	{
		//예외: 경계에 있으면 무조건 물을 채울수 없음
		if (r == N-1 || r == 0 || c == M-1 || c == 0)
		{
			if (map[r][c] < h)
				busted = true;
			return;
		}
		//DFS로 타고가면서 h보다 낮은 블록의 개수를 리턴
		if (map[r][c] < h)
		{
			filled[r][c] = h - map[r][c];
			for (int i = 0; i < 4; i++)
			{
				int newR = r + dir[i][0];
				int newC = c + dir[i][1];
				if (newR >= 0 && newR < N && newC >= 0 && newC < M &&
						visited[newR][newC] == 0 && map[newR][newC] <= h)
				{
					visited[newR][newC] = 1;
					flood(newR, newC, h);
				}
			}
			if (busted)
			{
				filled[r][c] = 0;
			}
		}
	}
}
