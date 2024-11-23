import java.util.List;

public class Print {
    public void printMainMenu(List<Menu> menuList){
        System.out.println();
        System.out.println("[ MAIN MENU ]");
        for (int i = 1; i < menuList.size() + 1; i++) {
            System.out.println(i + ". "+menuList.get(i-1).getCategoryName());
        }
        System.out.println("0. 종료");
    }

    public void printOrderMenu(int orderNumber){
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println(orderNumber + ". Orders");
        System.out.println((orderNumber+1) + ". Cancel");
    }
}
