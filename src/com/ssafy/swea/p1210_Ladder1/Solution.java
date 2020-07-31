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
			//ê±°ê¾¸ë¡? ??ê³? ?˜¬?¼ê°?ê¸?
			while (destR > 0)
			{
				boolean flag = true;
				//?™¼ìª½ìœ¼ë¡? ?´?™
				if (destC > 1)
				{
					//?•?œ¼ë¡? ëª»ê°ˆ?•Œê¹Œì? ê°?ê¸?
					while (destC > 0 && minimap[destR][destC-1] == 1)
					{
						destC--;
						flag = false;
					}
				}
				
				//?˜¤ë¥¸ìª½?œ¼ë¡? ?´?™
				if (flag && destC < 100)
				{
					while (destC < 99 && minimap[destR][destC+1] == 1)
					{
						destC++;
					}
				}
				
				//?•„?˜ë¡? ?´?™
				destR--;
			}
			System.out.println("#" + Ti + " " + destC);
		}
		

		sc.close();

	}
	


}
