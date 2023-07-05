
package unionandintersection;
import java.util.*;
public class UnionAndIntersection
{
    public static void main(String args[])
    {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        LinkedList unin = new LinkedList();
        LinkedList intersecn = new LinkedList();
  
        //First linked List is {6,1,3,5,20,7}: 
        list1.push(6);
        list1.push(1);
        list1.push(3);
        list1.push(20);
        list1.push(7);
  
        //Second linked List is {2,6,8,3,5}:
        list2.push(2);
        list2.push(6);
        list2.push(8);
        list2.push(3);
        list2.push(5);

        System.out.println("First List is");
        list1.printList();
  
        System.out.println("Second List is");
        list2.printList();
        
        intersecn.getIntersection(list1.head, list2.head);
        System.out.println("Intersection List is");
        intersecn.printList();
        
        unin.getUnion(list1.head, list2.head);
        System.out.println("Union List is");
        unin.printList();
    }//end of main.
}    
class LinkedList 
{
    Node head;
  
    class Node 
    {
        int data;
        Node next;
        Node(int valu)
        {
            data = valu;
            next = null;
        }//end of Node.
    }//end of Node.
  
    void getUnion(Node head1, Node head2)
    {
        Node cur1 = head1, cur2 = head2;
  
        // insert all elements of list1 in the result
        while (cur1 != null) 
        {
            push(cur1.data);
            cur1 = cur1.next;
        }
        
        // insert those elements of list2 that are not present
        while (cur2 != null) 
        {
            if (!isPresent(head1, cur2.data))
                push(cur2.data);
            cur2 = cur2.next;
        }
    }//end of getUnion.
  
    void getIntersection(Node head1, Node head2)
    {
        Node result = null;
        Node cur1 = head1;
        while (cur1 != null) 
        {
            if (isPresent(head2, cur1.data))
                push(cur1.data);
            cur1 = cur1.next;
        }
    }//end of getIntersection.
  
 
    void printList()
    {
        Node temp = head;
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }//end of printList.
  
    
    void push(int newData)
    {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }//end of push.
  

    boolean isPresent(Node head, int data)
    {
        Node cur1 = head;
        while (cur1 != null) {
            if (cur1.data == data)
                return true;
            cur1 = cur1.next;
        }
        return false;
    }//end of isPresent.
    
}//end of LinkedList.