public class App {

	public static void main(String[] args) {
		
		// polymorphism = 	greek word for poly-"many", morph-"form"
		//					The ability of an object to identify as more than one type
		
        /* Definition:
         *  is the ability of a class instance to behave as if 
         * it were an instance of another class in its inheritance tree, 
         * most often one of its ancestor classes. For example, in Java all 
         * classes inherit from Object. Therefore, you can create a variable 
         * of type Object and assign to it an instance of any class
         * 
         * 
         * Method overloading vs overriding
         * 
         * Polymorphism can be achieved by using two ways, those are:
         *      1.  Method overriding
         *      2.  Method overloading
         * 
         * 1. Method overloading means writing two or more methods in the 
         * same class by using same method name, but the passing parameters is different.
         * 
         * 2. Method overriding means we use the method names in the different classes,
         * that means parent class method is used in the child class.
         * 
         * 
         * 
         * 
         * Other explanation about override a method:
         * 
         * An override is a type of function which occurs in a class which inherits from 
         * another class. An override function "replaces" a function inherited from the 
         * base class, but does so in such a way that it is called even when an instance
         * of its class is pretending to be a different type through polymorphism. Referring
         * to the previous example, you could define your own class and override the toString()
         * function. Because this function is inherited from Object, it will still be available
         * if you copy an instance of this class into an Object-type variable. Normally, 
         * if you call toString() on your class while it is pretending to be an Object, 
         * the version of toString which will actually fire is the one defined on Object itself.
         * However, because the function is an override, the definition of toString() from your 
         * class is used even when the class instance's true type is hidden behind polymorphism
         */
		Car car = new Car();
		Bicycle bicycle = new Bicycle();
		Boat boat = new Boat();
		
		Vehicle[] racers = {car,bicycle,boat};
		//Object[] racers2 = {car,bicycle,boat}; We can do it like this, cuz all classes inherites
        //from the class Object.
		for(Vehicle x : racers) {
			x.go();
		}
		
	}
}