package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private List<Product> products= new ArrayList<>();
    private Long nextId = 1L;
    private Product digitalProduct;

    ProductService(){
        this.digitalProduct=new DigitalProduct(1L,"windows10",2000,"https:downloadLink",10024);
    }

    public List<Product> getAllProducts(){
//        products.add(new DigitalProduct(1L,"windows10",2000,"https:downloadLink",10024));
//        products.add(new PhysicalProduct(2L,"HandBag",10000,4,"1000x800")); // super() calls the parents full constructor and intiallizes the values to the variables id,name,price which are in the Product class
        products.add(digitalProduct);
        return products;
    }

    public Product addProduct(Product product){

        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id){
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void deleteProduct(Long id){
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name){
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }
}
