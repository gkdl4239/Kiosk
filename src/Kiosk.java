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

            // 범위를 벗어나는 번호 입력시 예외 처리
            if(check.isValidMenu(mainInput,menuList,orderList)){
                throw new IllegalArgumentException("유효하지 않은 번호입니다!");
            }

            // 0 입력시 종료
            if (mainInput == 0) {
                break;
            }

            // 메인 메뉴 선택 시 처리
            else if(mainInput > 0 && mainInput <= menuList.size()){
                Menu chosenMenu = menuList.get(mainInput - 1);
                int n = chosenMenu.showItem();

                // 메뉴 아이템 선택 시 처리
                if(n!=-1) {
                    MenuItem selectedItem = chosenMenu.getItem(n);

                    // 장바구니에 추가했다면 리스트에도 추가
                    if (selectedItem != null) {
                        orderList.setOrderList(selectedItem);
                    }
                }
            }

            // 주문 선택 시 처리
            else if (mainInput == orderMenuNumber) {
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
                else if(totalCheck == 3){
                    System.out.println();
                    System.out.println("장바구니에서 삭제할 메뉴의 번호를 입력해주세요(다른 번호의 같은 메뉴도 삭제)");

                    int removeItem = num.menuNumber();
                    String name = orderList.getOrderList().get(removeItem-1).getName();
                    orderList.removeByName(name);

                }
            }

            // 주문 초기화
            else if (mainInput == orderMenuNumber + 1) {
                orderList.removeOrder();
            }
        }
    }
}


