import java.util.Optional;

public class PlayStationGame extends Videojuego{
    
    private String generation, classification;
    public PlayStationGame(String name, String classification, String generation){
        super(name);
        this.generation = generation;
        this.classification = classification;
        //this.producer = producer;
    }

    public PlayStationGame(String generation, String classfication, String name, String producer){
        this(generation, classfication, name);
        this.producer = producer;
    }

    @Override
    public String toString(){
        return String.format("The playstation game %s developed by %s",this.getName(), this.producer);
    }        
}
