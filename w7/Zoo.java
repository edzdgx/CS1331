public class Zoo {

    private Animal[] animals;

    public Zoo(Animal ... animals) {
        this.animals = animals;
    }

    public Animal getAnimal(int i) {
        return animals[i];
    }

    public void soundOff() {
        for (Animal a : animals) {
            System.out.println(a.getName() + " says " + a.speak());
        }
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo(new Dog("Chloe"),
                          new Cat("Fiona"));
        zoo.soundOff();
        Animal chloe = zoo.getAnimal(0);
        ((Dog)chloe).wagTail();
    }
}