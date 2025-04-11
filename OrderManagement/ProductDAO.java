package Qli;
import java.util.ArrayList;
import java.util.List;
public class ProductDAO {
	private List<Product> products;

    public ProductDAO() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
