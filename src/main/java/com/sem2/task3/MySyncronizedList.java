package com.sem2.task3;

import java.util.*;

public class MySyncronizedList<E> implements List {
    private LinkedList<E> lst;
    public MySyncronizedList(){
        lst = new LinkedList<>();
    }
    @Override
    synchronized public int size() {
        return lst.size();
    }

    @Override
    synchronized public boolean isEmpty() {
        return lst.isEmpty();
    }

    @Override
    synchronized public boolean contains(Object o) {
        return lst.contains(o);
    }

    @Override
    synchronized public Iterator iterator() {
        return lst.iterator();
    }

    @Override
    synchronized public Object[] toArray() {
        return lst.toArray();
    }

    @Override
    synchronized public boolean add(Object o) {
        return lst.add((E) o);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return lst.remove(o);
    }

    @Override
    synchronized public boolean addAll(Collection c) {
        return lst.addAll(c);
    }

    @Override
    synchronized public boolean addAll(int index, Collection c) {
        return lst.addAll(index, c);
    }

    @Override
    synchronized public void clear() {
        lst.clear();
    }

    @Override
    synchronized public Object get(int index) {
        return lst.get(index);
    }

    @Override
    synchronized public Object set(int index, Object element) {
        return lst.set(index, (E) element);
    }

    @Override
    synchronized public void add(int index, Object element) {
        lst.add(index, (E) element);
    }

    @Override
    synchronized public Object remove(int index) {
        return lst.remove(index);
    }

    @Override
    synchronized public int indexOf(Object o) {
        return lst.indexOf((E) o);
    }

    @Override
    synchronized public int lastIndexOf(Object o) {
        return lst.lastIndexOf((E) o);
    }

    @Override
    synchronized public ListIterator listIterator() {
        return lst.listIterator();
    }

    @Override
    synchronized public ListIterator listIterator(int index) {
        return lst.listIterator(index);
    }

    @Override
    synchronized public List subList(int fromIndex, int toIndex) {
        return lst.subList(fromIndex, toIndex);
    }

    @Override
    synchronized public boolean retainAll(Collection c) {
        return lst.retainAll(c);
    }

    @Override
    synchronized public boolean removeAll(Collection c) {
        return lst.removeAll(c);
    }

    @Override
    synchronized public boolean containsAll(Collection c) {
        return lst.containsAll(c);
    }

    @Override
    synchronized public Object[] toArray(Object[] a) {
        return lst.toArray();
    }
}
