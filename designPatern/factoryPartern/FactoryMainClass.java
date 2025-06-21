package designPatern.factoryPartern;

public class FactoryMainClass {
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**
     * This main method will test the Factory pattern by creating a "driver"
     * profession object and then print out the profession name.
     * @param args the input arguments
     */
/* <<<<<<<<<<  907bbb1d-759f-458a-96d2-8d03faf57cd7  >>>>>>>>>>> */
    public static void main(String[] args) {
        ProfessionFactory professionFactory = new ProfessionFactory();
        Profession profession = professionFactory.getProfession("driver");
        profession.print();
    }
}
