package com.ssafy.swea.p1210_Ladder1;

import java.util.Scanner;

public class Solution {
	
	static int[][] minimap;
	static int T, destR, destC;
	
	public static void main(String[] args) {
		T = 10;
		
		Scanner sc = new Scanner(System.in);

		for (int Ti = 1; Ti <= T; Ti++)
		{
			sc.nextInt();
			minimap = new int[100][100];
			for (int i = 0; i < 100; i++)
			{
				for (int j = 0; j < 100; j++)
				{
					minimap[i][j] = sc.nextInt();
					if (minimap[i][j] == 2)
					{
						destR = i;
						destC = j;
					}
				}
			}
			//거꾸�? ??�? ?��?���?�?
			while (destR > 0)
			{
				boolean flag = true;
				//?��쪽으�? ?��?��
				if (destC > 1)
				{
					//?��?���? 못갈?��까�? �?�?
					while (destC > 0 && minimap[destR][destC-1] == 1)
					{
						destC--;
						flag = false;
					}
				}
				
				//?��른쪽?���? ?��?��
				if (flag && destC < 100)
				{
					while (destC < 99 && minimap[destR][destC+1] == 1)
					{
						destC++;
					}
				}
				
				//?��?���? ?��?��
				destR--;
			}
			System.out.println("#" + Ti + " " + destC);
		}
		

		sc.close();

	}
	


}
