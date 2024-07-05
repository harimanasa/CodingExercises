public class ReverseLinkedList_KNodes {
    public static LinkedListNode reverseKGroups(LinkedListNode head, int k) {
    
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode ptr = dummy;
    
        while (ptr != null) {
    
            LinkedListNode tracker = ptr;
    
            for (int i = 0; i < k; i++) {
                if (tracker == null) {
                    break;
                }
                tracker = tracker.next;
            }
    
            if (tracker == null) {
                break;
            }
    
            LinkedListNode[] updatedNodes = reverseLinkedList(ptr.next, k);
            LinkedListNode previous = updatedNodes[0];
            LinkedListNode current = updatedNodes[1];
    
            LinkedListNode lastNodeOfReversedGroup = ptr.next;
            lastNodeOfReversedGroup.next = current;
            ptr.next = previous;
            ptr = lastNodeOfReversedGroup;
    
        }
    
        return dummy.next;
    }

    static LinkedListNode[] reverseLinkedList(LinkedListNode node, int k){
		
		LinkedListNode previous = null;  
		LinkedListNode current = node;  
		LinkedListNode next = null;  

		for (int i = 0; i < k; i++) {
			next = current.next;  
			current.next = previous;  
			previous = current;  
			current = next;
		}

		return new LinkedListNode[]{previous, current}; 
	}
}
