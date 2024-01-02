import java.io.Serializable;

public class Author implements Serializable {

    private String authorName;
    private String authorEmail;
    private String gender;

    public Author()
    {
        this.authorName="";
        this.authorEmail="";
        this.gender="";
    }
    public Author(String authorEmail,String authorName,String gender){
        this.authorName=authorName;
        this.authorEmail=authorEmail;
        this.gender=gender;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public String getGender() {
        return gender;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public  void display_details_author()
    {
        System.out.print("Author name : "+authorName +
                "\nAuthor email" + authorEmail +
                "\nAuthor gender" + gender );
    }

    @Override
    public String toString() {
        return  authorName + '\n'  + authorEmail + "\n" +gender+"\n" ;
    }
}
