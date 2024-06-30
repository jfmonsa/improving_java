/**
 * Concepts:
 * - class methods and variables != instance methods and variables
 * - to implement a class method or variable -> static modifier
 * - A single copy of a variable/method is created and shared.
 * - to call the method or variable use ClassName.method() or ClassName.variable
 * - Ex: Math.round()
 */
public class Friend {
	String name;
	static int numberOfFriends; //Static variable
	
	Friend(String name){
		this.name=name;
		numberOfFriends++;
	}

    public static void numberOfFriends(){
        System.out.println("You have :"+numberOfFriends+" friends");
    }
}

public class TestFriend {

	public static void main(String[] args) {	
		Friend friend1 = new Friend("Sponegbob");
		Friend friend2 = new Friend("Patrick");
		Friend friend3 = new Friend("Patrick");
		
		System.out.println(Friend.numberOfFriends);

	}
}