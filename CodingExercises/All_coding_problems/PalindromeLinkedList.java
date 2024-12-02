
//  * Definition for singly-linked list.
// O(N) TC, O(1) SC

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
       
        ListNode slow = head;
        ListNode fast = head;
        

        // 1. Find mid point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 2. Reverse second half of the list
        ListNode revertData = reverseLinkedList(slow);

        // 3. Compare the two halves
        boolean check = compareTwoHalves(head, revertData);

        // 4. Revert back the reversal of second half
        reverseLinkedList(revertData);
        
        if (check) {
            return true;
        }

        return false;

    }

    public static boolean compareTwoHalves(ListNode firstHalf, ListNode secondHalf) {
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            } else {
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }


        }
        return true;
    }

    public static ListNode reverseLinkedList(ListNode slowPtr){
		ListNode prev = null;
		ListNode next = null;    
		ListNode curr = slowPtr;  
		
		while (curr != null)   
		{  
		next = curr.next;  
		curr.next = prev;  
		prev = curr;  
		curr = next;  
		}    
		return prev;  
	}
}

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}