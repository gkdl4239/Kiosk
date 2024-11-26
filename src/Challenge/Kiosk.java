package Challenge;

import java.util.List;

public class Kiosk {
    private final List<Menu> menuList;
    private final int orderMenuNumber;

    OrderList orderList = new OrderList();
    InputMenu num = new InputMenu();
    Print print = new Print();
    Check check = new Check();

    public Kiosk(List<Menu> menuList){
        this.menuList = menuList;
        this.orderMenuNumber = menuList.size()+1;
    }

    public void start() {
        while(true){
            // MAIN MENU 출력
            print.printMainMenu(menuList);

            // 장바구니에 메뉴가 들어있으면 ORDER MENU 출력
            if(check.isOrderListEmpty(orderList)) {
                print.printOrderMenu(orderMenuNumber);
            }

            int mainInput = num.menuNumber();

            // 0 입력시 종료
            if (mainInput == 0) {
                break;
            }

            // 예외 처리 통합
            try {
                check.isValidOrder(orderList,mainInput,orderMenuNumber); // 장바구니가 비었을 때 오더 메뉴 입력시 예외
                startMainProcess(mainInput);
            }
            catch (InvalidMenuSelectionException e) {
                System.out.println(e.getMessage());
                System.out.println("처음부터 다시 시작해주세요.");
            }
        }
    }

    // 핵심 프로세스
    private void startMainProcess(int mainInput){

        // 메인 메뉴 처리
        if(mainInput > 0 && mainInput <= menuList.size()){
            handleMenuSelection(mainInput);
        }

        // 오더 메뉴 처리
        else if (mainInput == orderMenuNumber){
            handleOrderMenu();
        }

        // 주문 초기화
        else if (mainInput == orderMenuNumber + 1){
            orderList.removeOrder();
            System.out.println("장바구니를 비었습니다");
        }

        // 예외
        else{
            throw new InvalidMenuSelectionException();
        }
    }

    // 메인 메뉴 선택 시 처리
    private void handleMenuSelection(int mainInput) {

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
                System.out.println(selectedItem.getName() + " 이 장바구니에 추가되었습니다.");
                orderList.setOrderList(selectedItem);
            }

            // 취소
            else if (wannaAdd == 2) {
                System.out.println("취소되었습니다.");
            }

            // 예외
            else {
                throw new InvalidMenuSelectionException();
            }
        }

        // 예외
        else{
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
        }

        // 장바구니 메뉴 삭제
        else if (totalCheck == 3) {
            System.out.println();
            System.out.println("장바구니에서 삭제할 메뉴의 번호를 입력해주세요(다른 번호의 같은 메뉴도 삭제)");

            int removeItem = num.menuNumber();
            String name = orderList.getOrderList().get(removeItem - 1).getName();
            orderList.removeByName(name);
        }
    }
}


