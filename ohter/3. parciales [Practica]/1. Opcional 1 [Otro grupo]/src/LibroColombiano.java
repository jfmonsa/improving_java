public class LibroColombiano extends Libro{
    RegionDelLibro region;
    
    //Enum regiones
    public  enum RegionDelLibro{
        Bogota, Valle, Tolima, Antioquia, Choco, Caribe, Amazonas;
    }

    //Constructor
    public LibroColombiano(String nombre, String autor, int costo, LibroColombiano.RegionDelLibro region) {
        super(nombre, autor, costo);
        this.region = region;
    }

    //Gettter & setters
    public RegionDelLibro getRegion() {
        return region;
    }
    public void setRegion(RegionDelLibro region) {
        this.region = region;
    }
}

