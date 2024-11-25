import java.util.List;

public class Check {

    public boolean isValidMenu(int mainInput, List<Menu>menuList, OrderItem orderList){
        return (mainInput>=menuList.size() && orderList.getOrderList().isEmpty()) || (mainInput > menuList.size()+2);
    }

    public boolean isOrderListEmpty(OrderItem orderList){
        return !orderList.getOrderList().isEmpty();
    }
}
