public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        try{
            System.out.println(1/0);            
        }catch(ArithmeticException e){
            System.out.println("no puedes dividir sobre 0");
            e.printStackTrace();
        }
        System.out.println(":)");
        
    }
}
