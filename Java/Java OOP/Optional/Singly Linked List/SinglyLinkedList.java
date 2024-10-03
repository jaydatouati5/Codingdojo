public class SinglyLinkedList {
    public Node head;
    
    public SinglyLinkedList() {
        this.head = null;
    }
    
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }   
    
    public void remove() {
    	if (this.head != null) {
    		if (this.head.next == null) {
    			this.head = null;
    		}else {
    			Node current = this.head.next;
    			Node previous = this.head;
    			while(current.next != null) {
    				current = current.next;
    				previous = previous.next;
    			}
    			previous.next = null;
    		}
    	}
    }
    
    public void printValues() {
    	if (this.head == null) {
    		System.out.println("null");
    	}else {
    		Node current = this.head;
    		while(current != null) {
    			System.out.printf("%d -> " , current.value);
    			current = current.next;
    		}
    		System.out.print("null\n");
    	}
    }
    
    public Node find(int value) {
    	if (this.head == null) {
    		return null;
    	}
    	Node current = this.head;
    	while(current != null) {
    		if (current.value == value) {
    			return current;
    		}
    		current = current.next;
    	}
    	return null;
    }
    
    public void removeAt(int index) {
    	if (this.head != null) {
    		if (index == 0) {
    			this.head = this.head.next;
    		}else {
    			index--;
    			Node current = this.head.next;
    			Node previous = this.head;
    			while(index != 0 && current != null) {
    				current = current.next;
    				previous = previous.next;
    				index--;
    			}
    			previous.next = current.next;
    		}
    	}
    }
}
