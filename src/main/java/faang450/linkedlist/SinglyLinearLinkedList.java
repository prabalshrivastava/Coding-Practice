package faang450.linkedlist;

public class SinglyLinearLinkedList {
    Node head;

    public void addNode(String data) {


        if (head == null) {
            //head --> null
            Node node = new Node(data, null);
            head = node;
            //head --> 10,null
            return;
        }


        Node traverse = head;
        while (traverse.nextElement != null) {
            traverse = traverse.nextElement;
        }

        Node node = new Node(data, null);
        traverse.nextElement = node;
    }

    public void print() {
        System.out.println("Printing Now :");
        Node traverse = head;
        while (traverse != null) {
            System.out.println(traverse.data);
            traverse = traverse.nextElement;
        }
    }

    public void printWithHead(Node traverse) {
        System.out.println("Printing Now :");
        while (traverse != null) {
            System.out.println(traverse.data);
            traverse = traverse.nextElement;
        }
    }

    public static void main(String[] args) {
        SinglyLinearLinkedList singlyLinearLinkedList = new SinglyLinearLinkedList();
//        singlyLinearLinkedList.addNode("10");
//        singlyLinearLinkedList.addNode("20");
//        singlyLinearLinkedList.addNode("30");
//        singlyLinearLinkedList.addNode("40");
//        singlyLinearLinkedList.addNode("50");
//        singlyLinearLinkedList.print();
//        singlyLinearLinkedList.reverse();
//        singlyLinearLinkedList.print();
        //singlyLinearLinkedList.reverseUsingString();
        singlyLinearLinkedList.addNode("1");
        singlyLinearLinkedList.addNode("2");
        singlyLinearLinkedList.addNode("2");
        singlyLinearLinkedList.addNode("4");
        singlyLinearLinkedList.addNode("5");
        singlyLinearLinkedList.addNode("6");
        singlyLinearLinkedList.addNode("7");
        singlyLinearLinkedList.addNode("8");
        singlyLinearLinkedList.print();
        singlyLinearLinkedList.reverseInGroup(4);
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

    public void reverseUsingString() {
        String s = "";
        Node trav = head;
        while (trav != null) {
            s = s + trav.data + ",";
            trav = trav.nextElement;
        }
        System.out.println("linkedlist as string : " + s);
        String[] elements = s.split(",");
//        for (int i = elements.length - 1; i >= 0; i--) {
//            System.out.println(elements[i]);
//        }
        trav = head;
        int counter = 0;
        while (trav != null) {
            trav.data = elements[counter];
            counter++;
            trav = trav.nextElement;
        }
    }

    //100 -> 200 -> 300 -> 400
    //A   -> B   -> C   -> D
    public Node recursiveReverse(Node current, SinglyLinearLinkedList singlyLinearLinkedList) {
        if (current.nextElement == null) {
            singlyLinearLinkedList.head = current;
            return current;
        }
        current = current.nextElement;
        Node nextElement = recursiveReverse(current, singlyLinearLinkedList);
        nextElement.nextElement = current;
        return null;
    }


    public void reverseInGroup(int keyCount) {
//        Reverse a Linked List in groups of given size.
//        Medium Accuracy: 45.83% Submissions: 100k+ Points: 4
//        Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should be considered as a group and must be reversed (See Example 2 for clarification).
//        Example 1:
//        Input:
//        LinkedList: 1->2->2->4->5->6->7->8
//        K = 4
//        Output: 4 2 2 1 8 7 6 5
//        Explanation:
//        The first 4 elements 1,2,2,4 are reversed first
//        and then the next 4 elements 5,6,7,8. Hence, the
//        resultant linked list is 4->2->2->1->8->7->6->5.
//        Example 2:
//        Input:
//        LinkedList: 1->2->3->4->5
//        K = 3
//        Output: 3 2 1 5 4
//        Explanation:
//        The first 3 elements are 1,2,3 are reversed
//        first and then elements 4,5 are reversed.Hence,
//                the resultant linked list is 3->2->1->5->4.
//        Your Task:
//        You don't need to read input or print anything. Your task is to complete the function reverse() which should reverse the linked list in group of size k and return the head of the modified linked list.
//
//        Expected Time Complexity : O(N)
//        Expected Auxilliary Space : O(1)
//        Constraints:
//        1 <= N <= 104
//        1 <= k <= N
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

        Node[] links = new Node[100];
        int counter = 0;
        Node trav = head;
        Node newHead = trav;
        boolean flag = true;
        Node curr = null;
        while (trav != null) {
            Node prev = newHead;
            Node next = null;
            Node first = newHead;
            if (prev != null) {
                curr = prev.nextElement;
                if (curr != null)
                    next = curr.nextElement;

                for (int i = 0; i < keyCount - 1; i++) {
                    if (prev == newHead) {
                        prev.nextElement = null;
                        first = prev;
                        links[counter] = prev;
                        counter++;
                        System.out.println("first : " + first.data);
                    }
                    if (curr != null && curr != prev) {
                        System.out.println("curr.nextElement = prev; --> " + curr.data + " = " + prev.data);
                        curr.nextElement = prev;
                    }
                    prev = curr;
                    curr = next;
                    if (next == null)
                        break;
                    next = next.nextElement;
                }
            }
//            System.out.println(Arrays.asList(links));
            if (curr != null) {
                System.out.println("first.nextElement = curr; : " + first.data + " = " + curr.data);
            } else
                System.out.println("first.nextElement = curr; : " + first.data + " = " + null);
            first.nextElement = curr;
            newHead = curr;

        }
//        printWithHead(newHead);
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
