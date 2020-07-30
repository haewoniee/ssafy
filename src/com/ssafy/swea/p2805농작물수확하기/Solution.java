package com.ssafy.swea.p2805농작물수확하기;


import java.util.Scanner;

public class Solution {

	private static int T, N;
	private static int[][] map;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++)
		{
			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++)
			{
				String s = sc.next();
				for (int j = 0; j < N; j++)
				{
					map[i][j] = Character.getNumericValue(s.charAt(j));
				}
			}
			int sum = 0;
			for (int i = 0; i <= N/2; i++)
			{
				for (int j = N/2-i; j <= N/2+i; j++)
				{
					sum += map[i][j];
				}
			}
			for (int i = N/2-1; i >= 0; i--)
			{
				for (int j = N/2-i; j <= N/2+i; j++)
				{
					sum += map[N-i-1][j];
				}
			}
			System.out.println("#" + t + " " + sum);
		}
		sc.close();
	}

}
