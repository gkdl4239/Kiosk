package Challenge;


public class Check {
    public boolean isOrderListEmpty(OrderList orderList) {
        return !orderList.getOrderList().isEmpty();
    }

    public void isValidOrder(OrderList orderList, int mainInput, int orderMenuNumber) {
        if (orderList.getOrderList().isEmpty() && (mainInput == orderMenuNumber || mainInput == orderMenuNumber + 1)) {
            throw new InvalidMenuSelectionException();
        }
    }
}

