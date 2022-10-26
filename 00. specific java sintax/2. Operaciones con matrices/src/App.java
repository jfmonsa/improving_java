import java.util.Scanner;

public class App {

    int Matriz[][];
    Scanner sc = new Scanner(System.in);
    int filas, columnas;
    
    //Ingresar Filas y columnas de una Matriz
    public void LeerTam(){
        System.out.println("Ingrese la cantidad de filas:");
        filas = sc.nextInt();
        System.out.println("Ingrese la cantidad de columnas: ");
        columnas = sc.nextInt();
        Matriz = new int[filas][columnas];
        System.out.println("");
    }
    
    //Imprimir Los Datos de una Matriz
    public void recorrer(){
        for(int i = 0; i < Matriz.length; i++){
            for(int j = 0; j < Matriz[0].length; j++){
                System.out.print(Matriz[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    //Ingresar los datos a una Matriz
    public void LeerDatos(){
        for (int i = 0; i < Matriz.length; i++) {
            for(int j = 0; j < Matriz[0].length; j++){
                System.out.println("Ingrese Matriz [" + i + "][" + j + "] = ");
                 Matriz[i][j] = sc.nextInt();
            }
        }
        System.out.println("");
    }
    
    //Llenar una Matriz AleatoriaMente
    public void LlenarAleatorio(){
        for (int i = 0; i < Matriz.length; i++) {
            for(int j = 0; j < Matriz[0].length; j++){
                 Matriz[i][j] = 1 + (int)(Math.random() * 10);
            }
        }
            System.out.println("");
    }
    
    //Busqueda Lineal En Una Matriz  
    public void Buscar(){
        int valorBuscar;
        boolean existe = false;
        System.out.println("Ingrese el valor a buscar: ");
        valorBuscar = sc.nextInt();
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz.length; j++) {
                if(Matriz[i][j] == valorBuscar){
                    existe = true; 
                    System.out.println("El valor " + valorBuscar + "Esta en Matriz[" 
                    + i + "][" + j + "] = " + Matriz[i][j]);
                    i = Matriz.length;
                    break;
                }          
            }         
        }
        if(!existe){
            System.out.println("El valor " + valorBuscar + " No existe en la Matriz: " );
        }
        System.out.println("");
    }
    
    //Frecuencia de un elemento en una Matriz;
    public void Frecuencia(){
        int ValorBuscar, cont = 0;
        //boolean existe = false;
        System.out.println("Ingrese el valor a Buscar: ");
        ValorBuscar = sc.nextInt();
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz.length; j++) {
                if(Matriz[i][j] == ValorBuscar){
                    cont ++;
                }
            }
        }
        System.out.println("El valor: " + ValorBuscar + " Esta: " + cont + " Veces");
        System.out.println("");
    }
    
    //Recorrer Una Fila de la matriz:
    public void RecorrerFila(){
        int FilaRecorrer;
        System.out.println("Ingrese La Fila Que desea recorrer");
        FilaRecorrer = sc.nextInt();
        for (int i = 0; i < Matriz[0].length; i++) {
            System.out.print(" Matriz[" + FilaRecorrer + "][" + i + "] = " + Matriz[FilaRecorrer][i]);
        }
        System.out.println("");
    }
    
    //Recorrer Una Columna De La Matriz:
        public void RecorrerColumna(){
        int ColumnaRecorrer;
        System.out.println("Ingrese La Columna Que desea recorrer");
        ColumnaRecorrer = sc.nextInt();
        for (int i = 0; i < Matriz.length; i++) {
            System.out.println(" Matriz[" + ColumnaRecorrer + "][" + i + "] = " + Matriz[i][ColumnaRecorrer]);
        }
        System.out.println("");
    }
    
    public void menu(){
        int opc;
        do{
            System.out.println("MENU");
            System.out.println("1) Leer el tamaño:");
            System.out.println("2) Ingresar datos a la matriz");
            System.out.println("3) Recorrer la Matriz");
            System.out.println("4) Llenar Aleatorio");
            System.out.println("5) Buscar un valor en la Matriz");
            System.out.println("6) Frecuencia de un valor");
            System.out.println("7) Imprimir una Fila");
            System.out.println("8) Imprimir una Columna");
            System.out.println("0) Salir");
            System.out.print("Seleccione una opcion:");
            opc = sc.nextInt();
            switch (opc) {
                case 1: LeerTam(); break;
                case 2: LeerDatos(); break;
                case 3: recorrer(); break;
                case 4: LlenarAleatorio(); break;
                case 5: Buscar(); break;
                case 6: Frecuencia(); break;
                case 7: RecorrerFila(); break;
                case 8: RecorrerColumna(); break;
                case 0: break;
                default: System.out.println("Opcion incorrecta: \n\n");
            }
        }while(opc != 0);
    }
    
    public static void main(String[] args) {
        App obj = new App();
        obj.menu();
    }
    
}
