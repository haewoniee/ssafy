package com.ssafy.HW.hw_11;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServer {
	int port = 8080;

	public void setPort(int port) {
		this.port = port;
	}

	ServerSocket serverSocket;

	public void service() {
		System.out.println("start Server service...");
		try {
			System.out.println("접속 준비중");
			serverSocket = new ServerSocket(port);
			// ServerSocket port 바로 다시사용
			serverSocket.setReuseAddress(true);
		} catch (IOException e) {
			System.out.println("서비스 준비중에 IOException 발생.");
		}
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				String ip = socket.getInetAddress().toString();
				System.out.println(socket.getInetAddress() + "가 붙었습니다.");
				System.out.println(ip + ".");

				Thread t = new Thread(new DataServerThread(socket));
				t.start();
			} catch (IOException e) {
				System.out.println("IOException이 발생했습니다.");
			}
		}
	}
	public static void main(String[] args) {
		DataServer server = new DataServer();
		server.service();
	}

}
