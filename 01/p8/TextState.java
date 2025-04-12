class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditorHistory {
    private TextState current;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public void addState(String content) {
        TextState newState = new TextState(content);

        if (current != null) {
            current.next = newState;
            newState.prev = current;
        }

        current = newState;

        // Clear all redo history
        current.next = null;

        // Limit size by trimming oldest states
        while (getOldest().next != null && countStates() > MAX_HISTORY) {
            TextState oldest = getOldest();
            getOldest().next.prev = null;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("No content available.");
        }
    }

    private int countStates() {
        int count = 0;
        TextState temp = getOldest();
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private TextState getOldest() {
        TextState temp = current;
        while (temp != null && temp.prev != null) {
            temp = temp.prev;
        }
        return temp;
    }
}
