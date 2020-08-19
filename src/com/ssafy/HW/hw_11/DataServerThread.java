package com.ssafy.HW.hw_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class DataServerThread implements Runnable {

	Socket s;
	BufferedReader br;
	PrintWriter pw;
	
	public DataServerThread(Socket s) {
		this.s = s;
		System.out.println("Socket이 생성되었습니다.");
		System.out.println(s.getLocalAddress());
		System.out.println(s.getInetAddress());
		System.out.println("이 붙음!!");
		try
		{
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try
		{
			pw.println("----------상품재고정보----------");
			String msg;
			while ((msg = br.readLine()) != null)
			{
				pw.println(msg);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (pw != null)
			{
				pw.close();
			}
			if (s != null)
			{
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
