package Lv4Lv5;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menuList;

    public Kiosk(List<Menu> menuList){
        this.menuList = menuList;
    }

    public void start(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println();
            System.out.println("[ MAIN MENU ]");

            for (int i = 1; i < menuList.size() + 1; i++) {
                System.out.println(i + ". "+menuList.get(i-1).getCategoryName());
            }
            System.out.println("0. 종료");

            int menuNumber = sc.nextInt();

            if(menuNumber>0 && menuNumber<=menuList.size()){
                Menu menu = menuList.get(menuNumber-1);

                System.out.println("[ "+menu.getCategoryName().toUpperCase()+" ]");
                menu.showMenuItem();
                System.out.println("0. 뒤로가기");

                int itemNumber = sc.nextInt();

                if(itemNumber == 0){
                    System.out.println("뒤로가기를 눌렀습니다.");
                }

                else if(itemNumber>0 && itemNumber<=menu.getMenuList().size()){
                    MenuItem pickMenu = menu.getMenuList().get(itemNumber);
                    System.out.println();
                    System.out.println("선택한 메뉴: "+pickMenu.getName()+" | W "+pickMenu.getPrice()+" | "+pickMenu.getExp());
                }

                else{
                    throw new IllegalArgumentException("유효한 번호가 아닙니다.");
                }
            }

            else if(menuNumber == 0){
                break;
            }

            else{
                throw new IllegalArgumentException("유효한 번호가 아닙니다.");
            }
        }
    }
}
