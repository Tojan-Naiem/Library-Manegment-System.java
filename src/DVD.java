public class DVD extends LibraryItems {

    private String language;
    private int durationMinutes;// the time in minutes

    public DVD(){
        super();
        this.durationMinutes=0;
        this.language="";
    }
    public DVD(String title,double price,int durationMinutes,String language)
    {
        super(title,price);
        this.durationMinutes=durationMinutes;
        this.language=language;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    @Override
    public void display_details(){
        super.display_details();
        System.out.println("Duration Minutes : "+this.durationMinutes);

    }

    @Override
    public String toString() {
        return super.toString()+  durationMinutes + "\n" + language +"\n";
    }
}
