package scaler.advancedDsa.linkedlist1;

import scaler.module1.linkedlist.AQ1LinkedList;

public class AQ6LinkedList {
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
//1 <= value <= 105
//            1 <= position <= n where, n is the size of the linked-list.
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
    public static void main(String[] args) {

        insert_node(1, 4998);   //i 1 4998
        insert_node(2, 6629);   //i 2 6629
        insert_node(3, 7976);   //i 3 7976
        insert_node(4, 1445);   //i 4 1445
        insert_node(5, 6573);   //i 5 6573
        insert_node(6, 6416);   //i 6 6416
        insert_node(7, 2528);   //i 7 2528
        insert_node(8, 6208);   //i 8 6208
        insert_node(9, 7871);   //i 9 7871
        insert_node(10, 8738);  //i 10 8738
        insert_node(11, 9468);  //i 11 9468
        insert_node(12, 7983);  //i 12 7983
        insert_node(13, 6477);  //i 13 6477
        insert_node(14, 1214);  //i 14 1214
        insert_node(15, 8468);  //i 15 8468
        insert_node(16, 4793);  //i 16 4793
        insert_node(17, 5687);  //i 17 5687
        insert_node(18, 7074);  //i 18 7074
        insert_node(19, 430);   //i 19 430
        insert_node(20, 3310);  //i 20 3310
        insert_node(21, 4005);  //i 21 4005
        insert_node(22, 3848);  //i 22 3848
        insert_node(23, 6598);  //i 23 6598
        insert_node(24, 2184);  //i 24 2184
        insert_node(25, 5350);  //i 25 5350
        insert_node(26, 201);   //i 26 201
        insert_node(27, 952);   //i 27 952
        insert_node(28, 2842);  //i 28 2842
        insert_node(29, 3564);  //i 29 3564
        insert_node(30, 8239);  //i 30 8239
        insert_node(31, 6513);  //i 31 6513
        insert_node(32, 6310);  //i 32 6310
        insert_node(33, 2195);  //i 33 2195
        insert_node(34, 4645);  //i 34 4645
        insert_node(35, 4237);  //i 35 4237
        insert_node(36, 4763);  //i 36 4763
        insert_node(37, 3786);  //i 37 3786
        insert_node(38, 1331);  //i 38 1331
        insert_node(39, 644);   //i 39 644
        insert_node(40, 7022);  //i 40 7022
        insert_node(41, 4055);  //i 41 4055
        insert_node(42, 5940);  //i 42 5940
        insert_node(43, 7777);  //i 43 7777
        insert_node(44, 9343);  //i 44 9343
        insert_node(45, 5284);  //i 45 5284
        insert_node(46, 7284);  //i 46 7284
        insert_node(47, 9061);  //i 47 9061
        insert_node(48, 6201);  //i 48 6201
        insert_node(49, 4987);  //i 49 4987
        insert_node(50, 3808);  //i 50 3808
        insert_node(51, 8755);  //i 51 8755
        insert_node(52, 6335);  //i 52 6335
        insert_node(53, 2478);  //i 53 2478
        insert_node(54, 8615);  //i 54 8615
        insert_node(55, 4455);  //i 55 4455
        insert_node(56, 4466);  //i 56 4466
        insert_node(57, 4290);  //i 57 4290
        insert_node(58, 7744);  //i 58 7744
        insert_node(59, 5193);  //i 59 5193
        insert_node(60, 2801);  //i 60 2801
        insert_node(61, 3705);  //i 61 3705
        insert_node(62, 8208);  //i 62 8208
        insert_node(63, 7357);  //i 63 7357
        insert_node(64, 785);   //i 64 785
        insert_node(65, 9765);  //i 65 9765
        insert_node(66, 7857);  //i 66 7857
        insert_node(67, 5365);  //i 67 5365
        insert_node(68, 5535);  //i 68 5535
        insert_node(69, 9190);  //i 69 9190
        insert_node(70, 8728);  //i 70 8728
        insert_node(71, 4598);  //i 71 4598
        insert_node(72, 242);   //i 72 242
        insert_node(73, 8917);  //i 73 8917
        insert_node(74, 9501);  //i 74 9501
        insert_node(75, 6524);  //i 75 6524
        insert_node(76, 6305);  //i 76 6305
        insert_node(77, 5566);  //i 77 5566
        insert_node(78, 7105);  //i 78 7105
        insert_node(79, 3865);  //i 79 3865
        insert_node(80, 9204);  //i 80 9204
        insert_node(81, 6068);  //i 81 6068
        insert_node(82, 6423);  //i 82 6423
        insert_node(83, 2371);  //i 83 2371
        insert_node(84, 3519);  //i 84 3519
        insert_node(85, 4510);  //i 85 4510
        insert_node(86, 5354);  //i 86 5354
        insert_node(87, 9899);  //i 87 9899
        insert_node(88, 407);   //i 88 407
        insert_node(89, 530);   //i 89 530
        insert_node(90, 9102);  //i 90 9102
        insert_node(91, 8426);  //i 91 8426
        insert_node(92, 3926);  //i 92 3926
        insert_node(93, 686);   //i 93 686
        insert_node(94, 8645);  //i 94 8645
        insert_node(95, 2445);  //i 95 2445
        insert_node(96, 2226);  //i 96 2226
        insert_node(97, 5199);  //i 97 5199
        insert_node(98, 1892);  //i 98 1892
        insert_node(99, 5012);  //i 99 5012
        insert_node(100, 9844); //i 100 9844
        insert_node(24, 7114);  //i 24 7114
        delete_node(5);               //d
        print_ll();                           //p
    }

    static Node head;

    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void insert_node(int position, int value) {
        if (head == null) {
            head = new Node(value, null);
            return;
        }
        if (position == 1) {
            Node temp = head;
            head = new Node(value, temp);
            return;
        }
        int count = 1;
        Node trav = head;
        while (trav.next != null && count != position - 1) {
            trav = trav.next;
            count++;
        }
        Node temp = trav.next;
        trav.next = new Node(value, temp);
    }

    public static void delete_node(int position) {
        if (head == null)
            return;
        if (position == 1) {
            head = head.next;
            return;
        }
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
        Node trav = head;
        while (trav.next != null) {
            System.out.print(trav.value + " ");
            trav = trav.next;
        }
        System.out.print(trav.value);
    }
}
