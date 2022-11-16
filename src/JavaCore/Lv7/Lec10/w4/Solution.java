package JavaCore.Lv7.Lec10.w4;

import java.util.*;

/*
Общий список
1. Изменить класс Solution так, чтобы он стал списком. (Необходимо реализовать интерфейс java.util.List).
2. Список Solution должен работать только с целыми числами Long.
3. Воспользуйся полем original.
4. Список будет использоваться нитями, поэтому позаботься, чтобы все методы были синхронизированы.

Требования:
•	Класс Solution должен реализовывать интерфейс List<Long>.
•	Класс Solution должен содержать private поле original типа ArrayList<Long>.
•	Все переопределенные в классе Solution методы интерфейса List должны вызывать соответствующие методы объекта original.
•	Все методы класса Solution, кроме метода main, должны быть синхронизированы.
*/

public class Solution implements List<Long> {
    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {

    }

    @Override
    public synchronized int size() {
        return original.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return original.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return original.contains(o);
    }

    @Override
    public synchronized Iterator iterator() {
        return original.iterator();
    }

    @Override
    public synchronized Object[] toArray() {
        return original.toArray();
    }

    @Override
    public synchronized <Long> Long[] toArray(Long[] a) {
        return original.toArray(a);
    }

    @Override
    public synchronized boolean add(Long aLong) {
        return original.add(aLong);
    }

    @Override
    public synchronized boolean remove(Object o) {
        if (o instanceof Long) {
            return original.remove((Long) o);
        }
        return false;
    }

    @Override
    public synchronized boolean addAll(Collection c) {
        return original.addAll(c);
    }

    @Override
    public synchronized boolean addAll(int index, Collection c) {
        return original.addAll(index, c);
    }

    @Override
    public synchronized void clear() {
        original.clear();

    }

    @Override
    public synchronized Long get(int index) {
        return original.get(index);
    }

    @Override
    public synchronized Long set(int index, Long element) {
        return original.set(index, element);
    }

    @Override
    public synchronized void add(int index, Long element) {
        original.add(index, element);
    }

    @Override
    public synchronized Long remove(int index) {
        return original.remove(index);
    }


    @Override
    public synchronized int indexOf(Object o) {
        return original.indexOf(o);
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        return original.lastIndexOf(o);
    }

    @Override
    public synchronized ListIterator listIterator() {
        return original.listIterator();
    }

    @Override
    public synchronized ListIterator listIterator(int index) {
        return original.listIterator();
    }

    @Override
    public synchronized List subList(int fromIndex, int toIndex) {
        return original.subList(fromIndex, toIndex);
    }

    @Override
    public synchronized boolean retainAll(Collection c) {
        return original.retainAll(c);
    }

    @Override
    public synchronized boolean removeAll(Collection c) {
        return original.removeAll(c);
    }

    @Override
    public synchronized boolean containsAll(Collection c) {
        return original.containsAll(c);
    }

}
