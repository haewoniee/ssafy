package com.ssafy.baekjoon.p17135_캐슬디펜스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, D, R, mxCnt;
	static int[] chosen;
	static int[][] map, mapCopy, dir = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		mapCopy = new int[N][M];
		R = 3;
		mxCnt = 0;
		chosen = new int[R];
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				mapCopy[i][j] = map[i][j];
			}
		}
		nCr(0,0);
		bw.write(mxCnt+"\n");
		bw.close();
		br.close();
	}

	static void nCr(int cnt, int start)
	{
		if (cnt == R)
		{
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < M; j++)
				{
					map[i][j] = mapCopy[i][j];
				}
			}
			if (chosen[0] == 0 && chosen[1] == 5 && chosen[2] == 9)
			{
				int a = 1;
			}
			run();
			return;
		}
		for (int i = start; i < N; i++)
		{
			chosen[cnt] = i;
			nCr(cnt+1, i+1);
		}
	}
	
	static void run()
	{
		int cnt = 0;
		int numEnemies = 0;
		do  {
			numEnemies = 0;
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < M; j++)
				{
					if (map[i][j] == 1)
					{
						numEnemies++;
					}
				}
			}
			if (numEnemies == 0)
			{
				mxCnt = Math.max(mxCnt, cnt);
				return;
			}
			int[][] toRemove = new int[][] {{-1,-1},{-1,-1},{-1,-1}};
			
			for (int gi = 0; gi < 3; gi++)
			{
				boolean flag = false;
				for (int d = 1; d <= D && !flag; d++)
				{
					for (int i = 0; i < 5; i++)
					{
						int newR = N - 1 + d * dir[i][0];
						int newC = chosen[gi] + d * dir[i][1];
						if (newR >= 0 && newR < N && newC >= 0 && newC < R && map[newR][newC] == 1)
						{
							toRemove[gi] = new int[] {newR, newC};
							flag = true;
							break;
						}
					}
				}
			}
			
			for (int i = 0; i < 3; i++)
			{
				if (toRemove[i][0] > -1 && toRemove[i][1] > -1 && map[toRemove[i][0]][toRemove[i][1]] == 1)
				{
					map[toRemove[i][0]][toRemove[i][1]] = 0;
					cnt++;
				}
			}
			
			//적 이동
			for (int i = N-2; i >= 0; i--)
			{
				for (int j = 0; j < M; j++)
				{
					map[i+1][j] = map[i][j];
				}
			}
			System.arraycopy(new int[M], 0, map[0], 0, M);
			
		} while (numEnemies > 0);
			

	
		
		
		
	}
	
	static int dist(int r1, int c1, int r2, int c2)
	{
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}
}
