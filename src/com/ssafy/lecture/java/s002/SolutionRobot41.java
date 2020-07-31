package com.ssafy.lecture.java.s002;

import java.util.ArrayList;
import java.util.Scanner;

public class SolutionRobot41 {

	static int Ti, N;
	static char[][] grid;
	static ArrayList<int[]> robotPos;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Ti = sc.nextInt();

		for (int T = 1; T <= Ti; T++)
		{
			N = sc.nextInt();
			grid = new char[N][N];
			robotPos = new ArrayList<int[]>();
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					grid[i][j] = sc.next().charAt(0);
					if (grid[i][j] == 'A' || grid[i][j] == 'B' || grid[i][j] == 'C')	
					{
						int[] pos = {i,j};
						robotPos.add(pos);
					}
				}
			}
			int cnt = 0;
			for (int[] pos : robotPos)
			{
				switch(grid[pos[0]][pos[1]])
				{
				case 'A':
					//?˜¤ë¥¸ìª½?œ¼ë¡œë§Œ ?´?™
					for (int j = pos[1]+1; j < N; j++)
					{
						if (grid[pos[0]][j] != 'S')
						{
							break;
						}
						cnt++;
					}
					break;
				case 'B':
					//?˜¤ë¥¸ìª½?œ¼ë¡œë§Œ ?´?™
					for (int j = pos[1]+1; j < N; j++)
					{
						if (grid[pos[0]][j] != 'S')
						{
							break;
						}
						cnt++;
					}
					//?™¼ìª½ìœ¼ë¡œë§Œ ?´?™
					for (int j = pos[1]-1; j >= 0; j--)
					{
						if (grid[pos[0]][j] != 'S')
						{
							break;
						}
						cnt++;
					}
					break;
				case 'C':
					//?˜¤ë¥¸ìª½?œ¼ë¡œë§Œ ?´?™
					for (int j = pos[1]+1; j < N; j++)
					{
						if (grid[pos[0]][j] != 'S')
						{
							break;
						}
						cnt++;
					}
					//?™¼ìª½ìœ¼ë¡œë§Œ ?´?™
					for (int j = pos[1]-1; j >= 0; j--)
					{
						if (grid[pos[0]][j] != 'S')
						{
							break;
						}
						cnt++;
					}
					//?•„?˜,?œ„
					//?•„?˜ìª½ìœ¼ë¡œë§Œ ?´?™
					for (int i = pos[0]+1; i < N; i++)
					{
						if (grid[i][pos[1]] != 'S')
						{
							break;
						}
						cnt++;
					}
					//?œ„ìª½ìœ¼ë¡œë§Œ ?´?™
					for (int i = pos[0]-1; i >= 0; i--)
					{
						if (grid[i][pos[1]] != 'S')
						{
							break;
						}
						cnt++;
					}
				}
			}
			System.out.println("#" + T + " " + cnt);
		}
		
		sc.close();
	}

}
