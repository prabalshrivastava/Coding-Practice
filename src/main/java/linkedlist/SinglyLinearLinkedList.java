package linkedlist;

public class SinglyLinearLinkedList {
    Node head;

    public void addNode(String data) {


        if (head == null) {
            //head --> null
            Node node = new Node(data, null);
            head = node;
            //head --> 10,null
        }


        Node traverse = head;
        while (traverse.nextElement != null) {
            traverse = traverse.nextElement;
        }

        Node node = new Node(data, null);
        traverse.nextElement = node;
    }

    public void print() {
        Node traverse = head;
        while (traverse != null) {
            System.out.println(traverse.data);
            traverse = traverse.nextElement;
        }
    }

    public static void main(String[] args) {
        SinglyLinearLinkedList singlyLinearLinkedList = new SinglyLinearLinkedList();
        singlyLinearLinkedList.addNode("10");
        singlyLinearLinkedList.addNode("20");
        singlyLinearLinkedList.addNode("30");
        singlyLinearLinkedList.addNode("40");
        singlyLinearLinkedList.addNode("50");
        singlyLinearLinkedList.print();
        singlyLinearLinkedList.reverse();
        singlyLinearLinkedList.print();

    }

    public void insert(String data, int position) {

    }

    public void reverse() {
//        Reverse a linked list
//        Difficulty Level : Medium
//        Given pointer to the head node of a linked list, the task is to reverse the linked list. We need to reverse the list by changing the links between nodes.
//        Examples:
//        Input: Head of following linked list
//        1->2->3->4->NULL
//        Output: Linked list should be changed to,
//        4->3->2->1->NULL
//        Input: Head of following linked list
//        1->2->3->4->5->NULL
//        Output: Linked list should be changed to,
//        5->4->3->2->1->NULL
//        Input: NULL
//        Output: NULL

        System.out.println("Reversing Now");
        Node prev = head;
        Node current = head.nextElement;
        Node next = current.nextElement;
        int counter = 0;
        Node temp = head;

        while (prev != null && current != null) {
            next = current.nextElement;
            if (head == prev) {
                prev.nextElement = null;
            }
            current.nextElement = prev;
            prev = current;
            if (next != null)
                current = next;
            else {
                head = current;
                break;
            }
            counter++;
        }
        //head = current;
        System.out.println("counter : " + counter);
//        System.out.println("temp : " + temp.data + "-------" + temp.nextElement);
    }
}

class Node {
    String data;
    Node nextElement;

    public Node(String data, Node nextElement) {
        this.data = data;
        this.nextElement = nextElement;
    }
}
