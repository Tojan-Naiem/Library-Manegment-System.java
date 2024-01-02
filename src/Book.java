import java.util.ArrayList;

public class Book extends LibraryItems{


    private ArrayList<Author> authors=new ArrayList<>();//make an arraylist  from a class called author that have info about them
                                                    // and why arraylist ? bc maybe one book will have more than one author
    private int numberOfAuhtor;// this variable will help me in the file
    private int pages;// the namber of pages for the book
    private int copies;// the quantity for the book
    private boolean isAvailable;// to check if available or not



    public Book()
    {
        super();
        this.pages=0;
        this.copies=0;
        this.isAvailable=true;
        this.numberOfAuhtor=0;
    }
    public Book(String title,double price ,int numberOfAuhtor,String email,String authorName,String gender
            ,int pages,int copies,boolean isAvailable)// this constructor to add one author
    {
        super(title,price);
        this.authors.add(new Author(email,authorName,gender));
        this.copies=copies;
        this.pages=pages;
        this.isAvailable=isAvailable;
        this.numberOfAuhtor=numberOfAuhtor;
    }
    public Book(String title,double price ,int numberOfAuthor,ArrayList<Author>authors,int pages,int copies,boolean isAvailable)
    // if the argument was arraylist have info about more than one author
    {
        super(title,price);
        this.authors=authors;
        this.copies=copies;
        this.pages=pages;
        this.isAvailable=isAvailable;
        this.numberOfAuhtor=numberOfAuthor;
    }
    public int getPages() {
        return pages;
    }

    public int getCopies() {
        return copies;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public void addAuthor(Author author)
    {
        this.authors.add(author);
    }
    public void setAuthor(ArrayList<Author>authors)
    {
        this.authors=authors;
    }
    public int getNumberOfAuthor()
    {
        return authors.size();
    }
    public boolean checkAvailable()// check if their has an available book from all copies
    {
        if(this.copies==0)
            return false;
         return true;
    }

    @Override
    public void display_details(){
      super.display_details();
                this.display_details_author();
                System.out.println("Pages : "+this.pages+"\nCopies : "
                +this.copies+"\nIs available : "+this.isAvailable);

    }
    public  void display_details_author()
    {
        for(Author author:authors) {
            System.out.print("Author name : "+author.getAuthorName() +
                    "\nAuthor email : " + author.getAuthorEmail() +
                    "\nAuthor gender : " + author.getGender()+"\n");
        }
    }

    @Override
    public String toString() {
        StringBuilder s=new StringBuilder();
        for(Author author:authors)
        {
            s.append(author.toString());

        }

        return super.toString()+numberOfAuhtor+"\n"+s.toString() + pages +
                "\n" + copies+"\n"+isAvailable;

    }
}
