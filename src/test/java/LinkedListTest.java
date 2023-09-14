import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.bobocode.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

  public LinkedList<String> linkedList = new LinkedList<>();

  @Before
  public void initLinkedList() {
    linkedList = new LinkedList<>();
  }

  @Test
  public void testSizeIncreases() {
    linkedList.add("Hello");
    assertEquals(1, linkedList.getSize());
  }

  @Test
  public void testInitListSizeEqualsZeroAndHeadNull() {
    assertEquals(0, linkedList.getSize());
    assertThrows(NullPointerException.class, () -> linkedList.getFirst());
    assertThrows(NullPointerException.class, () -> linkedList.getLast());
  }


  @Test
  public void testHeadInitializedWhenAdd() {
    String expected = "Hi";
    linkedList.add(expected);
    assertNotNull(linkedList.getFirst());
    assertEquals(expected, linkedList.getFirst());
    assertEquals(expected, linkedList.getLast());
  }

  @Test
  public void testFirstAndLastElementWhenAddMultipleElements() {
    linkedList.add("Hi");
    linkedList.add("Hello");
    linkedList.add("Ola");

    assertEquals("Ola", linkedList.getLast());
    assertEquals("Hi", linkedList.getFirst());
  }

  @Test
  public void testThatListContainsElement() {
    linkedList.add("Hi");
    linkedList.add("Hello");
    linkedList.add("Ola");

    Assert.assertTrue(linkedList.contains("Hello"));
  }

  @Test
  public void testThatListContainsReturnsFalse() {
    linkedList.add("Hi");
    linkedList.add("Hello");
    linkedList.add("Ola");

    Assert.assertFalse(linkedList.contains("TheNewOne"));
  }

  @Test
  public void testIsEmptyReturnsTrue() {
    Assert.assertTrue(linkedList.isEmpty());
  }

  @Test
  public void testIsEmptyReturnsFalse() {
    linkedList.add("Bobocode");
    Assert.assertFalse(linkedList.isEmpty());
  }

  @Test
  public void testThatListIsCleared() {
    linkedList.add("First one");
    linkedList.add("First second one");

    linkedList.clear();

    Assert.assertEquals(0, linkedList.getSize());
  }

  @Test
  public void testGetByIndexReturnsElement() {
    linkedList.add("First");
    linkedList.add("Second");
    linkedList.add("Third");

    Assert.assertEquals("First", linkedList.get(0));
    Assert.assertEquals("Second", linkedList.get(1));
    Assert.assertEquals("Third", linkedList.get(2));
  }

  @Test
  public void testGetByIndexFromEmptyListThrowsIndexOutOfBoundsException() {
    Assert.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(2));
  }

  @Test
  public void testGetByInvalidIndexThrowsIndexOutOfBoundsException() {
    linkedList.add("First");
    linkedList.add("Second");
    linkedList.add("Third");

    Assert.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
    Assert.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(3));
  }

  @Test
  public void testThatElementSetByIndex() {
    linkedList.add("First");
    linkedList.add("Second");
    linkedList.add("Third");

    linkedList.set(1, "Fourth");

    Assert.assertEquals("Fourth", linkedList.get(1));
  }

  @Test
  public void testSetElementByIndexThrowIndexOutOfBoundsException() {
    linkedList.add("First");
    linkedList.add("Second");
    linkedList.add("Third");

    assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(-1, "Hi"));
    assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(3, "Random"));
  }

  @Test
  public void testRemoveHead() {
    linkedList.add("First");
    linkedList.add("Second");
    linkedList.add("Third");

    linkedList.remove("First");

    assertEquals("Second", linkedList.getFirst());
    assertFalse(linkedList.contains("First"));
  }

  // 1, 2, 3, 4
  @Test
  public void testRemoveTail() {
    linkedList.add("First");
    linkedList.add("Second");
    linkedList.add("Third");

    linkedList.remove("Third");

    assertEquals("Second", linkedList.getLast());
    assertFalse(linkedList.contains("Third"));
  }

  @Test
  public void testRemoveInTheMiddle() {
    linkedList.add("First");
    linkedList.add("Second");
    linkedList.add("Third");

    linkedList.remove("Second");
    assertFalse(linkedList.contains("Second"));
  }
}
