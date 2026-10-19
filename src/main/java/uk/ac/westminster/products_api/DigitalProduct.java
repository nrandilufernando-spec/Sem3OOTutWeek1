package uk.ac.westminster.products_api;

public class DigitalProduct extends Product {
    private String downloadUrl;
    private double fileSizeMB;

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
}
