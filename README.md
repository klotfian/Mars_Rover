# Mars Rover
A simple two-dimensional coordinate grid that shows where a Mars Rover will end up after getting Instructions

# Code Explanation
The code design is seperated into two java classes. The Main class which will start the simulation and the Rover class which will create the and run the Rover object.

The main class will take in a text file through the use of the console and parse each line. Afterwards, the main class will create Rover objects based on the instructions in the text file. Each Rover object will be put into a list of Rover ojbects and will have the run method invoked on each one. It is the Rover object that will do their own work within their run method and output to the console once they are finished executing their assigned instructions. 
