package Challenge;

import Challenge.Controller.Kiosk;
import Challenge.Domain.Database;
import Challenge.Domain.Menu;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Menu> menuList = Database.getMenuList();
        Kiosk kiosk = new Kiosk(menuList);
        kiosk.start();
    }
}