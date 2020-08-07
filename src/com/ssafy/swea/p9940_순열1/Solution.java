package com.ssafy.swea.p9940_순열1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int T, N;
	static int[] perm;
	static boolean endFlag;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++)
		{
			endFlag = false;
			N = Integer.parseInt(br.readLine().trim());
			perm = new int[N+1];
			String[] input = br.readLine().trim().split(" ");
			System.out.print("#" + t + " ");
			
			for (int i = 0; i < N; i++)
			{
				int num = Integer.parseInt(input[i]);
				if (num < 0 || num > N || perm[num] == 1)
				{
					System.out.println("No");
					endFlag = true;
					break;
				}
				perm[num] = 1;
			}
			if (endFlag) continue;
			for (int i = 1; i <= N; i++)
			{
				if (perm[i] == 0)
				{
					System.out.println("No");
					endFlag = true;
					break;
				}
			}
			System.out.println("Yes");

		}
		br.close();
		
	}

}
