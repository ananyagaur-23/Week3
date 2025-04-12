class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}
class Library {
    private Book head, tail;

    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addAtPosition(int pos, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (pos <= 0) {
            System.out.println("Invalid Position.");
            return;
        }
        if (pos == 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }

        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp == tail) {
            addAtEnd(title, author, genre, bookId, isAvailable);
            return;
        }

        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
    }

    public void removeById(int bookId) {
        if (head == null) return;

        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    public void searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                printBook(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                printBook(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void updateAvailability(int bookId, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void displayForward() {
        Book temp = head;
        if (temp == null) {
            System.out.println("No books in library.");
            return;
        }
        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Book temp = tail;
        if (temp == null) {
            System.out.println("No books in library.");
            return;
        }
        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books: " + count);
    }

    private void printBook(Book b) {
        System.out.println("Book ID: " + b.bookId);
        System.out.println("Title: " + b.title);
        System.out.println("Author: " + b.author);
        System.out.println("Genre: " + b.genre);
        System.out.println("Availability: " + (b.isAvailable ? "Available" : "Checked Out"));
        System.out.println("-----------------------------");
    }
}
