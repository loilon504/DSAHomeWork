

// Complete the insertNodeAtTail function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode next;
 * }
 *
 */
static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode tail = new SinglyLinkedListNode(data);
        SinglyLinkedListNode old_head = head;
        if (head == null) return tail;
        while (head.next != null) head = head.next;
        head.next = tail;
        return old_head;
        }

