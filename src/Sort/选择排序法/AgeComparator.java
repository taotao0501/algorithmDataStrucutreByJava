package Sort.选择排序法;
import java.util.Comparator;

public class AgeComparator implements Comparator<Person2>{
    @Override
    public int compare(Person2 o1, Person2 o2) {
        int age1 = o1.getAge();
        int age2 = o2.getAge();
        return age1-age2;
    }
}
