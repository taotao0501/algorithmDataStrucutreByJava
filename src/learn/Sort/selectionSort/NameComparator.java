package learn.Sort.selectionSort;

import java.util.Comparator;

public class NameComparator implements Comparator<Person2> {

    @Override
    public int compare(Person2 o1, Person2 o2) {
        // 按名字升序排序
        String name1 = o1.getName();
        String name2 = o2.getName();
        int n = name1.compareTo(name2);
        return n;
    }
}
