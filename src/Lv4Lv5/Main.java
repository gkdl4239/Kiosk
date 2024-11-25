package Lv4Lv5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Menu> menuList = new ArrayList<>();

        Menu burger = new Menu("Burgers");
        Menu drink = new Menu("Drinks");
        Menu dessert = new Menu("Desserts");

        burger.setItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burger.setItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burger.setItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burger.setItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        drink.setItem(new MenuItem("Sprite", 2.5, "청량한 스프라이트"));
        drink.setItem(new MenuItem("ZeroCoke", 2.5, "시원한 제로코카콜라"));
        drink.setItem(new MenuItem("Iced Tea", 3.0, "달콤한 아이스티"));

        dessert.setItem(new MenuItem("Vanilla Shake", 5.0, "바닐라 맛 쉐이크"));
        dessert.setItem(new MenuItem("Chocolate Shake", 5.0, "초콜릿 맛 쉐이크"));

        menuList.add(burger);
        menuList.add(drink);
        menuList.add(dessert);

        Kiosk kiosk = new Kiosk(menuList);
        kiosk.start();
    }
}
