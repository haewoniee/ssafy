package com.ssafy.swea.p1954_달팽이숫자;

import java.util.Scanner;

public class Solution {

	static int T, N, d;
	static int[][] map, dir = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int Ti = 1; Ti <= T; Ti++)
		{
			N = sc.nextInt();
			map = new int[N][N];
			int idx = 1;
			d = 0;
			int r = 0, c = 0;
			while (N > 0)
			{
				d = d % 4;
				//諛⑺뼢蹂꾨줈 N 媛� �몢踰� 諛섎났
				for (int j = 0; j < 2; j++)
				{
					for (int i = 0; i < N; i++)
					{
						r = i * dir[d][0];
						c = i * dir[d][1];
						map[r][c] = idx;
						idx++;
					}
					d++;
				}
				N--;
			}
		}
		
		
		sc.close();
	}
}
