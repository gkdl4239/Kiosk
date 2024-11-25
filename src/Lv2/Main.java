package Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        while (true) {
            System.out.println("[ SHAKESHACK BURGER ]");
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem menu = menuItems.get(i);
                System.out.println((i + 1) + ". " + menu.name + "\t" + "| W " + menu.price + " | " + menu.detail);
            }
            System.out.println("0. 종료\t | 종료");
            int number = sc.nextInt();

            switch (number) {
                case (1):
                    System.out.println("ShackBurger 를 선택했습니다");
                    break;
                case (2):
                    System.out.println("SmokeShack 를 선택했습니다");
                    break;
                case (3):
                    System.out.println("Cheeseburger 를 선택했습니다");
                    break;
                case (4):
                    System.out.println("Hamburger 를 선택했습니다");
                    break;
                case (0):
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
            }
        }

    }
}
