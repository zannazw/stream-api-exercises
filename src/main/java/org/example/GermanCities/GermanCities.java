package org.example.GermanCities;

import java.util.List;
import java.util.stream.Stream;

public class GermanCities {

    public List<String> findAllDistinctCities(Stream<Person> stream) {
        List<String> result = stream.map(person -> person.address().city()).distinct().toList();
        return result;
    }
}
