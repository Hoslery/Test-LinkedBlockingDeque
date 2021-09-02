package ru.ac.uniyar.testingcourse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.LinkedBlockingDeque;

import static org.assertj.core.api.Assertions.*;

public class MyTest {

    //exception test
    @Test
    void exc(){
        LinkedBlockingDeque <Integer> deque = null;
        assertThatThrownBy(()->deque.offerFirst(2)).isInstanceOf(NullPointerException.class);
    }

    //Тест кейс проверяет, что offerFirst вставляет указанный элемнет вперед очереди
    @Test
    void test1(){
        LinkedBlockingDeque <Integer> deque = new LinkedBlockingDeque<Integer>(5);
        deque.add(1);
        assertThat(deque.offerFirst(5)).isTrue();
        assertThat(deque.getFirst()).isEqualTo(5);
    }


    //Тест кейс проверяет, что offerFirst нарушает оганиченность объема
    @Test
    void test2(){
        LinkedBlockingDeque <Integer> deque = new LinkedBlockingDeque<Integer>(1);
        deque.add(1);
        assertThat(deque.offerFirst(5)).isFalse();
    }


    //Тест кейс удаляет все доступные элементы из этой очереди(deque) и добавляет их к данному набору(deque1).
    @Test
    void test3(){
        LinkedBlockingDeque <Integer> deque = new LinkedBlockingDeque<Integer>(2);
        LinkedBlockingDeque <Integer> deque1 = new LinkedBlockingDeque<Integer>(3);
        deque.add(1);
        assertThat(deque.drainTo(deque1,2)).isEqualTo(1);
        assertThat(deque).hasSize(0);
    }




}
