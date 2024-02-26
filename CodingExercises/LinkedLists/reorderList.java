/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null)
		    return;

        /* Logic 
        1. Find the middle element
        2. Reverse the second half
        3. Merge the two half lists
        */

        /* 1. Find the middle element */


		ListNode slow = head; 
		ListNode fast = head;

		while(fast!= null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}

        /* 2. Reverse the second list (from mid to end) */

        ListNode prev = null;
		ListNode curr = slow;
		ListNode next = null;

		while(curr != null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

        /* 3. Merge two lists */
        ListNode first = head;
		ListNode second = prev;
		ListNode temp = head;

        while(second.next != null)
		{
			temp = temp.next;
			first.next = second;
			second = second.next;
			first.next.next = temp;
			first = first.next.next;
		}

        /* Finally, we are done. Yay! */
		return;

    }
}