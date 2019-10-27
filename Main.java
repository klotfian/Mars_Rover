import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Kamran Lotfian
 * To run the code successfully, input the name of the text file along with its extension and potential file location i.e. "input.txt", into the console and
 * the output will show the result of the simulation.
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		int x_bounds, y_bounds, counter = 0;	
		ArrayList<String> Input_list = new ArrayList<String>();
		ArrayList<Rover> Rover_list = new ArrayList<Rover>(); 

		//input the name of the text which should be in the same directory as the source files
		Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        
        //Read in the text file
		File file = new File(input); 
		Scanner sc = new Scanner(file); 

		//Parse the String line by line
		while (sc.hasNextLine()) {
			String s = sc.nextLine().trim();
			if(!s.matches("")) {
				Input_list.add(s);
			}
		}

		//Assign the x and y bounds as requested by the user
		x_bounds = Character.getNumericValue(Input_list.get(0).toString().trim().charAt(0));
		y_bounds = Character.getNumericValue(Input_list.get(0).toString().trim().charAt(2));

		//Parse the inputed text file and create the Rover Objects
		for(int i = 1; i < Input_list.size(); i+=2) {

			//Create a new Rover object and add it into the Rover List
			Rover_list.add(new Rover(Character.getNumericValue(Input_list.get(i).toString().charAt(0)),
					Character.getNumericValue(Input_list.get(i).toString().charAt(2)),
					Input_list.get(i).toString().charAt(4)));

			//Add each Rover's respective instructions to its own Move List. 
			for(char c : Input_list.get(i+1).toCharArray()) {
				Rover_list.get(counter).put_moves(c);
			}
			counter++;
		}

		//Starts and runs all Rover threads
		for(Rover r : Rover_list) {
			r.run();
		}

		in.close();
		sc.close();
	}
}
