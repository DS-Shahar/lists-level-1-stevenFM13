public class Main {

    public static void main(String[] args) {
        // Create linked list L1
        Node<Integer> L1 = new Node<>(1);
        L1.setNext(new Node<>(2));
        L1.getNext().setNext(new Node<>(3));
        L1.getNext().getNext().setNext(new Node<>(4));
        L1.getNext().getNext().getNext().setNext(new Node<>(5)); // Added 5

        // Create linked list L2
        Node<Integer> L2 = new Node<>(4);
        L2.setNext(new Node<>(3));
        L2.getNext().setNext(new Node<>(2));

        // Call newL1 to delete elements from L1 that are in L2

        // Print the modified L1
        System.out.println("Modified L1: " + printList(ex11(L1, L2)));
    }

    public static Node<Integer> ex11(Node<Integer> L1, Node<Integer> L2) {
        Node<Integer> currentL1 = L1;

        // Traverse L1
        while (currentL1 != null && currentL1.getNext() != null) {
            Node<Integer> currentL2 = L2;
            // Traverse L2 to check if any value in L1 matches any value in L2
            boolean deleted = false;
            while (currentL2 != null) {
                if (currentL1.getValue().equals(currentL2.getValue())) {
                    // Remove currentL1 node from L1
                    currentL1.setValue(currentL1.getNext().getValue()); // Copy the value from the next node
                    currentL1.setNext(currentL1.getNext().getNext()); // Skip the next node
                    deleted = true; // Mark as deleted
                    break; // Exit the loop once the value is deleted
                }
                currentL2 = currentL2.getNext();
            }
            // Only move to the next node if no deletion happened
            if (!deleted) {
                currentL1 = currentL1.getNext();
            }
        }

        // Check if the last node should be deleted
        Node<Integer> currentL2 = L2;
        while (currentL2 != null) {
            if (currentL1 != null && currentL1.getValue().equals(currentL2.getValue())) {
                currentL1 = currentL1.getNext(); // Remove last node if it matches
                break;
            }
            currentL2 = currentL2.getNext();
        }

        return L1;
    }

    // Helper method to print the linked list
    public static String printList(Node<Integer> head) {
        StringBuilder sb = new StringBuilder();
        Node<Integer> current = head;
        while (current != null) {
            sb.append(current.getValue()).append(" --> ");
            current = current.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}