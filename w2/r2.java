public class r2 {
    public static void main(String[] args) {
        int i;
        String s;
        float floaty;
        boolean b;
        char c;
// 4 categories:
// whole numbers: int, int
// real numbers: float, double
// characters: char(stored as numbers in memory)
// boolean: True/False
        c = (char)('A'+1);
        b = true;
        s = "Stringy boi";
        i = 420;
        floaty = 3.14151f;
        // use the f, since decimal point numbers are doubles by default
        System.out.printf("This is a float: %.2f%nThis is a string: %s%nThis is a char: %s!!!%n", floaty, s, c);
            // System.out.print
            // System.out.println
            // System.out.printf

        // Conditions
        int x = 10;
        int y = 5;
        if (x > y) {
            System.out.println("x is greater!");
        }
        else if (y > x) {
            System.out.println("y is greater!");
        }
        else {
            System.out.println("x equals y!");
        }

        // ternary expression
        boolean someBoolean = false;
        int ifVar = 0;
        if (someBoolean) {
            ifVar = 1;
        }
        else {
            ifVar = -1;
        }
        int ternVar = 0;
        //
        ternVar = someBoolean ? 1 : -1;
        System.out.println(ternVar);

}
}




