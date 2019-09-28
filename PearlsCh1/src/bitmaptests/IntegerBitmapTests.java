package bitmaptests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bitmap.IntegerBitmap;

class IntegerBitmapTests {
	private IntegerBitmap bm;
	
	byte a = -128;
	byte b = 64;
	byte c = 32;
	byte d = 16;
	byte e = 8;
	byte f = 4;
	byte g = 2;
	byte h = 1;

	@BeforeEach
	void setUp() throws Exception {
		bm = new IntegerBitmap();
	}

	@AfterEach
	void tearDown() throws Exception {
		bm = null;
	}

	@Test
	final void testGetMask() {
		assertEquals(a, IntegerBitmap.getMask(0));
		assertEquals(b, IntegerBitmap.getMask(1));
		assertEquals(c, IntegerBitmap.getMask(2));
		assertEquals(d, IntegerBitmap.getMask(3));
		assertEquals(e, IntegerBitmap.getMask(4));
		assertEquals(f, IntegerBitmap.getMask(5));
		assertEquals(g, IntegerBitmap.getMask(6));
		assertEquals(h, IntegerBitmap.getMask(7));
	}

}
