package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import uk.ac.westminster.products_api.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    // The interface, never the implementation.
    private final ProductRepository repository;

    // One constructor, so Spring uses it automatically - no @Autowired needed.
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public void deleteProduct(Long id) {
        findById(id); // throws 404 if it is not there
        repository.delete(id);
    }

    // Business rule (search) stays in the service; only storage moved out.
    public List<Product> findByName(String name) {
        return repository.findAll().stream()
                .filter(p -> p.getName() != null && p.getName().contains(name))
                .toList();
    }

    // Business rule (10% discount on Discountable products) stays in the service.
    public List<String> getAllSummaries() {
        List<String> summaries = new ArrayList<>();
        for (Product product : repository.findAll()) {
            if (product instanceof Discountable d) {
                d.applyDiscount(0.10);
            }
            summaries.add(product.getSummary());
        }
        return summaries;
    }
}
