import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryFile {
    private ArrayList<LibraryItems> libraryItems = new ArrayList<>();
    private ArrayList<LibraryItems> libraryItemsFile=new ArrayList<>();


     public LibraryFile()
     {

     }
     public void addItem(LibraryItems items)
     {
         this.libraryItems.add(items);
     }
    public void display_items(String item) // this method tp print all details for every class
    {
        int counter=0;
        System.out.println("---------"+item+"-------------");
        for(LibraryItems items:libraryItemsFile){

            if(item.equals(getItemType(items))) {
                System.out.println(++counter+".");
                items.display_details();
            }
        }
    }
    public String getItemType(LibraryItems item) //this method is to find the item
    {
        if(item instanceof Book)return "Book";
        else if(item instanceof Songs)return "Songs";
        else if(item instanceof CD)return "CD";
        else if(item instanceof Movies)return "Movies";
        else if(item instanceof Magazine)  return "Magazine";
        return "";
    }


    //*****************************************************************************************************
    // Book text I/O
    public void putBookIntoBookFile()
    {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter("Book.txt",true));
            for(LibraryItems items:libraryItems)
            {
                if(items instanceof Book)pr.println(items.toString());
            }
            pr.flush();
            pr.close();
        }
        catch (Exception e)
        {
            System.out.println("There is an error in loading to the Book file ");
        }
    }
    public   void readBookFromBookFile() {

        File file=new File("Book.txt");
        try (Scanner input = new Scanner(file)) {

            while (input.hasNextLine()) {

                String title = input.nextLine();
                double price = Double.parseDouble(input.nextLine());
                int numberOfAuthors = Integer.parseInt(input.nextLine());
                if (numberOfAuthors == 1) { // if there's one author
                    String authorEmail = input.nextLine();
                    String authorName = input.nextLine();
                    String gender = input.nextLine();
                    int pages = Integer.parseInt(input.nextLine());
                    int copies = Integer.parseInt(input.nextLine());
                    boolean isAvailable=Boolean.parseBoolean(input.nextLine());
                    libraryItemsFile.add((new Book(title, price, numberOfAuthors, authorEmail,
                            authorName, gender, pages, copies,isAvailable)));

                } else {
                    int x = numberOfAuthors;
                    ArrayList<Author> authors = new ArrayList<>();
                    while (x != 0) {
                        String authorEmail = input.nextLine();
                        String authorName = input.nextLine();
                        String gender = input.nextLine();
                        authors.add(new Author(authorEmail, authorName, gender));
                        x--;
                    }
                    int pages = Integer.parseInt(input.nextLine());
                    int copies = Integer.parseInt(input.nextLine());
                    boolean isAvailable=Boolean.parseBoolean(input.nextLine());
                    libraryItemsFile.add((new Book(title, price, numberOfAuthors, authors, pages, copies,isAvailable)));

                }

            }
            input.close();

        } catch (IOException e) {
            System.out.println("Error in Book file");
            e.printStackTrace();
        }
    }

    //*****************************************************************************************************
    // Movies text I/O
    public  void putMovieIntoMoviesFile()
    {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter("Movies.txt",true));
            for(LibraryItems items:libraryItems)
            {
                 if(items instanceof Movies)
                {
                    pr.println(items.toString());
                }
            }
            pr.flush();
        }
        catch (IOException e)
        {
            System.out.println("There is an error in loading to the Movies file ");
        }
    }
    public  void readMovieFromMoviesFile()
    {
        try(Scanner input=new Scanner(new File("Movies.txt")))
        {
            while(input.hasNextLine())
            {
                String title=input.nextLine();
                double price=Double.parseDouble(input.nextLine());
                int durationMinutes=Integer.parseInt(input.nextLine());
                String language=input.nextLine();
                String type=input.nextLine();

                int numberOfActors=Integer.parseInt(input.nextLine());
                String name=input.nextLine();
                boolean isAvailable=Boolean.parseBoolean(input.nextLine());
                libraryItemsFile.add((new Movies(title,price,durationMinutes,language,type,
                        numberOfActors,name,isAvailable)));

            }

        }
        catch (IOException e)
        {
            System.out.println("Error in Movie file");
        }

    }
    //*****************************************************************************************************
    // Songs text I/O
    public  void putSongIntoSongsFile()
    {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter("Songs.txt",true));
            for(LibraryItems items:libraryItems)
            {
                if(items instanceof Songs)
                {
                    pr.println(items.toString());
                }
            }
            pr.flush();
        }
        catch (IOException e)
        {
            System.out.println("There is an error in loading to the Songs file ");
        }
    }

    public  void readSongFromSongsFile()// For the Song File
    {
        try(Scanner input=new Scanner(new File("Songs.txt")))
        {
            while(input.hasNextLine())
            {
                String title=input.nextLine();
                double price=Double.parseDouble(input.nextLine());
                int numberOfTrack=Integer.parseInt(input.nextLine());
                int durationMinutes=Integer.parseInt(input.nextLine());
                String language=input.nextLine();
                String type=input.nextLine();
                    String artist=input.nextLine();
                    boolean isAvailable=Boolean.parseBoolean(input.nextLine());
                    libraryItemsFile.add((new Songs(title,price,numberOfTrack,durationMinutes,language,type,
                            artist,isAvailable)));
            }

        }
        catch (IOException e)
        {
            System.out.println("Error in Song file");
        }

    }
    //*****************************************************************************************************
    // Magazine text I/O
    public  void putMagazineIntoMagazinesFile()
    {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter("Magazine.txt",true));
            for(LibraryItems items:libraryItems)
            {
                if(items instanceof Magazine)
                {
                    pr.println(items.toString());
                }
            }
            pr.flush();
        }
        catch (IOException e)
        {
            System.out.println("There is an error in loading to the Songs file ");
        }
    }

    public  void readMagazineFromMagazinesFile()// For the Song File
    {
        try(Scanner input=new Scanner(new File("Magazine.txt")))
        {
            while(input.hasNextLine())
            {
                String title=input.nextLine();
                double price=Double.parseDouble(input.nextLine());
                int issueNumber=Integer.parseInt(input.nextLine());
                libraryItemsFile.add((new Magazine(title,price,issueNumber)));
            }
        }
        catch (IOException e)
        {
            System.out.println("Error in Magazine file");
        }
    }
    //*****************************************************************************************************
    //*****************************************************************************************************
    // Here I Write a one Binary file that have all data and make methods for reading every class from it
    public   void putLibraryIntoBinaryFile()
    {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Library.txt"))){
            os.writeObject(libraryItemsFile);
            os.flush();
        }
        catch (IOException e)
        {
            System.out.println(" Error in the Binary File");
        }

    }
    public  void readBookFromBinaryFile()//read the objects from the binary file
    {
        try {
            FileInputStream file=new FileInputStream("Library.txt");
            ObjectInputStream read = new ObjectInputStream(file);
            ArrayList<LibraryItems>libraryItemsNew=(ArrayList<LibraryItems>) read.readObject();
            for(LibraryItems items:libraryItemsNew)
            {
                if(items instanceof Book)
                    items.display_details();

            }
            file.close();

        }
        catch ( Exception e)
        {
            System.out.println("Error in the Binary File");
        }


    }
    public  void readMoviesFromBinaryFile()//read the objects from the binary file
    {
        try {
            FileInputStream file=new FileInputStream("Library.txt");
            ObjectInputStream read = new ObjectInputStream(file);
            ArrayList<LibraryItems>libraryItemsNew=(ArrayList<LibraryItems>) read.readObject();
            for(LibraryItems items:libraryItemsNew)
            {
                if(items instanceof Movies)
                items.display_details();

            }
            file.close();

        }
        catch ( Exception e)
        {
            System.out.println("Error in the Binary File");
        }


    }
    public  void readSongsFromBinaryFile()//read the objects from the binary file
    {
        try {
            FileInputStream file=new FileInputStream("Library.txt");
            ObjectInputStream read = new ObjectInputStream(file);
            ArrayList<LibraryItems>libraryItemsNew=(ArrayList<LibraryItems>) read.readObject();
            for(LibraryItems items:libraryItemsNew)
            {
                if(items instanceof Songs)
                items.display_details();

            }
            file.close();

        }
        catch ( Exception e)
        {
            System.out.println("Error in the Binary File");
        }


    }
    public  void readMagazineFromBinaryFile()//read the objects from the binary file
    {
        try {
            FileInputStream file=new FileInputStream("Library.txt");
            ObjectInputStream read = new ObjectInputStream(file);
            ArrayList<LibraryItems>libraryItemsNew=(ArrayList<LibraryItems>) read.readObject();
            for(LibraryItems items:libraryItemsNew)
            {
                if(items instanceof Magazine)
                    items.display_details();

            }
            file.close();

        }
        catch ( Exception e)
        {
            System.out.println("Error in the Binary File");
        }


    }
}
