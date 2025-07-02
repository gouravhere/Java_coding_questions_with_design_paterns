package ioStreams.serialization;

import java.io.Serializable;
/**
 * This package contains the classes for serialization and deserialization in java.
 *
 * The serialization is a process of converting an object into a byte stream and
 * reconstructing the object from the byte stream. The process of serialization is
 * used to persist the state of an object.
 *
 * The deserialization is the process of reconstructing the object from a byte
 * stream.
 */
public class Employee implements Serializable {
    int id;
    String name;
    double salary;
   transient int ssn;   //----To avoid variable to be serialized

    Employee(int id , String name , double salary , int ssn){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.ssn = ssn;
    }
}
