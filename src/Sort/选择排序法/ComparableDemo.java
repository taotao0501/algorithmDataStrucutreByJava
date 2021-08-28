package Sort.选择排序法;

import java.util.*;

public class ComparableDemo {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Eakon",20));
        list.add(new Person("zhao",22));
        list.add(new Person("Kang",26));
        list.add(new Person("Yi",30));

        for(Person person:list)
            System.out.println(person.toString()); //与添加的顺序是一致的
        System.out.println("=======================");
        //下面开始排序，使用Collection.sort()
        Collections.sort(list); //显示指定比较器
        for(Person person:list)
            System.out.println(person.toString()); //排序后按照年龄从小到大
        System.out.println("========================");
        //使用TreeSet自动排序，不需要显示指定比较器，因为 TreeSet实现了SortedMap接口

        Set<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person("Eakon",20));
        treeSet.add(new Person("zhao",22));
        treeSet.add(new Person("Kang",26));
        treeSet.add(new Person("Yi",30));
        for(Person person:treeSet)
            System.out.println(person.toString());
    }
}
