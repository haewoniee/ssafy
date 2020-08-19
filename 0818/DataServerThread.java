package com.ssafy.HW.hw_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class DataServerThread extends Thread {

	Socket s;
	BufferedReader br;
	PrintWriter pw;
	
	public DataServerThread(Socket s) {
		this.s = s;
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(System.out));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			String msg="";
			while((msg=br.readLine())!=null) {
				pw.println(msg);
			}
		} catch (IOException e) {
			System.out.println(e);
		}finally {
			if(pw!=null) {
				pw.close();
			}
			if(s!=null) {
				try {
					s.close();
				} catch (IOException e) {
					
				}
			}
		}
	}

}
