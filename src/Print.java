import java.util.List;
import java.util.stream.IntStream;

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

    public void printTotalOrder(OrderItem orderList){
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
    }

    public void printDiscountChoice(){
        System.out.println();
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자 \t: 20%");
        System.out.println("2. 군인 \t\t\t: 10%");
        System.out.println("3. 학생 \t\t\t: 5%");
        System.out.println("4. 일반 \t\t\t: 0%");
    }

    public void printOrderCompleted(double discountedPrice){
        System.out.println();
        System.out.println("주문이 완료되었습니다. 금액은 W " + discountedPrice + " 입니다.");
    }

    public void printWannaAdd(MenuItem selected){
        System.out.println();
        System.out.println("선택한 메뉴: "+selected.getName()+" | W "+selected.getPrice()+" | "+selected.getExp());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t 2. 취소");
    }
}
