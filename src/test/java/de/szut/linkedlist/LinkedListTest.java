package de.szut.linkedlist;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LinkedListTest {

    @Test
    void givenEmptyList_whenSize_thenZero(){
        LinkedList list = new LinkedList();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void givenEmptyList_WhenIsEmpty_thenTrue(){
        LinkedList list = new LinkedList();
        assertThat(list.isEmpty()).isTrue();
    }




}
