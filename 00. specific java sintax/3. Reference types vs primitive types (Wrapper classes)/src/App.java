public class App {

    public static void main(String[] args) {
     
     // wrapper class =  provides a way to use primitive data types as reference data types
     //     reference data types contain useful methods
     //     can be used with collections (ex.ArrayList)

     /*
      * In Java, non-primitive data types are known as reference types. In other words,
       a variable of class type is called reference data type. It contains the address (or reference) of dynamically created objects. For example, if Demo is a class and we have created its object d, then the variable d is known as a reference type.

        It refers to objects. It is not pre-defined. It is created by the programmer 
        if required. The reference types hold the references of objects. All reference 
        types are a subclass of type java.lang.Object. It provides access to the 
        objects stored in the memory.
      */
     
     //primitive  //wrapper
     //---------  //-------
     // boolean      Boolean
     // char         Character
     // int          Integer
     // double       Double

     //Other examples of reference types:
     //String, ArrayList, Annotations, Interface, Enumeration <-- In general all
     //reference type begins with Uppercase letter

     //A primitive type can't be initialized with null, insted reference types can
     
     // autoboxing = the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes
     // unboxing = the reverse of autoboxing. Automatic conversion of wrapper class to primitive

     //More info    
     
     Boolean a = true;
     Character b = '@';
     Integer c = 123;
     Double d = 3.14;
     
     
    }
    
   }