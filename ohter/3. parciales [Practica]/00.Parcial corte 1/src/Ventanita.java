import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//Eventos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ventanita extends JFrame implements ActionListener, ItemListener{
    //------------------------------ Global vars ---------------------------------------
    //Array de las materias
    String c1 = materiasMatriculadas.Fisíca.name();
    String c2 = materiasMatriculadas.Español.name();
    String c3 = materiasMatriculadas.Matemáticas.name();
    String c4 = materiasMatriculadas.Sociales.name();
    String arr_materias[] = {c1,c2,c3,c4};
    //static String arr_materias[] = {"Fisíca","Español","Matemáticas","Sociales"};
    static ArrayList<AsignarMatricula> materias_matriculadas = new ArrayList<AsignarMatricula>();
    //Materias por la mañana
    //String[] arr_mat1 = {"Fisica","Matematicas"}; //Las da prof1
    //String[] arr_mat4 = {"Español","Sociales"}; //Las da prof4
    //Materias por la tarde
    //String[] arr_mat2 = {"Fisica"}; //Las da prof2
    //String[] arr_mat3 = {"Matematicas"}; //Las da prof 3
    //String[] arr_mat5 = {"Español","Sociales"}; //Las da prof 5
    
    profHoraCatedra prof1 = new profHoraCatedra("Ramiro Ramirez","123456789","Ing Sistemas", 8);
    profHoraCatedra prof2 = new profHoraCatedra("Lexmer antonio","012378965","Agronomo", 8);
    profNombrado prof3 = new profNombrado("Yonio jimenez", "159623487",Categorias.Asociado, "01/02/1752");
    profNombrado prof4 = new profNombrado("Matecho restrepo", "487159623",Categorias.Auxiliar, "01/02/1502");
    profNombrado prof5 = new profNombrado("Jorge Orwell", "159487623",Categorias.Asistente, "01/02/1984");
    
    //------------------------------ Global vars ---------------------------------------
    //------------------------------ GUI vars ---------------------------------------
    Container contenedor;
    //JPanel contenedor;
    int ancho_ventana =400;
    int largo_ventana =450;
    JComboBox<String> combo1;
    JButton btn_terminar, btn_agregar, btn_regresar;
    JRadioButton rbtn1, rbtn2;
    ButtonGroup btngroup1;
    JTextArea textArea;
    //------------------------------ GUI vars ---------------------------------------

    //Window constructor
    public Ventanita(){
        super("Interfaz de colegio");
        contenedor=getContentPane();
        FlowLayout layout = new FlowLayout();
        contenedor.setLayout(layout);
        //Other settings
        setSize(ancho_ventana,largo_ventana);
        setBackground(Color.LIGHT_GRAY);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //--------------------------- Form ---------------------------------
        JLabel label1  = new JLabel("Matricular jornada mañana");
        label1.setFont(new Font("Segoe UI Black", 0, 24));
        contenedor.add(label1);

        JLabel label_combo1 = new JLabel("Seleccione materia a matricular");
        contenedor.add(label_combo1);

        combo1= new JComboBox<>(arr_materias);
        contenedor.add(combo1);

        JLabel label_radio_btngroup = new JLabel("Seleccione la jornada");
        contenedor.add(label_radio_btngroup);

        rbtn1= new JRadioButton("Mañana",true);
        rbtn2= new JRadioButton("Tarde");
        btngroup1 = new ButtonGroup();
        btngroup1.add(rbtn1);
        btngroup1.add(rbtn2);
        contenedor.add(rbtn1);
        contenedor.add(rbtn2);

        textArea = new JTextArea(5,30);
        textArea.setBounds(200,280,100,40);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        contenedor.add(textArea);
        JScrollPane scroll=new JScrollPane(textArea/* , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED*/);
        contenedor.add(scroll);
   
        btn_agregar = new JButton("Agregar materia");
        btn_agregar.addActionListener(this);
        contenedor.add(btn_agregar);

        btn_terminar = new JButton("Terminar de matricular");
        btn_terminar.addActionListener(this);
        contenedor.add(btn_terminar);   
        //--------------------------- Form ---------------------------------

        //####################################################
        this.setVisible(true); 
            //this always goes to the end, otherwise it doesn't work
        //####################################################
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //To add subjects
        if(e.getSource()==btn_agregar){ 
            String materia_seleccionada = (String) combo1.getSelectedItem();
            String jornada_seleccionada="";
            if(rbtn1.isSelected()){
                jornada_seleccionada="Mañana";
            }else{
                jornada_seleccionada="Tarde";
            }
            Matricular(jornada_seleccionada,materia_seleccionada);

        }

        //to finish tuition process
        if(e.getSource()==btn_terminar){
            verificar2Materias(materias_matriculadas);
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        
        
    }
    public void Matricular(String jornada_seleccionada, String materia_seleccionada){
            //Encontrando que jornada esta seleccionada  
        //Truquito con array
        Profesor[] arr_p1={prof1};
        Profesor[] arr_p2={prof2};
        Profesor[] arr_p3={prof3};
        Profesor[] arr_p4={prof4};
        Profesor[] arr_p5={prof5};
        Profesor[] profesor_que_la_da=null;
        //Encontrando que profesor da la materia 
        //Asignando profesores por la mañana
        if(materia_seleccionada==materiasMatriculadas.Fisíca.name() && jornada_seleccionada=="Mañana")
            profesor_que_la_da = arr_p1;
        else if(materia_seleccionada==materiasMatriculadas.Matemáticas.name() && jornada_seleccionada=="Mañana")
            profesor_que_la_da = arr_p1;
        else if(materia_seleccionada==materiasMatriculadas.Español.name() && jornada_seleccionada=="Mañana")
            profesor_que_la_da = arr_p4;
        else if(materia_seleccionada==materiasMatriculadas.Sociales.name() && jornada_seleccionada=="Mañana")
            profesor_que_la_da = arr_p4;

        //Asignando profesores por la tarde
        else if(materia_seleccionada==materiasMatriculadas.Fisíca.name() && jornada_seleccionada=="Tarde")
            profesor_que_la_da = arr_p2;
        else if(materia_seleccionada==materiasMatriculadas.Matemáticas.name() && jornada_seleccionada=="Tarde")
            profesor_que_la_da = arr_p3;
        else if(materia_seleccionada==materiasMatriculadas.Español.name() && jornada_seleccionada=="Tarde")
            profesor_que_la_da = arr_p5;
        else if(materia_seleccionada==materiasMatriculadas.Sociales.name() && jornada_seleccionada=="Tarde")
            profesor_que_la_da = arr_p5;
        //Matriculamos
        verificarQueNoEsteMatriculadaYa(materias_matriculadas, jornada_seleccionada, materia_seleccionada, profesor_que_la_da);
    }
    public String actualizarTabla(){
        String texto_salida="";
        for(AsignarMatricula m: materias_matriculadas){
            texto_salida+="-->Jornada: "+m.getJornada()+" Materia: "+m.getMateria()+
            " Profesor/a: "+m.getProfesor()[0].getNombre()+"\n";
        }
        return texto_salida;
    }

    public void verificarQueNoEsteMatriculadaYa(ArrayList<AsignarMatricula> arr, String jornada, String materia, Profesor[] prof){
        boolean encontrada = false;
        for(AsignarMatricula a: arr){
            if(a.getMateria()==materia && a.getJornada()==jornada){
                encontrada=true;
                break;
            }
        }
        if(!encontrada){
            AsignarMatricula matricula;
            matricula = new AsignarMatricula(jornada,prof,materia/*jornada_seleccionada, arr_p5, materia_seleccionada*/);
            materias_matriculadas.add(matricula);
            textArea.setText(actualizarTabla());
        }else{
            JOptionPane.showMessageDialog(contenedor, "La materia que solicitas ya fue matricualada","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    public void profesorConMasMaterias(){
        Profesor[] arr_profesores = {prof1,prof2,prof3,prof4,prof5};
        int[] arr_conunter_profesores = new int[arr_profesores.length];
        int i=0; //indexer

        for(Profesor p: arr_profesores){ 
            int counter=0;   
            for(AsignarMatricula m: materias_matriculadas){
                if(p.getCedula()==m.getProfesor()[0].getCedula()){
                    counter++;
                }
            }
            arr_conunter_profesores[i]=counter;
            i++;
        }

        //iterate arr_conunter_profesores to find the index of the busiest prof
        int max_val=arr_conunter_profesores[0];
        int j=0;
        int final_index=0;
        System.out.println("jljadflkjadfjljk");
        for(; j<arr_profesores.length-1; j++){
            if(arr_conunter_profesores[j]>max_val){
                max_val=arr_conunter_profesores[j];
                final_index=j;
            }
        }
        JOptionPane.showMessageDialog(contenedor, "El profesor con más materias matriculadas es: "+arr_profesores[final_index].getNombre()+" , da "+max_val+" materia(s)");
        JOptionPane.showMessageDialog(contenedor, "Matricula exitosa programa a terminar");
        System.exit(0);
    }
    public void verificar2Materias(ArrayList<AsignarMatricula> arr){
        if(arr.size()<2){
            JOptionPane.showMessageDialog(contenedor, "Debe matricular por lo menos dos materias", "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            profesorConMasMaterias();
        }
    }
}