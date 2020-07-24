package com.ssafy.swea.emoticon;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine().trim());
		for (int i = 0; i < n; i++)
		{
			String emo = sc.nextLine().trim();
			StringBuffer sb = new StringBuffer();
			int idx = 0;
			int len = emo.length();
			while (idx < len-1)
			{
				
				if (idx > 0 && emo.charAt(idx-1) == '^' && emo.charAt(idx) != '^' && emo.charAt(idx+1) == '^')
				{
					sb.append("_");
				}
				else if (!((emo.charAt(idx) == '(' && emo.charAt(idx+1) == '(') ||
						(emo.charAt(idx) == ')' && emo.charAt(idx+1) == ')') ||
						(idx > 0 && emo.charAt(idx-1) == '^' && emo.charAt(idx) == '^' && emo.charAt(idx+1) == '^')))
				{
					sb.append(emo.charAt(idx));
				}
				idx++;
			}
			sb.append(emo.charAt(len-1));
			System.out.println(sb.toString());
		}
		
		
		sc.close();
	}
}
