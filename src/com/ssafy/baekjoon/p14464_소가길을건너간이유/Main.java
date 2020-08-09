package com.ssafy.baekjoon.p14464_소가길을건너간이유;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int C, N, A, B, T;
	static int[] chicks;
	static int[][] cows;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		chicks = new int[C];
		cows = new int[N][2];
		for (int i = 0; i < C; i++)
		{
			chicks[i] = Integer.parseInt(br.readLine().trim());
		}
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine().trim());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			cows[i] = new int[] {A,B};
		}
		
		Arrays.sort(chicks);
		Arrays.sort(cows, new Comparator<int[]>() 
		{
			@Override
			public int compare(int[] c1, int[] c2)
			{
				//끝나는시간이 빠른 소부터 오름차순 정렬
				if (c1[1] == c2[1])
				{
					return c1[0] - c2[0];
				}
				return c1[1] - c2[1];
			}
		});
		T = 0;
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < C; j++)
			{
				if (cows[i][0] <= chicks[j] &&
						chicks[j] <= cows[i][1])
				{
					T++;
					chicks[j] = -1;
					break;
				}
			}
				
		}
		System.out.println(T);
		br.close();
	}
	

}
