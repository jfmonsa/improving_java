public class Pelicula {
    public String name, description;
    public double length;
    public Topic topic;
    public static final int price = 1000;

    public enum Topic{
        Accion, Romance, Drama;
    }

    //Constructor
    public Pelicula(String name, String description, double length, Pelicula.Topic topic) {
        this.name = name;
        this.description = description;
        this.length = length;
        this.topic = topic;
    }

    //Getters & setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public Topic getTopic() {
        return topic;
    }
    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    public static int getPrice() {
        return price;
    }

    //To string
    @Override
    public String toString() {
        return "Pelicula [name=" + name + ", description=" + description + ", length=" + length + ", topic=" + topic
                + "]";
    }
        
}
