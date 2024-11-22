import java.util.ArrayList;
import java.util.List;

public class Orderitem {
    private List<MenuItem> orderList = new ArrayList<>();

    public void setOrderList(MenuItem menu){
        this.orderList.add(menu);
    }

    public List<MenuItem> getOrderList(){
        return this.orderList;
    }
}
