import java.io.*;

public class Car {

    public void calculateVroom(int b) throws Exception{
        System.out.println("Speed : " + b);
        if(b < 0)
            help();
        System.out.println("Goin’ vroom");
    }



    public static void help() throws Exception {
        throw new Exception("No vroom");
    }

    // public static void main(String[] args) throws Exception {
    //     Car c = new Car();
    //     try{
    //         // if (true) {
    //         //     throw new Exception("whatever this is");
    //         // }
    //         System.out.println("Rev!!");
    //         c.calculateVroom(-4);
    //         System.out.println("faster!");
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //         System.out.println("hi");
    //     }
    // }



    public static void main(String[] args) throws Exception {
        Car c = new Car();
        try{
            System.out.println("Go!");
            c.calculateVroom(1);
            System.out.println("Vroom!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Phew!");
        }
    }
}


/*
Go!
Speed: 1
Goin' vroom
Vroom!
Phew!