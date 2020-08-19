package com.ssafy.baekjoon.p2933_미네랄;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, N, turn, curR;// turn: 0=왼쪽, 1=오른쪽
	static char[][] cave;
	static int[][] visited;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	static ArrayList<int[]> cluster;
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cave = new char[R][C];
		cluster = new ArrayList<int[]>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine().trim());
			char[] input = st.nextToken().toCharArray();
			for (int j = 0; j < C; j++) {
				cave[i][j] = input[j];
			}
		}
		N = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			curR = R - Integer.parseInt(st.nextToken());
			run();
			turn ^= 1;
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				pw.write(cave[i][j]);
			}
			pw.println();
		}
		pw.close();
		br.close();
	}

	static void printMap() {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				pw.write(cave[i][j]);
			}
			pw.println();
		}
		pw.println("-------------");
		pw.flush();
	}

	static void run() {
		// 일단 제거하기
		visited = new int[R][C];
		int c = 0;
		switch (turn) {
		case 0:// 왼쪽
			for (c = 0; c < C; c++) {
				if (cave[curR][c] == 'x') {
					break;
				}
			}
			break;
		case 1:// 오른쪽
			for (c = C - 1; c >= 0; c--) {
				if (cave[curR][c] == 'x') {
					break;
				}
			}
		}
		cave[curR][c] = '.';
		visited[curR][c] = 1;
		for (int i = 0; i < 4; i++) {
			int newR = curR + dr[i];
			int newC = c + dc[i];
			if (rangeCheck(newR, newC) && cave[newR][newC] == 'x') {
				visited[newR][newC] = 1;
				if (!isNormalCluster(newR, newC)) {
					gravity();
				}
			}
		}
	}

	private static boolean isNormalCluster(int r, int c) {
		cluster.clear();
		visited = new int[R][C];
		visited[r][c] = 1;
		// BFS로 r이 0인 상황이 되면 true 리턴하기, 안되면 false 리턴하기
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { r, c });
		cluster.add(new int[] { r, c });
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			if (cur[0] == R - 1) {
				return true;
			}
			for (int i = 0; i < 4; i++) {
				int newR = cur[0] + dr[i];
				int newC = cur[1] + dc[i];
				if (rangeCheck(newR, newC) && visited[newR][newC] == 0) {
					visited[newR][newC] = 1;
					if (cave[newR][newC] == 'x') {
						que.offer(new int[] { newR, newC });
						cluster.add(new int[] { newR, newC });
					}
				}
			}
		}
		return false;
	}

	private static void gravity() {
		// 떠 있는 클러스터가 있음
		// 모양 유지하며 바닥이나 다른 클러스터 만날때까지 밑으로 내리기
		// col by col로 내리기
		// 왼쪽으로
		Collections.sort(cluster, new Comparator<int[]>()
		{
			@Override
			public int compare(int[] o1, int[] o2)
			{
				//Row로 내림차순, col로 오름차순
				if (o1[0] == o2[0])
				{
					return o1[1] - o2[1];
				}
				return o2[0] - o1[0];
			}
		}
		);
		boolean flag = downByOne();
		while (!flag)
		{
			flag = downByOne();
			printMap();
		}
	}
	
	private static boolean downByOne()
	{
		for (int[] p : cluster)
		{
			
		}
		return false;
	}

	private static boolean rangeCheck(int r, int c) {
		if (r >= 0 && r < R && c >= 0 && c < C) {
			return true;
		}
		return false;
	}

}
