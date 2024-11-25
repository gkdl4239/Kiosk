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

    public double getTotalPrice(){
        double sum = 0;
        for(MenuItem item : this.orderItems){
            sum+=item.getPrice();
        }
        return sum;
    }


    public void removeOrder(){
        this.orderItems.clear();
    }
}
