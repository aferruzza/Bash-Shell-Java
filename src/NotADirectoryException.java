/*
 * Andrew Ferruzza
 * STUDENT ID : 111616974
 * HW 5 : Bash Shell
 * 
 * Exception Class : NOT A DIRECTORY
 * Function - creates NotADirectoryException using inheritance from the parent class Exception
 */
public class NotADirectoryException extends Exception {
	public NotADirectoryException() { super(); }
	public NotADirectoryException(String message) { super(message); }
	static final long serialVersionUID = 412015914;
}
