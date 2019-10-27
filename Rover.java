import java.util.ArrayList;

public class Rover implements Runnable {
	private ArrayList<Character> Move_list; 
	private int x, y;
	private char z;


	//initialize the Rover object
	public Rover(int x, int y, char z) {
		Move_list = new ArrayList<Character>();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	//adds a subsequent move in the Rover's list of moves
	public void put_moves(char c) {
		this.Move_list.add(c);
	}

	//returns the a list of all the moves given to that specific Rover
	public ArrayList<Character> get_moves() {
		return this.Move_list;
	}

	//execute the Rover's move that are assigned to it and print out the result when done.
	@Override
	public void run() {
		for(char c : Move_list) {
			if(c == 'M') {
				if(z == 'N')
					y += 1;
				if(z == 'W')
					x -= 1;
				if(z == 'S')
					y -= 1;
				if(z == 'E')
					x += 1;
			} else {
				change_dir(c);
			}
		}
		
		System.out.println(x + " " + y + " " + z);
	}

	//changes the Rover's heading direction based on the command
	public void change_dir(char c) {
		if(c == 'L') {
			switch(z) {
			case 'N': 
				z = 'W';
				break;
			case 'W':
				z = 'S';
				break;
			case 'S':
				z = 'E';
				break;
			case 'E':
				z = 'N';
				break;
			}
		} else if(c == 'R'){
			switch(z) {
			case 'N': 
				z = 'E';
				break;
			case 'E':
				z = 'S';
				break;
			case 'S':
				z = 'W';
				break;
			case 'W':
				z = 'N';
				break;
			}
		}
	}
}
