import java.util.List;

public class Kiosk {
    private final List<Menu> menuList;

    Orderitem orderList = new Orderitem();
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

            int j = menuList.size();
            if(!orderList.getOrderList().isEmpty()) {
                System.out.println();
                System.out.println("[ ORDER MENU ]");
                System.out.println(j + ". Orders");
                System.out.println((j + 1) + ". Cancel");
            }

            int order = num.menuNumber();

            if (order == j) {
                System.out.println("아래와 같이 주문 하시겠습니까?");
                System.out.println();
                System.out.println("[ Orders ]");
                for (MenuItem orders : orderList.getOrderList()) {
                    System.out.println(orders.getName() + "\t" + "| W " + orders.getPrice() + " | " + orders.getExp());
                }

                System.out.println();
                System.out.println("[ Total ]");
                System.out.println("W " + orderList.getTotalPrice());

                System.out.println();
                System.out.println("1. 주문 \t 2. 메뉴판");
                int check = num.menuNumber();
                if (check == 1) {
                    System.out.println("주문이 완료되었습니다. 금액은 W " + orderList.getTotalPrice() + " 입니다.");
                    orderList.removeOrder();
                    continue;
                } else if (check == 2) {
                    continue;
                }
            } else if (order == j + 1) {
                orderList.removeOrder();
                continue;
            }

            System.out.println();

            if (order == 0) {
                break;
            } else if (order > menuList.size()) {
                System.out.println("유효한 메뉴를 입력하세요");
                continue;
            }

            Menu chosenMenu = menuList.get(order - 1);
            int n = chosenMenu.showItem();
            if (n != -1) {
                MenuItem selctedItem = chosenMenu.getItem(n);
                orderList.setOrderList(selctedItem);
            }
        }

    }
}


