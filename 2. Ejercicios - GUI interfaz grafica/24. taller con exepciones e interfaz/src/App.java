public class App {
    public static void main(String[] args) throws Exception {
        Ventana ventana =new Ventana();
        ventana=null;
        System.gc();
    }
}
