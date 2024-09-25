public class Node {
    int position;  // Cell position (1-9)
    String value;  // 'X', 'O', or empty ("")
    Node next;

    // Constructor for a new node
    public Node(int position) {
        this.position = position;
        this.value = "";  // Start with an empty value
        this.next = null;
    }
}
