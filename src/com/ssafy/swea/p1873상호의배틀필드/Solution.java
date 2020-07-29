package com.ssafy.swea.p1873상호의배틀필드;

import java.util.Scanner;

public class Solution {

	static int T, H, W, N, r, c, curDir = -1;
	static char[][] map;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++)
		{
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];
			
			for (int i = 0; i < H; i++)
			{
				String next = sc.next();
				for (int j = 0; j < W; j++)
				{
					map[i][j] = next.charAt(j);
					if (map[i][j] == '>' || map[i][j] == '^' || map[i][j] == '<' || map[i][j] == 'v')
					{
						switch(map[i][j])
						{
						case '^':
							curDir = 0;
							break;
						case 'v':
							curDir = 1;
							break;
						case '<':
							curDir = 2;
							break;
						case '>':
							curDir = 3;
							break;
						}
						r = i;
						c = j;
					}
				}
			}
			
			N = sc.nextInt();
			String commands = sc.next();
			for (int i = 0; i < N; i++)
			{
				char command = commands.charAt(i);
				switch(command)
				{
				case 'U':
					curDir = 0;
					if (r-1 >= 0 && map[r-1][c] == '.')
					{
						map[r][c] = '.';
						map[r-1][c] = '^';
						r--;
					}
					else
					{
						map[r][c] = '^';
					}
					break;
				case 'D':
					curDir = 1;
					if (r+1 < H && map[r+1][c] == '.')
					{
						map[r][c] = '.';
						map[r+1][c] = 'v';
						r++;
					}
					else
					{
						map[r][c] = 'v';
					}
					break;
				case 'L':
					curDir = 2;
					if (c-1 >= 0 && map[r][c-1] == '.')
					{
						map[r][c] = '.';
						map[r][c-1] = '<';
						c--;
					}
					else
					{
						map[r][c] = '<';
					}
					break;
				case 'R':
					curDir = 3;
					if (c+1 < W && map[r][c+1] == '.')
					{
						map[r][c] = '.';
						map[r][c+1] = '>';
						c++;
					}
					else
					{
						map[r][c] = '>';
					}
					break;
				case 'S':
					int newR = r + dir[curDir][0];
					int newC = c + dir[curDir][1];
					while (newR >= 0 && newR < H && newC >= 0 && newC < W)
					{
						if (map[newR][newC] == '#')
						{
							break;
						}
						else if (map[newR][newC] == '*')
						{
							map[newR][newC] = '.';
							break;
						}
						newR += dir[curDir][0];
						newC += dir[curDir][1];
					}
					break;
				}
			}
			
			System.out.print("#" + t + " ");
			print();
		}
		
		
		sc.close();
	}

	
	static void print()
	{
		for (int i = 0; i < H; i++)
		{
			for (int j = 0; j < W; j++)
			{
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}
}

