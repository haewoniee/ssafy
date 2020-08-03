package com.ssafy.swea.p7272_안경이없어;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static int[] alpMap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		
		StringTokenizer st;
		for (int t = 1; t <= T; t++)
		{
			st = new StringTokenizer(br.readLine().trim());
			initMap();
			char[] first = st.nextToken().toCharArray();
			char[] second = st.nextToken().toCharArray();
			boolean success = true;
			System.out.print("#" + t + " ");
			if (first.length != second.length)
			{
				System.out.println("DIFF");
				success = false;
				continue;
			}
			for (int i = 0; i < first.length && success; i++)
			{
				if (alpMap[first[i]-'A'] != alpMap[second[i]-'A'])
				{
					success = false;
					System.out.println("DIFF");
					break;
				}
			}
			if (success)
			{
				System.out.println("SAME");
			}
		}
		br.close();
	}

	static void initMap()
	{
		alpMap = new int[26];
		char[] one_hole = "ADOPQR".toCharArray();
		for (int i = 0; i < one_hole.length; i++)
		{
			alpMap[one_hole[i]-'A'] = 1;
		}
		alpMap[1] = 2;
	}
}
