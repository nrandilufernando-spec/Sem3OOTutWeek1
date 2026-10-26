//A PhysicalProduct IS-A Product because it uses the methods and properties of its parent class Product
//Oder would has a relationship with Products
package uk.ac.westminster.products_api;



public class PhysicalProduct extends Product implements Discountable{
    private double weightKg;
    private String dimensions;
    private double discountedPrice;

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


    /*
    Because @Override doesn’t change how the code runs; it tells the compiler “this method must override something in a parent class,”
    so if you misspell the method name or change its parameters, you get a compile error instead of a silent bug where you’ve accidentally created a brand-new method and the parent’s version keeps running.*/

    @Override
    public String getSummary(){
        return this.getName()+" "+this.getPrice()+" "+this.getWeightKg();
    }
//interfaces checks only method signature
    @Override
    public void applyDiscount(double rate) {
        double capped=Math.min(rate,0.20);
        this.discountedPrice=this.getPrice()*(1-capped);
    }

    @Override
    public double getDiscountedPrice() {
        //this.applyDiscount(40.5);
        return discountedPrice;
    }
}
