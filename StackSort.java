package javalab;


//import java.io.*;

import java.util.*;


/**
 * StackSort is a program that will use two stacks to sort an array of integer values.
 */ 

public class StackSort {

   
 public static void main(String args[]) {


 int data[] = null;
       
 int result[] = null;

       
 Scanner input;
      
  input = new Scanner(System.in);
    
System.out.println("This program sorts an array of integer values.");


        // Create an empty array of integers
       
 data = createArray(0, 1, 1);
       
 System.out.println("Original array is: " + representationOfArray(data));
  
  result = doStackSort(data);
    
    System.out.println("Sorted array is: " + representationOfArray(result));
    
    System.out.println();

        // Create an array with one integer
       
 data = createArray(1, 0, 9);
      
  System.out.println("Original array is: " + representationOfArray(data));
   
     result = doStackSort(data);
    
    System.out.println("Sorted array is: " + representationOfArray(result));
      
  System.out.println();

        // Create an array with two integers
     
   data = createArray(2, 0, 9);
     
   System.out.println("Original array is: " + representationOfArray(data));
    
    result = doStackSort(data);
   
     System.out.println("Sorted array is: " + representationOfArray(result));
  
      System.out.println();

  
      // Create an array with 10 integers
    
    data = createArray(10, 0, 9999);
    
    System.out.println("Original array is: " + representationOfArray(data));
   
     result = doStackSort(data);
      
  System.out.println("Sorted array is: " + representationOfArray(result));
  
      System.out.println();

        // Create an array with 20 integers
     
   data = createArray(20, 0, 9);
     
   System.out.println("Original array is: " + representationOfArray(data));
    
    result = doStackSort(data);
     
   System.out.println("Sorted array is: " + representationOfArray(result));
   
     System.out.println();

    
    System.out.println("Please enter the number of values to sort");
    
    int size = getInt("   It should be an integer value greater than or equal to 1.");
        // Create an array of the given size

      
  data = createArray(size, 0, 99);
   
     System.out.println("Original array is: " + representationOfArray(data));
    
    result = doStackSort(data);
      
  System.out.println("Sorted array is: " + representationOfArray(result));
   
     System.out.println();


     input.close();
    }


    /**
     * Use two stacks to sort the data in an array
     *
     * @param data An array of integer values to be sorted.
     * @return     An array of sorted integers. 
     */
   
 private static int[] doStackSort(int data[]) {

 
   int result[] = new int[data.length];

        
    VectorStack<Integer> left=new VectorStack<Integer>(data.length);
    VectorStack<Integer> right=new VectorStack<Integer>(data.length);
    
    if(data.length>=2)
    {
    	left.push(data[0]<data[data.length-1]?data[0]:data[data.length-1]);
    	right.push(data[0]>data[data.length-1]?data[0]:data[data.length-1]);
    }
    else
    {
    	result=data;
    }
    
    int i=1;
    
    /**comparing values by peek() method
     * and shifting values between left and right stack
     * using push() and pop() methods and checking if stack is empty by isEmpty() method*/
    
    while(i<data.length-1&&data.length>=2)
    {
    	if(!left.isEmpty()&&!right.isEmpty()&&data[i]>left.peek()&&data[i]<right.peek())
    		left.push(data[i]);
    	
    	else if(!left.isEmpty()&&data[i]<left.peek())
    	{
    		while(!left.isEmpty()&&data[i]<left.peek())
    		{
    			right.push(left.pop());//shifting left stack values to right
    		}
    		left.push(data[i]);
    	}
    	else if(!right.isEmpty()&&data[i]>right.peek())
    	{
    		while(!right.isEmpty()&&data[i]>right.peek())
    		{
    			left.push(right.pop());//shifting right stack values to left
    		}
    		right.push(data[i]);
    	}
    	else
    		left.push(data[i]);
    	
    	i++;
    }
    while(!(left.isEmpty()))
    	right.push(left.pop());//pushing left to right stack now right stack stores sorted values
    i=0;
    while(!(right.isEmpty()))
    	result[i++]=right.pop();
    
   return result;

    }

 
   /**
     * Load an array with data values
     *
     * @param size The number of data values to generate and place in the array.
     * @param min The minimum value to generate.
     * @param max The maximum value to generate.
     * @return     An array of randomly generated integers. 
     */
  
  private static int[] createArray(int size, int min, int max) {

       
 Random generator = new Random();

        // If we get a negative size, just make the size 1
       
 if (size < 0) {
            size = 1;
        }
        // We need max > min for the random number generator to be happy

      
  if (max <= min) {
            max = min + 1;
        }

      
  int[] data = new int[size];

    
    for (int i = 0; i < size; i++) {
      
      data[i] = min + generator.nextInt(max - min);
        }

   
     return data;
    }

    /**
     * Create a string with the data values from an array
     *
     * @param data An array of integer values.
     * @return A string representation of the array.
     */
   
 private static String representationOfArray(int data[]) {
     
   String result = new String("< ");
        for (int i = 0; i < data.length; i++) {
            result += data[i] + " ";
        }
        result += ">";

        return result;
    }

    /**
     * Get an integer value
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt) {
        Scanner input;
        int result = 10;        //default value is 10
        try {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();

        } catch (NumberFormatException e) {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        } catch (Exception e) {
            System.out.println("There was an error with System.in");
            
System.out.println(e.getMessage());
      
      System.out.println("Will use 10 as the default value");
        }
     
   return result;

    }
    
}
