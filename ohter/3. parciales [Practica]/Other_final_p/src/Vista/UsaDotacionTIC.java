package Vista;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import Modelo.DotacionTIC;
import Modelo.EspacioFisico;
import Modelo.Revision;
import Modelo.RevisionEspecial;
import Modelo.RevisionPeriodica;

public class UsaDotacionTIC {
    
    //Generar la coleccion
   static LinkedList<DotacionTIC> lasDotacionesTIC;

    public static void main(String[] args) throws Exception {
    

        //Generar la coleccion lasDotacionesTIC
        lasDotacionesTIC = new LinkedList<>();

        //menu
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("MENÚ ESCENARIO \n"
                    + "1. Crear Dotacion TIC con sus Revisiones \n"
                    + "2. Generar reporte de Todas los Dotaciones TIC \n"
                    + "3. Generar reporte de Una Dotacion TIC \n"
                    + "4. Generar reporte de la Primera Dotacion TIC \n"
                    + "5. Generar reporte de la Última Revisión de Una Dotación TIC"                  
                    + "6. Salir \n"
                    ));

                    switch(opc){
                        case 1:
                            crearDotacionTIC();
                            break;
                        case 2:
                            mostrarReporte(generarReporteTodasDotacionesTIC());
                            break;
                        case 3:
                            int numeroEscenario = Integer.parseInt(JOptionPane.showInputDialog("Número de Dotacion"));
                            mostrarReporte(generarReporteUnaDotacionTIC(numeroEscenario));
                            break;
                        case 4:
                            mostrarReporte(generarReportePrimeraDotacionTIC());
                            break;
                        case 5:  
                            mostrarReporte(generarReporteUltimaRevisionDeUnaDotacionTIC(Integer.parseInt(JOptionPane.showInputDialog("Numero de dotacion"))));
                            break;               
                        case 6: //6. Salir
                            JOptionPane.showMessageDialog(null,"El programa se cerrará");
                            System.exit(0);
                        default:
                             JOptionPane.showMessageDialog(null, "Opción inválida.");
                        }//fin switch

        } while(opc>=1 && opc<=5);
    }

    
   

    //+ «static» crearDotacionTIC() : void
    public static void crearDotacionTIC(){

        //1.recompilar datos
        int numeroDotacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número dotacioón"));
   
        String nombreDotacion = JOptionPane.showInputDialog("Nombre de la dotación");
        
        String fechaAdquisicion = JOptionPane.showInputDialog("Ingrese la fecha de aquisición");

        EspacioFisico suUbicacion;
        int numeroUbi = Integer.parseInt(JOptionPane.showInputDialog("Número de la ubicación"));
        String nombrebUbi = JOptionPane.showInputDialog("Nombre de la Ubicacion");
        int capacidadPersonasUbi = Integer.parseInt(JOptionPane.showInputDialog("Capacidad de personas de la ubicacion"));
        double areaUbi = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el area de la ubicacion"));
        suUbicacion = new EspacioFisico(numeroUbi, nombrebUbi, capacidadPersonasUbi, areaUbi);

     
        LinkedList<Revision> susRevisiones = new LinkedList<>();

        //Usar un ciclo por si hay máas de una revision Ingrese numero de revision
        int cantidadRevisiones = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de revisiones de la dotación"));
        int contador=1;

        while(contador<=cantidadRevisiones){
                int numeroRev = Integer.parseInt(JOptionPane.showInputDialog("Numero de la revision"));
                String fechaRev = JOptionPane.showInputDialog("fecha Inicio de la revision");
                int horasDuracionRev = Integer.parseInt(JOptionPane.showInputDialog("Horas de duración de la revisión"));
                int tarifaBase = Integer.parseInt(JOptionPane.showInputDialog("Tarifa base de la revisión"));

                while (true){
                    int tipoRevision = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de revision \n"
                        + "0. Revision Periodica \n"
                        + "1. Revision especial \n"
                    ));
    
                    // Que tipo de revision y con un if llamar un constructor u otro
                    if(tipoRevision==1){
                        int urengcia_str;
                        Boolean urg;

                        while (true){
                            //si la revicion fue de urengcia 1 si no 0 -> paresar a Boolean
                            urengcia_str = Integer.parseInt(JOptionPane.showInputDialog("Si la revision se realizo de urgencia Ingrese 1 de lo contrario 0"));

                            if(urengcia_str==1){
                                urg=true;
                                break;
                            }else if(urengcia_str==0){
                                urg=false;
                                break;
                            }else{
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta, Ingresa una opcion correcta", 
                        "Warning", JOptionPane.WARNING_MESSAGE);
                            }   
                        }
                    
                        RevisionEspecial revObj = new RevisionEspecial(numeroRev,fechaRev,horasDuracionRev,tarifaBase,urg);
                        susRevisiones.add(revObj);
                        break;

                    }else if(tipoRevision==0){
                        Boolean antesVen;
                        int antesVen_str;

                        while (true){
                            //Si la revision fue antes del vencimiento 1 sino 0 -> parsear a Boolean
                            antesVen_str = Integer.parseInt(JOptionPane.showInputDialog("Si la revision se realizo antes del vencimiento Ingrese 1 de lo contrario 0"));


                            if(antesVen_str==1){
                                antesVen=true;
                                break;
                            }else if(antesVen_str==0){
                                antesVen=false;
                                break;
                            }else{
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta, Ingresa una opcion correcta", 
                        "Warning", JOptionPane.WARNING_MESSAGE);
                            }   
                        }
                    
                        RevisionPeriodica revObj =  new RevisionPeriodica(numeroRev,fechaRev,horasDuracionRev,tarifaBase,antesVen);
                        susRevisiones.add(revObj);
                        break;

                    }else{
                        //Caso opcion incorrecta
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta, Ingresa una opcion nuevamente", 
                        "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }

                contador++;
        }
        //2) Crear el objeto Dotacion
        DotacionTIC dotacionObj = new DotacionTIC(numeroDotacion,nombreDotacion,fechaAdquisicion,suUbicacion,susRevisiones);
        //3- Agregar el objeto creado a la colección "losEscenarios"
        lasDotacionesTIC.add(dotacionObj);  
    }

    //+ «static» generarReporteTodasDotacionesTIC() : String
    public static String generarReporteTodasDotacionesTIC(){
        
        String reporte = "REPORTE DE TODAS LAS DOTACIONES \n";
        if(!lasDotacionesTIC.isEmpty()){
            //while(!lasDotacionesTIC.isEmpty()){
            for (DotacionTIC listElement: lasDotacionesTIC) { 
                reporte+=listElement.toString();
            }
        }else{
            JOptionPane.showMessageDialog(null, "El inventario de dotacion esta vacio", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return reporte;
    }

    //+ «static» generarReporteUnaDotacionTIC(numeroDotacionTIC : int) : String
    public static String generarReporteUnaDotacionTIC(int numeroDotacionTIC){
        String reporte = "REPORTE DE UNA DOTACION \n";
        Boolean encontrado =false;

        if(!lasDotacionesTIC.isEmpty()){
            for(DotacionTIC listobj : lasDotacionesTIC){
                if(listobj.getNumero() == numeroDotacionTIC){
                    reporte+=listobj.toString() + "\n";
                    encontrado=true;
                    break;
                }
            }
            if(!encontrado){
                JOptionPane.showMessageDialog(null, "La dotación buscada con el número ingresado no existe (no fue encontrada)", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "El inventario de dotacion esta vacio", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return reporte;
    }

    //+ «static» generarReportePrimeraDotacionTIC() : String
    public static String generarReportePrimeraDotacionTIC(){
        String reporte="REPORTE DE LA PRIMERA DOTACIÓN \n";

        if(!lasDotacionesTIC.isEmpty()){
            reporte+=lasDotacionesTIC.getFirst().toString();
        }else{
            JOptionPane.showMessageDialog(null, "El inventario de dotacion esta vacio", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return reporte;
    }

    //+ «static» generarReporteUltimaRevisionDeUnaDotacionTIC(numeroDotacionTIC : int) : String
    public static String generarReporteUltimaRevisionDeUnaDotacionTIC(int numeroDotacionTIC){
        String reporte = "REPORTE DE LA ULTIMA REVISION DE LA DOTACIÓN INGRESADA\n";
        Boolean encontrado =false;

        if(!lasDotacionesTIC.isEmpty()){
            for(DotacionTIC listobj : lasDotacionesTIC){
                if(listobj.getNumero() == numeroDotacionTIC){

                    //Obteniendo informacion de la ultima revision de la dotacion encontrada
                    reporte+=listobj.getSusRevisiones().getFirst().toString();
                    encontrado=true;
                    break;
                }
            }
            if(!encontrado){
                JOptionPane.showMessageDialog(null, "La dotación buscada con el número ingresado no existe (no fue encontrada)", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "El inventario de dotacion esta vacio", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return reporte;
    }

    //+ «static» mostrarReporte(reporte: String): void
    public static void  mostrarReporte(String reporte){
        JOptionPane.showMessageDialog(null, reporte);
    }
}