package com.hackerrank.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    int getId() {
        return id;
    }

    String getFname() {
        return fname;
    }

    double getCgpa() {
        return cgpa;
    }
}

class SortStudents implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getCgpa() > s2.getCgpa())
            return -1;
        else if (s1.getCgpa() < s2.getCgpa())
            return 1;
        else {
            if (s1.getFname().compareTo(s2.getFname()) < 0)
                return -1;
            else if (s1.getFname().compareTo(s2.getFname()) > 0)
                return 1;
            else {
                return Integer.compare(s2.getId(), s1.getId());
            }
        }
    }

}

public class StudentsSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();
        SortStudents checkObj = new SortStudents();

        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        studentList.sort(checkObj);

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
        in.close();
    }
}
