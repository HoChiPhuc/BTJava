package Qli;
import java.util.ArrayList;
import java.util.List;
public class CustomerDAO {
	private List<Customer> customers;

    public CustomerDAO() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getID() == id) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}
