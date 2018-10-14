package fifo_replacement_algorithm;

import java.util.LinkedList;

public class FIFO_Replacement_Algorithm {

	int page_Hit = 0;
	int free_FramesNumber;
	String[] reference_StringArray;
	
	
	
	
	LinkedList<String> list_ReferenceContainer = new LinkedList<String>();
	
	//Constructor Initialization
	public FIFO_Replacement_Algorithm( int a, String[] b )
	{
		free_FramesNumber = a;
		reference_StringArray = b;
		
	}
	
	
	
	
	
	
	
	public void FIFO_Output_Calculation()
	{
		
		boolean status_OutputContainer = true;
		String[] OutputContainer = new String[free_FramesNumber];
		
//		System.out.println("\nInside Output Calc.");
		
		//Initializing list_ReferenceContainer with input reference strings;
		for(int i = 0; i < reference_StringArray.length; i++ )
		{
			
			list_ReferenceContainer.addLast( reference_StringArray[i] );
//			OutputContainer[i] = reference_StringArray[i];
//			System.out.println(list_ReferenceContainer);
		}
		
//		System.out.println("reference_StringArray: " + reference_StringArray.length);
		System.out.println();
		System.out.println("Outputs for FIFO page replacement algorithm:");
		System.out.println("--------------------------------------------\n");
		
		for( int i = 0; i < free_FramesNumber; i++ )
		{
			OutputContainer[i] = "";
			
			status_OutputContainer = OutputContainer[i].isEmpty();
		}
			
		
		while( list_ReferenceContainer.size()  != 0 )
		{
			
			
			for( int i = 0; i < free_FramesNumber; i++ )
			{
				for( int j = 0; j < free_FramesNumber; j++ )
				{
					status_OutputContainer = OutputContainer[j].isEmpty();
					
					if(status_OutputContainer == false)
						break;
				}
				
				if( status_OutputContainer == true )
				{
					OutputContainer[i] = list_ReferenceContainer.getFirst();
					list_ReferenceContainer.removeFirst();
					
//					System.out.print("OutputContainer[i]:: ");
					for( int j = 0; j < free_FramesNumber; j++ )
					{
						if( j < (free_FramesNumber-1) )
						{
							System.out.print( OutputContainer[j] + "--" );
						}
						else
						{
							System.out.print( OutputContainer[j] + "" );
						}
				
					}
					System.out.println();
					
//					Print_Output();
				}
				
				else
				{	
					int match = 0;
					int size = free_FramesNumber;
					String temp = list_ReferenceContainer.getFirst();
	
					for( int j = 0; j < free_FramesNumber; j++ )
					{
						if( OutputContainer[j].contains(temp) )
						{
							match = 999;
							++page_Hit;
							
							list_ReferenceContainer.removeFirst();
							Dispatcher(i, OutputContainer);
							
//							System.out.print("OutputContainer[i]:: ");
							for( int k = 0; k < free_FramesNumber; k++ )
							{
								if( k < (free_FramesNumber-1) )
								{
									System.out.print( OutputContainer[k] + "--" );
								}
								else
								{
									System.out.print( OutputContainer[k] + "" );
								}
								
							}
							System.out.println();
						}
					}
						
						
						
					if(match != 999)
					{
						OutputContainer[i] = list_ReferenceContainer.getFirst();
						list_ReferenceContainer.removeFirst();
						
//						System.out.print("OutputContainer[i]:: ");
						for( int k = 0; k < free_FramesNumber; k++ )
						{
							if( k < (free_FramesNumber-1) )
							{
								System.out.print( OutputContainer[k] + "--" );
							}
							else
							{
								System.out.print( OutputContainer[k] + "" );
							}
							
						}
						System.out.println();
//							Print_Output();
					}
					
					
				} //End of else() scope;
				
				if( list_ReferenceContainer.size() == 0 )
				{
					break;
				}
				
			} //End of for( int i = 0; i < free_FramesNumber; i++ );
			
			
			
			if( list_ReferenceContainer.size() == 0 )
			{
				break;
			}
			
		} //End while( list_ReferenceContainer.size()  != 0 );
		
		
		Double percent = ( ( (double) reference_StringArray.length - page_Hit) / reference_StringArray.length) * 100;
		System.out.println();
		System.out.println();
		System.out.println("Reference string length: " + reference_StringArray.length );
		System.out.println("Page hit: " + page_Hit);
		System.out.println("Page fault number = Total page number - Page hit number");
		System.out.println("Page fault number = " + (reference_StringArray.length - page_Hit) );
		System.out.println("Page fault rate = " + percent + "%" );
		System.out.println();

		
	} //End void FIFO_Output_Calculation() Method;
	
	
	
	
	void Dispatcher( int i, String[] OutputContainer)
	{
//		System.out.println("Inside Dispatcher");
		
		int size = OutputContainer.length;
		String temp = "";
		int flag = 0;

//		if( list_ReferenceContainer.size() != 0 )
//		{
//		System.out.println("list_ReferenceContainer.size(): " + list_ReferenceContainer.size());
			temp = list_ReferenceContainer.getFirst();
//		}
		
		
		
		for( int j = 0; j < free_FramesNumber; j++ )
		{
			if( OutputContainer[j].equals(temp) )
			{
				list_ReferenceContainer.removeFirst();
				
				++page_Hit;
				Dispatcher(i, OutputContainer);
//				System.out.println("Dispatcher: "+i+" Val: "+OutputContainer[j]);
				flag = 999;
				break;
			}
		}
			
		if( list_ReferenceContainer.size() == 0 )
		{
//			System.out.println("\nError occured.. System exiting.\tError code 401");
			System.exit(1);
		}
			
		if(flag != 999)
		{
			OutputContainer[i] = list_ReferenceContainer.getFirst();
//			System.out.println("Bottom-Dispatcher: "+i+" Under Outp. Container: "+OutputContainer[i]);
			list_ReferenceContainer.removeFirst();
		}
		
		
		
		
		
//				Print_Output(OutputContainer);
			
			
//		} //End of for( int j = 0; j < size; j++ );
		
	} //End of void Dispatcher( int i);
	
	
	
	
	//To Print Outputs for FIFO Algorithm
	void Print_Output(String[] OutputContainer)
	{
//		System.out.println("Inside Print Output");
		
		boolean status_OutputContainer = true;
		
		for( int i = 0; i < free_FramesNumber; i++ )
		{
			status_OutputContainer = OutputContainer[i].isEmpty();
			
			if(status_OutputContainer == false)
				break;
		}
		
		while( status_OutputContainer == false )
		{
			for( int i = 0; i < free_FramesNumber; i++ )
			{
				System.out.print( OutputContainer[i] );
				System.out.print("  ");
			}
			
			System.out.println();
			
			for( int i = 0; i < OutputContainer.length; i++ )
			{
				OutputContainer[i] = "";
			}
			
			for( int i = 0; i < free_FramesNumber; i++ )
			{
				status_OutputContainer = OutputContainer[i].isEmpty();
			}
			
			if( status_OutputContainer == true )
				break;
			
			
		}//End of while( list_OutputContainer.size() != 0 ) condition scope;
		
	} //End of void Print_Output() Method;
	
	
	
	
} //End public class FIFO_Replacement_Algorithm;
