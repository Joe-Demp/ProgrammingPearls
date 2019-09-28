package bitmaptests;

public class BitwiseTest {

	public static void main(String[] args) {
		int k = -60;
		
		System.out.println("-60 >> 1  = " + (k >> 1));
		System.out.println("-60 >>> 1  = " + (k >>> 1));
		
		int i = k >> 1;
		int j = k >>> 1;
		System.out.println("i ^ j = " + Integer.toBinaryString(i ^ j));
	}

}
