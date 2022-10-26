public class Archer extends Warrior{

    private Weapons weapon;
    private int numAmmo;
    
    
    //Constructor
    public Archer(String warname, Alliances alliance, SpecialAbility[] ability, Fuerza force, Weapons weapon,
            int numAmmo) {
        super(warname, alliance, ability, force);
        this.weapon = weapon;
        this.numAmmo = numAmmo;
    }


    //Setter & getters
    public Weapons getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }


    public int getNumAmmo() {
        return numAmmo;
    }
    public void setNumAmmo(int numAmmo) {
        this.numAmmo = numAmmo;
    }   
  
}
