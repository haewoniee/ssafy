package com.ssafy.edu.s002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution45 {
	
	public static int X,Y,N,P, iT, B, rX, rY;
	public static int[][] jump, start, bomb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		iT = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		
		for (int T = 1; T <= iT; T++)
		{
			st = new StringTokenizer(br.readLine().trim());
			
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			
			jump = new int[N+2][N+2];
			for (int i = 0; i < jump.length; i++)
			{
				Arrays.fill(jump[i], 1);
			}
			
			for (int i = 1; i < jump.length-1; i++)
			{
				for (int j = 1; j < jump.length-1; j++)
				{
					jump[i][j] = 0;
				}
			}
			
			start = new int[P][2];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < P; i++)
			{
				start[i][0] = Integer.parseInt(st.nextToken());
				start[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine().trim());
			B = Integer.parseInt(st.nextToken());
			
			bomb = new int[B][2];
			for (int i = 0; i < B; i++)
			{
				bomb[i][0] = Integer.parseInt(st.nextToken());
				bomb[i][1] = Integer.parseInt(st.nextToken());
			}
			
			
		}
		
	}

}
