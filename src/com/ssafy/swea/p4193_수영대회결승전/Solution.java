package com.ssafy.swea.p4193_수영대회결승전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	private static int T, N, A, B, C, D;
	private static boolean[][] swirl;
	private static int[][] map, dir = {{-1,0},{1,0},{0,1},{0,-1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++)
		{
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			swirl= new boolean[N][N];
			for (int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
					{
						map[i][j] = -1;
					}
					if (map[i][j] == 2)
					{
						map[i][j] = 0;
						swirl[i][j] = true;
					}
				}
			}
			st = new StringTokenizer(br.readLine().trim());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine().trim());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			PriorityQueue<int[]> que = new PriorityQueue<int[]>(new Comparator<int[]>() 
			{
				@Override
				public int compare(int[] o1, int[] o2) {
					return map[o1[0]][o1[1]] - map[o2[0]][o2[1]];
				}
			});
			que.offer(new int[] {A, B});
			map[A][B] = 0;
			boolean flag = true;
			while (!que.isEmpty() && flag)
			{
				int size = que.size();
				for (int i = 0; i < size && flag; i++)
				{
					int[] cur = que.poll();
					for (int j = 0; j < 4; j++)
					{
						int newR = cur[0] + dir[j][0];
						int newC = cur[1] + dir[j][1];
						if (newR >= 0 && newR < N && newC >= 0 && newC < N)
						{
							if (swirl[newR][newC])
							{
								if (map[newR][newC] == 0)
								{
									map[newR][newC] = map[cur[0]][cur[1]] + 3 - (map[cur[0]][cur[1]] % 3);
									que.offer(new int[] {newR, newC});
								}
							}
							else if (map[newR][newC] == 0)
							{
								if (!(newR == A && newC == B))
								{
									map[newR][newC] = map[cur[0]][cur[1]] + 1;
									if (newR == C && newC == D)
									{
										flag = false;
									}
									que.offer(new int[] {newR, newC});
								}
							}
						}
					}
					
				}
			}
			if (flag)
			{
				System.out.println("#" + t + " " + -1);
			}
			else
			{
				System.out.println("#" + t + " " + map[C][D]);
			}
		}
		
		br.close();
		
	}

	
	static void printMap()
	{
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				System.out.printf("%3d", map[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}
}
