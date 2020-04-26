
package tree.anupom.assignment5.p1;

/**
 * @author Anupom Roy
 *
 */
public interface Queue<E> {
	int size();
	boolean isEmpty();
	void enqueue(E e);
	E first();
	E dequeue();

}
