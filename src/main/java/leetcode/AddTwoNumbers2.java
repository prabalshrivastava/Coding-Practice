package leetcode;

public class AddTwoNumbers2 {
  //  You are given two non-empty linked lists representing two non-negative integers. The digits
  // are stored in reverse order, and each of their nodes contains a single digit. Add the two
  // numbers and return the sum as a linked list.
  //  Example 1:
  //  Input: l1 = [2,4,3], l2 = [5,6,4]
  //  Output: [7,0,8]
  //  Explanation: 342 + 465 = 807.
  //  
  //  Example 2:
  //
  //  Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
  //. 9999999 + 9999 = 10009998
  //  Output: [8,9,9,9,0,0,0,1]

  //  Constraints:
  //  The number of nodes in each linked list is in the range [1, 100].
  //      0 <= Node.val <= 9
  //  It is guaranteed that the list represents a number that does not have leading zeros.
  public static void main(String[] args) {
//    sample1();
   sample2();

  }

  public static LinkedList2 addTwoNumbers(LinkedList2 l1, LinkedList2 l2) {
    //add your code here

    LinkedList2 linkedList = new LinkedList2();
    int carry=0;
    ListNode2 list1=l1.head;
    ListNode2 list2=l2.head;
    while(list1!=null){
      if(list2!=null){
        
        int sum=(list1.val+list2.val+carry)%10;
        carry=(list1.val+list2.val)/10;
        linkedList.addNode(sum);
        list2=list2.next;
      }else{
        if(carry!=0){
          int sum=(list1.val+carry)%10;
         carry=(list1.val+carry)/10;
        linkedList.addNode(sum);
        }else{
        linkedList.addNode(list1.val);
        }
      }
      list1=list1.next;
    }
    if (carry != 0) {
      linkedList.addNode(carry);
    }
    while(list2!=null){
      linkedList.addNode(list2.val);
      list2=list2.next;
    }
    
    return linkedList;
  }

  private static void sample2() {
    LinkedList2 linkedList1 = new LinkedList2();
    linkedList1.addNode(9);
    linkedList1.addNode(9);
    linkedList1.addNode(9);
    linkedList1.addNode(9);
    linkedList1.addNode(9);
    linkedList1.addNode(9);
    linkedList1.addNode(9);
    linkedList1.print();

    LinkedList2 linkedList2 = new LinkedList2();
    linkedList2.addNode(9);
    linkedList2.addNode(9);
    linkedList2.addNode(9);
    linkedList2.addNode(9);
    linkedList2.print();

    System.out.println("------------------------------------------------------");
    LinkedList2 listNode = addTwoNumbers(linkedList1, linkedList2);
    listNode.print();
  }

  private static void sample1() {
    LinkedList2 linkedList1 = new LinkedList2();
    linkedList1.addNode(2);
    linkedList1.addNode(4);
    linkedList1.addNode(3);
    linkedList1.print();

    LinkedList2 linkedList2 = new LinkedList2();
    linkedList2.addNode(5);
    linkedList2.addNode(6);
    linkedList2.addNode(4);
    linkedList2.print();

    System.out.println("------------------------------------------------------");

    LinkedList2 listNode = addTwoNumbers(linkedList1, linkedList2);
    listNode.print();
  }
}
/** Definition for singly-linked list. */
class LinkedList2 {
  ListNode2 head;

  public LinkedList2() {
    head = null;
  }

  public void addNode(int elementToBeAdded) {
    ListNode2 trav = head;
    if (trav == null) {
      trav = new ListNode2();
      trav.val = elementToBeAdded;
      trav.next = null;
      head = trav;
    } else {
      while (trav.next != null) {
        trav = trav.next;
      }
      trav.next = new ListNode2();
      trav = trav.next;
      trav.val = elementToBeAdded;
      trav.next = null;
    }
  }

  public void print() {
    ListNode2 trav = head;
    while (trav != null) {
      System.out.println("current = " + trav + " - value = " + trav.val + " - next = " + trav.next);
      trav = trav.next;
    }
  }
}

class ListNode2 {

  int val;
  ListNode2 next;

  ListNode2() {}

  ListNode2(int val) {
    this.val = val;
  }

  ListNode2(int val, ListNode2 next) {
    this.val = val;
    this.next = next;
  }
}
