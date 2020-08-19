package com.ssafy.HW.hw_12.server;

public class ChatServerMain {
	public static void main(String args[]) {
		ChatServer cs = new ChatServer();
		cs.setPort(5200);
		cs.service();
	}

}
