package Challenge;

import java.util.List;

public class Kiosk {
    private final List<Menu> menuList;
    private final int orderMenuNumber;

    OrderList orderList = new OrderList();
    InputMenu num = new InputMenu();
    Print print = new Print();
    Check check = new Check();


    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
        this.orderMenuNumber = menuList.size() + 1;
    }

    public void start() {
        while (true) {
            // MAIN MENU 출력
            print.printMainMenu(menuList);

            // 장바구니에 메뉴가 들어있으면 ORDER MENU 출력
            if (check.isOrderListEmpty(orderList)) {
                print.printOrderMenu(orderMenuNumber);
            }

            int mainInput = num.menuNumber();

            // 0 입력시 종료
            if (mainInput == 0) {
                break;
            }

            // 예외 처리 통합
            try {
                check.isValidOrder(orderList, mainInput, orderMenuNumber); // 장바구니가 비었을 때 오더 메뉴 입력시 예외
                Handler handle = new Handler(mainInput, orderMenuNumber, menuList, orderList);
                handle.startMainProcess();
            } catch (InvalidMenuSelectionException e) {
                print.printError(e);
            }
        }
    }
}
