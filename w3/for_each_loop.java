public class for_each_loop {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        for (int ele : array){  // for ele in array:
            ele += ele;
            System.out.println(ele);
        }
    }
}