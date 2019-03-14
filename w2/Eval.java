import java.io.File;
import java.util.Scanner;
// import java.util.* // import everything from util package

public class Eval {

    public static void process(String line){
        System.out.println(line);
    }

    public static void main(String[] args) throws Exception{
        String fileName = args[0];  // first argument user inputs
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNext()) {
            String line = sc.nextLine();
            process(line);
        }
    }
}