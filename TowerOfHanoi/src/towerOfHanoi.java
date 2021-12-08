import java.util.Scanner;

/*
 * Author:      Zachary Florez
 * Class:       towerOfHanoi
 * Description: This class implements of a simulation of the game Tower 
 * 		of Hanoi. The View of the program asks a user for the
 * 		number of disks and then calls the function execute() 
 * 		to keep searching for the solution until all the disks
 * 		are placed correctly on another rod. 
 * 
 */

public class towerOfHanoi {

	public static void main(String[] args) {
		
		// New scanner
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome to Tower of Hanoi!");
		System.out.println("Would you like to play? (yes/no)");
		
		String answer = in.nextLine();
		
		// Now check to make sure user wants to play
		while (answer.startsWith("Y") || answer.startsWith("y")) {
			System.out.println();
			System.out.print("Enter number of disks you would like to play with: ");
			int disks = Integer.parseInt(in.next());
			execute(disks, 1, 2, 3);
			System.out.println();
			
			// Ask user if they want to continue playing.
			System.out.println("Would you like to play again? (yes/no)");
			answer = in.next();
		}
		
		// Close Scanner and end program
		in.close();
		System.out.println("Thanks for coming!");

	}
	
	/**
	 * This function executes the algorithm to complete and solve the tower 
	 * of hanoi problem. 
	 * 
	 * @param disks, number of disks to use, inputed from user initially
	 * @param rod1,  rod we will move a disk from.
	 * @param rod2,  rod we will move a disk to.
	 * @param rod3,  rod we don't use to move a disk for a current call. 
	 */
	public static void execute(int disks, int rod1, int rod2, int rod3) {
		
		// Base Case:
		if (disks == 1) {
			System.out.println("Moving disk #" + disks + " from rod #" + rod1 + " to rod #" + rod2);
			return;
		}
		
		// First Recursive Call to move disks from rod 1 to rod 3
		System.out.println("Making  first  recursive call");
		execute(disks - 1, rod1, rod3, rod2);
		
		System.out.println("Moving disk #" + disks + " from rod #" + rod1 + " to rod #" + rod2);
		
		// Second Recursive Call to move disks from rod 3 to rod 2
		System.out.println("Making  second  recursive call");
		execute(disks - 1, rod3, rod2, rod1);
	}
}



