package Java8.latest.interview;

/**
 * Default and Static Methods in Interfaces (Java 8+)
 * 
 * <p><b>Key Concepts:</b>
 * <ul>
 *     <li>Default methods allow adding new methods to interfaces without breaking existing implementations</li>
 *     <li>Static methods in interfaces provide utility methods that belong to the interface</li>
 *     <li>Default methods help in evolving interfaces over time</li>
 *     <li>Multiple inheritance of behavior is now possible through interfaces</li>
 *     <li>Diamond problem resolution rules in Java 8</li>
 * </ul>
 *
 * <p><b>Common Interview Questions:</b>
 * <ol>
 *     <li>What is the purpose of default methods in Java 8 interfaces?</li>
 *     <li>Can we override default methods in implementing classes?</li>
 *     <li>What happens if a class implements two interfaces with the same default method?</li>
 *     <li>Can we have static methods in interfaces? What's their purpose?</li>
 *     <li>What is the diamond problem and how does Java 8 handle it?</li>
 *     <li>Difference between abstract class and interface after Java 8?</li>
 *     <li>Can we have a default method with the same name in two interfaces implemented by a class?</li>
 * </ol>
 *
 * @since Java 8
 */
public class DefaultStaticMethodsDemo {

    public static void main(String[] args) {
        // 1. Using default method
        Vehicle car = new Car();
        car.honk(); // Calls default implementation
        car.start(); // Calls Car's implementation
        
        // 2. Using static method
        Vehicle.repair(); // Calls static method directly on interface
        
        // 3. Multiple inheritance scenario
        FlyingCar flyingCar = new FlyingCar();
        flyingCar.honk(); // Calls FlyingCar's overridden method
        flyingCar.start(); // Calls FlyingCar's implementation
        flyingCar.fly();   // Calls Flyable's default method
        
        // 4. Using static method from implementing class
        Vehicle.repair(); // Still calls the interface's static method
        // Car.repair(); // Compilation error - static method may be invoked on containing interface class only
    }
    
    // Basic interface with default and static methods
    interface Vehicle {
        // Abstract method
        void start();
        
        // Default method - provides default implementation
        default void honk() {
            System.out.println("Vehicle is honking!");
        }
        
        // Static method - belongs to the interface
        static void repair() {
            System.out.println("Repairing vehicle...");
        }
    }
    
    // Another interface with same default method name
    interface Flyable {
        default void fly() {
            System.out.println("Flying...");
        }
        
        // Same default method name as in Vehicle
        default void honk() {
            System.out.println("Flyable is honking!");
        }
    }
    
    // Concrete class implementing Vehicle
    static class Car implements Vehicle {
        @Override
        public void start() {
            System.out.println("Car is starting...");
        }
        
        // Optional: Override default method
        @Override
        public void honk() {
            System.out.println("Car is honking loudly!");
        }
        
        // This is a different static method, not overriding the interface's static method
        static void repair() {
            System.out.println("Repairing car...");
        }
    }
    
    // Class implementing multiple interfaces with same default method
    static class FlyingCar implements Vehicle, Flyable {
        @Override
        public void start() {
            System.out.println("Flying car is starting...");
        }
        
        // Must override the conflicting default method
        @Override
        public void honk() {
            // Option 1: Call specific interface's default method
            // Vehicle.super.honk();
            
            // Option 2: Provide custom implementation
            System.out.println("Flying car is honking!");
        }
        
        // Can also call default methods from interfaces
        public void startFlying() {
            fly(); // Calls Flyable's default method
            start(); // Calls FlyingCar's implementation
        }
    }
    
    /**
     * <b>Interview Questions with Answers:</b>
     * 
     * <p><b>1. What is the purpose of default methods in Java 8 interfaces?</b>
     * <p>Answer:
     * - To add new methods to interfaces without breaking existing implementations
     * - To enable multiple inheritance of behavior
     * - To provide backward compatibility when evolving APIs
     * - To provide utility methods that make sense in the context of the interface
     * 
     * <p><b>2. What happens if a class implements two interfaces with the same default method?</b>
     * <p>Answer:
     * - The class must override the conflicting default method
     * - It can either provide its own implementation
     * - Or explicitly choose which interface's default method to call using InterfaceName.super.methodName()
     * - Otherwise, it results in a compilation error
     * 
     * <p><b>3. What is the diamond problem and how does Java 8 handle it?</b>
     * <p>Answer:
     * - The diamond problem occurs when a class implements multiple interfaces that have a common default method
     * - Java 8 requires the implementing class to override the conflicting method
     * - The class can choose which default implementation to use or provide its own
     * - This resolution is done at compile-time
     * 
     * <p><b>4. What is the difference between abstract class and interface after Java 8?</b>
     * <p>Answer:
     * - Abstract classes can have constructors, interfaces cannot
     * - Abstract classes can have instance variables, interfaces can only have constants (public static final)
     * - A class can implement multiple interfaces but extend only one class
     * - Abstract classes can have state, interfaces cannot
     * - Default methods in interfaces are public by default, abstract class methods can have any access modifier
     * 
     * <p><b>5. Can we override static methods in interfaces?</b>
     * <p>Answer:
     * - No, static methods in interfaces cannot be overridden by implementing classes
     * - They can only be hidden by defining a static method with the same signature in the implementing class
     * - Static methods in interfaces are not inherited by implementing classes
     * - They can only be called using the interface name (InterfaceName.staticMethod())
     */
}
