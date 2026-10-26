package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private List<Product> products= new ArrayList<>();
    private List<String> allSummaries=new ArrayList<>();
    private Long nextId = 1L;
    private Product digitalProduct;
    private  Product physicalProduct;

    ProductService(){
        this.digitalProduct=new DigitalProduct(1L,"windows10",2000,"https:downloadLink",10024);
        this.physicalProduct=new PhysicalProduct(2L,"HandBag",10000,4,"1000x800");
    }

    public List<Product> getAllProducts(){
//        products.add(new DigitalProduct(1L,"windows10",2000,"https:downloadLink",10024));
//        products.add(new PhysicalProduct(2L,"HandBag",10000,4,"1000x800")); // super() calls the parents full constructor and intiallizes the values to the variables id,name,price which are in the Product class
        products.add(digitalProduct);
        products.add(physicalProduct);
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
// applyDiscount method is not defined inside Product classes as the products list refers to Products reference
    public List<String> getAllSummaries(){
        for(Product obj:products){
            if (obj instanceof Discountable d) {
                d.applyDiscount(0.10);
            }
            allSummaries.add(obj.getSummary());
        }
        return allSummaries;
    }
}
