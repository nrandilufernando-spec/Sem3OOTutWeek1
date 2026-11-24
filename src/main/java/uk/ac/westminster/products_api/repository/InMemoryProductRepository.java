package uk.ac.westminster.products_api.repository;

import org.springframework.stereotype.Repository;
import uk.ac.westminster.products_api.DigitalProduct;
import uk.ac.westminster.products_api.PhysicalProduct;
import uk.ac.westminster.products_api.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final Map<Long, Product> store = new HashMap<>();
    private Long nextId = 1L;

    // Seed data moved here from ProductService. save() assigns the ids.
    public InMemoryProductRepository() {
        save(new DigitalProduct(null, "windows10", 2000, "https:downloadLink", 10024));
        save(new PhysicalProduct(null, "HandBag", 10000, 4, "1000x800"));
    }

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(nextId++); // assign the id BEFORE putting it in the map
        }
        store.put(product.getId(), product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values()); // a copy, so callers cannot modify storage
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }
}
