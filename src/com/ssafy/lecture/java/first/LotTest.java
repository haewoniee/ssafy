package com.ssafy.lecture.java.first;


public class LotTest {

	public static void main(String[] args) {
		int[] numbers = new int[6];
		int cnt = 0;
		while (cnt < 6)
		{
			int newNum = (int) (Math.random() * 45 + 1);
			if (!hasSame(numbers, newNum))
			{
				numbers[cnt] = newNum;
				cnt++;
			}
		}
		for (int i = 0; i < numbers.length; i++)
		{
			System.out.print(numbers[i] + " ");
		}
		System.out.println();

	}
	
	public static boolean hasSame(int[] numbers, int num)
	{
		for (int i = 0; i < numbers.length; i++)
		{
			if (numbers[i] == num)
			{
				return true;
			}
		}
		return false;
	}

}
