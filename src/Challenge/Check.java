package Challenge;

import java.util.List;

public class Check {

    public boolean isValidMenu(int mainInput, List<Menu>menuList, OrderList orderList){
        return (mainInput>=menuList.size() && orderList.getOrderList().isEmpty()) || (mainInput > menuList.size()+2);
    }

    public boolean isOrderListEmpty(OrderList orderList){
        return !orderList.getOrderList().isEmpty();
    }
}
