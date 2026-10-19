//A PhysicalProduct IS-A Product because it uses the methods and properties of its parent class Product
//Oder would has a relationship with Products
package uk.ac.westminster.products_api;



public class PhysicalProduct extends Product{
    private double weightKg;
    private String dimensions;

    public PhysicalProduct(Long id, String name, double price,double weight,String dimensions){
        super(id,name,price);
        this.weightKg=weight;
        this.dimensions=dimensions;

    }
    public PhysicalProduct(){

    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}
