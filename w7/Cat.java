public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    public String speak() {
        return "meow!";
    }

    public void purr() {
        System.out.println("(" + getName()+ " purrs.)");
    }
}