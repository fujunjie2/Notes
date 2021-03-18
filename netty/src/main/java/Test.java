import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

        Set<Integer> s = new HashSet<Integer>();


        s.add(1);
        s.add(2);

        Iterator<Integer> iterator = s.iterator();

        while (iterator.hasNext()) {
            Integer each = iterator.next();
            iterator.remove();
            System.out.println(each);
        }

        System.out.println();
    }
}
