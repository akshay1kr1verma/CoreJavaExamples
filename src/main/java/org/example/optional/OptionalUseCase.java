package org.example.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalUseCase {

    public static Optional<String> emptyString = Optional.empty();
    public static Optional<String> nullableString = Optional.ofNullable(null);
    public static Optional<String> nonNullString = Optional.ofNullable("akshay");
    public static Optional<String> optionalOf = Optional.of("verma");

    public static void main(String[] args) {
        if (emptyString.isEmpty()) {
            System.out.println("empty string passed");
        }
        if (optionalOf.isPresent()) {
            System.out.println("non  null string passed value :: " + optionalOf.get());
        }
        System.out.println(" ********************  ");
        if (nullableString.isEmpty()) {
            String hello = nullableString.orElse("hello");
            System.out.println("nullableString value :: " + hello);
            System.out.println(" ********************  ");
            String supplierHello = nullableString.orElseGet(() -> {
                System.out.println("nullable string passed");
                return "nullableHello";
            });

            System.out.println("supplierHello value :: " + supplierHello);
            System.out.println(" ********************  ");
            try {
                nullableString.orElseThrow();
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(" ********************  ");
            try {
                nullableString.orElseThrow(
                        () -> new RuntimeException("Exception in nullable String, seems to be empty"));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(" ********************  ");
        }

        //Optional transformation using map
        Optional<Integer> nonNullStringLength = nonNullString.map((nonNullString) -> nonNullString.length());
        System.out.println("nonNullStringLength :: " + nonNullStringLength.get());
        System.out.println(" ********************  ");

        //Optional transformation using flatMap when lambda function is also returning Optional
        Optional<Integer> nonNullStringLengthFlatMap = nonNullString
                .flatMap((nonNullString) -> Optional.of(nonNullString.length()));
        System.out.println("nonNullStringLengthFlatMap :: " + nonNullStringLengthFlatMap.get());
        System.out.println(" ********************  ");

        //Optional transformation using filter
        Optional<String> nonNullStringFilter = nonNullString
                .filter((string) -> string.length() > 10);
        System.out.println("nonNullStringLengthFlatMap :: " + nonNullStringFilter.isPresent());
        System.out.println(" ********************  ");


        //Action based methods
        nonNullString.ifPresent((name) -> System.out.println("name :: " + name));

        emptyString.ifPresentOrElse((name) -> System.out.println("name :: " + name),
                () -> System.out.println("executing runnable command as optional is empty"));
        System.out.println(" ********************  ");

        //Optional or
        Optional<String> akshay = nullableString.or(() -> Optional.of("akshay"));
        System.out.println("akshay value :: " + akshay.get());
    }
}
