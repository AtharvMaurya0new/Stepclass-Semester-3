public 
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class question2 {

    static Node reverseInGroups(Node head, int k) {

        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;

        while (true) {

            Node curr = prev.next;
            Node temp = curr;

            // Check if k nodes exist
            for (int i = 0; i < k; i++) {
                if (temp == null)
                    return dummy.next;

                temp = temp.next;
            }

            // Reverse k nodes
            Node next = null;
            Node p = null;

            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = p;
                p = curr;
                curr = next;
            }

            // Connect reversed group
            Node tail = prev.next;
            prev.next = p;
            tail.next = curr;

            prev = tail;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        int k = 3;

        head = reverseInGroups(head, k);

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}
 {
    
}
