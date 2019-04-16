package task2;

import common.MyException;

/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2019/02/02 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
class BlockStack
{
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE; // Changed to private
	
	/**
	 * Number of times the stack is accessed
	 */
	private int accessCounter = 0; // Changed to private
	
	/**
	 * Current top of the stack
	 */
	private int iTop  = 3; // Changed to private
	
	/**
	 * stack[0:5] with four defined values
	 */
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '*', '*'}; // Changed to private
	
	
	
	public char[] getAcStack() {
		return acStack;
	}
	
	public int getAccessCounter() {
		return accessCounter;
	}
	
	public int getISize() {
		return iSize;
	}
	
	public int getITop() {
		return iTop;
	}
	
	public boolean isEmpty()
	{
	return (this.iTop == -1);
	}

	/**
	 * Default constructor
	 */
	public BlockStack()
	{
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize)
	{
        		
				
				if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char)('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '*';

			this.iTop = piSize - 3;
                        this.iSize = piSize;
		}
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 * @throws MyException
	 */
	public char pick() throws MyException
	{
		accessCounter++;
		if(!isEmpty())
		{
			return this.acStack[this.iTop];	
		}
		else throw new MyException("Empty stack!!!");
		// Modified method to handle case when stack is empty
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 * @throws MyException
	 */
	public char getAt(final int piPosition) throws MyException
	{
		accessCounter++; 
		if (piPosition < iSize)
		{
			return this.acStack[piPosition];	
		}
		else throw new MyException("Invalid position!!!");
		// Modified method to handle case when accessing an index out of bounds
	}

	/**
	 * Standard push operation
	 * @throws MyException
	 */
	public void push(final char pcBlock) throws MyException
	{
		accessCounter++; 
		if(iTop < iSize)
		{
			if(isEmpty())
			{
				this.acStack[++this.iTop] = 'a';
				System.out.println("Pushed successfully!");
			}
			else
			{
				this.acStack[++this.iTop] = pcBlock;
				System.out.println("Pushed successfully!");
			}	
		}
		else throw new MyException("Full Stack!!!");
		// Modified method to handle case when stack is full
		
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 * @throws MyException
	 */
	public char pop() throws MyException
	{
		accessCounter++; 
		if(!isEmpty()){
			char cBlock = this.acStack[this.iTop];
			this.acStack[this.iTop--] = '*'; // Leave prev. value undefined
			System.out.println("Popped successfully!");
			return cBlock;
		}else throw new MyException ("Empty Stack!!!");
		// Modified method to handle case when stack is empty
	}
}

// EOF