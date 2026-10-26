package uk.ac.westminster.products_api;

public class DigitalProduct extends Product implements Discountable {
    private String downloadUrl;
    private double fileSizeMB;
    private double discountedPrice;

    public DigitalProduct(Long id, String name, double price,String url,double size){
        super(id,name,price); //it won't give an error when the line is removed it would make the id,name,price instance variables null
        this.downloadUrl=url;
        this.fileSizeMB=size;
    }
    public DigitalProduct(){

    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    @Override
    public String getSummary(){
        return this.getName()+" "+this.getPrice()+" "+this.getDownloadUrl()+" "+this.getFileSizeMB();
    }

    @Override
    public void applyDiscount(double rate) {
        this.discountedPrice=this.getPrice()*(1-rate);

    }

    @Override
    public double getDiscountedPrice() {
        //this.applyDiscount(50);
        return this.discountedPrice;
    }
}
