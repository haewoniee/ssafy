package com.ssafy.book_prob;

public class NodeTest1 {
	
	public static class Points {
		int r;
		int c;
		public Points(int r, int c)
		{
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "Points [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	public static void main(String[] args)
	{
		Points [] ps = new Points[5];
		ps[0] = new Points(1,2);
		ps[1] = new Points(-4,2);
		ps[2] = new Points(-1,2);
		ps[3] = new Points(1,3);
		ps[4] = new Points(2,3);
		
		
		System.out.println(Integer.parseInt("111",10));
	}

}
