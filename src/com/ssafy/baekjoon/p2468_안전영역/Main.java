package com.ssafy.baekjoon.p2468_안전영역;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N, mxHeight, mnHeight, mxCnt;
	private static int[][] map, imap, dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		imap = new int[N][N];
		StringTokenizer st = null;
		mxHeight = 0;
		mxCnt = 1;
		mnHeight = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				mxHeight = Math.max(mxHeight, map[i][j]);
				mnHeight = Math.min(mnHeight, map[i][j]);
			}
		}
		
		for (int h = mnHeight; h < mxHeight; h++)
		{
			flood(h);
			int cnt = 0;
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					if (imap[i][j] == 0 && map[i][j] > 0)
					{
						cnt++;
						imap[i][j] = 1;
						DFS(i,j);						
					}
				}
			}
			mxCnt = Math.max(mxCnt, cnt);
		}
		
		bw.write(mxCnt + "");
		bw.newLine();
		bw.close();
		br.close();
	}
	
	static void flood(int height)
	{
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (map[i][j] > 0 && map[i][j] <= height)
				{
					map[i][j] = -1;
				}
				imap[i][j] = 0;
			}
		}
	}
	
	static void DFS(int r, int c)
	{
		for (int i = 0; i < 4; i++)
		{
			int newR = r + dir[i][0];
			int newC = c + dir[i][1];
			if (newR >= 0 && newR < N && newC >= 0 && newC < N)
			{
				if (imap[newR][newC] == 0 && map[newR][newC] > 0)
				{
					imap[newR][newC] = 1;
					DFS(newR, newC);					
				}
			}
		}
	}

}
