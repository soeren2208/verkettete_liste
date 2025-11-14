package de.szut.linkedlist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LinkedListTest {
    private LinkedList<Integer> list;

    @BeforeEach
    void setUp(){
        this.list = new LinkedList();
    }

    @Test
    void givenEmptyList_whenSize_thenZero(){
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void givenEmptyList_WhenIsEmpty_thenTrue(){
        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    void givenEmptyList_WhenAdd_ThenReturnValidValueAndSizeOneAndIsNotEmpty(){
        list.add(6);
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo(6);
    }

    @Test
    void givenListSizeOne_WhenAdd_ThenReturnValidValuesAndSizeTwo(){
        list.add(6);
        list.add(7);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0)).isEqualTo(6);
        assertThat(list.get(1)).isEqualTo(7);
    }

    @Test
    void givenListEmptyList_WhenRemove_ThenReturnNull(){
        assertThat(list.remove(0)).isEqualTo(null);
    }

    @Test
    void givenListSizeOne_WhenRemove_ThenReturnValidValueAndSizeZero(){
        list.add(6);
        assertThat(list.remove(0)).isEqualTo(6);
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @Disabled
    void givenListContainingThreeValues_WhenRemoveAtIndexOne_ThenSizeIsTwoAndReturnValidValues(){
        list.add(6);
        list.add(7);
        list.add(3);
        list.remove(1);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0)).isEqualTo(6);
        assertThat(list.get(1)).isEqualTo(3);
    }
}
