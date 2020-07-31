package com.ssafy.lecture.live.live02;

import java.util.Arrays;
import java.util.Scanner;

//input arrë°›ì•„?„œ ê±°ê¸°?„œ rê°œì˜ ?ˆœ?—´ ë½‘ê¸°
public class P2_PermutationTest2 {

	private static int N, R;
	private static int[] numbers, input;
	private static boolean[] isSelected;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		numbers = new int[R];
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++)
		{
			input[i] = sc.nextInt();
		}
		sc.close();
		
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
		
		for (int i = 0; i < N; i++)
		{
			//ì¤‘ë³µ ?™•?¸
			if (isSelected[i]) continue;
			
			numbers[cnt] = input[i]; //?•´?‹¹?ˆ«?ë¥? ?‚¬?š©
			isSelected[i] = true;
			
			permutation(cnt+1); //?‹¤?Œ ?ë¦? ?ˆœ?—´ ë½‘ê¸°
			isSelected[i] = false;
		}
	}
}
