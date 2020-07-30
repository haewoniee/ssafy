package com.ssafy.live.lec02;

import java.util.Arrays;

//?ˆœ?—´, 1~Nê¹Œì?
public class P1_PermutationTest {

	private static int N = 4, R = 2;
	private static int[] numbers;
	private static boolean[] isSelected;
	
	public static void main(String[] args) {
		numbers = new int[R];
		isSelected = new boolean[N+1];
		
		permutation(0);
		
	}

	
	//ì§?? •?œ ?ë¦¬ì— ?ˆœ?—´ ë½‘ê¸°
	private static void permutation(int cnt) // cnt: ?˜„?¬ê¹Œì? ë½‘ì? ?ˆœ?—´?˜ ê°??ˆ˜
	{
		if (cnt == R)
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 1; i <= N; i++)
		{
			//ì¤‘ë³µ ?™•?¸
			if (isSelected[i]) continue;
			
			numbers[cnt] = i; //?•´?‹¹?ˆ«?ë¥? ?‚¬?š©
			isSelected[i] = true;
			
			permutation(cnt+1); //?‹¤?Œ ?ë¦? ?ˆœ?—´ ë½‘ê¸°
			isSelected[i] = false;
		}
	}
}
