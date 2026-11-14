
class Node {
    String title;
    int day;
    Node next;

    Node(String title, int day) {
        this.title = title;
        this.day = day;
        this.next = null;
    }
}

public class question1 {

    static Node sortByDueDay(Node head) {

        if (head == null || head.next == null)
            return head;

        // Find middle
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split list
        Node second = slow.next;
        slow.next = null;

        // Sort both halves
        Node left = sortByDueDay(head);
        Node right = sortByDueDay(second);

        // Merge both halves
        return merge(left, right);
    }

    static Node merge(Node a, Node b) {

        Node dummy = new Node("", 0);
        Node temp = dummy;

        while (a != null && b != null) {

            if (a.day <= b.day) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }

            temp = temp.next;
        }

        if (a != null)
            temp.next = a;

        if (b != null)
            temp.next = b;

        return dummy.next;
    }

    public static void main(String[] args) {

        Node head = new Node("Java", 15);
        head.next = new Node("DSA", 3);
        head.next.next = new Node("OS", 9);
        head.next.next.next = new Node("DBMS", 3);
        head.next.next.next.next = new Node("CN", 12);
        head.next.next.next.next.next = new Node("AI", 1);

        head = sortByDueDay(head);

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.title + ":" + temp.day + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}
