import java.util.Scanner;
class StudentRecord {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentRecord next;

    StudentRecord(int rollNumber, String name, int age, String grade){
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList{
    private StudentRecord head;

    public void addAtStart(int rollNumber, String name, int age, String grade){
        StudentRecord newStudent = new StudentRecord(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }
    public void addAtEnd(int rollNumber, String name, int age, String grade){
        StudentRecord newStudent = new StudentRecord(rollNumber, name, age, grade);
        if(head == null){
            head = newStudent;
            return;
        }
        StudentRecord temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newStudent;
    }
    public void addAtPosition(int position, int rollNumber, String name, int age, String grade){
        if(position <= 0){
            System.out.println("Invalid Position");
            return;
        }
        if(position == 1){
            addAtStart(rollNumber, name, age, grade);
            return;
        }
        StudentRecord newStudent = new StudentRecord(rollNumber,name,age,grade);
        StudentRecord temp = head;
        for(int i = 1; i < position -1 && temp != null; i++){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Position out of Range");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }
    public void deleteRollNumber(int rollNumber){
        if(head == null){
            return;
        }
        if(head.rollNumber == rollNumber){
            head = head.next;
            return;
        }
        StudentRecord temp = head;
        while(temp.next != null && temp.next.rollNumber != rollNumber){
            temp = temp.next;
        }
        if(temp.next != null){
            temp.next = temp.next.next;
        }
        else{
            System.out.println("Student with roll number "+ rollNumber+ " not found");
        }
    }
    public void searchByRollNumber(int rollNumber){
        StudentRecord temp = head;
        while (temp != null){
            if(temp.rollNumber == rollNumber){
                System.out.println("Found "+temp.rollNumber+"\n"+temp.name+"\n"+temp.age+"\n"+temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }
    public void updateGrade(int rollNumber, String newGrade){
        StudentRecord temp = head;
        while(temp!= null){
            if(temp.rollNumber == rollNumber){
                temp.grade = newGrade;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }
    public void displayAll(){
        StudentRecord temp = head;
        if(temp == null){
            System.out.println("No student records");
            return;
        }
        while (temp != null){
            System.out.println(temp.rollNumber+"\n"+temp.name+"\n"+ temp.age+"\n"+temp.grade);
            temp = temp.next;
        }
    }
}
