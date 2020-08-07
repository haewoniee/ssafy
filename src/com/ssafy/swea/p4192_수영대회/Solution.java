package com.ssafy.swea.p4192_수영대회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static boolean flag;
	static int T, N, A, B, C, D, time;
	static int[][] map, dir = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int t = 1; t <= T; t++)
		{
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			flag = false;
			for (int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine().trim());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine().trim());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			time = 0;
			BFS();
			if (!flag) time = -1;
			System.out.println("#" + t + " " + time);
		}
		
		
		br.close();
	}

	static void BFS()
	{
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {A,B});
		map[A][B] = 2;
		int cnt = 1;
		int newCnt = 0;
		while (!que.isEmpty())
		{
			time++;
			newCnt = 0;
			for (int c = 0; c < cnt; c++)
			{
				int[] cur = que.poll();
				for (int i = 0; i < 4; i++)
				{
					int newR = cur[0] + dir[i][0];
					int newC = cur[1] + dir[i][1];
					if (newR >= 0 && newR < N && newC >= 0 && newC < N
							&& map[newR][newC] == 0)
					{
						//지나간 곳은 2로 표시
						map[newR][newC] = 2;
						if (map[C][D] == 2)
						{
							flag = true;
							return;
						}
						que.add(new int[] {newR, newC});
						newCnt++;
					}
				}
			}
			cnt = newCnt;
		}
	}
}
