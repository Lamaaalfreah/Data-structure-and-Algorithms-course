
package Linkedlist;
public class LinkedList
{
    static Node head;
    
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
 
        System.out.println("The Linked list is: ");
        list.printList(head);
        
        head = list.reverse(head);
        System.out.println("");
        
        System.out.println("The reverse of the linked list is: ");
        list.printList(head);
    }//end of main.
    
    static class Node 
    {
        int data;
        Node next;
 
        Node(int d)
        {
            data = d;
            next = null;
        }
    }//end of Node.
 
    //Reverse the linked list
    Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) 
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }//end of reverse.
 
    // prints the linked list
    void printList(Node node)
    {
        while (node != null) 
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }//end of printList.   
}//end of LinkedList. 
 