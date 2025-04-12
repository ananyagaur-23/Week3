class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
class Inventory {
    private Item head;

    public void addAtBeginning(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newItem;
    }

    public void addAtPosition(int pos, String name, int id, int quantity, double price) {
        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            addAtBeginning(name, id, quantity, price);
            return;
        }
        Item newItem = new Item(name, id, quantity, price);
        Item temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next != null)
            temp.next = temp.next.next;
        else
            System.out.println("Item not found.");
    }

    public void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                printItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchByName(String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                printItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void totalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            printItem(temp);
            temp = temp.next;
        }
    }

    public void sortBy(String key, boolean ascending) {
        head = mergeSort(head, key, ascending);
    }

    private Item mergeSort(Item head, String key, boolean asc) {
        if (head == null || head.next == null)
            return head;

        Item mid = getMiddle(head);
        Item nextOfMid = mid.next;
        mid.next = null;

        Item left = mergeSort(head, key, asc);
        Item right = mergeSort(nextOfMid, key, asc);

        return merge(left, right, key, asc);
    }

    private Item merge(Item a, Item b, String key, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        Item result;
        boolean condition;
        if (key.equals("name"))
            condition = asc ? a.name.compareToIgnoreCase(b.name) <= 0 : a.name.compareToIgnoreCase(b.name) > 0;
        else
            condition = asc ? a.price <= b.price : a.price > b.price;

        if (condition) {
            result = a;
            result.next = merge(a.next, b, key, asc);
        } else {
            result = b;
            result.next = merge(a, b.next, key, asc);
        }
        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private void printItem(Item item) {
        System.out.println("Name: " + item.name);
        System.out.println("ID: " + item.id);
        System.out.println("Quantity: " + item.quantity);
        System.out.println("Price: ₹" + item.price);
        System.out.println("----------------------");
    }
}
