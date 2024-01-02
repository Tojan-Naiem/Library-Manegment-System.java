import java.io.Serializable;

public class LibraryItems implements Serializable {

    private String title;
    private double price;



    public LibraryItems()
    {
        this.title="";
        this.price=0;
    }
    public LibraryItems(String title,double price)
    {
        this.title=title;
        this.price=price;
    }
    public void display_details(){

        System.out.println("Title : "+this.title+"\nPrice : "+this.price);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return   title + "\n"+ price+"\n";

    }
}
