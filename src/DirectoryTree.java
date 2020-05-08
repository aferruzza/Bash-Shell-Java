public class DirectoryTree {

	private DirectoryNode root;
	private DirectoryNode cursor;
	/*
	 * Constructor.
	 * Creates the tree, initializes root, root's name, and sets a cursor node equal to the root
	 */
	public DirectoryTree() {
		root = new DirectoryNode();
		root.setName("root");
		cursor = root;
	}
	/*
	 * resetCursor()
	 * simply brings the cursor back up to the root. Useful for printing the entire tree.
	 */
	public void resetCursor() {
		cursor = root;
	}
	/*
	 * presentWorkingDirectory()
	 * returns a String value of where the cursor is by "back-tracking" to the root and printing every node 
	 */
	public String presentWorkingDirectory() {
		DirectoryNode temp = new DirectoryNode();
		temp = cursor;
		String str = "";
		while (temp != null) {
			if (temp == root) {
				str = temp.getName() + str;
			}
			else {
				str = "/" + temp.getName() + str;
			}
			temp = temp.getParent(); 
		}
		return str;
	}
	/*
	 * makeDirectory(String name)
	 * Creates a directory, sets its name to whatever the user wants, and then also sets a parent to the cursor
	 * (because the cursor is above the location of the newNode)
	 * Also can't add if the child is not a directory or if the directory is full
	 */
	public void makeDirectory(String name) {
		DirectoryNode newNode = new DirectoryNode();
		try {
			cursor.addChild(newNode);
		} catch (FullDirectoryException | NotADirectoryException e) {}
		newNode.setName(name);
		newNode.setParent(cursor);
	}
	/*
	 * printDirectoryTree()
	 * Uses the helper method to print the directory tree, starting at the cursor
	 */
	public void printDirectoryTree() {
		DirectoryNode temp = new DirectoryNode();
		temp = cursor;
		printHelper(temp, "");
	}
	/*
	 * printHelper(DirectoryNode n, String spaces) 
	 * This is really the method that prints the tree. We see if n is a file or not (to print |- or -) and
	 * then we recursively keep calling the function for left right and middle of the node.
	 * Add spaces for every level down as per the sample I/O
	 */
	public void printHelper(DirectoryNode n, String spaces) {
		if (n.isFile()) {
			System.out.println(spaces + "-" + n.getName());
		} else if (!(n.isFile())) {
			System.out.println(spaces + "|-" + n.getName());
		}
		if (n.getLeft() != null) {
			printHelper(n.getLeft(), spaces + "   ");
		}
		if (n.getMiddle() != null) {
			printHelper(n.getMiddle(), spaces + "   ");
		}
		if (n.getRight() != null) {
			printHelper(n.getRight(), spaces + "   ");
		}
	}
	/*
	 * changeDirectory(String name)
	 * takes in the name of the directory the user wants to change to, then goes through the tree, starting at 
	 * cursor, and tries to find it and set cursor equal to it.
	 * If we can't find it or it is a file, we output this error.
	 */
	public void changeDirectory(String name) throws NotADirectoryException {
		if (cursor.getLeft() != null && cursor.getLeft().getName().equals(name)) {
			if ((cursor.getLeft().isFile())) {
				throw new NotADirectoryException("This is not a directory...");
			}
			else
				cursor = cursor.getLeft();
		}
		else if (cursor.getMiddle() != null && cursor.getMiddle().getName().equals(name)) {
			if ((cursor.getMiddle().isFile())) {
				throw new NotADirectoryException("This is not a directory...");
			}
			else
				cursor = cursor.getMiddle();
		}
		else if (cursor.getRight() != null && cursor.getRight().getName().equals(name)) {
			if ((cursor.getRight().isFile())) {
				throw new NotADirectoryException("This is not a directory.");
			}
			else
				cursor = cursor.getRight();
		}
		else {
			System.out.println("Can't find a directory with that name.");
		}
	}
	/*
	 * listDirectory()
	 * lists all the children of the current location of the cursor in a string separated by 1 space
	 */
	public String listDirectory() {
		DirectoryNode temp = new DirectoryNode();
		temp = cursor;
		String str = "";
		if (temp.getLeft() != null) {
			str += temp.getLeft().getName() + " ";
		}
		if (temp.getMiddle() != null) { 
			str += temp.getMiddle().getName() + " ";
		}
		if (temp.getRight() != null) {
			str += temp.getRight().getName() + " ";
		}
		return str;
	}
	/*
	 * makeFile(String name)
	 * makes a file with the indicated name entered by the user.
	 * we just make it a node, but set its isFile value to true, so the program knows it's not a directory
	 * if the name is illegal or the directory is full, we output this error
	 */
	public void makeFile(String name) throws IllegalArgumentException, FullDirectoryException {
		if (name.contains("/") || name.contains(" ")) {
			throw new IllegalArgumentException("ERROR : Not a valid name.");
		}
		DirectoryNode aFile = new DirectoryNode();
		aFile.setFile(true);
		aFile.setName(name);
		try {
			cursor.addFile(aFile);
		} catch (FullDirectoryException e) {
			System.out.println("ERROR : The directory is full.");
		}
	}
}
