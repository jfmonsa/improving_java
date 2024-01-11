public class Warrior { //Clase guerrero
    
    private String Warname;
    private Alliances alliance;
    private SpecialAbility [] ability; 
    private Fuerza force;
    
    //Constructor
    public Warrior(String warname, Alliances alliance, SpecialAbility[] ability, Fuerza force) {
        Warname = warname;
        this.alliance = alliance;
        this.ability = ability;
        this.force = force;
    }

    //Setters & Getters
    public String getWarname() {
        return Warname;
    }
    public void setWarname(String warname) {
        Warname = warname;
    }

    public Alliances getAlliance() {
        return alliance;
    }
    public void setAlliance(Alliances alliance) {
        this.alliance = alliance;
    }

    public SpecialAbility[] getAbility() {
        return ability;
    }
    public void setAbility(SpecialAbility[] ability) {
        this.ability = ability;
    }

    public Fuerza getForce() {
        return force;
    }
    public void setForce(Fuerza force) {
        this.force = force;
    }

}
