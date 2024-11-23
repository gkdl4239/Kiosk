import java.util.List;
import java.util.stream.IntStream;

public class Kiosk {
    private final List<Menu> menuList;

    Orderitem orderList = new Orderitem();
    InputMenu num = new InputMenu();
    Print print = new Print();

    public Kiosk(List<Menu> menuList){
        this.menuList = menuList;
    }

    public void start() {
        while(true){
            print.printMainMenu(menuList);

            int orderMenuNumber = menuList.size()+1;
            if(!orderList.getOrderList().isEmpty()) {
                print.printOrderMenu(orderMenuNumber);
            }

            int orderCheck = num.menuNumber();

            if(orderCheck>=menuList.size() && orderList.getOrderList().isEmpty()){
                throw new IllegalArgumentException("유효하지 않은 메뉴 입니다");
            }

            if (orderCheck == 0) {
                break;
            }

            else if( orderCheck > 0 && orderCheck <= menuList.size()){
                Menu chosenMenu = menuList.get(orderCheck - 1);
                int n = chosenMenu.showItem();
                if(n!=-1) {
                    MenuItem selectedItem = chosenMenu.getItem(n);
                    if (selectedItem != null) {
                        orderList.setOrderList(selectedItem);
                    }
                }
            }

            else if (orderCheck == orderMenuNumber) {
                System.out.println("아래와 같이 주문 하시겠습니까?");
                System.out.println();
                System.out.println("[ Orders ]");

                IntStream.range(0,orderList.getOrderList().size())
                        .forEach(i->{
                            MenuItem orders = orderList.getOrderList().get(i);
                            String formatName = String.format("%-20s",orders.getName());
                            System.out.println((i+1)+". "+formatName+"| W "+orders.getPrice()+" | "+orders.getExp());
                        });

                System.out.println();
                System.out.println("[ Total ]");
                System.out.println("W " + orderList.getTotalPrice());

                System.out.println();
                System.out.println("1. 주문 \t 2. 메뉴판");
                int totalCheck = num.menuNumber();
                System.out.println();

                if (totalCheck == 1) {
                    System.out.println("할인 정보를 입력해주세요.");
                    System.out.println("1. 국가유공자 \t: 20%");
                    System.out.println("2. 군인 \t\t\t: 10%");
                    System.out.println("3. 학생 \t\t\t: 5%");
                    System.out.println("4. 일반 \t\t\t: 0%");

                    int discountCheck = num.menuNumber();
                    double originalPrice = orderList.getTotalPrice();
                    Discount discount = Discount.fromCode(discountCheck);
                    double discountedPrice = discount.apply(originalPrice);

                    System.out.println("주문이 완료되었습니다. 금액은 W " + discountedPrice + " 입니다.");
                    System.out.println();
                    orderList.removeOrder();
                    continue;
                } else if (totalCheck == 2) {
                    continue;
                }

            }

            else if (orderCheck == orderMenuNumber + 1) {
                orderList.removeOrder();
                continue;
            }

            else if (orderCheck > menuList.size()) {
                System.out.println("유효한 메뉴를 입력하세요");
            }


            System.out.println();
        }
    }
}


