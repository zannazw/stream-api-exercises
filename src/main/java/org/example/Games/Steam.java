package org.example.Games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Steam {
    private final Collection<Game> library = new ArrayList<>();

    public Steam() {
        library.addAll(List.of(
                new Game("Horizon Zero Dawn", 743.1),
                new Game("Monkey Island 2: LeChuck's Revenge", 367.2),
                new Game("A Plague Tale: Innocence", 409.3),
                new Game("XOM 2", 664.4),
                new Game("Palworld", 1000.0), // most popular
                new Game("Return to Monkey Island", 331.5),
                new Game("Mario Kart", 782.8),
                new Game("A Plague Tale: Requiem", 535.0),
                new Game("A Way Out", 84.6),
                new Game("The Secret of Monkey Island", 567.2)
        ));
    }

    /**
     * @return a new collection of all games with acronymized names.
     * Converts the name of each game into an acronym by keeping only the first letter (or digit) of each word.
     * Example:
     * [Game("The Secret of Monkey Island", 567.2), Game("XOM 2", 664.4)] is converted into:
     * [Game("TSoMI", 567.2), Game("X2", 664.4)]
     * Note: You may solve this method without streams.
     */

    public Collection<Game> findAllGamesWithAcronymizedNames() {
        Collection<Game> gamesWithAcronymizedNames = library.stream()
                .map(game -> new Game(acronymizeName(game.name()), game.popularity())).collect(Collectors.toList());
        return gamesWithAcronymizedNames;
    }

    /*
    split each word by regex (double backslash to escape, \s for whitespaces and + for multiple following whitespaces)
     */
    public String acronymizeName(String name) {
        return Arrays.stream(name.split("\\s+")) //"Animal Crossing" -> [Animal, Crossing]; "Call of Duty" -> [Call, of, Duty]
                .filter(word -> !word.isEmpty())
                .map(word -> word.substring(0, 1)) //[A, C]; [C, o, D]
                .collect(Collectors.joining()); //"AC"; "CoD"
    }
}
