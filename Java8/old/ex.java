package Java8.old;

class ex { 
    static String str; 

    // Constructor without a return type
    public void ex() {
        System.out.println("In constructor"); 
        str = "Hello World"; 
    }

    public static void main(String[] args) { 
        ex c = new ex();  // Instantiates the class and calls the constructor
        System.out.println(str);  // Prints the value of the static variable str
    }
}

