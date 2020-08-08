package com.ssafy.baekjoon.p2931_가스관;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int R, C, ansR, ansC;
	static boolean successFlag = false;
	static char[][] map;
	static int[] M, Z, answer = new int[4];
	static int[][] visited, dir = {{-1,0},{0,-1},{1,0},{0,1}};
	static ArrayList<char[]> possibles = new ArrayList<char[]>();
	static HashMap<Character, int[]> blockDir = new HashMap<Character, int[]>();
	static HashMap<Integer, Character> blocks = new HashMap<Integer, Character>();
	
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		//위, 왼쪽, 아래, 오른쪽
		blocks.put(10, '|');
		blocks.put(5, '-');
		blocks.put(15, '+');
		blocks.put(3, '1');
		blocks.put(9, '2');
		blocks.put(12, '3');
		blocks.put(6, '4');

		blockDir.put('|', new int[] {0,2});
		blockDir.put('-', new int[] {1,3});
		blockDir.put('+', new int[] {0,1,2,3});
		blockDir.put('1', new int[] {2,3});
		blockDir.put('2', new int[] {0,3});
		blockDir.put('3', new int[] {0,1});
		blockDir.put('4', new int[] {1,2});
		
		possibles.add(new char[]{'|','+','1','4','Z'});
		possibles.add(new char[]{'-','+','1','2','Z'});
		possibles.add(new char[]{'|','+','2','3','Z'});
		possibles.add(new char[]{'-','+','3','4','Z'});
		
		ansR = -1;
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new int[R][C];
		for (int i = 0; i < R; i++)
		{
			char[] inputList = br.readLine().trim().toCharArray();
			for (int j = 0; j < C; j++)
			{
				map[i][j] = inputList[j];
				if (map[i][j] == 'M')
				{
					M = new int[] {i, j};
				}
				else if (map[i][j] == 'Z')
				{
					Z = new int[] {i, j};
				}
			}
		}
		
		visited[M[0]][M[1]] = 1;
		for (int i = 0; i < 4; i++)
		{
			int newR = M[0] + dir[i][0];
			int newC = M[1] + dir[i][1];
			if (newR >= 0 && newR < R && newC >= 0 && newC < C)
			{
				if (map[newR][newC] != '.' && map[newR][newC] != 'Z')
				{
					visited[newR][newC] = 1;
					map[M[0]][M[1]] = '.';
					DFS(newR, newC);
					break;
				}
				
			}
		}
		if (successFlag)
		{
			System.out.println(ansR + " " + ansC + " " + map[ansR-1][ansC-1]);
			return;
		}

		br.close();
	}
	
	static char getBlock(int[] keys)
	{
		int ansKey = 0;
		int multiplier = 8;
		for (int i = 0; i < 4; i++)
		{
			ansKey += answer[i] * multiplier;
			multiplier /= 2;
		}
		char ans = blocks.get(ansKey);
		return ans;
	}
	
	static void DFS(int r, int c)
	{
		if (map[r][c] == 'Z')
		{
			successFlag = true;
		}
		else if (map[r][c] == '.')
		{
			for (int i = 0; i < 4; i++)
			{
				int newR = r + dir[i][0];
				int newC = c + dir[i][1];
				if (newR >= 0 && newR < R && newC >= 0 && newC < C)
				{
					boolean flag = false;
					char[] poss = possibles.get(i);
					for (int j = 0; j < poss.length; j++)
					{
						if (poss[j] == map[newR][newC])
						{
							boolean zFlag = false;
							if (map[newR][newC] == 'Z')
							{
								for (int k = 0; k < 4; k++)
								{
									int secR = newR + dir[k][0];
									int secC = newC + dir[k][1];
									if (secR != r && secC != c && secR >= 0 && secR < R && secC >= 0 && secC < C)
									{
										if (map[secR][secC] != '.')
										{
											zFlag = true;
											break;
										}
									}
								}
							}
							if (!zFlag)
							{
								//found, possible
								flag = true;
								break;	
							}
						}
					}
					if (flag)
					{
						answer[i] = 1;
					}
				}
			}
			map[r][c] = getBlock(answer);
			visited[r][c] = 1;
			ansR = r + 1;
			ansC = c + 1;
			DFS(r,c);
		}
		else
		{
			int[] dirs = blockDir.get(map[r][c]);
			for (int i = 0; i < dirs.length; i++)
			{
				int newR = r + dir[dirs[i]][0];
				int newC = c + dir[dirs[i]][1];
				if (newR >= 0 && newR < R && newC >= 0 && newC < C)
				{
					if (visited[newR][newC] == 0)
					{
						visited[newR][newC] = 1;
						DFS(newR, newC);
					}
				}
			}
			
		}
	}

}
