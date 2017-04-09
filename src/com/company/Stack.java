package com.company;

import java.util.EmptyStackException;

/**
 * Created by matik on 31.03.2017.
 */
@SuppressWarnings("DefaultFileTemplate")
public class Stack<E> implements StackInterface<E> {
    private final Element<E> _headAndTail = new Element<>();
    private int size;

    public Stack (){
        size=0;
        _headAndTail.next=_headAndTail;

    }
    @Override
    public boolean isEmpty() {
        return size<=0;
    }


    @Override
    public E push(E o) throws StackOverflowError {
        Element<E> elem = new Element<>();
        elem.setKey(o);
        _headAndTail.attach(elem);
        size++;
        return o;
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        Object obj=_headAndTail.getNext().getKey();
        _headAndTail.detach();
        size--;
        return (E) obj;
    }

    @Override
    public E peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return (E)_headAndTail.getNext().getKey();
    }


    private final class Element<T>{
        private T key;
        private Element next;

        public Element() {
            this.key = null;
            this.next = null;

        }

        private void attach(Element e) throws NullPointerException
        {
            if (e==null) throw new NullPointerException();
            e.setNext(this.getNext());
            this.setNext(e);
        }


        private void detach ()
        {
            Element element=getNext().getNext();
            setNext(element);
        }


        private void setNext(Element next) {
            this.next = next;
        }

        private void setKey(T key) {
            this.key = key;
        }

        private Element getNext() {
            return next;
        }

        private T getKey() {
            return key;
        }

        public String toString(){ return key.toString();}



    }
}
