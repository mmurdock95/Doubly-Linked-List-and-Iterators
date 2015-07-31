/**
 * BasicLinkedList file for Project 5
 * Creates methods for the list files, to be able to make linked lists.
 * Creates your own iterator.
 *
 * @author Michael Murdock
 * @version Project 2
 * @version CPE102-11
 * @version Spring 2015
 */

import java.util.*;
import java.lang.*;

public class BasicLinkedList<E> implements BasicList<E>
{
	private Node<E> first;
	private Node<E> last;
	private int size;

	public BasicLinkedList()
	{
	}

	private class Node<E>
	{
		public E element;
		public Node<E> next;
		public Node<E> previous;
		
		public Node(E element, Node<E> next, Node<E> previous)
		{
			this.element=element;
			this.next=next;
			this.previous=previous;
		}
	}

	private class TempIterator<E> implements BasicListIterator<E>
	{
		private Node<E> data;
		private Node<E> previous;

		public TempIterator(Node<E> data)
		{
			this.data=data;
		}

		public boolean hasNext()
		{
			if (data==null)
				return false;
			return true;
		}

		public E next()
		{
			if (hasNext()==false)
				throw new NoSuchElementException();
			E tempData = data.element;
			previous = data;
			data = data.next;
			return tempData;
		}

		public boolean hasPrevious()
		{
			if (previous==null)
				return false;
			return true;
		}

		public E previous()
		{
			if (hasPrevious()==false)
				throw new NoSuchElementException();
			E tempData = previous.element;
			data = previous;
			previous = previous.previous;
			return tempData;
		}

		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}

	public void add(E element)
	{
		if (last==null)
		{
			Node<E> n = new Node<E>(element, null, null);
			first= n;
			last = n;
		}
		else 
		{
			Node<E> n = new Node<E>(element, null, last);
			last.next = n;
			last = n;
		}
		size++;
	}

	public void add(int index, E element)
	{
		if (size==0)
			add(element);
		if(index>=size)
			throw new IndexOutOfBoundsException();
		if(index<0)
			throw new IndexOutOfBoundsException();

		Node<E> n=first;
		for(int i=0; i<index; i++)
		{
			n=n.next;
		}
		Node<E> n2=new Node<E>(element, n, n.previous);
		if (n.previous != null)
			n.previous.next = n2;
		else
			first = n2;
		n.previous=n2;
		size++;
		
	}

	public BasicListIterator<E> basicListIterator()
	{
		TempIterator<E> newIterator = new TempIterator<E>(first);
		return newIterator;
	}

	public void clear()
	{
		first=null;
		last=null;
		size=0;
	}

	public boolean contains(E element)
	{
		Node<E> n=first;
		int i=0;

		while(i<size)
		{
			if (element==null && n.element==null || n.element.equals(element))
				return true;
			n=n.next;
			i++;
		}
		return false;
	}

	public E get(int index)
	{
		if(index>=size)
			throw new IndexOutOfBoundsException();
		if (index<0)
			throw new IndexOutOfBoundsException();
		Node<E> n = first;
		for(int i=0; i<index; i++)
		{
			n = n.next;
		}
		return n.element;
	}

	public int indexOf(E element)
	{
		Node<E> n = first;
		if (n==null)
			throw new NoSuchElementException();
		int i = 0;
		while(n != null)
		{
			if(element==null && n.element==null || n.element.equals(element))
				return i;
			n=n.next;
			i++;
		}
		throw new NoSuchElementException();
	}

	public java.util.Iterator<E> iterator()
	{
		TempIterator<E> newIterator = new TempIterator<E>(first);
		return newIterator;
	}

	public E remove(int index)
	{
		if(index>=size)
			throw new IndexOutOfBoundsException();
		if (index<0)
			throw new IndexOutOfBoundsException();

		Node<E> n = first;
		for (int i=0; i<index; i++)
		{
			n=n.next;
		}
		if(n.previous!=null)
			n.previous.next=n.next;
		else
			first=n.next;
		if (n.next!=null)
			n.next.previous=n.previous;
		else
			last=n.previous;
		size--;
		return n.element;
	}

	public E set(int index, E element)
	{
		if(index>=size)
			throw new IndexOutOfBoundsException();
		if (index<0)
			throw new IndexOutOfBoundsException();
		Node<E> n = first;
		for (int i=0; i<index; i++)
		{
			n=n.next;
		}
		E oldN = n.element;
		n.element= element;
		return oldN;

	}

	public int size()
	{
		return size;
	}
}