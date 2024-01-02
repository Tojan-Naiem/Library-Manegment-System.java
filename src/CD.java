public class CD extends LibraryItems{


    private int numberOfTrack;
    public CD()
    {
        super();

        this.numberOfTrack=0;
    }
    public CD(String title,double price ,int numberOfTrack)
    {
        super(title,price);
        this.numberOfTrack=numberOfTrack;
    }

    public int getNumberOfTrack() {
        return numberOfTrack;
    }

    public void setNumberOfTrack(int numberOfTrack) {
        this.numberOfTrack = numberOfTrack;
    }

    @Override
    public void display_details(){
        super.display_details();
        System.out.println("Number Of Track : "+this.numberOfTrack);

    }

    @Override
    public String toString() {
        return super.toString()+ numberOfTrack+"\n";
    }
}
