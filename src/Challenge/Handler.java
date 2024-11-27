package Challenge;

import java.util.List;

public class Handler {
    private final int mainInput;
    private final int orderMenuNumber;
    private final List<Menu> menuList;
    private final OrderList orderList;

    InputMenu num = new InputMenu();
    Print print = new Print();

    public Handler(int mainInput,int orderMenuNumber, List<Menu> menuList,OrderList orderList){
        this.mainInput = mainInput;
        this.menuList = menuList;
        this.orderList = orderList;
        this.orderMenuNumber = orderMenuNumber;
    }

    // 핵심 프로세스
    public void startMainProcess() {

        // 메인 메뉴 처리
        if (mainInput > 0 && mainInput <= menuList.size()) {
            handleMenuSelection();
        }

        // 오더 메뉴 처리
        else if (mainInput == orderMenuNumber) {
            handleOrderMenu();
        }

        // 주문 초기화
        else if (mainInput == orderMenuNumber + 1) {
            orderList.removeOrder();
            print.printResetOrder();
        }

        // 예외
        else {
            throw new InvalidMenuSelectionException();
        }
    }

    // 메인 메뉴 선택 시 처리
    private void handleMenuSelection() {

        Menu pickMenu = menuList.get(mainInput - 1);
        pickMenu.showItem();

        int pickItem = num.menuNumber();

        // 메뉴 아이템 선택 시 처리
        if (pickItem > 0 && pickItem <= pickMenu.getItemList().size()) {
            MenuItem selectedItem = pickMenu.getItem(pickItem);

            print.printWannaAdd(selectedItem);

            int wannaAdd = num.menuNumber();

            // 장바구니에 추가
            if (wannaAdd == 1) {
                print.printAddComplete(selectedItem);
                orderList.setOrderList(selectedItem);
            }

            // 취소
            else if (wannaAdd == 2) {
                print.printCanceled();
            }

            // 예외
            else {
                throw new InvalidMenuSelectionException();
            }
        }

        // 예외
        else {
            throw new InvalidMenuSelectionException();
        }
    }

    // 주문 선택 시 처리
    private void handleOrderMenu() {

        print.printTotalOrder(orderList);

        int totalCheck = num.menuNumber();

        // 주문 확정 시 할인 선택
        if (totalCheck == 1) {
            print.printDiscountChoice();

            // Enum을 이용한 할인율 로직
            int discountCheck = num.menuNumber();
            double originalPrice = orderList.getTotalPrice();
            Discount discount = Discount.fromCode(discountCheck);
            double discountedPrice = discount.apply(originalPrice);

            print.printOrderCompleted(discountedPrice);

            orderList.removeOrder();
        } else if (totalCheck == 2) {
            print.printSelectAddition();
        }

        // 장바구니 메뉴 삭제
        else if (totalCheck == 3) {
            print.printRemoveNumber();

            int removeItem = num.menuNumber();

            //예외
            if (removeItem >= orderList.getOrderList().size()) {
                throw new InvalidMenuSelectionException();
            }

            String name = orderList.getOrderList().get(removeItem - 1).getName();
            orderList.removeByName(name);
        } else {
            throw new InvalidMenuSelectionException();
        }
    }
}
