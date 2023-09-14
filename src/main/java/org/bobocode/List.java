package org.bobocode;

public interface List<T> {

  void add(T element);

  void remove(T element);

  boolean isEmpty();

  void clear();

  void set(int index, T element);

  T getFirst();

  T getLast();

  int getSize();

  boolean contains(T element);
}
