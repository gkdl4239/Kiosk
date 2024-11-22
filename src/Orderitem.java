import java.util.ArrayList;
import java.util.List;

public class Orderitem {
    private final List<MenuItem> orderList = new ArrayList<>();

    public void setOrderList(MenuItem menu){
        this.orderList.add(menu);
    }

    public List<MenuItem> getOrderList(){
        return this.orderList;
    }

    public double getTotalPrice(){
        double sum = 0;
        for(MenuItem item : this.orderList){
            sum+=item.getPrice();
        }
        return sum;
    }
    public void removeOrder(){
        this.orderList.clear();
    }
}
