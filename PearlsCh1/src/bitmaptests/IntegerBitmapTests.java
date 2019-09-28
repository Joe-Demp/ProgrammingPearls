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
	
	private static final int TEST_1 = 765; 

	@BeforeEach
	void setUp() throws Exception {
		bm = new IntegerBitmap();
	}

	@AfterEach
	void tearDown() throws Exception {
		bm = null;
	}

	@Test
	final void testEmpty() {
		assertTrue(bm.isEmpty());
	}
	@Test
	final void testNotEmpty() {
		bm.add(TEST_1);
		assertFalse(bm.isEmpty());
	}
	
	@Test
	final void testEmptySize() {
		assertEquals(0, bm.size());
	}
	@Test
	final void testNotEmptySize() {
		bm.add(1);
		bm.add(234);
		bm.add(TEST_1);
		
		assertEquals(3, bm.size());
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
	
	@Test
	final void testAdd() {
		assertFalse(bm.contains(TEST_1));
		
		assertTrue(bm.add(TEST_1));
		
		assertTrue(bm.contains(TEST_1));
	}
	
	@Test
	final void testAddMultiple() {
		assertFalse(bm.contains(TEST_1));
		
		assertTrue(bm.add(TEST_1));
		
		assertTrue(bm.contains(TEST_1));
		
		assertFalse(bm.add(TEST_1));
		
		assertTrue(bm.contains(TEST_1));
	}

	@Test
	final void testAddOutOfRange() {
		assertThrows(IllegalArgumentException.class, () -> {
			bm.add(-1);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			bm.add(1000000);
		});
	}
}
