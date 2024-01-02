import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static Scanner input=new Scanner(System.in);

 static LibraryFile libraryFile=new LibraryFile();
    public static void main(String[] args) {



        //add books to the library items

        // first book
        LibraryItems firstBook=new Book("Harry Potter", 30, 1, "JK@gmail.com",
                "J.K.Rowling", "female", 332, 2 ,true);
        libraryFile.addItem(firstBook);

        //second book
        libraryFile.addItem(new Book("The silent patient", 35, 1, "alex@gmail.com",
                "Alex Micharlides", "female", 325, 1,true));

        // The Third book have two authors , bc of that we make an array list
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("amal@gmail.com", "Amal EL-Mohtar", "female"));
        authors.add(new Author("max@gmail.com", "Max Gldston", "male"));

        libraryFile.addItem(new Book("This how you lose The time war", 15, 2, authors
                , 250, 4,true));

        //the fourth book
        libraryFile.addItem(new Book("Origin", 50, 1, "danBrown000@gmail.com",
                "Dan Brown", "male", 462, 3,true));


        //**************************************************************************************************
        // add songs(from CD) to the library items


        libraryFile.addItem(new Songs("Be happy", 30,20, 7,
                "English", "romantic", "jolia", true));

        libraryFile.addItem(new Songs("Nothing but the blue", 15, 10,2,
                "English", "romantic", "Sozi Albert", true));


        //****************************************************************************************************
        //Add movies to the library items

        //add actors to the first movie
        ArrayList<String> actors = new ArrayList<>();
        actors.add("Macaulty Culkue");
        actors.add("Joe Pesci");
        actors.add("Daniel Stern");

        libraryFile.addItem(new Movies("Home alone", 7, 103,
                "English", "Comedy", 3, actors, true));


        actors.clear(); // to re use the arraylist for but a new elements for another objects
        //add actors to the second movie
        actors.add("James");
        actors.add("Le Born");
        actors.add("Cina");
        libraryFile.addItem(new Movies("Small foot", 7, 96,
                "English", "Fantazy", 3, actors, true));

        actors.clear();
        //add actors to the third movie
        actors.add("Kate Winslet");
        actors.add("Jude law");
        libraryFile.addItem(new Movies("The holiday", 8, 136,
                "English", "Romantic", 2, actors, true));

        //****************************************************************************************************
       // Magazine

        LibraryItems magazine=new Magazine("By the number",50,2);
        libraryFile.addItem(magazine);




        while(true)
        {
         System.out.println("1.view");
         System.out.println("2.add");
         System.out.println("3.exit");
         int z=input.nextInt();
         int x=0;
         switch (z)
         {
          case 1:view();break;
          case 2:add();break;
          default:{
           x++;break;
          }
         }
         if(x!=0)break;

        }


//        libraryFile.putMagazineIntoMagazinesFile();
//        libraryFile.readMagazineFromMagazinesFile();
//        libraryFile.display_items("Magazine");//Write Class Name
//
//
//       libraryFile.putBookIntoBookFile();
//       libraryFile.readBookFromBookFile();
//       libraryFile.display_items("Book");//Write Class Name



    }
 public static void view() {


     System.out.println("1.Text I/O File\n2.Binary File");
     int x=input.nextInt();
     System.out.println("1.View Books");
  System.out.println("2.View DVD");
  System.out.println("3.View CD");
  System.out.println("4.View Magazine");
  int num = input.nextInt();
  switch (x)
  {
   case 1:{
    switch (num) {
     case 1: {
      libraryFile.putBookIntoBookFile();
      libraryFile.readBookFromBookFile();
      libraryFile.display_items("Book");
      break;
     }
     case 2: {
      libraryFile.putMovieIntoMoviesFile();
      libraryFile.readMovieFromMoviesFile();
      libraryFile.display_items("Movies");
      break;
     }
     case 3: {
      libraryFile.putSongIntoSongsFile();
      libraryFile.readSongFromSongsFile();
      libraryFile.display_items("Songs");
      break;
     }
     case 4: {
      libraryFile.putMagazineIntoMagazinesFile();
      libraryFile.readMagazineFromBinaryFile();
      libraryFile.display_items("Magazine");
      break;
     }
    }
    break;
   }
   case 2:
   {
    libraryFile.putLibraryIntoBinaryFile();
    switch (num) {
     case 1: {

      libraryFile.readBookFromBinaryFile();
      libraryFile.display_items("Book");
      break;
     }
     case 2: {

      libraryFile.readMoviesFromBinaryFile();
      libraryFile.display_items("Movies");
      break;
     }
     case 3: {

      libraryFile.readSongsFromBinaryFile();
      libraryFile.display_items("Songs");
      break;
     }
     case 4: {

      libraryFile.readMagazineFromBinaryFile();
      libraryFile.display_items("Magazine");
      break;
     }
    }
    break;
   }
  }

 }
 public static void add()
 {
  System.out.println("1.add Books");
  System.out.println("2.add DVD");
  System.out.println("3.add CD");
  System.out.println("4.add Magazine");
  int num = input.nextInt();

  switch (num)
  {
   case 1:
   {
    System.out.println("Enter the Title");
    String s=input.next();
    System.out.println("Enter the price");
    double price=input.nextDouble();
    System.out.println("Enter the Number of author");
    int numberOfAuthor=input.nextInt();
    if(numberOfAuthor==1)
    {
     System.out.println("Enter the name");
     String name=input.next();
     System.out.println("Enter the email");
     String email=input.next();
     System.out.println("Enter the gender");
     String gender=input.next();
     System.out.println("Enter the pages ");
     int pages=input.nextInt();
     System.out.println("Enter the number of copies ");
     int copies=input.nextInt();
     LibraryItems book=new Book(s,price,numberOfAuthor,email,name,gender,pages,copies,true);
     libraryFile.addItem(book);
    }
    else
    {
     int c=numberOfAuthor;
     ArrayList<Author>authors=new ArrayList<>();
     while(c!=0)
     {
      System.out.println("Enter the name");
      String name=input.next();
      System.out.println("Enter the email");
      String email=input.next();
      System.out.println("Enter the gender");
      String gender=input.next();
      authors.add(new Author(email,name,gender));
      c--;
     }
     System.out.println("Enter the pages ");
     int pages=input.nextInt();
     System.out.println("Enter the number of copies ");
     int copies=input.nextInt();
     LibraryItems book=new Book(s,price,numberOfAuthor,authors,pages,copies,true);
     libraryFile.addItem(book);
    }
    break;
   }
   case 2:
   {
    System.out.println("Enter the Title");
    String s=input.next();
    System.out.println("Enter the price");
    double price=input.nextDouble();
    System.out.println("Enter the Duration Minutes");
    int durationMinutes=input.nextInt();
    System.out.println("Enter the Language");
    String language=input.next();
    System.out.println("Enter the Type");
    String type=input.next();
    int numberOfActors=input.nextInt();
    if(numberOfActors==1)
    {
     System.out.println("Enter the name");
     String name=input.next();
     LibraryItems M=new Movies(s,price,durationMinutes,language,type,numberOfActors,name,true);
     libraryFile.addItem(M);
    }
    else
    {
     int c=numberOfActors;
     ArrayList<String>actors=new ArrayList<>();
     while(c!=0)
     {
      System.out.println("Enter the name");
      String name=input.next();;
      c--;
     }
     LibraryItems M=new Movies(s,price,durationMinutes,language,type,numberOfActors,actors,true);
     libraryFile.addItem(M);
    }
    break;
   }
   case 3:
   {
    System.out.println("Enter the Title");
    String s=input.next();
    System.out.println("Enter the price");
    double price=input.nextDouble();
    System.out.println("Enter the Number of tracks");
    int numberOfTracks=input.nextInt();
    System.out.println("Enter the Time");
    int durationMinutes=input.nextInt();
    System.out.println("Enter the Language");
    String language=input.next();
    System.out.println("Enter the Type");
    String type=input.next();
    System.out.println("Enter the Artist");
    String artist=input.next();

     LibraryItems M=new Songs(s,price,numberOfTracks,durationMinutes,language,type,artist,true);
     libraryFile.addItem(M);

    break;
   }
  case 4:
  {
   System.out.println("Enter the Title");
   String s=input.next();
   System.out.println("Enter the price");
   double price=input.nextDouble();
   System.out.println("Enter the issue number");
   int issueNumber=input.nextInt();

   LibraryItems M=new Magazine(s,price,issueNumber);
   libraryFile.addItem(M);

  break;
 }



  }
 }



}