
package stackqueue;
import java.util.Stack; 
public class StackQueue 
{
public static void main(String[] args) 
{ 
StackQueue q = new StackQueue();
q. enQueue( 1) ;
q. enQueue( 2) ;
q. enQueue( 3) ;
System.out.println(q.deQueue()); 
System.out.println(q.deQueue()); 
System.out.println(q.deQueue());
}

Stack<Integer> s1 = new Stack<Integer>(); 
Stack<Integer> s2 = new Stack<Integer>();
void enQueue(int x) 
{
// Move all elements from s1 to s2 
while (!s1.isEmpty()) 
{
s2.push(s1.pop()); 
}
// Push item into s1
s1.push(x);
// Push everything back to s1
while (!s2.isEmpty()) { 
s1.push(s2.pop());
} 
}

int deQueue() 
{
if (s1.isEmpty()) 
{
System.out.println("Q is Empty");
System.exit ( 0) ; 
}
int x = s1.peek(); 
s1.pop();
return x;
}
}


