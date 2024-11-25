import java.util.List;

public class Check {

    public void isValidMenu(int mainInput, List<Menu>menuList, OrderItem orderList){
        if((mainInput>=menuList.size() && orderList.getOrderList().isEmpty()) || (mainInput > menuList.size()+2)){
            throw new IllegalArgumentException("유효하지 않은 메뉴 입니다");
        }
    }

    public boolean isOrderListEmpty(OrderItem orderList){
        return !orderList.getOrderList().isEmpty();
    }
}
