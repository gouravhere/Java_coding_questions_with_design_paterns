package designPatern.abstractPatern;

public class FactoryParternMain {
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**
     * The main method demonstrating the usage of the Abstract Factory pattern.
     * It retrieves a factory based on the trainee flag and attempts to get a
     * profession object. If a valid profession is retrieved, it prints the
     * profession details. Otherwise, it notifies about an unavailable profession.
     *
     * @param args command line arguments
     */

/* <<<<<<<<<<  a8edb91c-8e5d-42a8-ad59-8ac4b2004fbb  >>>>>>>>>>> */
    public static void main(String[] args) {
        AbstractFactoryMain abstractFactory = AbstractFactoryProducer.getFactory(true);
        Profession profession = abstractFactory.getProfession("Teacher"); // Fixed case to match factory check
        
        if (profession != null) {
            profession.print();
        } else {
            System.out.println("No such profession found or null profession returned");
        }
    }
}
