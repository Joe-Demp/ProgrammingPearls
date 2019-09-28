package bitmap;

public interface Bitmap {
	/**
	 * 
	 * @param n
	 * @return
	 */
	boolean add(int n);
	/**
	 * 
	 * @param n the positive integer you would like to add to the map
	 * @return true if the value was not in the map and has now been added, false otherwise
	 */
	boolean remove(int n);
	/**
	 * 
	 * @param n
	 * @return
	 */
	boolean contains(int n);
	/**
	 * 
	 * @return
	 */
	boolean isEmpty();
	/**
	 * 
	 * @return
	 */
	int size();
}
