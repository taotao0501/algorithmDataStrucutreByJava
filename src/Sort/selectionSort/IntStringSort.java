package Sort.selectionSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IntStringSort {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(5);
        intList.add(6);
        intList.add(4);
        intList.add(7);
        intList.add(3);
        intList.add(9);

        Iterator<Integer> it = intList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("=================");
        //升序排列
        Collections.sort(intList);
        Iterator<Integer> sort_it = intList.iterator();
        while (sort_it.hasNext()) {
            System.out.println(sort_it.next());
        }

        System.out.println("=================");
        //降序排列
        Collections.reverse(intList);
        Iterator<Integer> rev_it = intList.iterator();
        while (rev_it.hasNext()) {
            System.out.println(rev_it.next());
        }
        //System.out.println("=================");

        // 字符串
        List<String> StringList = new ArrayList<>();
        StringList.add("abc");
        StringList.add("fde");
        StringList.add("ghf");
        StringList.add("ugh");
        StringList.add("xfg");

        StringList.add("aff"); //这个有点反常，倒序的时候竟然
        System.out.println("=================");
        //Collections.sort(StringList);
        Collections.reverse(StringList);
        Iterator <String> StringSort = StringList.iterator();
        while (StringSort.hasNext()) {
            System.out.println(StringSort.next());
        }
    }
}
