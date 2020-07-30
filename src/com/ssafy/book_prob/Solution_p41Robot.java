package com.ssafy.in_class;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_p41Robot {

	static int T, N, cnt;
	static ArrayList<int[]> robots;
	static char[][] grid;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		
		for (int Ti = 1; Ti <= T; Ti++)
		{
			cnt = 0;
			N = Integer.parseInt(br.readLine().trim());
			grid = new char[N][N];
			robots = new ArrayList<int[]>();

			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					char read = (char) br.read();
					while (read == ' ' || read == '\n' || read == '\r')
					{
						read = (char) br.read();
					}
					grid[i][j] = read;
					if (read == 'A' || read == 'B' || read == 'C')
					{
						int[] pt = {i, j, (int)read-65};
						robots.add(pt);
					}
				}
			}
			
			for (int[] robot: robots)
			{
				//A: 0, B: 1, C: 2
				switch(robot[2])
				{
				case 0:
					//오른쪽으로만
					for (int j = robot[1]+1; j < N; j++)
					{
						if (grid[robot[0]][j] != 'S')
						{
							break;
						}
						cnt++;
					}
					break;
				case 1:
					//오른쪽으로
					for (int j = robot[1]+1; j < N; j++)
					{
						if (grid[robot[0]][j] != 'S')
						{
							break;
						}
						cnt++;
					}
					
					//왼쪽으로
					for (int j = robot[1]-1; j >= 0; j--)
					{
						if (grid[robot[0]][j] != 'S')
						{
							break;
						}
						cnt++;
					}
					break;
				case 2:
					//오른쪽으로
					for (int j = robot[1]+1; j < N; j++)
					{
						if (grid[robot[0]][j] != 'S')
						{
							break;
						}
						cnt++;
					}
					
					//왼쪽으로
					for (int j = robot[1]-1; j >= 0; j--)
					{
						if (grid[robot[0]][j] != 'S')
						{
							break;
						}
						cnt++;
					}
					
					//아래로
					for (int i = robot[0]+1; i < N; i++)
					{
						if (grid[i][robot[1]] != 'S')
						{
							break;
						}
						cnt++;
					}
					//위로
					for (int i = robot[0]-1; i >= 0; i--)
					{
						if (grid[i][robot[1]] != 'S')
						{
							break;
						}
						cnt++;
					}

					break;
				}
			}
			System.out.println("#" + Ti + " " + cnt);
			br.readLine();
		}
		
		br.close();
	}

}
