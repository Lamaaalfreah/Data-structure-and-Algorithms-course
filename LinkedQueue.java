
package queue;
import java.util.*;
public class LinkedQueue<E> implements Queue<E>
{
private SingleLinkedList<E> LinkedQueue = new SingleLinkedList<E>() ; 
private Node<E> front;
private Node<E> rare; 
private int size;

public void enqueue(E element) 
{
if (size == 0) 
{
LinkedQueue.insertLast(element);
front = rare = LinkedQueue.head; 
} else {
LinkedQueue.insertLast(element); 
rare = LinkedQueue.tail;
}
++size;
}
public E element()
{
if (size == 0) {
throw new java.util.EmptyStackException();
}
return front.data;
}

public boolean isEmpty() 
{
return (size == 0); 
}

public E dequeue() 
{
if (size == 0) 
{
throw new java.util.EmptyStackException();
}
E element = front.data; 
LinkedQueue.deleteFirst(); 
front = LinkedQueue.head; 
--size;
return element;
}

public int size() 
{
return size; 
}

public void printQueue() 
{ 
System.out.print("[");
String str = ""; 
if (!isEmpty()) 
{
Node<E> current = front;
for (int i = 0; i < size; i++) 
{
str += current.data + ",";
current = current.next;
}
}
if (str.length() != 0)
str = str.substring(0, str.length() - 1);
System.out.print(str + "]\n");
}
}

class Node <E>
{
    E data;
    Node next;
    Node(E val)
    {
        data = val;
        next = null;
    }
}// end of Node.


 class SingleLinkedList <E> 
 {
 private LinkedList LinkedList;
 private int size;
 Node head;
 Node tail;

 public SingleLinkedList() 
 {
 LinkedList = new LinkedList();
 }

 public int size()
 {
 return size;
 }
 
public void deleteFirst() 
{
if(head == null)
throw new IllegalArgumentException("item not found"); 
head = head.next;
}

public void insertLast(E obj) 
 { 
  Node Node = new Node(obj);
  Node cur = head;
  while(cur.next!= null)
          cur=cur.next;
  cur.next= Node;
  Node.next=null;
  tail=Node;  
}
static void displayQueue(LinkedQueue queue)
{ 
LinkedQueue tempQueue = new LinkedQueue(); 
if (queue.isEmpty()) {
System.out.println("Queue is empty!"); 
return;
}

while (!queue.isEmpty()) 
{
Object item = queue.dequeue(); 
System.out.print(item);
tempQueue. enqueue( item) ;
}
while (!tempQueue.isEmpty()) 
queue.enqueue(tempQueue.dequeue());
System.out.println(); 
}
}

