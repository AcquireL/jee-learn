package com.briup.test;

import org.junit.Test;

public class Test01 {
	
	public static void main(String[] args) {
		
		System.out.println("test ...");
		
		System.out.println("*********");
		
		Test01 t = new Test01();
		t.test();
		
	}
	
	//单元测试 1.导入jar包  2.添加@Test
	@Test
	public void test() {
		System.out.println("in test ...");
	}
	
	
}








