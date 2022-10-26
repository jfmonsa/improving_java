public class App {

	public static void main(String[] args) {
		
		// static = modifier. A single copy of a variable/method is created and shared.
		//			The class "owns" the static member
		
		Friend friend1 = new Friend("Sponegbob");
		Friend friend2 = new Friend("Patrick");
		Friend friend3 = new Friend("Patrick");
		
		System.out.println(Friend.numberOfFriends);

	}
}

/*
 * An example of a static method is Math.round(), since it's invoked directly
 * the method round() by Math.round(), instead of declaring a new object of
 * type Math and the call the funcion round() of this object
 * 
 * you don't do this:
 *      Math mat = new Math();
 *      x = mat.round();
 * 
 * You do this instead:
 *      x = Math.round();
 */