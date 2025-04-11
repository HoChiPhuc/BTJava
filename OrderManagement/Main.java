package Qli;

public class Main {
	public static void main(String[] args) {

        CustomerDAO customerDAO = new CustomerDAO();
        ProductDAO productDAO = new ProductDAO();
        OrderDAO orderDAO = new OrderDAO();

        Customer customer1 = new Customer(1, "Nguyen Van A");
        customerDAO.addCustomer(customer1);

        Product product1 = new Product(1, "Laptop", 1500.0);
        Product product2 = new Product(2, "Mouse", 20.0);
        productDAO.addProduct(product1);
        productDAO.addProduct(product2);

        Order order1 = new Order(1, customer1);
        order1.addProduct(product1);
        order1.addProduct(product2);
        orderDAO.addOrder(order1);

        System.out.println("Đã thêm đơn hàng: " + order1.getId() + " cho khách hàng " + customer1.getName());

        System.out.println("\nLịch sử đơn hàng của " + customer1.getName() + ":");
        for (Order order : orderDAO.getOrdersByCustomer(customer1)) {
            System.out.println("Đơn hàng ID: " + order.getId());
            System.out.println("Sản phẩm trong đơn hàng:");
            for (Product product : order.getProducts()) {
                System.out.println("- " + product.getName() + ": $" + product.getPrice());
            }
        }

        double total = orderDAO.calculateOrderTotal(order1);
        System.out.println("\nTổng tiền đơn hàng " + order1.getId() + ": $" + total);
    }
}
