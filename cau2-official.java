import java.io.*;
   
// Java program to implement
// a Singly Linked List
public class LinkedList {
   
    Node head; // head of list
    Node tail;
   
    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    static class Node {
   
        int code;
        String name;
        String inhabitant;
        String food;
        Node next;
       
   
        // Constructor
        Node(int c,String na,String inhab,String fo )
        {
            code =c;
            name =na;
            inhabitant =inhab;
            food=fo;
           
            next = null;
        }
    }
   
    // Method to insert a new node
    public static LinkedList insertHead(LinkedList list, int c,String na,String inhab,String fo)
    {
        // Create a new node with given data
        Node new_node = new Node(c,na,inhab,fo);
         
   
        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {  
            //Node temp will point to head  
            Node temp = list.head;  
            //newNode will become new head of the list  
            list.head = new_node;  
            //Node temp(previous head) will be added after new head  
            list.head.next = temp;  
        }  
       
   
        // Return the list by head
        return list;
    }
     public void deleteFromStart() {  
  
        //Checks if the list is empty  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        else {  
            //Checks whether the list contains only one node  
            //If not, the head will point to next node in the list and tail will point to the new head.  
            if(head != tail) {  
                head = head.next;  
            }  
            //If the list contains only one node  
            //then, it will remove it and both head and tail will point to null  
            else {  
                head = tail = null;  
            }  
        }  
    }  
   
    // Method to print the LinkedList.
    public static void printList(LinkedList list)
    {
        Node currNode = list.head;
    
        System.out.print("LinkedList: ");
    
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.code + " "+currNode.name+" "+currNode.inhabitant +" "+currNode.food+" ");
    
            // Go to next node
            currNode = currNode.next;
        }
    }
    public static void reverseLinkedList(LinkedList list) {
		Node previous = null;
		Node current = list.head;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		list.head = previous;
	}
    
    public boolean search(Node head, int code) 
    { 
        Node current = head;    //Initialize current 
        while (current != null) 
        { 
            if (current.code == code) 
                return true;    //data found 
            current = current.next; 
        } 
        return false;    //data not found 
    } 
    // Driver code
    public static void main(String[] args)
    {
        /* Start with the empty list. */
        LinkedList list = new LinkedList();
   
        //
        // ******INSERTION******
        //
   
        // Insert the values
        list = insertHead(list,1,"nam","phan","oke");
        list = insertHead(list,2,"phuc","la","ok");
      //  list.deleteFromStart();
       
        // Print the LinkedList
        printList(list);
      // list.reverseLinkedList(list);
    //   System.out.print(" "+"reverse LinkedList: ");
     //  printList(list);
     System.out.println(list.search(list.head,1));
    }
}