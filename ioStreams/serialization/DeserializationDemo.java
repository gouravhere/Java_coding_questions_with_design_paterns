package ioStreams.serialization;

import java.io.*;

public class DeserializationDemo {
    public static void main (String[] args){
        FileInputStream fos ;
        ObjectInputStream bos;
        try {
            fos = new FileInputStream("D:/PersonalProjects/emp.ser");
            bos = new ObjectInputStream(fos);

          Object obj = bos.readObject();
          Employee emp = (Employee)obj;

            System.out.println("Data is DeSerialized Id = " + emp.id);
            System.out.println("Data is DeSerialized Name = " + emp.name);
            System.out.println("Data is DeSerialized Salary = " + emp.salary);
            System.out.println("Data is DeSerialized ssn = " + emp.ssn);   // it will be 0 because we have marked it as transient
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
