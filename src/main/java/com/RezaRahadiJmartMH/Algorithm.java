package com.RezaRahadiJmartMH;

import java.util.*;

public class Algorithm {
    private Algorithm(){}

    public static <T> List<T> collect(T[] array, T value) {
        List<T> list = new ArrayList<T>();
        for (T t: array) {
            if(t.equals(value)) {
                list.add(t);
            }
        }
        return list;
    }

    public static <T> List<T> collect(Iterable<T> iterable, T value) {
        List<T> list = new ArrayList<T>();
        for (T t: iterable) {
            if(t.equals(value)) {
                list.add(t);
            }
        }
        return list;
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value) {
        List<T> list = new ArrayList<T>();
        while(iterator.hasNext()) {
            T t = iterator.next();
            if(t.equals(value)) {
                list.add(t);
            }
        }
        return list;
    }

    public static <T> List<T> collect(T[] array, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        for (T t: array) {
            if(pred.predicate(t)) {
                list.add(t);
            }
        }
        return list;
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        for (T t: iterable) {
            if(pred.predicate(t)) {
                list.add(t);
            }
        }
        return list;
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        while(iterator.hasNext()) {
            T t = iterator.next();
            if(pred.predicate(t)) {
                list.add(t);
            }
        }
        return list;
    }

    public static <T> int count(T[] array, T value){
        int counter = 0;
        for(T Value : array){
            if (Value.equals(value)){
                counter++;
            }
    }
    return counter;
    }

    public static <T> int count(Iterable<T> iterable, T value){
    int counter = 0;
    for(T t: iterable){
        if(t.equals(value)){
            counter = counter + 1;
        }
    }
    return counter;
    }

    public static<T> int count(Iterator<T> iterator, T value){
        int counter = 0;
        while(iterator.hasNext()){
            if(iterator.next().equals(value)){
                counter++;
            }
        }
        return counter;
    }

    public static <T> int count(T[] array, Predicate<T> pred) {
        final Iterator<T> a = Arrays.stream(array).iterator();
        return count(a, pred);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> a = iterable.iterator();
        return count(a, pred);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        return count(iterator, pred);
    }

    public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> a = Arrays.stream(array).iterator();
        return exists(a, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T nilai) {
        return exists(iterator, nilai);
    }

    public static <T> boolean exists(Iterable<T> iterable, T nilai) {
        final Iterator<T> a = iterable.iterator();
        return exists(a, nilai);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        final Iterator<T> a = Arrays.stream(array).iterator();
        return exists(a, pred);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator <T> a = iterable.iterator();
        return exists(a, pred);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        return exists(iterator, pred);
    }

    public static <T> T find(T[] array, T value) {
        final Iterator<T> a = Arrays.stream(array).iterator();
        return find(a, value);
    }

    public static <T> T find(Iterable<T> iterable, T value) {
        final Iterator <T> a = iterable.iterator();
        return find(a, value);
    }

    public static <T> T find(Iterator<T> iterator, T value) {
        final Predicate <T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(T[] array, Predicate<T> pred) {
        final Iterator<T> a = Arrays.stream(array).iterator();
        return find(a, pred);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator <T> a = iterable.iterator();
        return find(a, pred);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        return find(iterator, pred);
    }

    public static<T extends Comparable<? super T>> T max(T first, T second) {
        if(first.compareTo(second) > 0) return first;
        return second;
    }

    public static<T extends Comparable<? super T>> T max(T[] array) {
        List<T> list = Arrays.asList(array);
        return Collections.max(list);
    }

    public static<T extends Comparable<? super T>> T max(Iterable<T> iterable) {
        List<T> list = new ArrayList<T>();
        iterable.forEach(list::add);
        return Collections.max(list);
    }

    public static<T extends Comparable<? super T>> T max(Iterator<T> iterator) {
        List<T> list = new ArrayList<T>();
        iterator.forEachRemaining(list::add);
        return Collections.max(list);
    }

    public static<T extends Comparable<? super T>> T max(T first, T second, Comparator<? super T> comparator) {
        List<T> list = new ArrayList<T>();
        list.add(first);
        list.add(second);
        return Collections.max(list, comparator);
    }

    public static<T extends Comparable<? super T>> T max(T[] array, Comparator<? super T> comparator) {
        List<T> list = Arrays.asList(array);
        return Collections.max(list, comparator);
    }

    public static<T extends Comparable<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator) {
        List<T> list = new ArrayList<T>();
        iterable.forEach(list::add);
        return Collections.max(list, comparator);
    }

    public static<T extends Comparable<? super T>> T max(Iterator<T> iterator, Comparator<? super T> comparator) {
        List<T> list = new ArrayList<T>();
        iterator.forEachRemaining(list::add);
        return Collections.max(list, comparator);
    }

    public static<T extends Comparable<? super T>> T min(T first, T second) {
        if(first.compareTo(second) < 0) return first;
        return second;
    }

    public static<T extends Comparable<? super T>> T min(T[] array) {
        List<T> list = Arrays.asList(array);
        return Collections.min(list);
    }

    public static<T extends Comparable<? super T>> T min(Iterable<T> iterable) {
        List<T> list = new ArrayList<T>();
        iterable.forEach(list::add);
        return Collections.min(list);
    }

    public static<T extends Comparable<? super T>> T min(Iterator<T> iterator) {
        List<T> list = new ArrayList<T>();
        iterator.forEachRemaining(list::add);
        return Collections.min(list);
    }

    public static<T extends Comparable<? super T>> T min(T first, T second, Comparator<? super T> comparator) {
        List<T> list = new ArrayList<T>();
        list.add(first);
        list.add(second);
        return Collections.min(list, comparator);
    }

    public static<T extends Comparable<? super T>> T min(T[] array, Comparator<? super T> comparator) {
        List<T> list = Arrays.asList(array);
        return Collections.min(list, comparator);
    }

    public static<T extends Comparable<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator) {
        List<T> list = new ArrayList<T>();
        iterable.forEach(list::add);
        return Collections.min(list, comparator);
    }

    public static<T extends Comparable<? super T>> T min(Iterator<T> iterator, Comparator<? super T> comparator) {
        List<T> list = new ArrayList<T>();
        iterator.forEachRemaining(list::add);
        return Collections.min(list, comparator);
    }
/*
    public static<T extends Comparable<? super T>> T max(T first, T second) {
        if(first.compareTo(second) > 0) return first;
        return second;
    }

    public static<T extends Comparable<? super T>> T min(T first, T second) {
        if(first.compareTo(second) < 0) return first;
        return second;
    }

 */
}
