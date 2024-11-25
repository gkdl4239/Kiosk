package Lv4Lv5;

public class MenuItem {
    private final String name;
    private final double price;
    private final String detail;

    public MenuItem(String name, double price, String detail) {
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public String getExp(){
        return this.detail;
    }
}
