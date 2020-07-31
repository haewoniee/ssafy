package com.ssafy.lecture.live.live02;

//input arrë°›ì•„?„œ ê±°ê¸°?„œ rê°œì˜ ì¡°í•© ë½‘ê¸°

import java.util.Arrays;
import java.util.Scanner;

public class C1_CombinatiionTest {
	
	static int N, R;
	static int[] numbers, input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
				
		input = new int[N];
		for(int i = 0; i < N; i++)
		{
			input[i] = sc.nextInt();
		}
		sc.close();

		numbers = new int[R];
;
		
		combination(0,0);
	}
	
	// ì§?? •?œ ?ë¦¬ì— ì¡°í•© ë½‘ê¸°
	private static void combination(int cnt, int start) //cnt: ?˜„?¬ê¹Œì? ë½‘ì? ì¡°í•© ?ˆ˜, start: ì¡°í•©?— ?‹œ?‘? ?œ¼ë¡? ?‹œ?„?•  index
	{
		if (cnt == R)
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//?•?„  ?ˆ˜?˜ ?„ ?ƒ ?‹¤?Œë¶??„° ?‹œ?„
		for (int i = start; i < N; i++)
		{
			numbers[cnt] = input[i];	
			combination(cnt+1, i+1);
		}
	}
}
