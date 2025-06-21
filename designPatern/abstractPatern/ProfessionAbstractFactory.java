package designPatern.abstractPatern;

public class ProfessionAbstractFactory extends AbstractFactoryMain {
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**
     * Retrieves a Profession object based on the provided profession name.
     *
     * @param profession the name of the profession to retrieve
     * @return a Profession object if the profession name matches "teacher" or "engineer",
     *         otherwise returns null
     * @throws IllegalArgumentException if the profession name is null
     */

/* <<<<<<<<<<  5f48ec9c-820c-4de4-b9f5-e23dff6b0e78  >>>>>>>>>>> */
    @Override
    public Profession getProfession(String profession) {
        if (profession == null) {
            throw new IllegalArgumentException("Profession cannot be null");
        }
        
        switch (profession.toLowerCase()) {
            case "teacher":
                return new Teacher();
            case "engineer":
                return new Engineer();
            default:
                System.err.println("No such profession available: " + profession);
                return null;
        }
    }
}
