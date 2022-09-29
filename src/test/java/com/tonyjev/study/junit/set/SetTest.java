package com.tonyjev.study.junit.set;

import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.Set;

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
}
