public class Soldier extends Warrior{

    private Weapons weapon;

    //Constructors
    public Soldier(String warname, Alliances alliance, SpecialAbility[] ability, Fuerza force, Weapons weapon) {
        super(warname, alliance, ability, force);
        this.weapon = weapon;
    }

    

    //Setters & getters
    public Weapons getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }
        
}
