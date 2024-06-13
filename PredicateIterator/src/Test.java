import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = new LinkedList();
        list.add("original");
        list.add("random");
        list.add("Test");
        list.add("Ddom");
        Predicate<String> pred = new PredicateEndsWith();
        Iterator<String> it = list.iterator();
        PredicateIterator<String> test = new PredicateIterator<String>(it, pred, "dom");
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
    }
}
