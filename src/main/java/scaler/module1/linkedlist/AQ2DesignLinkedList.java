package scaler.module1.linkedlist;

import java.util.List;

public class AQ2DesignLinkedList {
//    Problem Description
//    Given a matrix A of size Nx3 representing operations. Your task is to design the linked list based on these operations.
//    There are four types of operations:
//            0 x -1: Add a node of value x before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
//            1 x -1: Append a node of value x to the last element of the linked list.
//            2 x index: Add a node of value x before the indexth node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
//            3 index -1: Delete the indexth node in the linked list, if the index is valid.
//    A[i][0] represents the type of operation.
//            A[i][1], A[i][2] represents the corresponding elements with respect to type of operation.
//    Note: Indexing is 0 based.
//            Problem Constraints
//1 <= Number of operations <= 1000
//            1 <= All node values <= 109
//    Input Format
//    The only argument given is matrix A.
//            Output Format
//    Return the pointer to the starting of the linked list.
//    Example Input
//    Input 1:
//    A = [   [0, 1, -1]
//            [1, 2, -1]
//            [2, 3, 1]   ]
//    Input 2:
//    A = [   [0, 1, -1]
//            [1, 2, -1]
//            [2, 3, 1]
//            [0, 4, -1]
//            [3, 1, -1]
//            [3, 2, -1]  ]
//    Example Output
//    Output 1:
//            1->3->2->NULL
//    Output 2:
//            4->3->NULL

    ListNode head;

    public ListNode solve(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            switch (A[i][0]) {
                case 0:
                    addFirstNode(A[i][1]);
                    print_ll();
                    break;
                case 1:
                    addLastNode(A[i][1]);
                    print_ll();
                    break;
                case 2:
                    addAtPos(A[i][1], A[i][2]);
                    print_ll();
                    break;
                case 3:
                    delAtPos(A[i][1]);
                    print_ll();
                    break;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        int[][] input4A =
                {
                        {2, 18, 0},
                        {2, 5, 1},
                        {2, 8, 0},
                        {1, 7, -1},
                        {1, 5, -1}
                };

                AQ2DesignLinkedList obj4A = new AQ2DesignLinkedList();
        System.out.println("\n" + obj4A.solve(input4A));//8 -> 18 -> 5 -> 7 -> 5
        obj4A.print_ll();

//        int[][] input3A = {
//                {1, 13, -1},
//                {3, 0, -1},
//                {3, 1, -1},
//                {2, 15, 0},
//                {3, 0, -1},
//                {1, 12, -1},
//                {3, 0, -1},
//                {1, 19, -1},
//                {1, 13, -1},
//                {3, 0, -1},
//                {0, 12, -1},
//                {1, 13, -1},
//                {3, 2, -1}
//        };
//
//        AQ2DesignLinkedList obj3A = new AQ2DesignLinkedList();
//        System.out.println("\n" + obj3A.solve(input3A));//12->13
//        obj3A.print_ll();

//
//        int[][] input1A = {{0, 1, -1},
//                {1, 2, -1},
//                {2, 3, 1}};
//
//        AQ2DesignLinkedList obj1A = new AQ2DesignLinkedList();
//        System.out.println("\n" + obj1A.solve(input1A));
//        obj1A.print_ll();
//        int[][] input2A = {{0, 1, -1},
//                {1, 2, -1},
//                {2, 3, 1},
//                {0, 4, -1},
//                {3, 1, -1},
//                {3, 2, -1}};
//
//        AQ2DesignLinkedList obj2A = new AQ2DesignLinkedList();
//        System.out.println("\n" + obj2A.solve(input2A));
//        obj2A.print_ll();
    }

    void addFirstNode(int value) {
        if (head == null) {
            head = new ListNode(value);
            return;
        }
        ListNode node = head;
        head = new ListNode(value);
        head.next = node;
    }

    void addLastNode(int value) {
        ListNode trav = head;
        if (head == null) {
            head = new ListNode(value);
            return;
        }
        while (trav.next != null) {
            trav = trav.next;
        }
        trav.next = new ListNode(value);
    }


    void addAtPos(int value, int pos) {
        ListNode trav = head;
        if (head == null || pos == 0) {
            ListNode node = head;
            head = new ListNode(value);
            head.next = node;
            return;
        }
        int count = 0;
        while (trav.next != null) {
            if (count == pos - 1) {
                break;
            }
            trav = trav.next;
            count++;
        }
        ListNode x = trav.next;
        trav.next = new ListNode(value);
        trav.next.next = x;
    }

    void delAtPos(int pos) {
        ListNode trav = head;
        if (head == null)
            return;
        if (pos == 0) {
            head = head.next;
            return;
        }
        int count = 0;
        while (trav.next != null) {
            if (count == pos - 1) {
                break;
            }
            trav = trav.next;
            count++;
        }
//        System.out.println("count : " + count);
        if (trav.next != null)
            trav.next = trav.next.next;
    }

    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(int value) {
            this.value = value;
        }
    }

    public void print_ll() {
        // Output each element followed by a space
        ListNode trav = head;
        if (trav == null)
            return;
        while (trav.next != null) {
            System.out.print(trav.value + " ");
            trav = trav.next;
        }
        System.out.print(trav.value);
        System.out.println();
    }

}
