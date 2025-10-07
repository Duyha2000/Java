package LinkedList.Singly;

public class Node<T> {
    // https://docs.google.com/spreadsheets/d/1AHleYM1JweYpHPo8dx8kWsNQCkXjRfn-yRd7HVzWBXo/edit?gid=636223422#gid=636223422
    // https://meet.google.com/iem-fyvw-ord

    T data;
    Node<T> next; // vì nó -> phần tử kế tiếp (nên data type là Node)

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
