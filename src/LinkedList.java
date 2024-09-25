public class LinkedList {
    private Node head;  // Head of the linked list

    // Constructor to initialize the linked list for a 3x3 board
    public LinkedList() {
        this.head = null;
        initializeBoard();
    }

    // Method to initialize the board (linked list with 9 nodes)
    private void initializeBoard() {
        Node current = null;
        for (int i = 1; i <= 9; i++) {
            Node newNode = new Node(i);
            if (this.head == null) {
                this.head = newNode;
                current = this.head;
            } else {
                current.next = newNode;
                current = newNode;
            }
        }
    }

    // Method to display the Tic Tac Toe board
    public void displayBoard() {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.value.equals("")) {
                System.out.print(current.position);
            } else {
                System.out.print(current.value);
            }
            count++;
            if (count % 3 == 0) {
                System.out.println();  // New row
            } else {
                System.out.print(" | ");
            }
            current = current.next;
        }
    }

    // Method to update a specific position in the list
    public void updatePosition(int position, String data) {
        Node current = head;
        while (current != null) {
            if (current.position == position) {
                current.value = data;
                break;
            }
            current = current.next;
        }
    }

    // Method to get the value at a specific position
    public String getPositionValue(int position) {
        Node current = head;
        while (current != null) {
            if (current.position == position) {
                return current.value;
            }
            current = current.next;
        }
        return "";
    }

    // Method to check for a win
    public boolean checkWinCondition() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    // Helper method to check rows for a win
    private boolean checkRows() {
        Node current = head;
        for (int i = 0; i < 3; i++) {
            if (!current.value.equals("") && current.value.equals(current.next.value) && current.value.equals(current.next.next.value)) {
                return true;
            }
            current = current.next.next.next;  // Move to next row
        }
        return false;
    }

    // Helper method to check columns for a win
    private boolean checkColumns() {
        for (int i = 1; i <= 3; i++) {
            if (!getPositionValue(i).equals("") && getPositionValue(i).equals(getPositionValue(i + 3)) && getPositionValue(i).equals(getPositionValue(i + 6))) {
                return true;
            }
        }
        return false;
    }

    // Helper method to check diagonals for a win
    private boolean checkDiagonals() {
        return (!getPositionValue(1).equals("") && getPositionValue(1).equals(getPositionValue(5)) && getPositionValue(1).equals(getPositionValue(9))) ||
                (!getPositionValue(3).equals("") && getPositionValue(3).equals(getPositionValue(5)) && getPositionValue(3).equals(getPositionValue(7)));
    }

    // Method to check if the board is full (for draw condition)
    public boolean isBoardFull() {
        Node current = head;
        while (current != null) {
            if (current.value.equals("")) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    // Method to reset the board
    public void resetBoard() {
        Node current = head;
        while (current != null) {
            current.value = "";
            current = current.next;
        }
    }
}