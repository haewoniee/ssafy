package com.ssafy.lecture.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class DigitTest1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] nums = new int[10];
		HashSet<Integer> set = new HashSet<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int num = Integer.parseInt(st.nextToken());
		while (num != 0)
		{
			nums[num/10]++;
			set.add(num/10);
			num = Integer.parseInt(st.nextToken());
		}
		
		for (int i : set)
		{
			System.out.println(i + " : " + nums[i] + "ê°?");
		}
		
		br.close();

	}

}
