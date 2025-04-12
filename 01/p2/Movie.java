import java.util.*;
class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    Movie(String title, String director, int year, double rating){
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating =rating;
        this.next = null;
        this.prev = null;
    }
}
class MovieList{
    private Movie head;
    private Movie tail;
     public void addAtStart(String title, String director, int year, double rating){
         Movie newMovie = new Movie(title, director, year, rating);
         if(head == null){
             head = tail = newMovie;
         }
         else{
             newMovie.next = head;
             head.prev = newMovie;
             head = newMovie;
         }
     }
     public void addAtEnd(String title, String director, int year, double rating){
         Movie newMovie = new Movie(title, director, year, rating);
         if(tail == null){
             head = tail = newMovie;
         }
         else{
             tail.next = newMovie;
             newMovie.prev = tail;
             tail = newMovie;
         }
     }
     public void addAtPosition(int position, String title, String director, int year, double rating){
         if(position<=0){
             System.out.println("Invalid position");
             return;
         }
         if(position == 1){
             addAtStart(title, director, year, rating);
             return;
         }
         Movie newMovie = new Movie(title, director, year, rating);
         Movie current = head;
         for (int i = 1; i < position - 1 && current != null; i++) {
             current = current.next;
         }
         if (current == null || current == tail) {
             addAtEnd(title, director, year, rating);
             return;
         }
         newMovie.next = current.next;
         newMovie.prev = current;
         current.next.prev = newMovie;
         current.next = newMovie;
     }
    public void removeByTitle(String title) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Movie removed: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found: " + title);
    }

    public void searchByDirector(String director) {
        Movie current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found by director: " + director);
    }

    public void searchByRating(double rating) {
        Movie current = head;
        boolean found = false;
        while (current != null) {
            if (current.rating == rating) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Updated rating for: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found: " + title);
    }

    public void displayForward() {
        Movie current = head;
        if (current == null) {
            System.out.println("No movies in the list.");
            return;
        }
        while (current != null) {
            printMovie(current);
            current = current.next;
        }
    }

    public void displayReverse() {
        Movie current = tail;
        if (current == null) {
            System.out.println("No movies in the list.");
            return;
        }
        while (current != null) {
            printMovie(current);
            current = current.prev;
        }
    }

    private void printMovie(Movie m) {
        System.out.println("Title: " + m.title);
        System.out.println("Director: " + m.director);
        System.out.println("Year: " + m.year);
        System.out.println("Rating: " + m.rating);
        System.out.println("---------------------------");
    }
}