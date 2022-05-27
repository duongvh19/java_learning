package com.duongvh19;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N38", "N27",
                "A26", "A45",
                "B15", "B17", "B45",
                "G54", "G48", "G67", "G37", "G25", "g55"
        );

        someBingoNumbers
                .stream()
                .map(s-> s.toUpperCase())
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(s -> System.out.println(s));
        System.out.println("============");

        Stream<String> ioNumberStream = Stream.of("I26", "I27", "I45", "I60");
        Stream<String> inNumberStream = Stream.of("N40", "N48", "I26", "I27", "I45", "I60");
        Stream<String> concatStreams = Stream.concat(ioNumberStream,inNumberStream);

        System.out.println(concatStreams
                .distinct()
                .peek(s -> System.out.println(s))
                .count());

    }
}
