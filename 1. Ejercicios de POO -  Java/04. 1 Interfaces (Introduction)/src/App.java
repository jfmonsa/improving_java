public class App {
	public static void main(String[] args) {	
		Fish fish = new Fish();
		fish.hunt();
		fish.flee();			
	}
}
/*
    Definition:
    An interface is a completely "abstract class" that is used 
    to group related methods with empty bodies:

    Example:
        interface Animal {
        public void animalSound(); // interface method (does not have a body)
        public void run(); // interface method (does not have a body)
        }

    implements
    To inherit from an interface we use the keyword implements instead of extends

    Is it necesary the abstract keyword?
 * Interfaces and their methods are implicitly abstract and adding
 * [abstract] that modifier makes no difference.
 */

/*
 * Abstract vs interface
 * 
 * Parameters  |  interface   |  Abstract
 * Speed           Slow           Fast
 * ----------------------------------------
 * Multiple     |   Several    | Only one
 * Inheritance  | interfaces   | Absract class
 * ---------------------------*-------------
 * access                 | Everything in    | Can have an
 * Modifier   for         | in the class is  | acces modifier
 * class, vars, methods...| assumed as public|  for class, attributes and methods
 *                        |there isn't method|
 *                        |modifier          |
 * ---------------------------*-------------
 * Data fields       | An interface|  Can have 
 * (class variables) | can't have  | data fields
 *                   | data fields, |
 *                   |->the interface|
 *                   | Only declares |
 *                   | methods       |
 * ---------------------------*-------------
 */