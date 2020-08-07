package com.ssafy.swea.p1226_미로1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	static int T = 10, N = 16;
	static char[][] map = new char[N][N];
	static int[] stPt, endPt, dy = {0,0,1,-1}, dx = {1,-1,0,0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= T; t++)
		{
			br.readLine();
			for (int i = 0; i < N; i++)
			{
				char[] nums = br.readLine().trim().toCharArray();
				for (int j = 0; j < N; j++)
				{
					map[i][j] = nums[j];
					if (map[i][j] == '2')
					{
						stPt = new int[] {i,j};
					}
				}
			}
			System.out.print("#" + t + " " + BFS());
			System.out.println();
		}

		br.close();
	}
	
	static int BFS()
	{
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(stPt);
		while (!que.isEmpty())
		{
			int[] cur = que.poll();
			for (int i = 0; i < 4; i++)
			{
				int newR = cur[0] + dy[i];
				int newC = cur[1] + dx[i];
				if (newR >= 0 && newR < N && newC >= 0 && newC < N)
				{
					switch (map[newR][newC])
					{
					case '1':
						continue;
					case '3':
						return 1;
					case '0':
						que.add(new int[] {newR, newC});
						map[newR][newC] = '2';
					}
				}
			}
		}
		return 0;
		
	}
	
	static void printMap()
	{
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}
}
