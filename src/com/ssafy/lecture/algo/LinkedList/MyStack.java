package com.ssafy.lecture.algo.LinkedList;

import java.util.LinkedList;

public class MyStack {

	LinkedList<String> list;
	
	public MyStack()
	{
		list = new LinkedList<String>();
	}
	
	public void push(String data)
	{
		//마지막 원소로 추가
		list.add(data);
	}
	
	public String pop()
	{
		return list.removeFirst();
	}
	
	public String peek()
	{
		return list.peek();
	}
	
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
}
