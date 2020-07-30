package com.ssafy.swea.p4012요리사;


import java.util.Scanner;

public class Solution {

	static int T, N, min;
	static int[][] syn;
	static boolean[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++)
		{
			N = sc.nextInt();
			syn = new int[N][N];
			numbers = new boolean[N];
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					syn[i][j] = sc.nextInt();
				}
			}
			combination(0,1);
			System.out.println("#" + t + " " + min);
		}
		
		
		sc.close();
	}
	
	static void combination(int cnt, int start)
	{
		if (cnt == N/2)
		{
			//addup
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < N; i++)
			{
				if (numbers[i])
				{
					for (int j = i+1; j < N; j++)
					{
						if (numbers[j])
						{
							sum1 += syn[i][j];
							sum1 += syn[j][i];
						}
					}
				}
				else
				{
					for (int j = i+1; j < N; j++)
					{
						if (!numbers[j])
						{
							sum2 += syn[i][j];
							sum2 += syn[j][i];
						}
					}
				}
			}
			min = Math.min(min, Math.abs(sum1 - sum2));
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i < N; i++)
		{
			numbers[i] = true;
			combination(cnt+1, i+1);
			numbers[i] = false;
		}
	}

}
