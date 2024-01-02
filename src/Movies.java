import java.util.ArrayList;

public class Movies extends DVD {


    private String type;
    private ArrayList<String>actors=new ArrayList<>();
    private int numberOfActors;//this will help me in the FILE
    private boolean isAvailable;

    public Movies()
    {
        super();
        this.type="";
        this.isAvailable=true;
        this.numberOfActors=0;
    }
    public Movies(String title,double price,int durationMinutes,String language,String type,int numberOfActors,String actor
            ,boolean isAvailable)
    {
        super(title,price,durationMinutes,language);
        this.type=type;
        this.actors.add(actor);
        this.isAvailable=isAvailable;
        this.numberOfActors=numberOfActors;

    }
    public Movies(String title,double price,int durationMinutes,String language,String type,int numberOfActors,ArrayList<String>actors
    ,boolean isAvailable)
    {
        super(title,price,durationMinutes,language);
        this.type=type;
        this.actors=actors;
        this.numberOfActors=numberOfActors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public void addActors(String actor){this.actors.add(actor);}
    public ArrayList<String>getActors()
    {
        return actors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public void display_details(){
        super.display_details();
        System.out.println("Actors : "+this.actors+"\ntype : "
                +this.type+"\nIs available : "+this.isAvailable);

    }

    @Override
    public String toString() {

        return  super.toString()+type + "\n" +numberOfActors+"\n"+ actors +"\n" + isAvailable ;

    }
}
