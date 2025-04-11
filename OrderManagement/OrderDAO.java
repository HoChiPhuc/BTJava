package Qli;
import java.util.ArrayList;
import java.util.List;
public class OrderDAO {
	private List<Order> orders;

    public OrderDAO() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
        order.getCustomer().addOrder(order); 
    }

    public List<Order> getOrdersByCustomer(Customer customer) {
        return customer.getOrders();
    }

    
    public double calculateOrderTotal(Order order) {
        return order.calculateTotal();
    }

    public Order findOrderById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }
}
