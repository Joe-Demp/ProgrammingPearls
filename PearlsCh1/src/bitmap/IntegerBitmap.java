/**
 * 
 */
package bitmap;

/**
 * @author demps
 *
 */
public class IntegerBitmap implements Bitmap {
	private byte [] map;
	private int capacity;
	private int size;
	
	public static final int DEFAULT_CAP = 1000000;	//1 million
	public static final int MASK = 128;	//represents the binary number 1000 0000
	
	public IntegerBitmap() {
		this(DEFAULT_CAP);
	}
	
	public IntegerBitmap(int initialCap) {
		// Calculate size of array map
		capacity = initialCap;
		int arraySize = (int) Math.ceil(capacity / 8);
		map = new byte[arraySize];
		// Default values all set to 0, so the bitmap is initially empty
		
		size = 0;
	}
	
	@Override
	public boolean add(int n) throws IllegalArgumentException {
		if (n < 0 || n >= capacity)
			throw new IllegalArgumentException("Argument " + n + " is outside the range for the bitmap");
		
		//establish the return value: contains(n)
		boolean value = !contains(n);
		
		//find index in map,
		int index = n / 8;
		
		//get appropriate mask
		int radix = index % 8;
		byte mask = getMask(radix);
		
		// OR the mask with the value in the map
		map[index] = (byte) (map[index] | mask);
		
		return value;
	}
	
	@Override
	public boolean remove(int n) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(int n) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}
	/**
	 * Returns an integer with all bits set to zero, except the bit specified by radix<br>
	 * e.g. radix := 0 sets the leftmost bit to 1, radix := 7 sets the rightmost bit to 1
	 * 
	 * @param radix the bit in the integer you would like set, moving from left to right 
	 * @return the appropriate 
	 */
	public static byte getMask(int radix) throws IllegalArgumentException {
		if (radix < 0 || radix > 7)
			throw new IllegalArgumentException("radix " + radix + " out of bounds for an integer");
		
		return (byte) (MASK >>> radix);	//unsigned right shift operator
	}
}
