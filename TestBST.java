
package testbst;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TestBST 
{
    public static void main(String[] args) 
    {
     BST T = new BST();
     T.insert(5);
     T.insert(3);
     T.insert(9);
     T.insert(1);
     T.insert(4);
     T.insert(6);
     System.out.println("The root of Bi-Tree is: " + (T.root()));
     System.out.println("In-order traversal sequence :");
     T.inOrder();
     System.out.println("Pre-order traversal sequence :");
     T.preOrder();
     System.out.println("Post-order traversal sequence :");
     T.postOrder();
     System.out.println("Level-order traversal sequence :");
     T.levelOrder();
     System.out.println("In-order traversal sequence (after mirroring) :");
     T.mirror();
     T.inOrder();
    }  
}

class BST 
{
// Root node pointer. Will be null for an empty tree.
private Node root;
/*
* --Node-- The binary tree is built using this nested node class. Each node
* stores one data element, and has left and right sub-tree pointer which may be
* null. The node is a "dumb" nested class -- we just use it for storage; it
* does not have any methods.
*/
public static class Node 
{
Node left;
Node right;
int data;
Node(int newData) {
left = null;
right = null;
data = newData;
}
}
public void BST() {
root = null;
}
/**
* Inserts the given data into the binary tree. Uses a recursive helper.
*/
public void insert(int data) {
root = insert(root, data);
}
/**
* Recursive insert -- given a node pointer, recur down and insert the given
* data into the tree. Returns the new node pointer (the standard way to
* communicate a changed pointer back to the caller).
*/
private Node insert(Node node, int data) {
if (node == null) {
node = new Node(data);
} else {
if (data <= node.data) {
node.left = insert(node.left, data);
} else {
node.right = insert(node.right, data);
}
}
return (node); // in any case, return the new pointer to the caller
}
/**
* Returns the number of nodes in the tree. Uses a recursive helper that recurs
* down the tree and counts the nodes.
*/
public int size() {
return (size(root));
}

private int size(Node node) 
{
if (node == null)
return 0;
else return(size(node.left) + 1 + size(node.right));
}
/**
* Returns true if the given target is in the binary tree. Uses a recursive
* helper.
*/
public boolean lookup(int data) {
return (lookup(root, data));
}
/**
* Recursive lookup -- given a node, recur down searching for the given data.
*/
private boolean lookup(Node node, int data) {
if (node == null) {
return (false);
}
if (data == node.data) {
return (true);
} else if (data < node.data) {
return (lookup(node.left, data));
} else {
return (lookup(node.right, data));
}
}
/**
* Prints the node values in the "inorder" order. Uses a recursive helper to do
* the traversal.
*/
public void inOrder() {
inorderTree(root);
System.out.println();
}
private void inorderTree(Node node) {
if (node == null) {
return;
}
// left, node itself, right
inorderTree(node.left);
System.out.print(node.data + " ");
inorderTree(node.right);
}
/**
* Prints the node values in the "preOrder" order. Uses a recursive helper to do
* the traversal.
*/
public void preOrder() {
preOrder(root);
System.out.println();
}
public void preOrder(Node node) {
if (node == null) 
return;
System.out.print(node.data + " "); 
preOrder(node.left);
preOrder(node.right);
}
/**
* Prints the node values in the "postOrder" order. Uses a recursive helper to
* do the traversal.
*/
public void postOrder() {
postOrder(root);
System.out.println();
}
public void postOrder(Node node) {
if (node == null)
return;
postOrder(node.left);
postOrder ( node. right ); 
System.out.print(node.data + " ");
}   
public void levelOrder() {
levelOrder(root);
System.out.println();
}
public void levelOrder(Node node) {
if (node != null) {
Queue<Node> q = new ArrayDeque<Node>();
q.add(node);
while (q.size() != 0) {
Node currentNode = q.remove();
System.out.print(currentNode.data + " ");
if (currentNode.left != null) {
q.add(currentNode.left);
}
if (currentNode.right != null) {
q.add(currentNode.right);
}
}
}
}
/**
* Changes the tree into its mirror image. Uses a recursive helper that recurs
* over the tree, swapping the left/right pointers.
*/
public void mirror() {
root = mirror(root); 
}
private Node mirror(Node node) {
if (node == null)
return node;
/* do the subtrees */
Node left = mirror(node.left); 
Node right = mirror(node.right);
/* swap the left and right pointers */
node.left = right; 
node.right = left;
return node; 
}
public int root() {
// TODO Auto-generated method stub
return root.data;
}
public void deleteNode(int key) 
{
deleteNode(root, key); 
}
public Node deleteNode(Node n, int key) 
{
if (n == null)
return n; 
if (key < n.data)
n.left = deleteNode(n.left, key);
else if (key > n.data)
n.right = deleteNode(n.right, key);
else 
{ 
    if (n.left == null)
    return n.right;   
    else if (n.right == null) 
     return n.left;
n.data = minimum(n.right);
n.right = deleteNode(n.right, n.data);
}
return n;
}

private int minimum(Node node) { 
    if (node.left == null)
    return node.data; 
    return minimum(node.left);
}

private int findMax(Node node) {
    if (node.right == null)
    return node.data;
    return findMax(node.right);
}

public void insertByLevel(int i) {
    if (root == null) {
    root = new Node(i);
    }
    else 
    insertByLevel(root,i);
}

private void insertByLevel(Node temp, int key)
{
Queue<Node> q = new LinkedList<Node>();
q. add( temp);

while (!q.isEmpty()) 
{
temp = q.peek();
q.remove();   
if (temp.left == null) { 
    temp.left = new Node(key);
break;
}
else 
    q.add(temp.left);
if (temp.right == null) { 
    temp.right = new Node(key);
    break;
}
else 
    q.add(temp.right);
}
}
}