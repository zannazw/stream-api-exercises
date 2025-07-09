package org.example.GermanCities;

import java.util.stream.Stream;

public class MainGermanCities {
    public static void main(String[] args) {
        var persons = Stream.of(
                new Person("Elon", new Address("Mönckebergstraße", "Hamburg")),
                new Person("Olaf", new Address("Rathausstraße", "Hamburg")),
                new Person("Angela", new Address("Schillerstraße", "Berlin")),
                new Person("Markus", new Address("Hofbräuhaus", "München")),
                new Person("Annalena", new Address("Hauptstraße", "Berlin"))
        );

        GermanCities germanCities = new GermanCities();
        System.out.println(germanCities.findAllDistinctCities(persons));

    }
}
