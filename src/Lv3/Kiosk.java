package Lv3;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItems;
    Scanner sc = new Scanner(System.in);
    public Kiosk(List<MenuItem> menuItems){
        this.menuItems = menuItems;
    }
    public void start(){
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
                default:
                    System.out.println("유효하지 않은 메뉴 입니다");
            }
            System.out.println();
        }
    }
}
