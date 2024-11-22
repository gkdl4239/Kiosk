import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Menu> menuList = Database.getMenuList();
        Kiosk kiosk = new Kiosk(menuList);
        kiosk.start();
    }
}