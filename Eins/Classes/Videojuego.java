import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Videojuego{

    private String name;
    private Date releaseDate;
    protected String producer;
    private ArrayList<String> systems = new ArrayList<>(1);

    public Videojuego(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setReleaseDate(Date releaseDate){
        this.releaseDate = releaseDate;
        System.out.println(this.date());
    }

    public void setReleaseDate(int year, int month, int day){
        this.setReleaseDate(new GregorianCalendar(year, month, day).getTime());
    }    

    public String date(){
        return this.releaseDate.toString();
    }

   public void addSystem(String system){
       this.systems.add(0, system);
    }

    @Override
    public String toString(){
        return String.format("The video game %s", this.name);
    }
}