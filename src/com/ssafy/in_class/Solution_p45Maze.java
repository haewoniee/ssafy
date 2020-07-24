package com.ssafy.in_class;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_p45Maze {

	static int T, N, numJumpers, numMoves;
	static int[][] jumper, dir = {{}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int startR, startC;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		T = Integer.parseInt(st.nextToken());
		
		for (int Ti = 1; Ti <= T; Ti++)
		{
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			
			numJumpers = Integer.parseInt(st.nextToken());
			jumper = new int[N+1][N+1];
			
			st = new StringTokenizer(br.readLine().trim());
			for (int k = 0; k < numJumpers; k++)
			{
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				jumper[i][j] = 1;
			}
			
			
			numMoves = Integer.parseInt(br.readLine().trim());

			st = new StringTokenizer(br.readLine().trim());

			int newR = startR;
			int newC = startC;
			boolean flag = true;
			for (int m = 0; m < numMoves && flag; m++)
			{
				int d = Integer.parseInt(st.nextToken());
				int moveAmt = Integer.parseInt(st.nextToken());
				for (int i = 0; i < moveAmt; i++)
				{
					newR += dir[d][0];
					newC += dir[d][1];
					if (newR > 0 && newR <= N && newC > 0 && newC <= N)
					{
						if (jumper[newR][newC] == 1)
						{
							newR = 0;
							newC = 0;
							flag = false;
							break;
						}
					}
					else
					{
						newR = 0;
						newC = 0;
						flag = false;
						break;	
					}
				}
			}	
			System.out.println("#" + Ti + " " + newR + " " + newC);
		}
		
		
		
		br.close();
		
	}
}
