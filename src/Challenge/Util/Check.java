package Challenge.Util;


import Challenge.Domain.OrderList;
import Challenge.Exception.InvalidMenuSelectionException;

public class Check {
    // 장바구니가 비었는지 확인
    public boolean isOrderListEmpty(OrderList orderList) {
        return !orderList.getOrderList().isEmpty();
    }

    // 장바구니가 비었을때 ORDER 번호를 입력하면 예외처리
    public void isValidOrder(OrderList orderList, int mainInput, int orderMenuNumber) {
        if (orderList.getOrderList().isEmpty() && (mainInput == orderMenuNumber || mainInput == orderMenuNumber + 1)) {
            throw new InvalidMenuSelectionException();
        }
    }
}

