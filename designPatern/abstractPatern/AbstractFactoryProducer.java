package designPatern.abstractPatern;

public class AbstractFactoryProducer {
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**
     * Returns an instance of an AbstractFactory based on the specified type.
     *
     * @param trainee a boolean indicating whether to return a trainee factory or not.
     *                If true, a TraineeProfessionAbstractFactory is returned.
     *                If false, a ProfessionAbstractFactory is returned.
     * @return an instance of AbstractFactory corresponding to the specified type.
     */

/* <<<<<<<<<<  bf4d32c4-2c07-4bea-a093-b300b5580e05  >>>>>>>>>>> */
    public static AbstractFactoryMain getFactory(Boolean trainee) {
        if (trainee) {
            return new TraineeProfessionAbstractFactory();
        } else {
            return new ProfessionAbstractFactory();
        }
    }
}
