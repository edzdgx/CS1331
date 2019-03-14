public class Drama extends MovieType {

    public Drama() {
        super("Drama", "sappy");
    }

    @Override
    public double getPrice() {
        return 4;
    }
}