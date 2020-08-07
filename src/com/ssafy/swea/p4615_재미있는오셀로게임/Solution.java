package com.ssafy.swea.p4615_재미있는오셀로게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, M;
	static int[][] board;
	static int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new int[N][N];
			//가운데에 돌 놓기
			//백
			board[N/2-1][N/2-1] = 2;
			board[N/2][N/2] = 2;
			//흑
			board[N/2][N/2-1] = 1;
			board[N/2-1][N/2] = 1;
			for (int i = 0; i < M; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				int c = Integer.parseInt(st.nextToken())-1;
				int r = Integer.parseInt(st.nextToken())-1;
				int color = Integer.parseInt(st.nextToken());
				turn(r,c,color);
			}
			int[] result = count();
			System.out.println("#" + t + " " + result[0] + " " + result[1]);
		}
		
		br.close();
		
	}
	
	static int[] count()
	{
		int bc = 0, wc = 0;
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (board[i][j] == 1)
				{
					bc++;
				}
				else if (board[i][j] == 2)
				{
					wc++;
				}
			}
		}
		return new int[] {bc, wc};
	}
	
	static void printBoard()
	{
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}
	
	static void turn(int r, int c, int color)
	{
		for (int i = 0; i < 8; i++) {
			int toEatR = r + dir[i][0];
			int toEatC = c + dir[i][1];
			if (toEatR >= 0 && toEatR < N
					&& toEatC >= 0 && toEatC < N)
			{
				if (board[toEatR][toEatC] != 0 && board[toEatR][toEatC] != color)
				{
					int myR = r + dir[i][0]*2;
					int myC = c + dir[i][1]*2;
					ArrayList<int[]> toChange = new ArrayList<int[]>();
					toChange.add(new int[] {toEatR, toEatC});
					while (myR >= 0 && myR < N && myC >= 0 && myC < N)
					{
						if (board[myR][myC] == color)
						{
							//found
							board[r][c] = color;
							for (int [] change : toChange)
							{
								board[change[0]][change[1]] = color;
							}
							break;
						}
						else if (board[myR][myC] == 0)
						{
							break;
						}
						toChange.add(new int[] {myR, myC});
						myR += dir[i][0];
						myC += dir[i][1];
					}
				}
			}
		}
	}
}
