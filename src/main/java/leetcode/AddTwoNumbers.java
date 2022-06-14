package leetcode;

public class AddTwoNumbers {
  // https://leetcode.com/problems/add-two-numbers/

  //  You are given two non-empty linked lists representing two non-negative integers. The digits
  // are stored in reverse order, and each of their nodes contains a single digit. Add the two
  // numbers and return the sum as a linked list.
  //  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  //  Example 1:
  //  Input: l1 = [2,4,3], l2 = [5,6,4]
  //  Output: [7,0,8]
  //  Explanation: 342 + 465 = 807.
  //  Example 2:
  //
  //  Input: l1 = [0], l2 = [0]
  //  Output: [0]
  //  Example 3:
  //
  //  Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
  //  Output: [8,9,9,9,0,0,0,1]

  //  Constraints:
  //  The number of nodes in each linked list is in the range [1, 100].
  //      0 <= Node.val <= 9
  //  It is guaranteed that the list represents a number that does not have leading zeros.
  public static void main(String[] args) {
//    sample1();
//    sample2();
    sample3();
  }
  private static void sample3() {
    LinkedList linkedList1 = new LinkedList();
    linkedList1.addNode(0);
    linkedList1.print();

    LinkedList linkedList2 = new LinkedList();
    linkedList2.addNode(0);
    linkedList2.print();

    LinkedList listNode = addTwoNumbers(linkedList1, linkedList2);
    System.out.println("---------------");
    listNode.print();
  }

  private static void sample2() {
    LinkedList linkedList1 = new LinkedList();
    linkedList1.addNode(9);
    linkedList1.addNode(9);
    linkedList1.addNode(9);
    linkedList1.addNode(9);
    linkedList1.addNode(9);
    linkedList1.addNode(9);
    linkedList1.addNode(9);
    linkedList1.print();

    LinkedList linkedList2 = new LinkedList();
    linkedList2.addNode(9);
    linkedList2.addNode(9);
    linkedList2.addNode(9);
    linkedList2.addNode(9);
    linkedList2.print();

    LinkedList listNode = addTwoNumbers(linkedList1, linkedList2);
    listNode.print();
  }

  private static void sample1() {
    LinkedList linkedList1 = new LinkedList();
    linkedList1.addNode(2);
    linkedList1.addNode(4);
    linkedList1.addNode(3);
    linkedList1.print();

    LinkedList linkedList2 = new LinkedList();
    linkedList2.addNode(5);
    linkedList2.addNode(6);
    linkedList2.addNode(4);
    linkedList2.print();

    LinkedList listNode = addTwoNumbers(linkedList1, linkedList2);
    listNode.print();
  }

  public static LinkedList addTwoNumbers(LinkedList l1, LinkedList l2) {
    ListNode trav1 = l1.head;
    ListNode trav2 = l2.head;

    double val1 = 0;
    int i1 = 0;
    while (trav1 != null) {
      val1 = val1 + trav1.val * Math.pow(10, i1);
      i1++;
      trav1 = trav1.next;
    }

    double val2 = 0;
    int i2 = 0;
    while (trav2 != null) {
      val2 = val2 + trav2.val * Math.pow(10, i2);
      i2++;
      trav2 = trav2.next;
    }

    System.out.println(val1);
    System.out.println(val2);

    double outputVal = val1 + val2;
    System.out.println(outputVal);

    LinkedList linkedList = new LinkedList();

    int currentVal = (int) outputVal;
    while (currentVal != 0) {
      int toBeInserted = currentVal % 10;
      currentVal = currentVal / 10;
      linkedList.addNode(toBeInserted);
    }
    return linkedList;
  }
}
/** Definition for singly-linked list. */
class LinkedList {
  ListNode head;

  public LinkedList() {
    head = null;
  }

  public void addNode(int elementToBeAdded) {
    ListNode trav = head;
    if (trav == null) {
      trav = new ListNode();
      trav.val = elementToBeAdded;
      trav.next = null;
      head = trav;
    } else {
      while (trav.next != null) {
        trav = trav.next;
      }
      trav.next = new ListNode();
      trav = trav.next;
      trav.val = elementToBeAdded;
      trav.next = null;
    }
  }

  public void print() {
    ListNode trav = head;
    while (trav != null) {
      System.out.println("current = " + trav + " - value = " + trav.val + " - next = " + trav.next);
      trav = trav.next;
    }
  }
}

class ListNode {

  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
