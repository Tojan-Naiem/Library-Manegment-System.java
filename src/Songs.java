public class Songs extends CD {

    private String type;
    private String artist;
    private String language;
    private int durationMinutes;
    private boolean isAvailable;//to check if the song are available or not
    public Songs()
    {
        super();
        this.type="";
        this.artist="";
        this.isAvailable=true;
    }
    public Songs(String title,double price,int numberOfTracks,int durationMinutes,String language,
                 String type,String artist,boolean isAvailable)
    {
        super(title,price,numberOfTracks);
        this.type=type;
        this.durationMinutes=durationMinutes;
        this.language=language;
        this.artist=artist;
        this.isAvailable=isAvailable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
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
        System.out.println("Artist : "+this.artist+"\ntype : "
                +this.type+"\nIs available : "+this.isAvailable);

    }

    @Override
    public String toString() {

        return  super.toString()+type + "\n"+ artist + "\n" + isAvailable;
    }
}
