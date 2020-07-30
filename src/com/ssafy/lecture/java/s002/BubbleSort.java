package com.ssafy.lecture.java.s002;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,2,6,5,3,1};
		bSort(arr);
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void bSort(int[] arr)
	{
		for (int i = 0; i < arr.length-1; i++)
		{
			for (int j = 0; j < arr.length-i-1; j++)
			{
				if (arr[j] > arr[j+1])
				{
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}

}
