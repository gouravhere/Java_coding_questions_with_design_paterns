# Java Interview Questions

## 1. Constructors in Java
##test
**Q:** What are constructors? How do they differ from other methods of the class? Can we invoke one constructor from another constructor? And can we invoke the super class's constructor from the child class constructor?

**A:** 
A constructor is a special method used to initialize objects when they are created. Key characteristics:
- Has the same name as the class
- No return type (not even void)
- Automatically called when an object is instantiated
- Can be overloaded (multiple constructors with different parameters)

**Invoking one constructor from another (Constructor Chaining):**
```java
class Accord {
    Accord() {
        this(10); // Calls the parameterized constructor
    }
    
    Accord(int x) {
        // Constructor implementation
    }
}
```

**Invoking superclass constructor:**
```java
class Accord extends Honda {
    Accord() {
        super(x); // Calls the parent class constructor
    }
}
```

---

## 2. Method Overloading vs Method Overriding

**Q:** What is method overloading and method overriding? What are the key differences?

**A:**

### Method Overloading (Compile-time Polymorphism)
- Multiple methods with same name but different parameters in the same class
- Also called compile-time polymorphism
- Return type can be same or different
- Must have different parameter lists

### Method Overriding (Runtime Polymorphism)
- Redefining parent class method in child class with same signature
- Also called runtime polymorphism
- Used for implementing interface/abstract class methods

**Example of Method Overriding:**
```java
class A {
    void compute() { /* Implementation */ }
}

class B extends A {
    @Override
    void compute() { /* New implementation */ }
}
```

---

## 3. final, finally, and finalize

**Q:** What are the usages or differences between final, finally, and finalize?

**A:**

### final
- **Variable:** Makes variable constant (cannot be reassigned)
- **Method:** Prevents method from being overridden
- **Class:** Prevents class from being inherited

### finally
- Block that always executes after try-catch
- Used for cleanup code (closing resources)
- Executes even if exception occurs

### finalize()
- Method called by garbage collector before object is destroyed
- Not reliable for resource cleanup
- Deprecated in Java 9+

**Example of try-finally:**
```java
try {
    // Code that might throw exception
} finally {
    // Cleanup code
}
```

---

## 4. Generics and Type Erasure

**Q:** What are Generics and what is Type Erasure?

**A:**

### Generics
- Introduced in Java 5
- Provides type safety at compile time
- Eliminates need for type casting

**Example:**
```java
List<Integer> numbers = new ArrayList<>();
numbers.add(1);
// numbers.add("text"); // Compile-time error
```

### Type Erasure
- Process where generic type information is removed during compilation
- For backward compatibility with pre-Java 5 code
- All generic types become `Object` at runtime

---

## 5. == vs equals()

**Q:** What's the difference between == and equals() when comparing objects?

**A:**

### == Operator
- Compares object references (memory addresses)
- For primitives, compares values
- Returns `true` only if both references point to same object

### equals() Method
- Meant for content comparison
- Default implementation in Object class uses ==
- Should be overridden for meaningful comparison
- Already overridden for String, Wrapper classes, etc.

**Example:**
```java
String s1 = new String("hello");
String s2 = new String("hello");

System.out.println(s1 == s2);      // false
System.out.println(s1.equals(s2)); // true
```

---

## 6. Class Loaders in Java

**Q:** What are class loaders and how does class loading work in Java?

**A:**

### Class Loader Hierarchy
1. **Bootstrap ClassLoader**
   - Loads core Java classes (rt.jar)
   - Written in native code

2. **Extension ClassLoader**
   - Child of Bootstrap
   - Loads from JRE/lib/ext

3. **System/Application ClassLoader**
   - Loads from classpath
   - Loads application classes

### Key Points
- Follows delegation model
- Child first asks parent to load class
- Custom class loaders possible
- `Class.forName()` for dynamic loading

---

## 7. Custom Annotations

**Q:** How to create a custom annotation?

**A:**

### Basic Annotation
```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
    String value() default "";
    int count() default 0;
}
```

### Usage
```java
@MyAnnotation(value = "test", count = 1)
public void myMethod() {
    // Method implementation
}
```

---

## 8. String Classes in Java

**Q:** What are the different String classes in Java?

**A:**

### String
- Immutable
- Thread-safe
- String pooling for literals

### StringBuffer
- Mutable
- Thread-safe (synchronized)
- Slower than StringBuilder

### StringBuilder
- Mutable
- Not thread-safe
- Faster than StringBuffer

**Example:**
```java
String str = "Hello";
StringBuffer sbf = new StringBuffer("Hello");
StringBuilder sbd = new StringBuilder("Hello");
```

---

## 9. Thread Creation

**Q:** What are the different ways to create a thread?

**A:**

### 1. Extending Thread class
```java
class MyThread extends Thread {
    public void run() {
        // Thread logic
    }
}
```

### 2. Implementing Runnable
```java
class MyRunnable implements Runnable {
    public void run() {
        // Thread logic
    }
}
```

### 3. Using Executor Framework
```java
ExecutorService executor = Executors.newFixedThreadPool(10);
executor.submit(() -> {
    // Task to execute
});
```

---

## 10. Functional Interfaces

**Q:** What are Functional Interfaces?

**A:**
- Interface with exactly one abstract method
- Can have multiple default/static methods
- Can be implemented using lambda expressions
- `@FunctionalInterface` annotation is optional but recommended

**Example:**
```java
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
    
    default void defaultMethod() {
        // Default implementation
    }
}

// Usage
Greeting greet = name -> System.out.println("Hello " + name);
```

---

## 11. Lambda Expressions

**Q:** What are Lambda Expressions?

**A:**
- Introduced in Java 8
- Anonymous functions
- Enable functional programming
- Simplify code

**Example:**
```java
// Before Java 8
new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("Running in a thread");
    }
}).start();

// With Lambda
new Thread(() -> System.out.println("Running in a thread")).start();
```

---

## 12. Predicates

**Q:** What are Predicates?

**A:**
- Functional interface that takes one argument and returns boolean
- Part of `java.util.function` package
- Used for filtering in streams

**Example:**
```java
Predicate<String> isLong = s -> s.length() > 5;
System.out.println(isLong.test("Hello"));  // false
System.out.println(isLong.test("Welcome")); // true
```

---

## 13. Streams API

**Q:** What are Streams in Java?

**A:**
- Introduced in Java 8
- Process collections in a declarative way
- Supports functional-style operations
- Lazy evaluation
- Can be parallelized

**Example:**
```java
List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");

// Filter and print names starting with 'A'
names.stream()
     .filter(name -> name.startsWith("A"))
     .forEach(System.out::println);

// Calculate total length of all names
int totalLength = names.stream()
                      .mapToInt(String::length)
                      .sum();
```

---

*Note: This document covers the questions from the original file in a structured markdown format. Each section includes code examples and clear explanations.*
