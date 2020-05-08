import java.util.*;
public class BashTerminal {
	
	/*
	 * Main Method
	 * This method will handle all user I/O
	 * Note: I did not do the Extra Credit portion of this assignment. Just the base requirements
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String user = "[111616974@Foo]: $ ";
		DirectoryTree tree = new DirectoryTree();
		boolean flag = true;
		
		System.out.println("Bash terminal opened.");
		
		//bash terminal I/O starts here
		while (flag = true) {
			System.out.print(user);
			String key = input.nextLine();
			String keyNoSpaces = "";
		
		//removing spaces from user input to help with putting it into a switch statement
		char tempKey[] = key.toCharArray();
		for (int i = 0; i< tempKey.length; i++) {
			if (!(tempKey[i] == ' ')) {
				keyNoSpaces += tempKey[i];
			}
		}
		
		//switch statement for most of the commands
		switch (keyNoSpaces) 
		{
			case "pwd" :
				System.out.println(tree.presentWorkingDirectory());
				break;
			case "exit" :
				System.out.println("Program terminated.");
				System.exit(0);
				break;
			case "ls-R" :
			case "ls-r" :
				tree.printDirectoryTree();
				break;
			case "ls" : 
				System.out.println(tree.listDirectory());
				break;
			case "cd/" : 
				tree.resetCursor();
				break;
		}
		//handling the "cd" command here
		if (keyNoSpaces.length() > 2)
			if (keyNoSpaces.substring(0, 2).equals("cd") && (!(keyNoSpaces.substring(2).equals("/")))) {
				try 
				{
					tree.changeDirectory(keyNoSpaces.substring(2));
				} catch (NotADirectoryException e) {
					System.out.println("That is not a directory.");
				}
			}
		//handling the "mkdir" and "touch" commands here
		if (keyNoSpaces.length() > 5) {
			if (keyNoSpaces.substring(0, 5).equals("mkdir")) {
				tree.makeDirectory(keyNoSpaces.substring(5));
			}
			else if (keyNoSpaces.substring(0, 5).equals("touch")) {
				try 
				{
					tree.makeFile(key.substring(6));
				} catch (FullDirectoryException  | IllegalArgumentException e) {
					System.out.println("Invalid argument");
				}
			}
		}
			
		} //end while loop here
		input.close();
	}
}
