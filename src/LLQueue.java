import java.util.LinkedList;
import java.util.Iterator;
/**
 * 
 * @author Allegra Allgeier, Binny Lee, Jane Delmonico
 * This class implements the KQueue class and the Object class.
 * It is a queue with a linked-list structure.
 * 
 *  <br> <br>
 *  Created: <br>
 *     September 30th, Allegra Allgeier<br>
 *    
 */

public class LLQueue<T> implements KQueue<T> {
	private LinkedList<T> theQueue;


	/**
	 * Constructor
	 */
	public LLQueue() 	
	{
		theQueue = new LinkedList<T>();
		
	}


	@Override
	public boolean isEmpty() {
		if (theQueue.size() == 0)
		{
			return true;
			
		}
		else
		{
			return false;
			
		}
		
	}
	
	@Override
	public void enqueue(T e) 
	{
		theQueue.addLast(e);			
				
	}


	@Override
	public T dequeue() 
	{   // the remove() method in the LikedList class throws a 
		// NoSuchElementException if queue is empty
		return theQueue.remove();		
								
	}


	@Override
	public T peekFront() 
	{
		// the getFirst() method in the LikedList class throws a 
		// NoSuchElementException if queue is empty
		return theQueue.getFirst();
		
	}
	

	@Override
	public int size()
	{
		
		return theQueue.size();	
		
	}
	
	/**
	 * This method returns a string showing the current state of the queue.
	 * It is overriding the toString method in the Object class.
	 * Implementing the toString method in the Object class.
	 * 
	 * @return queue as a string
	 */
	@Override
	public String toString()
	{	 
		 if ( theQueue.isEmpty() )
		 {
			 return "[]";
		 }
		 
		 else
		 {
			 String queue = "[";
			 Iterator<T>  itr = theQueue.iterator();
			 while (itr.hasNext())
			 {
				 Object element = itr.next();
				 queue = queue + element.toString()+",";				 
				 
			 }
			 return queue.substring(0, queue.length()-1) + "]";
			 
		 }
		
	}
	
	/**
	 * Returns the element at specified index
	 * @return element at specified index
	 */
	public T get(int index)
	{
		return theQueue.get(index);
		
	}
	

	


}
