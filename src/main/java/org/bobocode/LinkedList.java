package org.bobocode;

import java.util.Objects;

public class LinkedList<T> {

  private int size = 0;
  private Node<T> head;
  private Node<T> tail;

  public void add(T element) {
    if (head == null) {
      head = new Node<>(element);
      tail = head;
    } else {
      tail.next = new Node<>(element);
      tail = tail.next;
    }
    size++;
  }

  public void remove(T element) {
    if (head.element.equals(element)) {
      if (size == 1) {
        clear();
      } else {
        head = head.next;
      }
    }
    Node<T> current = head;
    while (current.next != null) {
      if (current.next.element.equals(element)) {
        if (current.next.next != null) {
          current.next = current.next.next;
        } else {
          tail = current;
        }
      }
      current = current.next;
    }
  }

  public boolean isEmpty() {
    return size == 0;
  }


  public void clear() {
    head = tail = null;
    size = 0;
  }


  public void set(int index, T element) {
    Objects.requireNonNull(element);
    Node<T> nodeByIndex = findNodeByIndex(index);
    nodeByIndex.element = element;
  }

  private Node<T> findNodeByIndex(int index) {
    Objects.checkIndex(index, size);
    Node<T> current = head;
    for (int i = 1; i <= index; i++) {
      current = current.next;
    }
    return current;
  }

  public T get(int index) {
    return findNodeByIndex(index).element;
  }

  public T getFirst() {
    Objects.requireNonNull(head);
    return head.element;
  }


  public T getLast() {
    Objects.requireNonNull(tail);
    return tail.element;
  }

  public int getSize() {
    return size;
  }

  public boolean contains(T element) {
    Node<T> current = head;
    while (current.next != null) {
      if (current.element.equals(element)) {
        return true;
      }
      current = current.next;
    }

    return false;
  }

  private static class Node<R> {

    Node<R> next;
    private R element;

    public Node(R element) {
      this.element = element;
    }
  }
}