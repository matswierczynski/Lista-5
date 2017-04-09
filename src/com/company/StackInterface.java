package com.company;

import java.util.EmptyStackException;

/**
 * Created by matik on 31.03.2017.
 */
@SuppressWarnings("DefaultFileTemplate")
interface StackInterface<E> {
    boolean isEmpty();
    E push(E o) throws StackOverflowError;
    E pop() throws EmptyStackException;
    E peek() throws EmptyStackException;
}
