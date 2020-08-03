package com.ssafy.swea.p9229_한빈이와SpotMart;

import java.util.Scanner;

public class Solution {

	static int T, N, M, R = 2, mxSum;
	static int[] winfo, chosen;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			chosen = new int[2];
			winfo = new int[N];
			mxSum = -1;
			for (int i = 0; i < N; i++)
			{
				winfo[i] = sc.nextInt();
			}
			nCr(0,0,0);
			System.out.println("#" + t + " " + mxSum);
		}
		
		sc.close();
	}
	
	static void nCr(int cnt, int start, int sum)
	{
		if (cnt == 2)
		{
			mxSum = Math.max(sum, mxSum);
			return;
		}
		for (int i = start; i < N; i++)
		{
			if (winfo[i] + sum <= M)
			{
				chosen[cnt] = winfo[i];
				nCr(cnt+1, i+1, sum+winfo[i]);
			}
		}
		
	}
}
