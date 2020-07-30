package com.ssafy.swea.p1225암호생성기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] arr = new int[8];
	static int pos;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String t;
		while (br.ready())
		{
			t = br.readLine().trim();
			st = new StringTokenizer(br.readLine().trim());
			pos = 0;
			
			for (int i = 0; i < 8; i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			while (arr[pos] > 0)
			{
				for (int i = 1; i <= 5; i++)
				{
					arr[pos] = arr[pos] >= i ? arr[pos] - i : 0;
					if (arr[pos] == 0){
						break;
					};
					pos = (pos + 1) % 8;
				}
			}
			pos = (pos + 1) % 8;
			System.out.print("#" + t + " ");
			for (int i = pos; i < 8; i++)
			{
				System.out.print(arr[i] + " ");
			}
			
			for (int i = 0; i < pos; i++)
			{
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		br.close();
	}

}
