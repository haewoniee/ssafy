package com.ssafy.book_prob;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_p43_Strider {
	
	static int T, N, numStriders;
	static int[][] grid;
	static int[][] dir = {{}, {1,0}, {0,1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		for (int Ti = 1; Ti <= T; Ti++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			numStriders = Integer.parseInt(st.nextToken());
			grid = new int[N][N];
			int ans = 0;
			boolean flag = true;
			for (int strider = 1; strider <= numStriders; strider++)
			{
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				if (grid[r][c] == 0)
				{
					for (int i = 3; i >= 1 && flag; i--)
					{
						r += dir[d][0] * i;
						c += dir[d][1] * i;
						if (r >= 0 && r < N && c >= 0 && c < N)
						{
							if (grid[r][c] != 0)
							{
								flag = false;
								ans = strider;
								break;
							}
							grid[r][c] = strider;
						}
					}
				}
				else
				{
					ans = strider;
					flag = false;
				}
			}
			System.out.println("#" + Ti + " " + ans);
				
			
		}
		
		br.close();
	}

}
