package page_replacements_algorithms;

import java.util.Scanner;

import fifo_replacement_algorithm.FIFO_Replacement_Algorithm;

public class Page_Replacements_Algorithms {
	
	
	public static void main(String[] args)
	{
		int free_FramesNumber;
		String reference_String;
		String[] reference_StringArray;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter reference string (separating with space): ");
		reference_String = input.nextLine();
		
		System.out.print("Enter free frames number: ");
		free_FramesNumber = input.nextInt();
		
		System.out.println(free_FramesNumber);
		System.out.println(reference_String);
		
		reference_StringArray = reference_String.split(" ");

		
		FIFO_Replacement_Algorithm obj_FIFO = new FIFO_Replacement_Algorithm( free_FramesNumber, reference_StringArray );
		obj_FIFO.FIFO_Output_Calculation();
		
	} //End Main() Method;

} //End of class Page_Replacements_Algorithms;
