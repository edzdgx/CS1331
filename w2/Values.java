public class Values {

    public static String toString(String[] a) {
        //String result = "";
        //System.out.printf("a.length == %d%n", a.length);
        String result = "[";
        for (int i = 0; i < a.length; i++) {
            // System.out.printf("a[%d] == %s%n", i, a[i]);
            //result += a[i] + ((i == a.length - 1) ? "" : ", ");  // ternary
            result += a[i] + ", ";
        }
        return result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) {
        String argsAsString = toString(args);
        System.out.println(argsAsString);
    }
}

/*        int i = 0;
        while (i < a.length) {
            System.out.printf("a[%d] == %s%n", i, a[i]);
            i++;
        }
        System.out.printf("Final value of i: %d%n", i);
*/

// ctrl + g: navigate to line x
// ctrl + o: iOpener
// debugging: 1. typos
//            2. import issues
//            3. scope issues