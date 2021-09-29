package arrays.anjali;

public class LinkedListImplementation {
    Node head;

    static class Node {
        int data;
        Node nextElement;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    @Override
    public String toString() {
        Node trav = this.head;
        String s = "LinkedListImplementation = ";
        while (trav!=null){
            s = s + trav.data + " | ";
            trav = trav.nextElement;
        }
        return s;

    }

    public static LinkedListImplementation insert(LinkedListImplementation list, int data) {
        Node newNode = new Node(data);

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.nextElement != null) {
                last = last.nextElement;
            }
            last.nextElement = newNode;
        }

        return list;

    }

    public static LinkedListImplementation reverse(LinkedListImplementation list) {
        System.out.println();
        Node pre = null;
        Node next = null;
        if (list.head == null) {
            list.head = null;
        } else {
            Node curr = list.head;
            while (curr != null) {
                next = curr.nextElement;
                curr.nextElement = pre; //
                pre = curr;
                curr = next;
            }
            list.head = pre;
            // list.head=last;

            // last.nextElement = newNode;
        }

        return list;

    }

    public static LinkedListImplementation reversemethod(LinkedListImplementation list) {
        Node pre = null;
        Node track;
        track = list.head;
        while (track != null) {
            pre = track;
            track = track.nextElement;
            track = pre;
            list.head = pre;
            System.out.println(" reverse : " + pre.data);
        }

        return list;

    }

    public static void printList(LinkedListImplementation li) {
        Node currNode = li.head;
        while (currNode != null) {
            System.out.println(" called list : " + currNode.data);

            currNode = currNode.nextElement;

        }
    }

    public static void main(String[] args) {
        LinkedListImplementation list = new LinkedListImplementation();

        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);
        System.out.println("before : ");
//        printList(list);
        System.out.println(list.toString());

//        reversemethod(list);
        reverse(list);
        System.out.println("after : ");
        System.out.println(list.toString());

        // Print the LinkedList
//        printList(list);
    }

}
