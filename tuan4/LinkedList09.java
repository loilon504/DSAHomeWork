

// Complete the mergeLists function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode next;
 * }
 *
 */
static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int[] a = new int[2005];
        int n = 0;
        while (head1 != null || head2 != null) {
        if (head1 == null) {
        a[++n] = head2.data;
        head2 = head2.next;
        } else if (head2 == null) {
        a[++n] = head1.data;
        head1 = head1.next;
        } else {
        if (head1.data <= head2.data) {
        a[++n] = head1.data;
        head1 = head1.next;
        } else {
        a[++n] = head2.data;
        head2 = head2.next;
        }
        }
        }
        SinglyLinkedListNode head = new SinglyLinkedListNode(a[1]);
        SinglyLinkedListNode ans = head;
        for (int i = 2; i <= n; i++) {
        SinglyLinkedListNode new_node = new SinglyLinkedListNode(a[i]);
        head.next = new_node;
        head = new_node;
        }
        return ans;
        }

