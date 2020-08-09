package com.ssafy.baekjoon.p17135_캐슬디펜스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, D, R, mxCnt, nE, rcnt, nECopy;
	static int[] chosen;
	static int[][] map, mapCopy;
	
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
		nE = 0;
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
				{
					nE++;
				}
				mapCopy[i][j] = map[i][j];
			}
		}
		nECopy = nE;
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
			nE = nECopy;
			rcnt = 0;
			run();
			mxCnt = Math.max(rcnt, mxCnt);
			return;
		}
		for (int i = start; i < M; i++)
		{
			chosen[cnt] = i;
			nCr(cnt+1, i+1);
		}
	}
	
	static void run()
	{
		while  (nE > 0)
		{
			int[][] toRemove = new int[][] {{-1,-1},{-1,-1},{-1,-1}};
			
			for (int gi = 0; gi < 3; gi++)
			{
				//바로 위의 블록 검사
				boolean found = false;
				if (map[N-1][chosen[gi]] == 1)
				{
					found = true;
					toRemove[gi] = new int[] {N-1, chosen[gi]};
				}
				for (int d = 2; d <= D && !found; d++)
				{
					for (int j = -d+1; j <= d-1; j++)
					{
						int i = -1 * (d - Math.abs(j));
						int newR = N + i;
						int newC = chosen[gi] + j;
						if (checkRange(newR, newC))
						{
							if (map[newR][newC] == 1)
							{
								toRemove[gi] = new int[] {newR, newC};
								found = true;
								break;
							}
						}
					}
				}
			}
			
			for (int i = 0; i < 3; i++)
			{
				if (toRemove[i][0] > -1 && toRemove[i][1] > -1 && map[toRemove[i][0]][toRemove[i][1]] == 1)
				{
					map[toRemove[i][0]][toRemove[i][1]] = 0;
					rcnt++;
					nE--;
				}
			}
			
			//적 이동
			for (int j = 0; j < M; j++)
			{
				if (map[N-1][j] == 1)
				{
					map[N-1][j] = 0;
					nE--;
				}
			}

			for (int i = N-2; i >= 0; i--)
			{
				for (int j = 0; j < M; j++)
				{
					if (map[i][j] == 1)
					{
						map[i+1][j] = 1;
						map[i][j] = 0;
					}
				}
			}
		}
		
	}
	
	static boolean checkRange(int r, int c)
	{
		if (r >= 0 && r < N && c >= 0 && c < M)
		{
			return true;
		}
		return false;
	}
}
