package Challenge.Domain;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final List<Menu> menuList = new ArrayList<>();

    static {
        // Burger 카테고리 생성
        Menu Burger = new Menu("Burger");
        Burger.setItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        Burger.setItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        Burger.setItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        Burger.setItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Drinks 카테고리 생성
        Menu Drinks = new Menu("Drinks");
        Drinks.setItem(new MenuItem("Sprite", 2.5, "청량한 스프라이트"));
        Drinks.setItem(new MenuItem("ZeroCoke", 2.5, "시원한 제로코카콜라"));
        Drinks.setItem(new MenuItem("Iced Tea", 3.0, "달콤한 아이스티"));

        // Desserts 카테고리 생성
        Menu Desserts = new Menu("Desserts");
        Desserts.setItem(new MenuItem("Vanilla Shake", 5.0, "바닐라 맛 쉐이크"));
        Desserts.setItem(new MenuItem("Chocolate Shake", 5.0, "초콜릿 맛 쉐이크"));

        // 메뉴 리스트에 카테고리 추가
        menuList.add(Burger);
        menuList.add(Drinks);
        menuList.add(Desserts);
    }

    public static List<Menu> getMenuList() {
        return menuList;
    }
}
