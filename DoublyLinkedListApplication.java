
package doublylinkedlistapplication;

public class DoublyLinkedListApplication 
{

public static void main(String[] args) 
{
/* Start with the empty list */
DoublyLinkedList dll = new DoublyLinkedList();
dll.insertLast("One");
dll.insertLast("Two");
dll.insertFirst("Three");
dll.insertFirst("Four");
dll.InsertAfter("Three","Five");
dll.insertFirst("Six");
dll.insertLast("Seven");
dll.printlist(dll.head);
String target = null;

System.out.println(dll.deleteNode(target)?target+" Found and deleted successfuly!":target+" Not Found!");
target = "Seven";
System.out.println(dll.deleteNode(target)?target+" Found and deleted successfuly!":target+" Not Found!");
target = "Nine";
System.out.println(dll.deleteNode(target)?target+" Found and deleted successfuly!":target+" Not Found!");
target = "One";
System.out.println(dll.deleteNode(target)?target+" Found and deleted successfuly!":target+" Not Found!");
dll.printlist(dll.head); 
}//end of main.
}//end of DoublyLinkedListApplication.

class DoublyLinkedList 
{
DNode head; // head of list

// Adding a node at the front of the list
public void insertFirst(String new_data) 
{
/*
* 1. allocate node 2. put in the data
*/
DNode new_Node = new DNode(new_data);
/* 3. Make next of new node as head and previous as NULL */
new_Node.next = head;
new_Node.prev = null;
/* 4. change prev of head node to new node */
if (head != null)
head.prev = new_Node;
/* 5. move the head to point to the new node */
head = new_Node;
}//end of insertFirst.

public void InsertAfter(String preValue, String newValue) 
{
//implement this part
DNode newNode = new DNode(newValue);    
DNode cur = head;
while(cur.next!= null && !cur.element.equals(preValue))
cur = cur.next;
if (cur.element.equals(preValue)) 
{
cur.next.prev = newNode; 
newNode.next = cur.next;
newNode.prev = cur; 
cur.next = newNode;    
}
}//end of InsertAfter.

// Add a node at the end of the list
void insertLast(String new_data) 
{
//implement this part
DNode newNode = new DNode(new_data);
DNode cur = head;
newNode.next=null;
if (head == null)
   {
   newNode.prev=null;
   head = newNode;
   return;
   }

while (cur.next != null) 
   cur = cur.next;
cur.next = newNode;
newNode.prev = cur;        
}//end of insertLast.

public void printlist(DNode node) 
{
DNode last = null;
System.out.println("Traversing the Doubly Linked List in forward Direction");
while (node != null) 
{
System.out.print(node.element + " ");
last = node;
node = node.next;
}
System.out.println();

System.out.println("Traversing the Doubly Linked List in reverse direction");
//implement this part
while (last != null)
{
System.out.print(last.element + " ");
last = last.prev;   
}
System.out.println();
}//end of printlist.

// delete a node in a Doubly Linked List.
boolean deleteNode(String target) 
{
// implement this part
if (head == null || target == null) 
    return false;

// If the node is a head node
if (head.element.equals(target))
{
    head = head.next;
    head.prev = null; 
    return true;
}

DNode cur = head;
while (cur.next != null && !cur.element.equals(target))
      cur = cur.next;

// If the node is a last node
if (cur.next == null && cur.element.equals(target)) 
{
cur.prev.next = cur.next;  
return true;
}

// If the node are not head and last node
if (cur.next != null && cur.element.equals(target))
{ 
   cur.next.prev = cur.prev;
   cur.prev.next = cur.next; 
   return true;
}

// If no node with this value
return false;     
}//end of deleteNode.
}//end of DoublyLinkedList.

/* DNode of a doubly linked list of strings */
class DNode {
protected String element; // String element stored by a node
protected DNode next, prev; // Pointers to next and previous nodes

/* Constructor that creates a node with given fields */
public DNode(String e) 
{
element = e;
prev = null;
next = null;
}//end of DNode.

/* Returns the element of this node */
public String getElement() 
{
return element;
}//end of getElement.

/* Returns the previous node of this node */
public DNode getPrev() 
{
return prev;
}//end of getPrev.

/* Returns the next node of this node */
public DNode getNext()
{
return next;
}//end of getNext.

/* Sets the element of this node */
public void setElement(String newElem) 
{
element = newElem;
}//end of setElement.

/* Sets the previous node of this node */
public void setPrev(DNode newPrev) 
{
prev = newPrev;
}//end of setPrev.

/* Sets the next node of this node */
public void setNext(DNode newNext) 
{
next = newNext;
}//end of setNext.
}//end of DNode.