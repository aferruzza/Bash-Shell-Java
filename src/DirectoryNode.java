public class DirectoryNode {
	
	private String name = "";
	private DirectoryNode left;
	private DirectoryNode middle;
	private DirectoryNode right;
	private DirectoryNode parent;
	private boolean isFile;
	
	/**
	 * @return the parent
	 */
	public DirectoryNode getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(DirectoryNode parent) {
		this.parent = parent;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the isFile
	 */
	public boolean isFile() {
		return isFile;
	}
	/**
	 * @param isFile the isFile to set
	 */
	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the left
	 */
	public DirectoryNode getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(DirectoryNode left) {
		this.left = left;
	}
	/**
	 * @return the middle
	 */
	public DirectoryNode getMiddle() {
		return middle;
	}
	/**
	 * @param middle the middle to set
	 */
	public void setMiddle(DirectoryNode middle) {
		this.middle = middle;
	}
	/**
	 * @return the right
	 */
	public DirectoryNode getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(DirectoryNode right) {
		this.right = right;
	}
	
	/*
	 * addChild method
	 * Creates a child according to where there is empty space below the cursor's location.
	 * We start looking at the left, then to the middle, then to the right.
	 * If it's all full, the FullDirectoryException gets thrown.
	 * If the child is a file, it is not considered a directory and will not be added. An exception is thrown
	 */
	public void addChild(DirectoryNode newChild) throws FullDirectoryException, NotADirectoryException {
		if (getLeft() == null) {
			setLeft(newChild);
		}
		else if (getMiddle() == null) {
			setMiddle(newChild);
		}
		else if (getRight() == null) {
			setRight(newChild);
		}
		else {
			throw new FullDirectoryException("Directory is full!");
		}
		if (newChild.isFile) {
			throw new NotADirectoryException("This is not a directory.");
		}
			
	}
	/*
	 * addFile method
	 * A helper method I made to add a file. Same thing as the above method, except we can add files (obviously).
	 * We still check if the directory is full, however.
	 */
	public void addFile(DirectoryNode newChild) throws FullDirectoryException {
		if (getLeft() == null) {
			setLeft(newChild);
		}
		else if (getMiddle() == null) {
			setMiddle(newChild);
		}
		else if (getRight() == null) {
			setRight(newChild);
		}
		else {
			throw new FullDirectoryException("Directory is full!");
		}
	}
}
