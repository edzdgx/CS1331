import java.util.ArrayList;
import java.util.*;

public class ArrayListGenericsDemo {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Engineer!");
        strings.add("Engineer!");
        strings.add("Helluva");
        strings.add("Engineer!");
        strings.add("Helluva");
        strings.add("Engineer!");
        strings.add("Helluva");
        strings.add("Engineer!");
        Integer BULL_DOG = Integer.MIN_VALUE;
        // Since strings is a typed collection, Java type checks
        // insertions and retrievals
        //strings.add(BULL_DOG); Won't compile
        System.out.println(strings);

        Set<String> nameSet = new HashSet<>(strings);
        System.out.println("nameSet: " + nameSet);

        // If we use a raw ArrayList, we get auto-boxing, but no auto-unboxing
        ArrayList myInts = new ArrayList();
        myInts.add(2);
        myInts.add(3);
        myInts.add("four");
        // So this won't compile - no auto-unboxing for raw collection
        // int x = myInts.get(0);
        System.out.println(myInts);

        // Notice that we don't need to repeat the type parameter in the
        // creation expression, because Java infers the type from
        // the declaration
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(new Integer(99));
        ints.add(new Integer(42));
        // As before, Java will auto-box a primitive int in an Integer
        ints.add(42);
        System.out.println(ints);

        // And since we have a typed collection, Java will also autobox
        // when we retrieve elements form the collection
        int num = ints.indexOf(42);
        System.out.println(ints.subList(1, 2));
    }

}
