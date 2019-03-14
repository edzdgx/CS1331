import java.util.Scanner;
import java.io.File;
public class Histogram {

    // create array for bins
    public static int[] createBins(String filename, int bins) throws Exception {

        // create bins
        int[] out = new int[bins];
        int num = 100 / bins;  // scale for each bin
        //System.out.printf("Grade range in each bin: %d%n", num);  // debug


        // read file
        Scanner scanner = new Scanner(new File(filename));
        scanner.useDelimiter(",\\s*");  // one comma followed by 0 or spaces
        scanner.next();  // get rid of first name
        while (scanner.hasNext()) {
            int left = 100;  // highest grade
            int grade = Integer.parseInt(scanner.next().replaceAll("\\D+", ""));
            //System.out.printf("grade is ::::;::::   %d%n%n", grade);
            // replaceAll("\\D+","")) removes all non-digits
            for (int i = 0; i < bins; i++) {
                int right = left - num + 1;
                //System.out.printf("%d, %d%n", left, right);
                if (i == bins - 1) {
                    right = 0;
                }
                if (grade <= left & grade >= right) {
                    out[i] += 1;
                    break;
                }
                left = right - 1;
            }
            /*System.out.println("bins =============");
            System.out.println(out[0]);
            System.out.println(out[1]);
            System.out.println(out[2]);
            System.out.println(out[3]);
            System.out.println(out[4]);
            System.out.println(out[5]);
            System.out.println(out[6]);
            System.out.println(out[7]);
            System.out.println(out[8]);
            System.out.println(out[9]);
            System.out.println(out[98]);
            System.out.println(out[99]);*/
        }
                /*System.out.print(left);
                left -= num - 1;
                System.out.printf(", %d%n", left--);
                */
        //System.out.printf("%d, 0%n" ,left);
        return out;
    }

    // draw the histogram
    public static void drawBins(int[] array, int bins) {
        int num = 100 / bins;
        int left = 100;

        // case bins == 101
        if (bins == 101) {
            int right = 100;
            for (int i = 0; i < bins; i++) {
                if (left == 100) {
                    System.out.print("100 - 100| ");
                    for (int j = 0; j < array[i]; j++) {
                        System.out.print("[]");
                        left--;
                        right--;
                    }
                } else {
                    System.out.printf("%3d - %3d | ", left, right);
                    for (int j = 0; j < array[i]; j++) {
                        System.out.print("[]");
                        left--;
                        right--;
                    }
                }
                if (right != 0) {
                    System.out.print("\n");
                }
            }
        }

        // case bins == [0 to 100]
        for (int i = 0; i < bins; i++) {
            int right = left - num + 1;
            // the print statements depending on the digits so it aligns
            if (left == 100 & i == bins - 1) {
                right = 0;
                System.out.printf("%d -  %d | ", left, right);
                for (int j = 0; j < array[i]; j++) {
                    System.out.print("[]");
                }
            } else if (left >= 10 & i == bins - 1) {
                right = 0;
                System.out.printf(" %d -  %d | ", left, right);
                for (int j = 0; j < array[i]; j++) {
                    System.out.print("[]");
                }
            } else if (left < 10 & i == bins - 1) {
                right = 0;
                System.out.printf("  %d -  %d | ", left, right);
                for (int j = 0; j < array[i]; j++) {
                    System.out.print("[]");
                }
            } else if (left == 100 & right < 10) {
                System.out.printf("%d -   %d | ", left, right);
                for (int j = 0; j < array[i]; j++) {
                    System.out.print("[]");
                }
            } else if (left == 100 & right >= 10) {
                System.out.printf("%d - %d | ", left, right);
                for (int j = 0; j < array[i]; j++) {
                    System.out.print("[]");
                }
            } else if (left >= 10 & right >= 10) {
                System.out.printf(" %d - %d | ", left, right);
                for (int j = 0; j < array[i]; j++) {
                    System.out.print("[]");
                }
            } else if (left >= 10 & right < 10) {
                System.out.printf(" %d -  %d | ", left, right);
                for (int j = 0; j < array[i]; j++) {
                    System.out.print("[]");
                }
            } else if (left < 10 & right < 10) {
                System.out.printf("  %d -  %d | ", left, right);
                for (int j = 0; j < array[i]; j++) {
                    System.out.print("[]");
                }
            }

            if (right != 0) {
                System.out.print("\n");
            }

            left = right - 1;
        }
    }

    public static void main(String[] args) throws Exception { // main function
        int bins = 0;
        if (args.length == 2) {  // if arg[1] exists
            bins = Integer.parseInt(args[1]);  // parsing input arg to int
        } else { // if (args.length == 1) {  // if arg[1] DNE
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("How many bins would you like?");  // user in
            bins = reader.nextInt(); // store input in bins
            reader.close();
        }

        int[] array = createBins(args[0], bins);
        drawBins(array, bins);
    }
}