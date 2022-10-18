import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//Eventos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Ventanita extends JFrame implements ActionListener, ItemListener{
    Container contenedor=getContentPane();
    JButton btn_mañana, btn_tarde;
    JPanel panel_ppal, panel_mañana, panel_tarde;
    int ancho_ventana =400;
    int largo_ventana =450;
    JComboBox<String> panel_mañana_c1;
    JButton panel_mañana_btn_terminar, panel_mañana_btn_agregar, panel_mañana_btn_regresar;
    JRadioButton rbtn1, rbtn2;
    ButtonGroup jornada_btngroup;
    JTextArea panel_mañana_tArea;

    //Parte logica xd
    //Array de las materias
    String c1 = materiasMatriculadas.Fisíca.name();
    String c2 = materiasMatriculadas.Español.name();
    String c3 = materiasMatriculadas.Matemáticas.name();
    String c4 = materiasMatriculadas.Sociales.name();
    String arr_materias[] = {c1,c2,c3,c4};
    //static String arr_materias[] = {"Fisíca","Español","Matemáticas","Sociales"};
    static ArrayList<AsignarMatricula> materias_matriculadas = new ArrayList<AsignarMatricula>();

    //Profesores
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

    

    public Ventanita(){
        super("Interfaz de colegio");
        this.setSize(400,450);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.LIGHT_GRAY);
        this.setResizable(false);
        this.setLayout(null);
        

        //ventana principal
        panel_ppal = new JPanel();
        panel_ppal.setBounds(0,0,ancho_ventana,largo_ventana);
        contenedor.add(panel_ppal);


        JLabel l1  = new JLabel("Intefaz colegio");
        l1.setFont(new Font("Segoe UI Black", 0, 24));
        l1.setBounds(100,10,200,50); //SetLocationRelative(null)
        panel_ppal.add(l1);


        JLabel l2  = new JLabel("Seleccione un jornada:    ");
        l2.setBounds(20,50,200,50); //SetLocationRelative(null)
        panel_ppal.add(l2);

        btn_mañana = new JButton("Mañana");
        btn_mañana.setBounds(20,110,100,40);
        btn_mañana.addActionListener(this);
        panel_ppal.add(btn_mañana);

        /*btn_tarde = new JButton("Tarde");
        btn_tarde.setBounds(260,110,100,40);
        btn_tarde.addActionListener(this);
        panel_ppal.add(btn_tarde);*/

        //JPanel mañana
        panel_mañana = new JPanel();
        panel_mañana.setBounds(0,0,ancho_ventana,largo_ventana);
        //panel_mañana.setBackground(Color.red);
        panel_mañana.setBounds(0,0,400,450);
        panel_mañana.setVisible(false);
        contenedor.add(panel_mañana);

        JLabel panel_mañana_l1  = new JLabel("Matricular jornada mañana");
        panel_mañana_l1.setFont(new Font("Segoe UI Black", 0, 24));
        //panel_mañana_l1.setBounds(100,10,200,50); //SetLocationRelative(null)
        panel_mañana.add(panel_mañana_l1);

        JLabel panel_mañana_l2 = new JLabel("Seleccione materia a matricular");
        //panel_mañana_l2.setBounds(20,50,200,50); //SetLocationRelative(null)
        panel_mañana.add(panel_mañana_l2);

        
        panel_mañana_c1= new JComboBox<>(arr_materias);
        //panel_mañana_c1.setBounds(200,110,100,40);
        panel_mañana.add(panel_mañana_c1);

        JLabel l7 = new JLabel("Seleccione la jornada");
        panel_mañana.add(l7);
        rbtn1= new JRadioButton("Mañana",true);
        rbtn2= new JRadioButton("Tarde");
        jornada_btngroup = new ButtonGroup();
        jornada_btngroup.add(rbtn1);
        jornada_btngroup.add(rbtn2);
        panel_mañana.add(rbtn1);
        panel_mañana.add(rbtn2);

        panel_mañana_tArea= new JTextArea(5,30);
        panel_mañana_tArea.setBounds(200,280,100,40);
        panel_mañana_tArea.setEditable(false);
        panel_mañana_tArea.setFocusable(false);
        panel_mañana_tArea.setLineWrap(true);
        panel_mañana_tArea.setWrapStyleWord(true);
        panel_mañana.add(panel_mañana_tArea);
        JScrollPane scroll=new JScrollPane(panel_mañana_tArea/* , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED*/);
        panel_mañana.add(scroll);
   

        panel_mañana_btn_agregar = new JButton("Agregar materias");
        //panel_mañana_btn_agregar.setBounds(20,380,100,40);
        panel_mañana_btn_agregar.addActionListener(this);
        panel_mañana.add(panel_mañana_btn_agregar);

        panel_mañana_btn_terminar = new JButton("Terminar de matricular");
        //panel_mañana_btn_terminar.setBounds(260,380,100,40);
        panel_mañana_btn_terminar.addActionListener(this);
        panel_mañana.add(panel_mañana_btn_terminar);


        panel_mañana_btn_regresar = new JButton("Regresar al menu");
        panel_mañana_btn_regresar.addActionListener(this);
        panel_mañana_btn_regresar.setBackground(Color.DARK_GRAY);
        panel_mañana_btn_regresar.setForeground(Color.CYAN);
        panel_mañana_btn_regresar.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2)); //Poniendole un borde al boton
        panel_mañana.add(panel_mañana_btn_regresar);

        //JPanel tarde
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_mañana){
            panel_ppal.setVisible(false);
            panel_mañana.setVisible(true);
        }

        //Para agregar materias a la matricula
        if(e.getSource()==panel_mañana_btn_agregar){ 
            String materia_seleccionada = (String) panel_mañana_c1.getSelectedItem();
            String jornada_seleccionada="";
            if(rbtn1.isSelected()){
                jornada_seleccionada="Mañana";
            }else{
                jornada_seleccionada="Tarde";
            }
            Matricular(jornada_seleccionada,materia_seleccionada);

        }
        //Para terminar la matricula
        if(e.getSource()==panel_mañana_btn_terminar){

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
            panel_mañana_tArea.setText(actualizarTabla());
        }else{
            JOptionPane.showMessageDialog(panel_mañana, "La materia que solicitas ya fue matricualada","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    /*public void profesorConMasMaterias(){
        Profesor[] arr_profesores = {prof1,prof2,prof3,prof4,prof5};
        int valor_inicial=0;
        for(Profesor p: arr_profesores){
            for(AsignarMatricula m: materias_matriculadas){

            }
        }
    }*/
    public void verificar2Materias(ArrayList<AsignarMatricula> arr){
        if(!(arr.size()<2)){
            JOptionPane.showMessageDialog(panel_mañana, "Debe matricular por lo menos dos materias", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}