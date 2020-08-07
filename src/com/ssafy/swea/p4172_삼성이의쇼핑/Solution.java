package com.ssafy.swea.p4172_삼성이의쇼핑;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	private static int T, M, mxSat;
	private static long N;
	private static int[][] clothes;
	private static int[] picked;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++)
		{
			mxSat = 0;
			st = new StringTokenizer(br.readLine().trim());
			N = Long.parseLong(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			clothes = new int[M][2];
			for (int i = 0; i < M; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				clothes[i][0] = Integer.parseInt(st.nextToken());
				clothes[i][1] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= M; i++)
			{
				picked = new int[i];
				choose(0, 0, i, 0, 0);
			}
			System.out.println("#" + t + " " + mxSat);
		}		
		br.close();
	}

	static void choose(int cnt, int start, int R, long sum, int satisfied)
	{
		if (cnt == R)
		{
			System.out.println(Arrays.toString(picked));
			if (sum <= N)
			{
				mxSat = Math.max(satisfied, mxSat);
			}
			return;
		}
		for (int i = start; i < M; i++)
		{
			picked[cnt] = i;
			if (sum + (long)clothes[i][0] <= N)
			{
				choose(cnt+1, i+1, R, sum + (long)clothes[i][0], satisfied + clothes[i][1]);
			}
		}
		
	}
}
