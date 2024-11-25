import java.util.List;
import java.util.stream.IntStream;

public class Kiosk {
    private final List<Menu> menuList;
    private final int orderMenuNumber;

    OrderItem orderList = new OrderItem();
    InputMenu num = new InputMenu();
    Print print = new Print();
    Check check = new Check();

    public Kiosk(List<Menu> menuList){
        this.menuList = menuList;
        this.orderMenuNumber = menuList.size()+1;
    }

    public void start() {
        while(true){
            print.printMainMenu(menuList);

            if(check.isOrderListEmpty(orderList)) {
                print.printOrderMenu(orderMenuNumber);
            }

            int mainInput = num.menuNumber();

            check.isValidMenu(mainInput,menuList,orderList);

            if (mainInput == 0) {
                break;
            }

            else if(mainInput > 0 && mainInput <= menuList.size()){
                Menu chosenMenu = menuList.get(mainInput - 1);
                int n = chosenMenu.showItem();
                if(n!=-1) {
                    MenuItem selectedItem = chosenMenu.getItem(n);
                    if (selectedItem != null) {
                        orderList.setOrderList(selectedItem);
                    }
                }
            }

            else if (mainInput == orderMenuNumber) {
                print.printTotalOrder(orderList);

                int totalCheck = num.menuNumber();


                if (totalCheck == 1) {
                    print.printDiscountChoice();

                    int discountCheck = num.menuNumber();
                    double originalPrice = orderList.getTotalPrice();
                    Discount discount = Discount.fromCode(discountCheck);
                    double discountedPrice = discount.apply(originalPrice);

                    print.printOrderCompleted(discountedPrice);

                    orderList.removeOrder();
                }
            }

            else if (mainInput == orderMenuNumber + 1) {
                orderList.removeOrder();
            }
        }
    }
}


