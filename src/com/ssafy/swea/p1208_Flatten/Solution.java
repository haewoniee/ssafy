package com.ssafy.swea.p1208_Flatten;

import java.util.Scanner;

public class Solution {

	static int T = 10, C;
	static int[] arr = new int[100];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for (int Ti = 1; Ti <= T; Ti++)
		{
			int mxdiff;
			C = sc.nextInt();
			for (int i = 0; i < 100; i++)
			{
				arr[i] = sc.nextInt();
			}
			
			int mx, mxidx, mnidx, mn;
			while (true)
			{
				mx = arr[0];
				mxidx = 0;
				mnidx = 0;
				mn = arr[0];
				for (int i = 1; i < 100; i++)
				{
					if (arr[i] > mx)
					{
						mxidx = i;
						mx = arr[i];
					}
					if (arr[i] < mn)
					{
						mnidx = i;
						mn = arr[i];
					}
				}
				mxdiff = mx - mn;
				if (mxdiff <= 1 || C == 0)
				{
					break;
				}
				arr[mxidx]--;
				arr[mnidx]++;
				C--;
			}
			System.out.println("#" + Ti + " " + mxdiff);

		}
		
		sc.close();
	}
	

}
