package org.example.Student;

import java.util.Collection;
import java.util.Optional;

public class StudentManager implements StudentProcessor {

    @Override
    public Collection<String> getDetails(Collection<Student> students) {
        // "Hanna | 23 Jahre | Durchschnittsnote: 4", "Hannes | ..."
        return students.stream()
                .map(student -> String.format(
                        "%s | %d Jahre | Durchschnittsnote: %.1f", student.name(), student.age(), student.avgGrade()))
                //student.name() + " | " + student.age() + " Jahre | Durchschnittsnote: " + student.avgGrade()))
                .toList();
    }

    @Override
    public Collection<String> findNames(Collection<Student> students, double minGrade) {
        return students.stream()
                .filter(student -> student.avgGrade() >= minGrade)
                .map(student -> student.name())
                .sorted()
                .toList();
    }

    @Override
    public Collection<String> findNames(Collection<Student> students, double minGrade, int minAge) {
        return students.stream()
                .filter(student -> student.avgGrade() >= minGrade && student.age() >= minAge)
                .sorted((studentA, studentB) -> Integer.compare(studentA.age(), studentB.age()))
                .map(student -> student.name())
                .toList();
    }

    @Override
    public double averageGrade(Collection<Student> students) {
        return students.stream().mapToDouble(student -> student.avgGrade()).average().orElse(0.0);
    }

    @Override
    public Optional<Student> findTopStudent(Collection<Student> students) {
        return students.stream().min((studentA, studentB) -> Double.compare(studentA.avgGrade(), studentB.avgGrade()));
    }

    @Override
    public boolean exists(Collection<Student> students, String name) {
        return students.stream().anyMatch(student -> student.name().equalsIgnoreCase(name));
    }

    @Override
    public Collection<Student> adjustedGrade(Collection<Student> students, double minGrade, int minAge, double adjustment) {
        return students.stream()
                .filter(student -> student.age() >= minAge)
                .map(student -> new Student(student.name(), student.age(), student.avgGrade() + adjustment))
                .filter(student -> student.avgGrade() >= minGrade)
                .sorted((studentA, studentB) -> Double.compare(studentA.avgGrade(), studentB.avgGrade()))
                .toList();
    }
}
