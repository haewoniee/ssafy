package com.ssafy.baekjoon.p2954_창영이의일기장;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	private static String[] words;
	private static int mode;
	private static HashMap<Integer,HashSet<String>> set;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//문자열 대응 set 생성, 1: aeiou모드, 2: safy모드
		set = new HashMap<Integer, HashSet<String>>();
		set.put(1, new HashSet<String>());
		set.put(2, new HashSet<String>());
		
		//문자열 대응 dictionary
		set.get(1).add("apa");
		set.get(1).add("epe");
		set.get(1).add("ipi");
		set.get(1).add("opo");
		set.get(1).add("upu");

		set.get(2).add("sps");
		set.get(2).add("apa");
		set.get(2).add("fpf");
		set.get(2).add("ypy");
		
		//해석할 단어의 개수
		int numWords = st.countTokens();
		
		//주어진 단어들 저장하기
		words = new String[numWords];

		//단어 input 저장
		for(int i = 0; i < numWords; i++)
		{
			words[i] = st.nextToken();
		}
		mode = Integer.parseInt(br.readLine().trim());
		
		for (int w = 0; w < numWords; w++)
		{
			//단어의 알파벳을 하나하나 돌면서 고쳐준 단어를 버퍼에 저장
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < words[w].length(); i++)
			{
				if (i+2 < words[w].length() && set.get(mode).contains(words[w].substring(i,i+3)))
				{
					sb.append(words[w].charAt(i));
					i += 2;
				}
				else
				{
					sb.append(words[w].charAt(i));
				}
			}
			bw.write(sb.toString() + " ");
		}
		bw.newLine();
		bw.close();
		
		br.close();
	}

}