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

    public void print(){
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
    }

    public void insert(String data,int position){

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
