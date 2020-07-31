package com.ssafy.swea.p1861_정사각형방;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, mx, mxIdx;
	static int[][] room, dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++)
		{
			N = Integer.parseInt(br.readLine().trim());
			room = new int[N][N];
			mx = -1;
			mxIdx = N*N+1;
			for (int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++)
				{
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					DFS(i,j);
				}
			}			
			bw.append("#" + t + " " + mxIdx + " " + mx);
			bw.newLine();
		}	
		
		bw.close();
		br.close();

	}

	static int DFS(int r, int c)
	{
		int mxCnt = 1;
		for (int i = 0; i < 4; i++)
		{
			int cnt = 1;
			int newR = r+dir[i][0];
			int newC = c+dir[i][1];
			
			if (newR >= 0 && newR < N && newC >= 0 && newC < N)
			{
				if (room[newR][newC] == room[r][c] + 1)
				{
					cnt = cnt + DFS(newR, newC);
					mxCnt = Math.max(cnt, mxCnt);
					if (cnt > mx)
					{
						mx = cnt;
						mxIdx = room[r][c];
					}
					else if (cnt == mx)
					{
						mxIdx = Math.min(mxIdx, room[r][c]);
					}
				}
			}
		}
		return mxCnt;
		
		
	}
}
