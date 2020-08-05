package com.ssafy.baekjoon.p2667_단지번호붙이기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[][] map, dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[] numHouses;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		numHouses = new int[N*N+1];
		
		for (int i = 0; i < N; i++)
		{
			char[] input = br.readLine().trim().toCharArray();
			for (int j = 0; j < N; j++)
			{
				map[i][j] = Character.getNumericValue(input[j]);
				if (map[i][j] == 1)
					map[i][j] = -1;
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (map[i][j] == -1)
				{
					cnt++;
					map[i][j] = cnt;
					numHouses[cnt]++;
					DFS(i,j, cnt);
				}
			}
		}

		System.out.println(cnt);
		int[] houses = new int[cnt];
		System.arraycopy(numHouses, 1, houses, 0, cnt);
		Arrays.sort(houses);
		for (int i = 0; i < cnt; i++)
		{
			System.out.println(houses[i]);
		}
		br.close();
	}
	
	static void DFS(int r, int c, int num)
	{
		for (int i = 0; i < 4; i++)
		{
			int newR = r + dir[i][0];
			int newC = c + dir[i][1];
			if (newR >= 0 && newR < N && newC >= 0 && newC < N)
			{
				if (map[newR][newC] == -1)
				{
					map[newR][newC] = num;
					numHouses[num]++;
					DFS(newR, newC, num);
				}
			}
		}
	}

}
