package scaler.advancedDsa.linkedlist1;

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "" + this.val;
    }
}