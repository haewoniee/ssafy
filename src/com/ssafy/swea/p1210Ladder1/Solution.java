package com.ssafy.swea.p1210Ladder1;

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
			//거꾸로 타고 올라가기
			while (destR > 0)
			{
				boolean flag = true;
				//왼쪽으로 이동
				if (destC > 1)
				{
					//앞으로 못갈때까지 가기
					while (destC > 0 && minimap[destR][destC-1] == 1)
					{
						destC--;
						flag = false;
					}
				}
				
				//오른쪽으로 이동
				if (flag && destC < 100)
				{
					while (destC < 99 && minimap[destR][destC+1] == 1)
					{
						destC++;
					}
				}
				
				//아래로 이동
				destR--;
			}
			System.out.println("#" + Ti + " " + destC);
		}
		

		sc.close();

	}
	


}
