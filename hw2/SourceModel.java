import java.io.FileReader;

public class SourceModel {
    private static double[][] matrix; // fields/ instance vars
    private static String model;

    public SourceModel(String source, String filename) throws Exception {
        this.matrix = new double[26][26];
        this.model = source;
        System.out.printf("Training %s model ... ", source);
        FileReader inputStream = new FileReader(filename);
        int i = inputStream.read(); // first value
        char c0 = (char) i; // first value char version

        while (!Character.isLetter(c0)) {
            i = inputStream.read();
            c0 = (char) i;
        }

        int left = Character.toLowerCase(c0) - 'a'; // row char (left)
        char c; // read through each char
        int ctoi; // convert char c to int ctoi
        while ((i = inputStream.read()) != -1) {
            c = (char) i;
            c = Character.toLowerCase(c);
            if (Character.isLetter(c)) {
                ctoi = c - 'a';
                // System.out.print(left + " ");
                // System.out.println(ctoi);
                this.matrix[left][ctoi]++;
                //System.out.print(ctoi);
                //System.out.print(c);
                left = ctoi;
            }
        }
        if (inputStream != null) {
            inputStream.close();
        }
        //printMatrix(matrix);
        //System.out.println(matrix[2][4]); // ce
        double[] rowSum = getRowSum(matrix);

        for (int ii = 0; ii < matrix[0].length; ii++) {
            for (int j = 0; j < matrix[ii].length; j++) {
                matrix[ii][j] /= rowSum[ii];
                if (matrix[ii][j] == 0.00f) {
                    matrix[ii][j] = 0.01f;
                } else if (Double.isNaN(matrix[ii][j])) {
                    matrix[ii][j] = 0.01f;
                }
                //System.out.printf("%.2f ", matrix[ii][j]);
            }
            //System.out.println();
        }
        System.out.println("done.");
    }

    public static String getName() {
        return SourceModel.model;
    }

    // returns a String representation of the matrix
    public String toString() {
        String str = "Model: " + model + "\n"; // + matrix;
        str += "     a    b    c    d    e    f    g    h    i    j    k"
        +"    l    m    n    o    p    q    r    s    t    u    v    w    x"
        +"    y    z\n";
        for (int i = 0; i < 26; i++) {
            str += String.valueOf((char)(i + 97));
            for (int j = 0; j < 26; j++) {
                str += String.format(" %.2f", matrix[i][j]);
            }
            str += "\n";
        }
        // }
        return str;
    }

    public static double probability(String test) {
        double out = 1.0;
        test = test.replaceAll("[^a-zA-Z]", "").toLowerCase(); // change lower
        //System.out.println(test);
        int left;
        int right;
        for (int i = 0; i < test.length() - 1; i++) {
            left = test.charAt(i) - 'a';
            right = test.charAt(i + 1) - 'a';
            out *= matrix[left][right];
        }

        return out;
    }

    public static double[] getRowSum(double[][] array) {
        double[] rowSum = new double[26];
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                rowSum[i] += array[i][j];
            }
            //System.out.println(rowSum[i]);
        }
        return rowSum;
    }


    public static void main(String[] args) throws Exception {
        SourceModel[] list = new SourceModel[args.length - 1];
        String filename;
        String type;
        String str = args[args.length - 1];
        double probsum = 0;
        int longest = 0;
        double[] problist = new double[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            filename = args[i];
            type = filename.split("[.]")[0];
            if (longest < type.length()) {
                longest = type.length();
            }
            list[i] = new SourceModel(type, filename);
            problist[i] = list[i].probability(str);
            probsum += problist[i];
        }
        System.out.println("Analyzing: " + str);

        String format = "%" + longest + "s";
        int index = 0;
        for (int i = 0; i < args.length - 1; i++) {
            problist[i] /= probsum;
            System.out.print("Probability that test string is  ");
            System.out.printf(format, args[i].split("[.]")[0]);
            System.out.printf(": %.2f%n", problist[i]);
            if (problist[i] > problist[index]) {
                index = i;
            }
        }
        System.out.printf("Test string is most likely %s.%n",
            args[index].split("[.]")[0]);
    }
}