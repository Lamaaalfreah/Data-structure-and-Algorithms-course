
package sizeofdoublylinkedlist;

public class SizeOfDoublyLinkedList 
{
    public static void main(String args[])
    {
        Node head = null;
        head = push(head, 1);
        head = push(head, 2);
        head = push(head, 3);
        head = push(head, 4);
        printlist(head);
        System.out.println("The size of the Doubly Linked List is: " + findSize(head));
    }// end of main.
    
    //add a node from the head 
    static Node push(Node head, int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;
        
        if (head != null)
            head.prev = newNode;
        head = newNode;
            
        return head;
    }// end of push.
 
    //returns size of doubly linked list
    static int findSize(Node node)
    {
        int cur = 0;
        while (node != null)
        {
                cur++;
                node = node.next;
        }
        return cur;
    }// end of findSize.
    
    static void printlist(Node node) 
    {
    System.out.println("The Doubly Linked List is: ");
    while (node != null) 
    {
    System.out.print(node.data + " ");
    node = node.next;
    }
    System.out.println();
    }// end of printlist.
}// end of SizeOfDoublyLinkedList.

class Node
{
    int data;
    Node next, prev;
    Node(int val)
    {
        data = val;
        next = null;
        prev = null;
    }
}// end of Node.