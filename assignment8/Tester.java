package assignment08;

import static org.junit.Assert.*;
import org.junit.Test;

public class Tester {
  @Test
  public void nodeTest() {
    Node a = new Node(1);
    Node b = new Node(1);
    Node c = new Node(3);

    assertTrue(a.compareTo(b) == 0);
    assertTrue(a.compareTo(c) < 0);
    assertTrue(c.compareTo(b) > 0);
  }
  
  @Test
  public void treeTest() {
    BinarySearchTree tree = new BinarySearchTree();
    assertEquals("", tree.toString());

    tree.insert(new Node(10));
    assertEquals("10", tree.toString());

    tree.insert(new Node(5));
    assertEquals("5 10", tree.toString());

    tree.insert(new Node(20));
    assertEquals("5 10 20", tree.toString());

    tree.insert(new Node(10));
    assertEquals("5 10 10 20", tree.toString());
  }
  
  @Test
  public void nodebTest() {
    BinarySearchTree tree = new BinarySearchTree();

    tree.insert(new NodeB(10));
    assertEquals("b10", tree.toString());

    tree.insert(new NodeB(5));
    assertEquals("b5 b10", tree.toString());

    tree.insert(new NodeB(20));
    assertEquals("b5 b10 b20", tree.toString());

    tree.insert(new NodeB(10));
    assertEquals("b5 b10 b10 b20", tree.toString());
  }

  @Test
  public void mixedTest() {
    BinarySearchTree tree = new BinarySearchTree();

    tree.insert(new NodeB(10));
    assertEquals("b10", tree.toString());

    tree.insert(new NodeB(5));
    assertEquals("b5 b10", tree.toString());

    tree.insert(new NodeB(20));
    assertEquals("b5 b10 b20", tree.toString());

    tree.insert(new Node(10));
    assertEquals("b5 b10 10 b20", tree.toString());

    tree.insert(new Node(10));
    assertEquals("b5 b10 10 10 b20", tree.toString());

    tree.insert(new Node(20));
    assertEquals("b5 b10 10 10 b20 20", tree.toString());
  }
  
  @Test
  public void nodeTest2(){
	  Node a = new Node(1);
	  NodeB b = new NodeB(1);
	  Node c = new Node(3);
	  NodeB d = new NodeB(4);
	  Node e = new Node(5);

	    assertTrue(a.compareTo(b) == -1);
	    assertTrue(a.compareTo(c) < 0);
	    assertTrue(c.compareTo(b) > 0); 
	    assertTrue(b.compareTo(d) < 0);
	    assertTrue(d.compareTo(a) > 0);
	    assertTrue(d.compareTo(e) < 0);
	    assertTrue(e.compareTo(b) > 0);
	    
  }
}

