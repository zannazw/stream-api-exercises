package org.example.Games;

record Game(String name, double popularity) {
    @Override
    public String toString() {
        return "Game(\"" + name + "\", " + popularity + ")";
    }

}
