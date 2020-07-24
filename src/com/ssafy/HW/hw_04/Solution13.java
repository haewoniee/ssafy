package com.ssafy.HW.hw_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution13 {
	static int T, N, mx;
						//8방, 대각선 포함	
	static int[][] dir8 = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	static char[][] grid;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		
		for (int Ti = 1; Ti <= T; Ti++)
		{
			N = Integer.parseInt(br.readLine().trim());
			grid = new char[N][N];
			mx = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					char read = (char)br.read();
					while (read == ' ' || read == '\n' || read == '\r')
					{
						read = (char)br.read();
					}
					grid[i][j] = read;
				}
			}
			
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					if (!nextToG(i,j))
					{
						mx = Math.max(mx, cntBuild(i,j));
					}
				}
			}
			System.out.println("#" + Ti + " " + mx);
			br.readLine();
		}
		
		
		br.close();
	}
	
	public static int cntBuild(int r, int c)
	{
		int cnt = 1;
		for (int i = 0; i < 4; i++)
		{
			int[] d = dir8[i]; //초반 4개만 사용
			int newR = r + d[0];
			int newC = c + d[1];
			while (newR >= 0 && newR < N && newC >= 0 && newC < N)
			{
				if (grid[newR][newC] == 'G')
				{
					newR += d[0];
					newC += d[1];
					continue;
				}
				cnt++;
				newR += d[0];
				newC += d[1];
			}
		}
		return cnt;
	}
	
	public static boolean nextToG(int r, int c)
	{
		if (grid[r][c] == 'G')
		{
			return true;
		}
		for (int[] d : dir8)
		{
			int newR = r + d[0];
			int newC = c + d[1];
			if (newR >= 0 && newR < N && newC >= 0 && newC < N)
			{
				if (grid[newR][newC] == 'G')
				{
					return true;
				}
			}
		}
		return false;
	}
}
