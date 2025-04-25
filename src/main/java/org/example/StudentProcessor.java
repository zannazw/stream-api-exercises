package org.example;

import java.util.Collection;
import java.util.Optional;

public interface StudentProcessor {

    Collection<String> getDetails(Collection<Student> students);

    Collection<String> findNames(Collection<Student> students, double minGrade);

    Collection<String> findNames(Collection<Student> students, double minGrade, int minAge);

    double averageGrade(Collection<Student> students);

    Optional<Student> findTopStudent(Collection<Student> students);

    boolean exists(Collection<Student> students, String name);

    Collection<Student> adjustedGrade(Collection<Student> students, double minGrade, int minAge, double adjustment);
}
