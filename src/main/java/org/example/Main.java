package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Collection<Student> students = new ArrayList<>(List.of(
                new Student("Vanessa", 19, 2.0),
                new Student("Leonardo", 23, 5.0),
                new Student("Maja", 17, 2.7),
                new Student("Hannes", 28, 1.7)));

        StudentManager studentManager = new StudentManager();
        System.out.println(studentManager.getDetails(students));

        System.out.println(studentManager.findNames(students, 1));
        System.out.println(studentManager.findNames(students, 1, 18));
        System.out.println(studentManager.averageGrade(students));
        System.out.println(studentManager.findTopStudent(students));
        System.out.println(studentManager.exists(students, "Maja"));
        System.out.println(studentManager.adjustedGrade(students, 4.0, 18, -0.7));

    }
}