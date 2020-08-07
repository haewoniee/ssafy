package com.ssafy.programmers.dp_도둑질;

public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] money = {10, 2, 2, 100, 2};
		s.solution(money);

	}

	public int solution(int[] money) {
		int[] dp1 = new int[money.length];
		int[] dp2 = new int[money.length];
		dp1[0] = money[0];
        dp1[1] = dp1[0];
		//첫집 털고 마지막집 안터는 경우
		for (int i = 2; i < money.length-1; i++)
		{
			//현재 집 안터는 경우 or 현재 집 털고 그 전전집 터는 경우
			dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
		}
		//첫집 안털고 마지막집 터는 경우
		dp2[1] = money[1];
		for (int i = 2; i < money.length; i++)
		{
			dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);				
		}
	
        return Math.max(dp1[money.length-2], dp2[money.length-1]);
    }	
}
