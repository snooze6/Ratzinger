package rc.diego.model.persistence.VO;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Created by entakitos on 11/03/16.
 */
public class VOOrders implements List<VOOrder> {

    private List<VOOrder> orders=new LinkedList<>();

    @Override
    public void forEach(Consumer action) {
        orders.forEach(action);
    }

    @Override
    public int size() {
        return orders.size();
    }

    @Override
    public boolean isEmpty() {
        return orders.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return orders.contains(o);
    }

    @Override
    public Iterator iterator() {
        return orders.iterator();
    }

    @Override
    public Object[] toArray() {
        return orders.toArray();
    }

    @Override
    public boolean add(VOOrder o) {
        return orders.add(o);
    }

    @Override
    public boolean remove(Object o) {
        return orders.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return orders.addAll(c);
    }

    @Override
    public boolean removeIf(Predicate filter) {
        return orders.removeIf(filter);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return orders.addAll(index,c);
    }

    @Override
    public void replaceAll(UnaryOperator operator) {
        orders.replaceAll(operator);
    }

    @Override
    public void sort(Comparator c) {
        orders.sort(c);
    }

    @Override
    public void clear() {
        orders.clear();
    }

    @Override
    public VOOrder get(int index) {
        return orders.get(index);
    }

    @Override
    public VOOrder set(int index, VOOrder element) {
        return orders.set(index,element);
    }

    @Override
    public void add(int index, VOOrder element) {
        orders.add(index,element);
    }

    @Override
    public VOOrder remove(int index) {
        return orders.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return orders.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return orders.lastIndexOf(o);
    }

    @Override
    public ListIterator listIterator() {
        return orders.listIterator();
    }

    @Override
    public ListIterator listIterator(int index) {
        return orders.listIterator(index);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return orders.subList(fromIndex,toIndex);
    }

    @Override
    public Spliterator spliterator() {
        return orders.spliterator();
    }

    @Override
    public Stream stream() {
        return orders.stream();
    }

    @Override
    public Stream parallelStream() {
        return orders.parallelStream();
    }

    @Override
    public boolean retainAll(Collection c) {
        return orders.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return orders.removeAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return orders.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return orders.toArray(a);
    }
}
