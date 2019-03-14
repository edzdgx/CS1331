public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    public String speak() {
        return "woof!";
    }

    public void wagTail() {
        System.out.println("(" + getName()+ " wags tail.)");
    }
}