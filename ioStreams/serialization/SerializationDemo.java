package ioStreams.serialization;

import java.io.*;

public class SerializationDemo {
    public static void main (String[] args){
        FileOutputStream fos ;
        ObjectOutputStream bos;
        try {
            fos = new FileOutputStream("D:/PersonalProjects/emp.ser");
            bos = new ObjectOutputStream(fos);

            Employee emp = new Employee(10,"Gourav",10000,212);
            bos.writeObject(emp);
            System.out.println("Data is serialized");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
