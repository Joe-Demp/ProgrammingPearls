package bitmaptests;

import bitmap.IntegerBitmap;

public class BitmapDriver {
	private static final int[] TEST_INTS = {765, 100200, 999999, 567322, 7}; 
	
	public static void main(String[] args) {
		IntegerBitmap bm = new IntegerBitmap();
		
		//Testing iterator
		for (Integer k : TEST_INTS) {
			bm.add(k);
		}
		
		for (Integer m : bm) {
			System.out.println(m);
		}
	}

}
