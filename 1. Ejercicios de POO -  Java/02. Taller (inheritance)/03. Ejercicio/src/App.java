
public class App {

    public static void allianceCounter(Warrior[] characters){
        System.out.println("\n*****************************************************");
        int al1Cont=0;
        int al2Cont=0;
        int al3Cont=0;

        for(Warrior character : characters){
            if(character.getAlliance()==Alliances.Elfos) al1Cont++;
            else if(character.getAlliance()==Alliances.Terranova) al2Cont++;
            else al3Cont++;
        }

        //Hacer comparaciones
        if(al1Cont>al2Cont && al1Cont>al3Cont){ 
            System.out.println("La alianza con mas guerreros es: " + Alliances.Elfos);
        }else {if(al2Cont>al1Cont && al2Cont>al3Cont){
                System.out.println("La alianza con mas guerreros es: " + Alliances.Terranova);
            }else {if(al3Cont>al1Cont && al3Cont>al2Cont){
                    System.out.println("La alianza con mas guerreros es: " + Alliances.Horda);
                }else System.out.println("Todas las alianzas tienen la misma cantidad de guerreros");
            }
        }
        System.out.println("*****************************************************\n");
    }



    public static void mostAbilityUsed(Warrior[] characters){
        System.out.println("\n*****************************************************");
        int cont1=0;
        int cont2=0;
        int cont3=0;
        int cont4=0;
        int cont5=0;
        int cont6=0;
        
        for(Warrior ch: characters){
            for(int i=0; i < ch.getAbility().length; i++){
                SpecialAbility x=ch.getAbility()[i];
                switch(x){
                    case InstaKill:
                        cont1++;break;
                    case MaxDamage:
                        cont2++;break;
                    case PsycoKiller:
                        cont3++;break;
                    case maxAmmo:
                        cont4++;break;
                    case TNTDAncer:
                        cont5++;break;
                    case noDamage:
                        cont6++;break;
                }
            }
        }

        //Habilidad más usada
        int valMax=Math.max(cont1, Math.max(cont2, Math.max(cont3, Math.max(cont4, Math.max(cont5, cont6)))));
        String textoPred="La Habilidad más usada es: ";
        
        if(cont1==cont2 || cont1==cont3 || cont1==cont4 || cont1==cont5 || cont1==cont6 || cont2==cont3
        || cont2==cont4 || cont1==cont5 || cont1==cont6 || cont3==cont4 || cont3==cont5 || cont3==cont6
        || cont4==cont5 || cont4==cont6 || cont5==cont6) System.out.println("Dos o mas habilidades tienen igual frecuencia");
        
        if(valMax==cont1) System.out.println(textoPred+SpecialAbility.InstaKill);
        else if(valMax==cont2) System.out.println(textoPred+SpecialAbility.MaxDamage);
        else if(valMax==cont3) System.out.println(textoPred+SpecialAbility.PsycoKiller);
        else if(valMax==cont4) System.out.println(textoPred+SpecialAbility.maxAmmo);
        else if(valMax==cont5) System.out.println(textoPred+SpecialAbility.TNTDAncer);
        else System.out.println(textoPred+SpecialAbility.noDamage);

        System.out.println("*****************************************************\n");
    }

    public static void LeastCommonForce(Soldier[] soldiers){
        System.out.println("\n*****************************************************");
        int frS1 = 0;
        int frS2 = 0;
        int frS3 = 0;
        
        for(Warrior s: soldiers){
            Fuerza f=s.getForce();
            switch(f){
                case Cien:
                    frS1++;break;
                case Doscientos:
                    frS2++;break;
                case Trecientos:
                    frS3++;break;
            }
        }
        
        int valMax2=Math.min(frS1, Math.min(frS2, frS3));
        String defaultText="La fuerza menos comun es: ";
        if(frS1==frS2 || frS1==frS3 || frS2==frS3) System.out.println("Dos o mas fuerzas tienen igual frecuencia");
        if(valMax2==frS1) System.out.println(defaultText+Fuerza.Cien);
        if(valMax2==frS2) System.out.println(defaultText+Fuerza.Doscientos);
        if(valMax2==frS3) System.out.println(defaultText+Fuerza.Trecientos);

        System.out.println("*****************************************************\n");
    }



    public static void mostUsedRange(Warrior[] characters){
        System.out.println("\n*****************************************************");
        int fr1 = 0;
        int fr2 = 0;
        int fr3 = 0;
        
        for(Warrior ch: characters){
            Fuerza f=ch.getForce();
            switch(f){
                case Cien:
                    fr1++;break;
                case Doscientos:
                    fr2++;break;
                case Trecientos:
                    fr3++;break;
            }
        }
        
        int valMax3=Math.max(fr1, Math.max(fr2, fr3));
        String textoPred3="La fuerza/rango más usada es: ";
        
        if(fr1==fr2 || fr1==fr3 || fr2==fr3) System.out.println("Dos o mas fuerzas tienen igual frecuencia");
        if(valMax3==fr1) System.out.println(textoPred3+Fuerza.Cien);
        if(valMax3==fr2) System.out.println(textoPred3+Fuerza.Doscientos);
        if(valMax3==fr3) System.out.println(textoPred3+Fuerza.Trecientos);
        
        System.out.println("*****************************************************\n");
    }




    //main
    public static void main(String[] args) throws Exception {

        //Ability mix list
        SpecialAbility ability1[]= {SpecialAbility.InstaKill,SpecialAbility.maxAmmo};
        SpecialAbility ability2[]={SpecialAbility.TNTDAncer, SpecialAbility.PsycoKiller};
        SpecialAbility ability3[]={SpecialAbility.noDamage, SpecialAbility.MaxDamage};
        SpecialAbility ability4[]={SpecialAbility.PsycoKiller, SpecialAbility.MaxDamage, SpecialAbility.InstaKill};

        Archer arch1 = new Archer("Iosef", Alliances.Horda, ability3, Fuerza.Doscientos, Weapons.Ax, 1100);
        Archer arch2 = new Archer("Leon", Alliances.Elfos, ability1, Fuerza.Cien, Weapons.Bow, 240);
        Soldier sol1 = new Soldier("Nikolai", Alliances.Terranova, ability2, Fuerza.Doscientos, Weapons.Sword);
        Soldier sol2 = new Soldier("Ha-Joon", Alliances.Elfos,ability4, Fuerza.Trecientos,  Weapons.Bow);

        Warrior characters[]= {arch1,arch2,sol1,sol2};
        Soldier soldiersList[] ={sol1,sol2};

        //Probando las funciones
        allianceCounter(characters);
        mostAbilityUsed(characters);
        LeastCommonForce(soldiersList);
        mostUsedRange(characters);

    }
}
