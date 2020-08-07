package com.ssafy.baekjoon.p19238_스타트택시;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int[][] passengers, map, costMap, dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private static int N, M, fuel, curR, curC, arrived;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		passengers = new int[M][4];
		costMap = new int[N + 1][N + 1];
		arrived = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine().trim());
		curR = Integer.parseInt(st.nextToken());
		curC = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 4; j++) {
				passengers[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (fuel > 0) {
			// 최단거리 승객 찾기
			int mnCost = Integer.MAX_VALUE;
			int mnIdx = -1;
			for (int i = M-1; i >= 0; i--) {
				// 아직 태워야하는 승객이면
				if (passengers[i][0] > 0) {
					initCostMap();
					costMap[curR][curC] = 0;
					int cost = BFS(curR, curC, passengers[i][0], passengers[i][1]);
					if (cost < mnCost) {
						mnCost = cost;
						mnIdx = i;
					}
					else if (cost != Integer.MAX_VALUE && cost == mnCost)
					{
						if (passengers[i][0] < passengers[mnIdx][0] 
								|| (passengers[i][0] == passengers[mnIdx][0] && passengers[i][1] < passengers[mnIdx][1]))
						{
							mnCost = cost;
							mnIdx = i;
						}
					}
				}
			}

			if (mnCost == Integer.MAX_VALUE)
			{
				System.out.println(-1);
				break;
			}
			if (fuel - mnCost < 0) {
				// 못 태웠으니까 나가기
				if (mnCost == Integer.MAX_VALUE)
				{
					System.out.println(fuel);
				}
				else
				{
					System.out.println(-1);
				}
				break;
			}
			else
			{
				//승객 좌표로 이동
				curR = passengers[mnIdx][0];
				curC = passengers[mnIdx][1];
				//태운 승객 시작 좌표 -1로 찍기
				passengers[mnIdx][0] = -1;
				fuel -= mnCost;
			}
			// 승객 태워다주기
			initCostMap();
			costMap[curR][curC] = 0;
			int cost = BFS(curR, curC, passengers[mnIdx][2], passengers[mnIdx][3]);
			if (cost > fuel) {
				System.out.println(-1);
				break;
			}
			fuel += cost;
			arrived++;
			if (arrived == M)
			{
				System.out.println(fuel);
				break;
			}
			curR = passengers[mnIdx][2];
			curC = passengers[mnIdx][3];

			
		}

		br.close();
	}

	static int BFS(int r, int c, int destR, int destC) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] { r, c });
		while (!que.isEmpty()) {
			if (costMap[destR][destC] >= 0) {
				return costMap[destR][destC];
			}
			int[] cur = que.poll();
			for (int i = 0; i < 4; i++) {
				int newR = cur[0] + dir[i][0];
				int newC = cur[1] + dir[i][1];
				if (newR > 0 && newR <= N && newC > 0 && newC <= N) {
					if (map[newR][newC] == 0 && costMap[newR][newC] == -1) {
						que.add(new int[] { newR, newC });
						costMap[newR][newC] = costMap[cur[0]][cur[1]] + 1;
					}
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	static void initCostMap() {
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				costMap[i][j] = -1;
			}
		}
	}

}
