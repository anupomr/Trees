/**
 * 
 */
package tree.anupom.assignment5.p1;

import java.util.Iterator;

/**
 * @author Anupom
 *
 */
public abstract class AbstractTree<E> implements Tree<E> {
	@Override
	public boolean isInternal(Position<E> p) {return numChildren(p)>0;}
	@Override
	public boolean isExternal(Position<E> p) {return numChildren(p)==0;}
	@Override
	public boolean isRoot(Position<E> p) {return p==root();}
	@Override
	public boolean isEmpty() {return size()==0;}
	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		int count=0;
		for(Position child: positions())count++;
		return count;
	}
	@Override
	public int size() {
		int count=0;
		for(Position p: positions())count++;
		return count;
	}
	public int depth(Position<E> p) throws IllegalArgumentException {
		if(isRoot(p))
			return 0;
		else
			return 1+ depth(parent(p));
	}
	private int heightBad() {
		int h=0;
		for(Position<E> p:positions())
			if(isExternal(p))
				h=Math.max(h, depth(p));
		return h;
	} 
	public int height(Position<E> p)throws IllegalArgumentException{
		int h=0;
		for(Position<E> c: children(p))
			h=Math.max(h, 1+height(c));
		return h;
	}
	private class ElementIterator implements Iterator<E>{

		Iterator<Position<E>> postIterator =positions().iterator();
		@Override
		public boolean hasNext() {			
			return postIterator.hasNext();
		}

		@Override
		public E next() {			
			return postIterator.next().getElement();
		}
		
	}

}
