class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketCircularList {
    private Ticket head = null;
    private Ticket tail = null;

    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }
    }

    public void removeTicket(int ticketID) {
        if (head == null) return;

        Ticket curr = head, prev = tail;

        do {
            if (curr.ticketID == ticketID) {
                if (curr == head && curr == tail) {
                    head = tail = null;
                } else if (curr == head) {
                    head = head.next;
                    tail.next = head;
                } else if (curr == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Ticket removed successfully.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Ticket ID not found.");
    }

    public void displayAllTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketID);
            System.out.println("Customer: " + temp.customerName);
            System.out.println("Movie: " + temp.movieName);
            System.out.println("Seat: " + temp.seatNumber);
            System.out.println("Time: " + temp.bookingTime);
            System.out.println("----------------------");
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByCustomerOrMovie(String keyword) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }
        boolean found = false;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + temp.ticketID);
                System.out.println("Customer: " + temp.customerName);
                System.out.println("Movie: " + temp.movieName);
                System.out.println("Seat: " + temp.seatNumber);
                System.out.println("Time: " + temp.bookingTime);
                System.out.println();
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for: " + keyword);
        }
    }

    public int totalTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}
