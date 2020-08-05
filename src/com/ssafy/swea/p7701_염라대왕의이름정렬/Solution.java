package com.ssafy.swea.p7701_염라대왕의이름정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution {
	
	static int T, N;
	static HashSet<String> set;
	static PriorityQueue<String> names = new PriorityQueue<String>(new Comparator<String>()
	{
		@Override
		public int compare(String o1, String o2) {
			int len1 = o1.length();
			int len2 = o2.length();
			if (len1 == len2)
			{
				return o1.compareTo(o2);
			}
			return len1 - len2;
		}
	}					
	);
;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++)
		{
			names.clear();
			N = Integer.parseInt(br.readLine().trim());
			set = new HashSet<String>();
			for (int i = 0; i < N; i++)
			{
				String name = br.readLine().trim();
				if (!set.contains(name))
				{
					names.add(name);	
					set.add(name);
				}
			}
			
			bw.write("#" + t);
			bw.newLine();
			while (!names.isEmpty())
			{
				bw.write(names.poll());
				bw.newLine();
			}
		}
		bw.close();
		br.close();
	}

}
