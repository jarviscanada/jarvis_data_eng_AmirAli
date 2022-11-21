package ca.jrvs.practice.dataStructure.list;
import java.util.ArrayList;
public class ArrayJLists<E> implements JList<E> {
  /**
   * Default initial capacity
   */
  private static final int DEFAULT_CAPACITY = 10;



  @Override
  public boolean add(E e) {
    return false;
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public E get(int index) {
    return null;
  }

  @Override
  public E remove(int index) {
    return null;
  }

  @Override
  public void clear() {

  }
}
