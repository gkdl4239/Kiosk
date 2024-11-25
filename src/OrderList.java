import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderList {
    private List<MenuItem> orderItems = new ArrayList<>();

    public void setOrderList(MenuItem menu){
        this.orderItems.add(menu);
    }

    public List<MenuItem> getOrderList(){
        return this.orderItems;
    }

    // 총 금액 계산
    public double getTotalPrice(){
        double sum = 0;
        for(MenuItem item : this.orderItems){
            sum+=item.getPrice();
        }
        return sum;
    }

    // 스트림을 활용하여 이름으로 장바구니메뉴 삭제하는 메서드
    public void removeByName(String name){
        this.orderItems = orderItems.stream()
                .filter(item -> !item.getName().equals(name))
                .collect(Collectors.toList());
    }

    public void removeOrder(){
        this.orderItems.clear();
    }
}
