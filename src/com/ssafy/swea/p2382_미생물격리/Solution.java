package com.ssafy.swea.p2382_미생물격리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	static int T, K, M, N, total;
	static int[] dr = {0, -1,1,0,0};
	static int[] dc = {0, 0,0,-1,1};
	static int[][][] map, newMap;
	static HashMap<String, ArrayList<int[]>> dups;
	
	public static int reverse(int dir)
	{
		switch (dir)
		{
		case 1:
			return 2;
		case 2:
			return 1;
		case 3:
			return 4;
		case 4:
			return 3;
		}
		return -1;
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		dups = new HashMap<String,  ArrayList<int[]>>();
		for (int t = 1; t <= T; t++)
		{
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			total = 0;
			map = new int[N][N][2];
			for (int k = 0; k < K; k++)
			{
				st = new StringTokenizer(br.readLine().trim());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				total += num;
				map[r][c] = new int[] {num,dir};
			}
			
			for (int m = 0; m < M; m++)
			{
				newMap = new int[N][N][2];
				dups.clear();
				
				for (int r = 0; r < N; r++)
				{
					for (int c = 0; c < N; c++)
					{
						if (map[r][c][0] > 0)
						{
							int dir = map[r][c][1];
							int newR = r + dr[dir];
							int newC = c + dc[dir];
							int size = map[r][c][0];
							if (newR == 0 || newR == N-1 || newC == 0 || newC == N-1)
							{
								//반 삭제
								size = map[r][c][0] / 2;
								total -= map[r][c][0] - size;
								dir = reverse(map[r][c][1]);
								if (size == 0)
								{
									map[newR][newC][0] = 0;
									newMap[newR][newC][0] = 0;
								}
							}
							if (newMap[newR][newC][0] > 0)
							{
								//merge해야함. 가장 큰 군집의 방향으로 변경.
								String key = newR + " " + newC;
								if (!dups.containsKey(key))
								{
									dups.put(key, new ArrayList<int[]>());
									dups.get(key).add(newMap[newR][newC]);
								}
								dups.get(key).add(map[r][c]);
								
							}
							else
							{
								newMap[newR][newC][0] = size;
								newMap[newR][newC][1] = dir;
								map[r][c][0] = 0;
								map[r][c][0] = -1;
							}
							
						}
					}
				}
				for (String key : dups.keySet())
				{
					st = new StringTokenizer(key);
					int max = Integer.MIN_VALUE;
					int maxDir = -1;
					int total = 0;
					for (int[] p : dups.get(key))
					{
						if (p[0] > max)
						{
							max = p[0];
							maxDir = p[1];
						}
						total += p[0];
					}
					int r = Integer.parseInt(st.nextToken());
					int c = Integer.parseInt(st.nextToken());
					newMap[r][c][0] = total;
					newMap[r][c][1] = maxDir;
				}
				map = newMap;
			}
			bw.write("#" + t + " " + total + "\n");
		}
		
		bw.close();
		br.close();
	}

	static void printMap()
	{
		for (int r = 0; r < N; r++)
		{
			for (int c = 0; c < N; c++)
			{
				System.out.print(map[r][c][0] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}
}
