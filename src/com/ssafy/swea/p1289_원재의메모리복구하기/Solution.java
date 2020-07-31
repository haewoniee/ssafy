package com.ssafy.swea.p1289_원재의메모리복구하기;

import java.util.Scanner;

public class Solution {
	static int T;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = Integer.parseInt(sc.nextLine().trim());
		
		for (int t = 1; t <= T; t++)
		{
			String ss = sc.nextLine().trim();
			char s = '0';
			int c = 0;
			for (int i = 0; i < ss.length(); i++)
			{
				if (ss.charAt(i) != s)
				{
					if (s == '0') s = '1';
					else s = '0';
					c++;
				}
			}
			System.out.println("#" + t + " " + c);
		}
		
		
		sc.close();
	}

}
