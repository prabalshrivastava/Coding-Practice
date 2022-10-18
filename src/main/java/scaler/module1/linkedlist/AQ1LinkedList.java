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
        if (position == 1) {
            trav = new Node(value, null);
            trav.next=head;
            head = trav;
            return;
        }
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
        if (position == 1) {
            head = head.next;
            return;
        }
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
        while (trav.next != null) {
            System.out.print(trav.value + " ");
            trav = trav.next;
        }
        System.out.print(trav.value);
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

//        The expected return value:
//        4998 6629 7976 1445 6573 6416 2528 6208 7871 8738 9468 7983 6477 1214 8468 4793 5687 7074 430 3310 4005 3848 6598 7114 2184 5350 201 952 2842 3564 8239 6513 6310 2195 4645 4237 4763 3786 1331 644 7022 4055 5940 7777 9343 5284 7284 9061 6201 4987 3808 8755 6335 2478 8615 4455 4466 7744 5193 2801 3705 8208 7357 785 9765 7857 5365 5535 9190 8728 4598 242 8917 9501 6524 6305 5566 7105 3865 9204 6068 6423 2371 3519 4510 5354 9899 407 530 9102 8426 3926 686 8645 2445 2226 5199 1892 5012 9844
//        4998 6629 7976 1445 6573 6416 2528 6208 7871 8738 9468 7983 6477 1214 8468 4793 5687 7074 430 3310 4005 3848 6598 7114 2184 5350 201 952 2842 3564 8239 6513 6310 2195 4645 4237 4763 3786 1331 644 7022 4055 5940 7777 9343 5284 7284 9061 6201 4987 3808 8755 6335 2478 8615 4455 4466 7744 5193 2801 3705 8208 785 9765 7857 5365 5535 9190 8728 4598 242 8917 9501 6524 6305 5566 7105 3865 9204 6068 6423 2371 3519 4510 5354 9899 407 530 9102 8426 3926 686 8645 2226 5199 1892 5012 9844
//        4998 6629 7976 1445 6573 641
//        Your function returned the following:
//        4998 6629 7976 1445 6573 6416 2528 6208 7871 8738 9468 7983 6477 1214 8468 4793 5687 7074 430 3310 4005 3848 6598 7114 2184 5350 201 952 2842 3564 8239 6513 6310 2195 4645 4237 4763 3786 1331 644 7022 4055 5940 7777 9343 5284 7284 9061 6201 4987 3808 8755 6335 2478 8615 4455 4466 7744 5193 2801 3705 8208 7357 785 9765 7857 5365 5535 9190 8728 4598 242 8917 9501 6524 6305 5566 7105 3865 9204 6068 6423 2371 3519 4510 5354 9899 407 530 9102 8426 3926 686 8645 2445 2226 5199 1892 5012 9844
//        4998 6629 7976 1445 6573 6416 2528 6208 7871 8738 9468 7983 6477 1214 8468 4793 5687 7074 430 3310 4005 3848 6598 7114 2184 5350 201 952 2842 3564 8239 6513 6310 2195 4645 4237 4763 3786 1331 644 7022 4055 5940 7777 9343 5284 7284 9061 6201 4987 3808 8755 6335 2478 8615 4455 4466 7744 5193 2801 3705 8208 785 9765 7857 5365 5535 9190 8728 4598 242 8917 9501 6524 6305 5566 7105 3865 9204 6068 6423 2371 3519 4510 5354 9899 407 530 9102 8426 3926 686 8645 2226 5199 1892 5012 9844
//        4998 6629 7976 1445 6573 641
    }
}

