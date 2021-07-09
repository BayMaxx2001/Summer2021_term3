
class Node {

    Car info;
    Node next;

    Node(Car x, Node p) {
        info = x;
        next = p;
    }

    Node(Car x) {
        this(x, null);
    }
}