import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;


/**
 * The PointSource class either reads an array of 2d points from a file, 
 * or generates a set of points randomly.  
 * 
 * @author Allegra Allgeier
 */
public class InputReader
{
	String filename;
	
	InputReader(String filename)
	{
		this.filename = filename;
	}
	
	
     /** readPoints reads a file containing a set of two dimensional points.
     * It should discard any whitespace characters and non-numeric values.
     * 
     *  @param fileName    location of the file containing the points
     *  @returns points    An array of points
     */
    public  ArrayList<int[]> readData() {
	
    // the number of items in the problem set
	int[] n = new int[1];
	// the total weight limit
	int[] W = new int[1];
	// arraylist of three numbers: i - the item number, pi - the profit for item i, and wi - the weight of item i.
    ArrayList<int[]> data = new ArrayList<int[]>();  
   
	Scanner s = null;
        try 
        {
            s = new Scanner(new BufferedReader(new FileReader(this.filename)));
            s.useLocale(Locale.US);
		    
            int[] three_nums;
            int count;
            while (s.hasNext()) 
	        {
			
				if (s.hasNextInt()) 
				{
				    n[0] = s.nextInt();
				 // add n to array
				    data.add(n);
				}
				
				if (s.hasNextInt()) 
				{
				    W[0] = s.nextInt();
				 // add n to array
				    data.add(W);
				}
			
			    while (s.hasNext()) 
			    {
			    	three_nums = new int[3];
			    	count = 0; 
			    	for (int i = 0; i < 3; i++)
			    	{
			    		if (s.hasNextInt()) 
						{
							three_nums[i] = s.nextInt();
							//System.out.println(three_nums[i]);
							count ++;
						}		
			    	}
			    	
			    	if (count != 3)
			    	{
			    		return null;
			    	}
			    	
			    	else
			    	{
			    		data.add(three_nums);
			    	}
			    	    	
			    } 
	        }
        }
        
        catch (IOException e) 
        {
            System.out.println("Unable to open " + this.filename+": "+e.getMessage());
        } 
        
        finally 
        {
            s.close();
        }   

	return data;
    }
    
}
