package uk.ac.westminster.products_api;

// An exception is NOT a bean: it is created with `new` at the moment
// something goes wrong, so it carries no Spring annotation.
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Product with id " + id + " was not found");
    }
}
