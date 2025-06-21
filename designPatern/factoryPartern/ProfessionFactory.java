package designPatern.factoryPartern;

public class ProfessionFactory {
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**
     * Gets a profession instance given a string type.
     *
     * @param professionType a string type of a profession
     * @return a profession instance
     */
/* <<<<<<<<<<  d5cfbdb6-7abb-4867-a2df-196538417e37  >>>>>>>>>>> */
    public static Profession getProfession(String professionType) {
        if (professionType.equals("doctor")) {
            return new DoctorMainClass();
        } else if (professionType.equals("engineer")) {
            return new EngineerMainClass();
        } else if (professionType.equals("driver")) {
            return new DriverMainClass();
        }
        return null;
    }
}
