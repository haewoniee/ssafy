package com.ssafy.lecture.java.network_simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class NetworkSimpleClient {

	public static void main(String[] args) {

		String host = "localhost";
		int port = 5100;
		
		try (Socket socket = new Socket(host, port))
		{
			InputStream input = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			
			String message = br.readLine();
			System.out.println(message);
		}
		catch (IOException e)
		{
			System.out.println("NetworkSimpleClient exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
