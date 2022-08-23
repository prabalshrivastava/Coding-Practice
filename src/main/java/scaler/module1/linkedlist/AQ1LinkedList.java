package scaler.module1.linkedlist;

public class AQ1LinkedList {
//    Problem Description
//    Design and implement a Linked List data structure.
//    A node in a linked list should have the following attributes - an integer value and a pointer to the next node. It should support the following operations:
//    insert_node(position, value) - To insert the input value at the given position in the linked list.
//            delete_node(position) - Delete the value at the given position from the linked list.
//            print_ll() - Print the entire linked list, such that each element is followed by a single space.
//    Note:
//    If an input position does not satisfy the constraint, no action is required.
//    Each print query has to be executed in a new line.
//            Problem Constraints
//    1 <= position <= n where, n is the size of the linked-list.
//            Input Format
//    First line contains an integer denoting number of cases, let's say t.
//    Next t line denotes the cases.
//    Output Format
//    When there is a case of print_ll(),  Print the entire linked list, such that each element is followed by a single space.
//    NOTE: You don't need to return anything.
//    Example Input
//5
//    i 1 23
//    i 2 24
//    p
//    d 1
//    p
//    Example Output
//23 24
//        24
//    Example Explanation
//    After first two cases linked list contains two elements 23 and 24.
//    At third case print: 23 24.
//    At fourth case delete value at first position, only one element left 24.
//    At fifth case print: 24.

    static Node head;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        if (head == null) {
            head = new Node(value, null);
            return;
        }
        Node trav = head;
        int count = 1;
        while (trav.next != null && count != position - 1) {
            trav = trav.next;
            count++;
        }
        trav.next = new Node(value, trav.next);
    }

    public static void delete_node(int position) {
        // @params position, integer
        if (head == null)
            return;
        Node trav = head;
        int count = 1;
        while (trav.next != null && count != position - 1) {
            trav = trav.next;
            count++;
        }
        if (trav.next != null)
            trav.next = trav.next.next;
    }

    public static void print_ll() {
        // Output each element followed by a space
        Node trav = head;
        while (trav != null) {
            System.out.println(trav.value);
            trav = trav.next;
        }
    }

    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
//        100
//        i 1 226
//        i 2 875
//        i 3 604
//        i 4 550
//        i 5 498
//        i 6 875
//        i 7 847
//        i 8 633
//        i 9 793
//        i 10 872
//        i 11 313
//        i 12 440
//        i 13 331
//        i 14 582
//        i 15 188
//        i 16 476
//        i 17 722
//        i 18 402
//        i 19 890
//        i 20 713
//        i 21 421
//        i 22 930
//        i 23 579
//        i 24 459
//        i 25 278
//        i 26 818
//        i 27 320
//        i 28 549
//        i 29 240
//        i 30 528
//        i 31 367
//        i 32 835
//        i 33 20
//        i 34 170
//        i 35 903
//        i 36 242
//        i 37 943
//        i 38 802
//        i 39 145
//        i 40 291
//        i 41 224
//        i 42 400
//        i 43 43
//        i 44 355
//        i 45 83
//        i 46 26
//        i 47 816
//        i 48 477
//        i 49 425
//        i 50 543
//        i 51 211
//        i 52 799
//        i 53 185
//        i 54 5
//        i 55 184
//        i 56 150
//        i 57 572
//        i 58 626
//        i 59 109
//        i 60 807
//        d 25
//        p
//        d 53
//        p
//        d 12
//        d 54
//        p
//        p
//        p
//        p
//        p
//        d 39
//        d 42
//        p
//        d 47
//        d 45
//        d 35
//        p
//        d 13
//        p
//        d 18
//        d 59
//        d 47
//        d 43
//        d 38
//        p
//        p
//        p
//        p
//        p
//        p
//        d 8
//        p
//        d 8
//        p
//        d 39
//        d 60
//        d 16
//        p
//        p


//        226 875 604 550 498 875 847 633 793 872 313 440 331 582 188 476 722 402 890 713 421 930 579 459 818 320 549 240 528 367 835 20 170 903 242 943 802 145 291 224 400 43 355 83 26 816 477 425 543 211 799 185 5 184 150 572 626 109 807
//        226 875 604 550 498 875 847 633 793 872 313 440 331 582 188 476 722 402 890 713 421 930 579 459 818 320 549 240 528 367 835 20 170 903 242 943 802 145 291 224 400 43 355 83 26 816 477 425 543 211 799 185 184 150 572 626 109 807
//        226 875 604 550 498 875 847 633 793 872 313 331 582 188 476 722 402 890 713 421 930 579 459 818 320 549 240 528 367 835 20 170 903 242 943 802 145 291 224 400 43 355 83 26 816 477 425 543 211 799 185 184 150 626 109 807
//        226 875 604 550 498 875 847 633 793 872 313 331 582 188 476 722 402 890 713 421 930 579 459 818 320 549 240 528 367 835 20 170 903 242 943 802 145 291 224 400 43 355 83 26 816 477 425 543 211 799 185 184 150 626 109 807
//        226 875 604 550 498 875 847 633 793 872 313 331 582 188 476 722 402 890 713 421 930 579 459 818 320 54
    }
}

