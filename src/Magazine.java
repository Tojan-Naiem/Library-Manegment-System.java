public class Magazine extends LibraryItems{

    private int issueNumber;

    public Magazine()
    {
        super();
        this.issueNumber=0;
    }
    public Magazine(String title,double price,int issueNumber){
        super(title,price);
        this.issueNumber=issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public void display_details(){
        super.display_details();
        System.out.println("Issue Number: "+this.issueNumber);

    }

    @Override
    public String toString() {
        return super.toString()+ issueNumber ;
    }
}
