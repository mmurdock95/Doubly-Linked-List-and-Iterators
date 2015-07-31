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
import java.lang.Iterable;

public interface BasicListIterator<E> extends java.util.Iterator<E>
{
	public boolean hasPrevious();
	public E previous();

}