/*
 * Andrew Ferruzza
 * STUDENT ID : 111616974
 * HW 5 : Bash Shell
 * 
 * Exception Class : FULL DIRECTORY
 * Function - creates FullDirectoryException using inheritance from the parent class Exception
 */
public class FullDirectoryException extends Exception {
	public FullDirectoryException() { super(); }
	public FullDirectoryException(String message) { super(message); }
	static final long serialVersionUID = 1492534861;
}
