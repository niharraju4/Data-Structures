package com.vogella.ide.counter.main;

public class Counter {

	public int count (int x) {
		int result = 0;
		if (x>0 && x<=255) {
			 for (int i = 0; i<=x; i++){
		         result = result +i;
		      }
		}else {
			RuntimeException e = new RuntimeException();
			throw e;
		}
		System.out.println(result);
		return result;
		
		// TODO Auto-generated method stub

	}

}
