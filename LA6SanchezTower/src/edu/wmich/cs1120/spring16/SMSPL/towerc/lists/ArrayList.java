package edu.wmich.cs1120.spring16.SMSPL.towerc.lists;

public class ArrayList implements IList {
	
	private String[] Indexes;
	private int size = 0;
	
	@Override
	public void add(String e) {
		
		size++;
		if(isEmpty()){
			Indexes = new String[size];
		}
		else{
		String[] tempIndexes = new String[size];
		System.arraycopy(Indexes, 0, tempIndexes, 0, size-1);
		Indexes = tempIndexes;
		}
		Indexes[size-1] = e;
	}

	@Override
	public void add(int index, String e) throws IndexOutOfBoundsException {
	
		if(index < 0 || index > size-1){
			throw new IndexOutOfBoundsException();
			}
		else{
			size++;
			String[] tempIndexes = new String[size];
			System.arraycopy(Indexes, 0, tempIndexes, 0, index);
			System.arraycopy(Indexes, index, tempIndexes, index+1, size-(index+1));
			Indexes = tempIndexes;
			Indexes[index] = e;
			}
	}

	@Override
	public void clear() {
		
		Indexes = null;
		size = 0;
	}

	@Override
	public boolean contains(String s) {
		
		for(String contain: Indexes){
			if(contain.equals(s))
				return true;
		}
		return false;
	}

	@Override
	public String getHead() {
		
		if(isEmpty())
			return null;
		
		return Indexes[0];
	}

	@Override
	public String getTail() {
		
		if(isEmpty())
			return null;
					
		return Indexes[size-1];
		
	}

	@Override
	public String get(int index) throws IndexOutOfBoundsException {
					
		if(index < 0 || index > size-1){
			throw new IndexOutOfBoundsException();
			}
		else{
		return Indexes[index];
		}
	}

	@Override
	public int indexOf(String s) {
		
		for(int i = 0; i < size; i++){
			if(Indexes[i].equals(s))
				return i;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		
		if(Indexes == null)
			return true;
		else
			return false;
	}

	@Override
	public String remove(int index) throws IndexOutOfBoundsException {
		
		String remove = " ";
		
		if(index < 0 || index > size-1){
			throw new IndexOutOfBoundsException();
			} // END BRACKET for index out of bounds check
		else
		{
		remove = get(index);
		size --;
		String [] tempIndexes = new String[size];
		System.arraycopy(Indexes, 0, tempIndexes, 0, index);
		if(size != index)
		{
		System.arraycopy(Indexes, index+1, tempIndexes, index, size-(index+1));	
		} // END BRACKET for check skip this copy if first item
		
		Indexes = tempIndexes;
		return remove;
		}// END BRACKT FOR remove ELSE
		
 } // END BRACKET FOR remove method

	@Override
	public int size() {
		
		return size;
	}

}
