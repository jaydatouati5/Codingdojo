public class DLL {
    public Node head;
    public Node tail;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
    // the push method will add a new node to the end of the list
    public void push(int val) {
    	Node newNode = new Node(val);
        // if there is no head in the list, aka, an empty list, we set the newNode to be the head and tail of the list
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        
        // first find the lastNode in the list
        // then, set the lastNode's next to be the newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we found previously.
        // finally, set the list's tail to be the node that we have added
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }
    
    public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;
        
        // while the current node exists...
        while(current != null) {
            // print its value
            System.out.println(current.value);
            // and move on to its next node.
            current = current.next;
        }
    }
    
    public void printValuesBackward() {
    	Node current = this.tail;
    	while(current != null) {
    		System.out.printf("%d -> ", current.value);
    		current = current.previous;
    	}
    }
    
    public Node pop() {
    	Node lastNode = this.tail.previous;
    	Node ret = this.tail;
    	lastNode.next = null;
    	this.tail = lastNode;
    	return ret;
    }
    
    public boolean contains(Integer value) {
    	Node current = this.head;
    	while(current != null) {
    		if (current.value == value) {
    			return true;
    		}
    		current = current.next;
    	}
    	return false;
    }
    
    public int size() {
    	Node current = this.head;
    	int count = 0;
    	while(current != null) {
    		count++;
    		current = current.next;
    	}
    	return count;
    }
    
    public void insertAt(int val, int index) {
    	Node newNode = new Node(val);
    	Node current = this.head;
    	while(current != null) {
    		if(index == 0) {
    			System.out.println(current.value);
    			Node last = current.previous;
    			last.next = newNode;
    			newNode.previous = last;
    			newNode.next = current;
    			current.previous = newNode;
    			return;
    		}
    		current = current.next;
    		index--;
    	}
    }
    
    public void removeAt(int index) {
    	Node current = this.head;
    	while(current != null) {
    		if (index == 0) {
    			Node last = current.previous;
    			last.next = current.next;
    			current.next.previous = last;
    		}
    		current = current.next;
    		index--;
    	}
    }
    
    public boolean isPalindrome() {
    	int size = this.size() / 2;
    	Node right = this.tail;
    	Node left = this.head;
    	while(size != 0) {
    		if(right.value != left.value) {
    			return false;
    		}
    		left = left.next;
    		right = right.previous;
    		size--;
    	}
    	return true;
    }
}