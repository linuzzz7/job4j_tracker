package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax2To2Then1() {
        int result = Max.max(5, 2);
        assertThat(result, is(5));
    }

    @Test
    public void whenMaxEquals() {
        int result = Max.max(2, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMaxThird() {
        int result = Max.max(1, 2, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenMaxSecond() {
        int result = Max.max(1, 5, 3, 4);
        assertThat(result, is(5));
    }

    @Test
    public void whenMaxFour() {
        int result = Max.max(1, 5, 3, 7);
        assertThat(result, is(7));
    }
}