package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {

	static File inputFile;
	static int minGridWidth;
	static int maxGridWidth;
	
	public static void main(String[] args)throws FileNotFoundException {
		   if (handleArguments(args))
		      processInput();
		   }
		   
		   static final String usage = "Usage: GridWriter min_width max_width input_file_name";

		   /*
		    * Validate the command line arguments and do setup based on the
		    * arguments. Three command line arguments are expected:
		    *   1. A positive integer that sets minGridWidth
		    *   2. A positive integer that sets maxGridWidth
		    *   3. A String that names the input file.
		    *
		    * Return true if processing was successful and false otherwise.
		    */
		   static boolean handleArguments(String[] args) {
		      // Check for correct number of arguments
		      if (args.length != 3) {
		         System.out.println("Wrong number of command line arguments.");
		         System.out.println(usage);
		         return false;
		      }
		      
		      // Get the minimum and maximum grid width from the first two
		      // command line arguments.
		      try {
		         minGridWidth = Integer.parseInt(args[0]);
		         maxGridWidth = Integer.parseInt(args[1]);
		      } catch (NumberFormatException ex) {
		         System.out.println("min_width and max_width must be integers.");
		         System.out.println(usage);
		         return false;
		      }
		      
		      // Open the input file and get its length
		      inputFile = new File(args[2]);
		      if (!inputFile.canRead()) {
		         System.out.println("The file " + args[2] + " cannot be opened for input.");
		         return false;
		      }

		      return true;
		   }
		   
		   /*
		    * Get and process the input. For each width call loadUnloadGrid.
		    */
		   static void processInput() throws FileNotFoundException {
		      Scanner input = new Scanner(inputFile);
		      String line = input.nextLine();
		      
		      // Try each width in the appropriate range
		      for (int width = minGridWidth; width <= maxGridWidth; width++) {
		         // Determine height of grid
		         int height = line.length() / width;
		         
		         // Add one to height if there's a partial last row
		         if (line.length() % width != 0)
		            height += 1;
		            
		         
		      }
		   }
	}
	


