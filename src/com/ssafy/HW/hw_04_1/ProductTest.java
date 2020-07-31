package com.ssafy.HW.hw_04_1;

public class ProductTest {

	public static void main(String[] args) {
		TV led_TV = new TV(1, "SamsungTV_1", 99999.9f, 10, 12, "LED");
		TV smart_TV = new TV(2, "Samsung_SMART_TV", 299999.9f, 5, 12, "SMART");

		Refrigerator rf = new Refrigerator(1, "Samsung_double_door", 19999999.9f, 100, 20);
		
		System.out.println("LED TV 정보: " + led_TV);
		System.out.println("스마트 TV 정보: " + smart_TV);
		System.out.println("냉장고 정보: " + rf);
		
		System.out.println("LED TV의 재고는 " + led_TV.getQuantity() + "개 입니다.");
		
	}

}
