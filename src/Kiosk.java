import java.util.List;

public class Kiosk {
    private final List<Menu> menuList;

    InputMenu num = new InputMenu();

    public Kiosk(List<Menu> menuList){
        this.menuList = menuList;
    }
    public void start() {
        while(true){
            System.out.println("[ MAIN MENU ]");
            for (int i = 1; i < menuList.size() + 1; i++) {
                System.out.println(i + ". "+menuList.get(i-1).getCategoryName());
            }
            System.out.println("0. 종료");
            int choice = num.menuNumber();

            if(choice == 0){
                break;
            }else if (choice>menuList.size()){
                System.out.println("유효한 메뉴를 입력하세요");
                continue;
            }

            Menu chosenMenu = menuList.get(choice-1);
            int n = chosenMenu.showItem();
            if(n!=-1){
                chosenMenu.getItem(n);
            }
        }
    }




}


