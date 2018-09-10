/**
 * 
 */
package io.github.asiftasleem.linkedList;

/**
 * @author mtasleem
 *
 */
public class Solution {

	/**
	 * @param args
	 */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
         
        System.out.println("Given Linked list");
        list.printList();
        
        list.reverse();
        
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList();
    }

}

class Node {
	 
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class LinkedList {
	 
    Node head;
 
    /* Function to reverse the linked list */
    void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
 
    // prints content of double linked list
    void printList() {
    	Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 

}
