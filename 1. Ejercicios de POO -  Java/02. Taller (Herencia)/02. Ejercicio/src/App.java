public class App {
    public static void main(String[] args) throws Exception {
        Empleado ep1 = new Empleado("Dario Ramiro", "Gerente");
        ep1.asignacionAleatoria(ep1);
        Empleado.imprimir(ep1);
    }
}
