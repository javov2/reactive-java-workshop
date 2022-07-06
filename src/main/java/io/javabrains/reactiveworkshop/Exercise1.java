package io.javabrains.reactiveworkshop;

import java.util.Optional;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("Exercise 1:");
        StreamSources.intNumbersStream()
                .forEach(integer -> System.out.print(integer + " "));
        System.out.println();

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("Exercise 2:");
        StreamSources.intNumbersStream()
                .filter(integer -> integer < 5)
                .forEach(integer -> System.out.print(integer + " "));
        System.out.println();

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("Exercise 3:");
        StreamSources.intNumbersStream()
                .filter(integer -> integer > 5)
                .limit(3)
                .skip(1)
                .forEach(integer -> System.out.print(integer + " "));
        System.out.println();

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("Exercise 4:");
        StreamSources.intNumbersStream()
                .filter(integer -> integer > 5)
                .limit(1)
                .map(integer -> Optional.of(integer).orElse(-1))
                .forEach(System.out::print);
        System.out.println();

        // Print first names of all users in userStream
        System.out.println("Exercise 5:");
        StreamSources.userStream()
                .forEach(user -> System.out.print(user.getFirstName() + " "));
        System.out.println();

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("Exercise 6:");
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream()
                        .filter(user -> user.getId() == id))
                .map(User::getFirstName)
                .forEach(name -> System.out.print(name + " "));
        System.out.println();
        System.out.println("Exercise 6 - Answer 2:");
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(id -> id == user.getId()))
                .map(user -> user.getFirstName())
                .forEach(name -> System.out.print(name + " "));
        System.out.println();

    }

}
