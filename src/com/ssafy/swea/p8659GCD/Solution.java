package com.ssafy.swea.p8659GCD;

import java.util.Scanner;

public class Solution {
	
	static int T, K;
	static long[] fibo = new long[92];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		fibo[0] = 1;
		fibo[1] = 1;
		
		for (int t = 1; t <= T; t++)
		{
			K = sc.nextInt();
			if (fibo[K+1] == 0)
			{
				for (int i = 2; i <= K+1; i++)
				{
					if (fibo[i] == 0)
					{
						fibo[i] = fibo[i-1]+fibo[i-2];
					}
					else
					{
						continue;
					}
				}
			}
			
			System.out.println("#" + t + " " + fibo[K+1] + " " + fibo[K]);
		}
		
		
		sc.close();
	}

}
