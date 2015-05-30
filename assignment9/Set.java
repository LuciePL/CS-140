package assignment09;

import java.util.TreeSet;

public class Set<T> {
    java.util.Set<T> s;

    public Set() {
        this.s = new TreeSet<T>();
    }

    public void add(T e) {
        this.s.add(e);
    }

    public boolean contains(T t) {
        return this.s.contains(t);
    }

    public java.util.Set<T> getSet() {
        return this.s;
    }
}
