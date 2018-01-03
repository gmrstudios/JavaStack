package edu.wmich.cs1120.spring16.SMSPL.towerc.stacks;

import edu.wmich.cs1120.spring16.SMSPL.towerc.lists.ArrayList;

public class Stack implements IStack {
	
	private ArrayList stackString = new ArrayList();
	private int size = 0;

	@Override
	public void push(String s) {
		
		
		stackString.add(s);
		size++;
		
	}

	@Override
	public void pop() {
		
		stackString.remove(size-1);
		
		size--;
	}

	@Override
	public String peek() {
		
		return stackString.get(size-1);
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}

}
