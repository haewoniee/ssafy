package com.ssafy.baekjoon.p8980_택배;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N, C, M, delivered;
	static int[][] packages;
	static int[] maxLoading;
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine().trim());
		
		maxLoading = new int[N];

		packages = new int[M][3];
		for (int m = 0; m < M; m++)
		{
			st = new StringTokenizer(br.readLine().trim());
			packages[m][0] = Integer.parseInt(st.nextToken());
			packages[m][1] = Integer.parseInt(st.nextToken());
			packages[m][2] = Integer.parseInt(st.nextToken());
		}
		
		//그리디 알고리즘, 내리는 곳이 빠른 순서대로 정렬
		Arrays.sort(packages, new Comparator<int[]>() 
		{
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
				{
					if (o1[0] == o2[0])
					{
						return o1[2] - o2[2];
					}
					else
					{
						return o1[0] - o2[0];
					}
				}
				return o1[1] - o2[1];
			}
			
		});
		for (int i = 0; i < packages.length; i++)
		{
			int from = packages[i][0];
			int to = packages[i][1];
			int amt = packages[i][2];
			int toLoad = amt;
			for (int j = from; j < to; j++)
			{
				if (maxLoading[j] + amt > C)
				{
					toLoad = Math.min(toLoad, C - maxLoading[j]);
				}
			}
			for (int j = from; j < to; j++)
			{
				maxLoading[j] += toLoad;
			}
			delivered += toLoad;
		}
		System.out.println(delivered);
		
		br.close();
	}

}
