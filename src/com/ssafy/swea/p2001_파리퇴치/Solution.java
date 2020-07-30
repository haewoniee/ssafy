package com.ssafy.swea.p2001_파리퇴치;

import java.util.Scanner;

public class Solution {
	
	static int T, N, M, max;
	static int[][] map;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			max = 0;
			map = new int[N][N];
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < N-M+1; i++)
			{
				for (int j = 0; j < N-M+1; j++)
				{
					int sum = 0;
					for (int r = 0; r < M; r++)
					{
						for (int c = 0; c < M; c++)
						{
							sum += map[i+r][j+c];
						}
					}
					max = Math.max(max, sum);
				}
			}
			System.out.println("#" + t + " " + max);

		}

		
		
		sc.close();
	}

}
