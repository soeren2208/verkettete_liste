package de.szut.linkedlist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
        givenAList(6, 7);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0)).isEqualTo(6);
        assertThat(list.get(1)).isEqualTo(7);
    }

    @Test
    void givenListEmptyList_WhenRemove_ThenThrowIllegalArgumentException(){
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> this.list.remove(0));
        assertThat(ex.getMessage()).isEqualTo("Index 0 out of bounds.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 1, 9})
    void givenListWithOneElement_WhenRemoveWithInvalidIndex_ThenThrowIllegalArgumentException(int index){
        list.add(6);
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> this.list.remove(index));
        assertThat(ex.getMessage()).isEqualTo("Index " + index + " out of bounds.");
    }

    @Test
    void givenListSizeOne_WhenRemove_ThenReturnValidValueAndSizeZero(){
        list.add(6);
        assertThat(list.remove(0)).isEqualTo(6);
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void givenListContainingThreeValues_WhenRemoveAtIndexOne_ThenSizeIsTwoAndReturnValidValues(){
        givenAList(6, 7, 3);
        list.remove(1);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0)).isEqualTo(6);
        assertThat(list.get(1)).isEqualTo(3);
    }

    void givenAList(Integer ... elements){
        for(Integer element : elements){
            this.list.add(element);
        }
    }
}
