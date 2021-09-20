package Sort.selectionSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Person2> list = new ArrayList<>();

        list.add(new Person2("Eakon",20));
        list.add(new Person2("zhao",22));
        list.add(new Person2("Kang",26));
        list.add(new Person2("Yi",30));
        System.out.println("排序前： ");
        for(Person2 p2:list)
            System.out.println(p2.toString());

        //按名字升序排序
        System.out.println("按名字升序排序后");
        Collections.sort(list, new NameComparator());
        for(Person2 p2:list)
            System.out.println(p2.toString());

        //按年龄降序后
        System.out.println("按年龄降序排序后");
        Collections.sort(list, new AgeComparator());
        for(Person2 p3:list)
            System.out.println(p3.toString());
    }
}
