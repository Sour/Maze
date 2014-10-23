package maze;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MazeSolver {

   static int borderwidth;
   static int cellsize;
   static int sleeptime;
   static int row;
   static int col;
   static int start_row;
   static int start_col;
   static int end_row;
   static int end_col;
   static File inputFile;
   static String mazefile = "";
   
   
   public static void main(String[] args) throws FileNotFoundException {
	   
	   if (handleArguments(args)) {
		 
		 
         String[][] maze = getMaze(mazefile);
         findStart(maze);
         findEnd(maze);
         DrawMaze.draw(row, col, maze);
         
         if (solveMaze(maze))
            System.out.println("Solved!");
         else
            System.out.println("Maze has no solution.");
	   }
   }
   static final String usage = "Usage: borderwidth, cellsize, sleeptime, filename.txt ";
   
   // Handle the input arguments
   static boolean handleArguments(String[] args) throws FileNotFoundException {
	   
	   if (args.length != 4) {
	         System.out.println("Wrong number of command line arguments.");
	         System.out.println(usage);
	         return false;
	      }
	      
	      // Get the minimum and maximum grid width from the first two
	      // command line arguments.
	      try {
	         borderwidth = Integer.parseInt(args[0]);
	         cellsize = Integer.parseInt(args[1]);
	         sleeptime = Integer.parseInt(args[2]);
	        
	      } catch (NumberFormatException ex) {
	         System.out.println("min_width and max_width must be integers.");
	         System.out.println(usage);
	         return false;
	      }
	      
	      inputFile = new File(args[3]);
	      if (!inputFile.canRead()) {
	         System.out.println("The file " + args[3] + " cannot be opened for input.");
	         return false;
	      }
	      
	      Scanner scanner = new Scanner(inputFile);
	      int[] arrayDimension = new int[2];
	      int i = 0;
	      while(scanner.hasNextInt()){
	    	  arrayDimension[i++] = scanner.nextInt();
	      }
	      
	      row = (2*arrayDimension[0]) + 1;
	      col = (2*arrayDimension[1]) + 1;
	      
	      
	      
	      String pattern = "[0-9]*";
	      scanner.skip(pattern);
	      
	      while(scanner.hasNextLine()){
	    	  scanner.skip(pattern);
	    	  mazefile += scanner.nextLine();
	    	    
	      }
	    	 
	      return true;
   }
	   
	   
   // Read the file describing the maze.
   public static String[][] getMaze(String mazefile) throws FileNotFoundException {
	   
	   
	   String[][] maze  = new String[row][col];
	   
	   int charCount = 0;
	   for(int r = 0; r < row; r++){
		   for(int c = 0; c < col; c++){
			   maze[r][c] = mazefile.substring(charCount, charCount+1);
			   charCount += 1;
		   }
	   }
	   
	   for(int r = 0; r < row; r++){
		   for(int c = 0; c < col; c++){   
			   if(maze[r][c].equals(" ") && r % 2 == 1 && c % 2 == 1){
				   maze[r][c] = "0"; 
			   }
		   } 
	   }
	   
	   return maze;
   }
   
   static void printMaze(String[][] maze){
	   
	   for(int r = 0; r < row; r++){
		   for(int c = 0; c < col; c++){   
			   System.out.print(maze[r][c]);
		   }
	       System.out.println();
	   }    
	   
   }
   
   static boolean findStart(String[][] maze){
	   
	   for(int r = 0; r < MazeSolver.row; r++){
		   for (int c = 0; c < MazeSolver.col; c++){
			   if(maze[r][c].equals("S")){
				   
				   MazeSolver.start_row = r;
				   MazeSolver.start_col = c;
				   return true;
			   }   
		   }
	   }
	   return false;
   }
	   
	   
   static boolean findEnd(String[][] maze){
		
	   for(int r = 0; r < MazeSolver.row; r++){
		   for (int c = 0; c < MazeSolver.col; c++){
			   if(maze[r][c].equals("E")){
				   
				   MazeSolver.end_row = r;
				   MazeSolver.end_col = c;
				   return true;
			   }
		   }
	   }
	   return false;
   }
		     
   static int convert(int num){
	   int count = 0;
	   for(int i = 1; i < num+1; i++){
		   
		   if(i % 2 == 1){
			   count++;
		   }
	   }
	   
	   num = num - count;
	   
	   return num;
   }
   
   // Solve the maze.   
   static boolean solveMaze(String[][] maze) {
	   
	   printMaze(maze);  
       return false;
       
   }
   
  
}
