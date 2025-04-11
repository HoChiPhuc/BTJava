package Qli;
import java.util.ArrayList;
import java.util.List;
public class Order {
		private int id;
		private Customer customer;
		private List<Product> products;
		
		public Order(int id, Customer customer) {
			this.id=id;
			this.customer = customer;
			this.products = new ArrayList<>();
		}

		public int getId() {
			return id;
		}

		public Customer getCustomer() {
			return customer;
		}

		public List<Product> getProducts() {
			return products;
		}
		
		public void addProduct(Product product) {
			products.add(product);
		}
		
		public double calculateTotal() {
			double total = 0;
			for(Product product : products) {
				total += product.getPrice();
			}
			return total;
		}

}
