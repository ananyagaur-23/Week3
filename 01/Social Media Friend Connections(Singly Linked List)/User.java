import java.util.ArrayList;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friends;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

class FriendNetwork {
    private User head;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    private User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int id1, int id2) {
        User user1 = findUser(id1);
        User user2 = findUser(id2);
        if (user1 == null || user2 == null || id1 == id2) return;

        if (!user1.friends.contains(id2)) user1.friends.add(id2);
        if (!user2.friends.contains(id1)) user2.friends.add(id1);
    }

    public void removeFriend(int id1, int id2) {
        User user1 = findUser(id1);
        User user2 = findUser(id2);
        if (user1 == null || user2 == null) return;

        user1.friends.remove(Integer.valueOf(id2));
        user2.friends.remove(Integer.valueOf(id1));
    }

    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user == null) return;

        System.out.println("Friends of " + user.name + ":");
        for (int id : user.friends) {
            User f = findUser(id);
            if (f != null)
                System.out.println(f.userId + " - " + f.name);
        }
    }

    public void findMutualFriends(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);
        if (u1 == null || u2 == null) return;

        System.out.println("Mutual Friends:");
        for (int id : u1.friends) {
            if (u2.friends.contains(id)) {
                User f = findUser(id);
                if (f != null)
                    System.out.println(f.userId + " - " + f.name);
            }
        }
    }

    public void searchUserById(int userId) {
        User u = findUser(userId);
        if (u != null)
            System.out.println("Found: " + u.userId + " " + u.name + " " + u.age);
    }

    public void searchUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name))
                System.out.println("Found: " + temp.userId + " " + temp.name + " " + temp.age);
            temp = temp.next;
        }
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friends.size() + " friends.");
            temp = temp.next;
        }
    }

    public void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.userId + " - " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}
