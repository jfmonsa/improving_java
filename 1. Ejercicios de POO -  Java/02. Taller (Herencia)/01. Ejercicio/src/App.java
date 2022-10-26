public class App {
    public static void main(String[] args) throws Exception {

        Materiales[] listaMateriales = Materiales.values(); //Convertir array en una lista de strings

        Computador pc1 = new Computador(110.5f , 2000000,listaMateriales, Marca.Asus, 3.2f, 19);
        Computador pc2 = new Computador(105.5f , 1300000,listaMateriales, Marca.HP, 3.2f, 19);
        Computador pc3 = new Computador(240.5f , 4740000,listaMateriales, Marca.AlienWare, 3.2f, 19);

        Lavadora l1 = new Lavadora(540f,2500000,listaMateriales, 3.4f, true);
        Lavadora l2 = new Lavadora(400f,2500000,listaMateriales, 5f, false);
        Lavadora l3 = new Lavadora(600f,4000000,listaMateriales, 7.4f, true);

        Electrodomestico[] aparatos = {pc1, pc2, pc3, l1, l2, l3};

        int precioContador=0;
        for(Electrodomestico obj: aparatos){
            precioContador+=obj.getPrecio();
        }
        System.out.println("El valor total de los 6 electordomesticos (3 computadores y 3 lavadoras) es: "+precioContador);
    }
}
