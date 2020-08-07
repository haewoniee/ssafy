package com.ssafy.baekjoon.p2941_크로아티아알파벳;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
	static HashSet<String> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		set = new HashSet<String>();
		set.add("c=");
		set.add("c-");
		set.add("dz=");
		set.add("d-");
		set.add("lj");
		set.add("nj");
		set.add("s=");
		set.add("z=");
		String line = br.readLine().trim();
		
		int cnt = 0;
		int len = line.length();
		for (int i = 0; i < len; i++)
		{
			cnt++;
			if (i == len - 1)
			{
				continue;
			}
				//2글자 확인
			if (i <= len - 2 && set.contains(line.substring(i,i+2)))
			{
				i++;
				continue;
			}
			//3글자 확인
			if (i <= len - 3 && set.contains(line.substring(i,i+3)))
			{
				i += 2;
			}		
		}
		bw.append(cnt+"\n");
		bw.close();
		br.close();
	}

}
