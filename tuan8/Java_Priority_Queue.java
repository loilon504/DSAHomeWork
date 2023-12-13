import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Student {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        super();
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }
}

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.getGpa() == s2.getGpa()) {
            if (s1.getName().equals(s2.getName())) return Integer.compare(s1.getId(), s2.getId());
            return s1.getName().compareTo(s2.getName());
        }
        return -Double.compare(s1.getGpa(), s2.getGpa());
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalEvents = Integer.parseInt(scanner.nextLine());

        PriorityQueue<Student> pq = new PriorityQueue(totalEvents, new StudentComparator());
        while (totalEvents > 0) {
            String event = scanner.next();
            if (event.equals("ENTER")) {
                String name = scanner.next();
                double gpa = scanner.nextDouble();
                int id = scanner.nextInt();
                Student s = new Student(id, name, gpa);
                pq.add(s);
            }
            else {
                pq.poll();
            }

            totalEvents--;
        }
        if (pq.isEmpty()) {
            System.out.println("EMPTY");
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().getName());
        }
    }
}