public class DictionaryImplementation implements Dictionary {
	/**
	 * @author Vinay
	 * Class for implementing binary search tree
	 */
	class BSTNode {
		int key;//holding key
		String value;//holding value corresponding to key
		BSTNode left, right;//holding address of left and right node

		/* Constructor */
		public BSTNode(int key, String value) {
			this.left = null;
			this.right = null;
			this.value = value;
			this.key = key;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public BSTNode getLeft() {
			return left;
		}

		public void setLeft(BSTNode left) {
			this.left = left;
		}

		public BSTNode getRight() {
			return right;
		}

		public void setRight(BSTNode right) {
			this.right = right;
		}

	}

	private BSTNode root; //root node of type class BSTNode

	public BSTNode getRoot() {//getter to get root value
		return root;
	}

	public void setRoot(BSTNode root) {///setter to set value of rot
		this.root = root;
	}

	/* Function to get value corresponding to given key
	 * 
	 */
	@Override
	public boolean getKeyValue(int key, BSTNode root) {
		// TODO Auto-generated method stub
		BSTNode temp = root;
		if (temp == null) {
			return false;
		}
		if (temp.key == key) {
			System.out.println("Value corresponding to particular queue  "+ temp.value);
			return true;

		} else if (key < temp.key) {
			getKeyValue(key, temp.left);
		} else if (key > temp.key) {
			getKeyValue(key, temp.right);
		}
		return false;

	}

	/* 
	 * Function printing values in between given key pair
	 */
	@Override
	public void sortInBetween(int key1, int key2, BSTNode root) {
		// TODO Auto-generated method stub
		BSTNode temp = root;
		if (temp == null) {
			return;
		} else {
			sortInBetween(key1, key2, temp.left);
			if (temp.key >= key1 && temp.key <= key2) {
				System.out.println(temp.key + " " + temp.value);
			}
			sortInBetween(key1, key2, temp.right);
		}

	}

	/**
	 * @param key
	 * Function to delete particular key from the tree
	 */
	public void deleteKey(int key) {
		this.root = deleteKeyValue(key, this.getRoot());
	}

	@Override
	public BSTNode deleteKeyValue(int key, BSTNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return root;
		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = deleteKeyValue(key, root.left);
		else if (key > root.key)
			root.right = deleteKeyValue(key, root.right);
		// if key is same as root's key, then This is the node
		// to be deleted
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			// node with two children: Get the inorder successor (smallest
			// in the right subtree)
			root.key = minValue(root.right);
			// Delete the inorder successor
			root.right = deleteKeyValue(root.key, root.right);
		}
		return root;
	}

	/**
	 * @param root
	 * @return minv
	 * This is a helper method to find minimum value in delete function
	 */
	int minValue(BSTNode root) {
		int minv = root.key;
		while (root.left != null) {
			minv = root.left.key;
			root = root.left;
		}
		return minv;
	}

	/* 
	 * this function is used to add key value pair in binary search tree
	 */
	@Override
	public void addKeyValue(int key, String value, BSTNode root) {
		// TODO Auto-generated method stub
		BSTNode temp = root;
		BSTNode newnode = new BSTNode(key, value);
		if (this.getRoot() == null) {
			this.setRoot(newnode);
		} else if (temp.key > key) {
			if (temp.left == null) {
				temp.left = newnode;
			} else {
				addKeyValue(key, value, temp.left);
			}

		} else if (temp.key < key) {
			if (temp.right == null) {
				temp.right = newnode;
			} else {
				addKeyValue(key, value, temp.right);
			}
		}
	}
	
	/* 
	 * This function is printing value in sorted form according to key
	 */
	@Override
	public void sortedList(BSTNode root) {
		// TODO Auto-generated method stub
		BSTNode temp = root;
		if (temp == null) {
			return;
		} else {
			sortedList(temp.left);	
			System.out.println(temp.key + " " + temp.value);
			sortedList(temp.right);
		}
	}
}
