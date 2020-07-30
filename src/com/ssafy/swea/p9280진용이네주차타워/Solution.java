package com.ssafy.swea.p9280진용이네주차타워;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int T, N, M, numCars, income, car;
	static StringTokenizer st;
	static int[] R, W, carsPos;
	static boolean[] parking;
	static Queue<Integer> waitingQue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());
		waitingQue = new LinkedList<Integer>();
		
		for (int t = 1; t <= T; t++)
		{
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = new int[N];
			W = new int[M];
			carsPos = new int[M];
			parking = new boolean[N];
			numCars = 0;
			income = 0;
			
			for (int i = 0; i < N; i++)
			{
				R[i] = Integer.parseInt(br.readLine().trim());
			}
			for (int i = 0; i < M; i++)
			{
				W[i] = Integer.parseInt(br.readLine().trim());
			}
			
			for (int i = 0; i < 2*M; i++)
			{
				boolean parked = false;
				car = Integer.parseInt(br.readLine().trim());
				if (car > 0)
				{
					car--;
					for (int j = 0; j < N; j++)
					{
						if (!parking[j])
						{
							parking[j] = true;
							parked = true;
							income += W[car] * R[j];
							carsPos[car] = j;
							break;
						}
					}
					if (!parked) waitingQue.offer(car);
				}
				else
				{
					car = car * -1 - 1;
					if (!waitingQue.isEmpty())
					{
						int newCar = waitingQue.poll();
						income += W[newCar] * R[carsPos[car]];
						carsPos[newCar] = carsPos[car];
					}
					else
					{
						parking[carsPos[car]] = false;
					}
					carsPos[car] = 0;
				}
			}
			
			System.out.println("#" + t + " " + income);
		}
		
		br.close();
	}

}
