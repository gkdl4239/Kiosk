package Challenge.Domain;

public class MenuItem {
    private final String name;
    private final double price;
    private final String exp;

    MenuItem(String name, double price, String exp) {
        this.name = name;
        this.price = price;
        this.exp = exp;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getExp() {
        return this.exp;
    }
}
