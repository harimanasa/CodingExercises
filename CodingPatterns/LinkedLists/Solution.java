public class Solution {
    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> current = head;
        while (current != null && current.next != null) {
            if (current.next.data.equals(current.data)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    // Driver code
    public static void main(String[] args) {
        Integer[][] inputList = {
            {1, 2, 2, 3, 3, 3},
            {-21, -21, -21, -21, -21, -21, -21},
            {3, 7, 9},
            {-100, -100, -100, -10, -10, 0, 10, 10, 100, 100, 100},
            {-77, -77, -7, -7, -7, -7, 7, 7, 7, 7, 77, 77, 77, 77}
        };

        for (int i = 0; i < inputList.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<>();
            inputLinkedList.createLinkedList(inputList[i]);

            System.out.print((i + 1) + ".\tInput: ");
            inputLinkedList.printListWithForwardArrow();

            System.out.print("\n\tOutput: ");
            inputLinkedList.head = removeDuplicates(inputLinkedList.head);
            inputLinkedList.printListWithForwardArrow();

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}