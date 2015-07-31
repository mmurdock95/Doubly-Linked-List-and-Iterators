/**
 * BasicListIterator file for Project 5
 * Interface for BasicLinkedList file.
 *
 * @author Michael Murdock
 * @version Project 2
 * @version CPE102-11
 * @version Spring 2015
 */

import java.util.*;
import java.lang.*;

public interface BasicList<E> extends java.lang.Iterable<E> 
{
	public void add(E element);
	public void add(int index, E element);

	public BasicListIterator<E> basicListIterator();

	public void clear();
	public boolean contains (E element);
	public E get(int index);
	public int indexOf(E element);
	public java.util.Iterator<E> iterator();
	public E remove(int index);
	public E set(int index, E element);
	public int size();
}