public abstract class MovieType {

    private String type;
    private String typeDescrption;

    public MovieType(String type, String typeDescrption) {
        this.type = type;
        this.typeDescrption = typeDescrption;
    }

    public abstract double getPrice();

    public String getType() {
        return type;
    }

    public String getTypeDescription() {
        return typeDescrption;
    }
}