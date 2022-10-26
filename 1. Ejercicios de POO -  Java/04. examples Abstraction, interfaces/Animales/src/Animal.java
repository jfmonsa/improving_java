public abstract class Animal{
    /* Notese que agregamos abstract a la clase, 
    o que indica que esta es una clase abstracta y no se puede instanciar */

    private boolean sexo;
    private int edad;
    public Animal(boolean sexo, int edad) {
        this.sexo = sexo;
        this.edad = edad;
    }
    public boolean isSexo() {
        return sexo;
    }
    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /*
     * Notese que agregamos abstract a el metodo dormir, 
     * lo que estamos indicando es que toos los que herenden de 
     * animal deben implementar dormir
     * 
     * En las clases abstractas conviven métodos normales y los abstracts
     */
    public abstract void dormir();
    

}