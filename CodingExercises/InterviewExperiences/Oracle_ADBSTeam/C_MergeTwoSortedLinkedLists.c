#include <stdio.h>
#include <stdlib.h>

// Define the structure for a linked list node
struct Node {
    int data;
    struct Node* next;
};

// Function to create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Function to merge two sorted linked lists
struct Node* mergeSortedLists(struct Node* l1, struct Node* l2) {
    // Base cases
    if (l1 == NULL) return l2;
    if (l2 == NULL) return l1;

    // Start with the linked list whose head data is the least
    struct Node* result = NULL;
    if (l1->data <= l2->data) {
        result = l1;
        result->next = mergeSortedLists(l1->next, l2);
    } else {
        result = l2;
        result->next = mergeSortedLists(l1, l2->next);
    }
    return result;
}

// Function to print a linked list
void printList(struct Node* head) {
    struct Node* temp = head;
    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}

int main() {
    // Create first sorted linked list: 1 -> 3 -> 5 -> 7
    struct Node* l1 = createNode(1);
    l1->next = createNode(3);
    l1->next->next = createNode(5);
    l1->next->next->next = createNode(7);

    // Create second sorted linked list: 2 -> 4 -> 6 -> 8
    struct Node* l2 = createNode(2);
    l2->next = createNode(4);
    l2->next->next = createNode(6);
    l2->next->next->next = createNode(8);

    // Merge the two sorted linked lists
    struct Node* mergedList = mergeSortedLists(l1, l2);

    // Print the merged sorted linked list
    printf("Merged linked list: ");
    printList(mergedList);

    return 0;
}
