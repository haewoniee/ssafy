package com.ssafy.lecture.java.network_simple;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkSimpleServer {

	public static void main(String[] args) {
		int port = 5100;
		try (ServerSocket serverSocket = new ServerSocket(port))
		{
			System.out.println("NetworkSimpleServer Started");
			
			while (true)
			{
				Socket socket = serverSocket.accept(); //누군가 접속할때까지 기다림
				OutputStream output = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(output, true);
				pw.println("Hello SSAFY!");
			}
			
		}
		catch (IOException e)
		{
			System.out.println("NetworkSimpleSErver exception: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("NetworkSimpleServer Ended");

	}

}
