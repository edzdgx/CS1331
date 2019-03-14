public class Values {
    public static void main(String[] args) {
        int x = 0;
        // if conversion can be made without any lost of info, java will do it!
        x = (int)3.14;  // type cast
        String s = "foo";
        String t = "fighters";
        String u = s + t; // = "foofighters"  concatenation
        String v = x + t; // = "2fighters"  automatically cast x to String

        int[] xs = new int[5];  // array of int of length 5 [0,0,0,0,0]
        boolean[] bs = new boolean[5];  // array of booleans [false,false,false,false,false]
        String[] ss = new String[5];  // [null,null,null,null,null]

        int[] jeanValJean = {2,4,6,0,1};  // indexing
        System.out.println(jeanValJean[0]);  // 2
        System.out.println(jeanValJean.length);  // do not need .length() for int
        // String.length(), int.length

        System.out.println(x);
        System.out.println("Yay Values!");
    }
}
