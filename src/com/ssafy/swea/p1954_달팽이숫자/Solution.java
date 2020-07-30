package com.ssafy.swea.p1954_달팽이숫자;

import java.util.Scanner;

public class Solution {
	
	static int T, N;
	static int[][] snail;
	
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++)
		{
			N = sc.nextInt();
			snail = new int[N][N];
			System.out.println("#" + t);

			fill();
			
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		
		sc.close();
	}

	private static void fill()
	{
		int r = 0, c = 0, num = 1, d = 0;
		while (num <= N*N)
		{
			while (r >= 0 && r < N && c >= 0 && c < N)
			{
				if (snail[r][c] != 0)
				{
					break;
				}
				snail[r][c] = num;
				r += dir[d][0];
				c += dir[d][1];
				num++;
			}
			r -= dir[d][0];
			c -= dir[d][1];
			d = (d+1) % 4;
			r += dir[d][0];
			c += dir[d][1];
		}
		
	}
	
}
