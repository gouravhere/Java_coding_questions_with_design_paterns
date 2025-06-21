package designPatern.abstractPatern;

public class TraineeProfessionAbstractFactory extends AbstractFactoryMain {
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**
     * Returns a TraineeProfession object based on the provided profession name.
     *
     * @param profession the name of the profession to retrieve, case-insensitive.
     * @return a TraineeTeacher or TraineeEngineer object if the profession matches,
     *         or null if no matching profession is found.
     * @throws IllegalArgumentException if the provided profession is null.
     */

/* <<<<<<<<<<  b6a435e0-f775-46c6-b393-c537bd78353c  >>>>>>>>>>> */
    @Override
    public Profession getProfession(String profession) {
        if (profession == null) {
            throw new IllegalArgumentException("Profession cannot be null");
        }
        
        switch (profession.toLowerCase()) {
            case "teacher":
                return new TraineeTeacher();
            case "engineer":
                return new TraineeEngineer();
            default:
                System.err.println("No such trainee profession available: " + profession);
                return null;
        }
    }
}
