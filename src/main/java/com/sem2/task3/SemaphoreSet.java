package com.sem2.task3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Semaphore;

public class SemaphoreSet<E> implements Set {
    TreeSet<E> st;
    Semaphore sem;
    public SemaphoreSet(){
        st = new TreeSet<>();
        sem = new Semaphore(1);
    }
    @Override
    public int size() {
        try{
            sem.acquire();
            int size = st.size();
            sem.release();
            return size;
        }catch (InterruptedException e) {
            e.printStackTrace();
            sem.release();
            return 0;
        }
    }

    @Override
    public boolean isEmpty() {
        try{
            sem.acquire();
            boolean isem = st.isEmpty();
            sem.release();
            return isem;
        }catch (InterruptedException e) {
            e.printStackTrace();
            sem.release();
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        try{
            sem.acquire();
            boolean cont = st.contains(o);
            sem.release();
            return cont;
        }catch (InterruptedException e) {
            e.printStackTrace();
            sem.release();
            return false;
        }
    }

    @Override
    public Iterator iterator() {
        try{
            sem.acquire();
            Iterator iter = st.iterator();
            sem.release();
            return iter;
        }catch (InterruptedException e) {
            e.printStackTrace();
            sem.release();
            return null;
        }
    }

    @Override
    public Object[] toArray() {
        try{
            sem.acquire();
            Object[] arr = st.toArray();
            sem.release();
            return arr;
        }catch (InterruptedException e) {
            e.printStackTrace();
            sem.release();
            return null;
        }
    }

    @Override
    public boolean add(Object o) {
        try{
            sem.acquire();
            boolean res = st.add((E) o);
            sem.release();
            return res;
        }catch (InterruptedException e) {
            e.printStackTrace();
            sem.release();
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        try{
            sem.acquire();
            boolean res = st.remove(o);
            sem.release();
            return res;
        }catch (InterruptedException e) {
            e.printStackTrace();
            sem.release();
            return false;
        }
    }

    @Override
    public boolean addAll(Collection c) {
        try{
            sem.acquire();
            boolean res = st.addAll(c);
            sem.release();
            return res;
        }catch (InterruptedException e) {
            e.printStackTrace();
            sem.release();
            return false;
        }
    }

    @Override
    public void clear() {
        try{
            sem.acquire();
            st.clear();
            sem.release();
        }catch (InterruptedException e) {
            e.printStackTrace();
            sem.release();
        }
    }

    @Override
    public boolean removeAll(Collection c) {
        try{
            sem.acquire();
            boolean res = st.removeAll(c);
            sem.release();
            return res;
        }catch (InterruptedException e) {
            e.printStackTrace();
            sem.release();
            return false;
        }
    }

    @Override
    public boolean retainAll(Collection c) {
        try{
            sem.acquire();
            boolean res = st.retainAll(c);
            sem.release();
            return res;
        }catch (InterruptedException e) {
            e.printStackTrace();
            sem.release();
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection c) {
        try{
            sem.acquire();
            boolean res = st.containsAll(c);
            sem.release();
            return res;
        }catch (InterruptedException e) {
            e.printStackTrace();
            sem.release();
            return false;
        }
    }

    @Override
    public Object[] toArray(Object[] a) {
        try{
            sem.acquire();
            Object[] arr = st.toArray(a);
            sem.release();
            return arr;
        }catch (InterruptedException e) {
            e.printStackTrace();
            sem.release();
            return null;
        }
    }
}
