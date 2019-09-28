/*
 * Issue: loses some numbers when moving from the bitmap to the output file
 * 	probably due to limited memory
 */
package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import bitmap.IntegerBitmap;

public class BitmapSorter {
	public static final int N = 10000000;	//	10 million
	public static final int K = 1000000;	//	1 million
	
	public static void sort(String source, String destination) {
		File in = new File(source);
		File out = new File(destination);
		
		IntegerBitmap bm = new IntegerBitmap(N);
		
		try (Scanner scan = new Scanner(in)) {
			while (scan.hasNextInt()) {
				bm.add(scan.nextInt());
			}
			
			PrintWriter pw = new PrintWriter(out);
			Iterator<Integer> it = bm.iterator();
			while (it.hasNext()) {
				pw.println(it.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void generateTrivialSource() {
		try (PrintWriter pw = new PrintWriter("trivial.txt")) {
			for (int i = K - 1; i >= 0; --i) {
				pw.println(i);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	
	public static void main(String[] args) {
		generateTrivialSource();
		sort("trivial.txt", "trivial_result.txt");
	}

}
