package com.bismark.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class MainOptional {

    public static void main(String[] args) throws Throwable {
        test_1();
        test_2();
    }

    public static void test_1() {
        try {
            Optional emptyOptional = Optional.empty();
            System.out.println(emptyOptional.get());

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void test_2() throws Throwable {
        String val = null;
        Optional optional = Optional.ofNullable(val);
        System.out.println(optional.orElse("test"));
        System.out.println(optional.isPresent());
        optional.orElseThrow(IllegalArgumentException::new);
    }
}
