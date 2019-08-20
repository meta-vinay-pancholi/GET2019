/**
 * @author Vinay
 * Interface for dictionary 
 */
public interface Dictionary {
	public void addKeyValue(int key , String value , DictionaryImplementation.BSTNode root);
	public DictionaryImplementation.BSTNode deleteKeyValue(int key , DictionaryImplementation.BSTNode root);
	public boolean getKeyValue(int key, DictionaryImplementation.BSTNode root);
	public void sortInBetween(int key1 ,int key2, DictionaryImplementation.BSTNode root);
	void sortedList( DictionaryImplementation.BSTNode root);
}
