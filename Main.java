package graded2;

public class Main {
	
	
	node node;
	node prev = null;
	node newHead = null;
	void processBST(node root)
	{
	if(root == null)return;
	//loop till left leaf
	processBST(root.left);
	node rightNode = root.right;
	node leftNode = root.left;
	//update new head to hold new root
	if(newHead == null)
	{
	newHead = root;
	root.left = null;
	prev = root;
	}
	else
	{
	//update the right of predecessor and also the predecessor to accomodate next node
	prev.right = root;
	root.left = null;
	prev = root;
	}
	processBST(rightNode);
	}
	void traverse(node root)
	{
	//traverse till leaf
	if(root == null)return;
	System.out.print(root.val + " ");
	traverse(root.right);
	}
	public static void main(String[] args) {
	//given code to test
	Main tree = new Main();
	tree.node = new node(50);
	tree.node.left = new node(30);
	tree.node.right = new node(60);
	tree.node.left.left = new node(10);
	tree.node.right.left= new node(55);
	//utility method to transform bst to skewed tree
	tree.processBST(tree.node);
	//utility method to print the transformed data
	tree.traverse(tree.newHead);
	}
	}

