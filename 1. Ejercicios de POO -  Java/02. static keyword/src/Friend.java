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