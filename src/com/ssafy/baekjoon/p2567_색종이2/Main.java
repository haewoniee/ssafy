package com.ssafy.baekjoon.p2567_색종이2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map = new int[102][102];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		for (int t = 0; t < N; t++)
		{
			st = new StringTokenizer(br.readLine().trim());
			int c = 1 + Integer.parseInt(st.nextToken());
			int r = 1 + Integer.parseInt(st.nextToken());
			//색칠하기
			for (int i = 0; i < 10; i++)
			{
				for (int j = 0; j < 10; j++)
				{
					map[r+i][c+1] = 1;
				}
			}
			
			//둘레 구하기
			for (int i = 0; i < N+1; i++)
			{
				for (int j = 0; j < N+1; j++)
				{
					if (map[i][j] == 0)
					{
						//가로 둘레
						if (map[i+1][j] == 1 && map[i][j+1] != 1)
						{
							map[i+1][j] = -1;
							DFS(i+1, j);
						}
						//세로 둘레
						else if (map[i+1][j] != 1 && map[i][j+1] == 1)
						{
							
						}
					}
				}
			}
		}
		
		br.close();
	}
	
	static void DFS(int r, int c)
	{
		
	}

}
