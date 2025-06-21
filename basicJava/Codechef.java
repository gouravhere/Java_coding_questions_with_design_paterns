package basicJava;

//Update the '_' to solve the problem
class Food {
 String name;
 int calories;

 Food(String foodName, int foodCalories) {
     // Assigning the values of foodName, foodCalories to the name and calories variable
     name = foodName;
     calories = foodCalories;
 }

 void display() {
     System.out.println("Name: " + name);
     System.out.println("Calories: " + calories);
 }
}

class Fruit extends Food {
 String vitaminContent;

 Fruit(String fruitName, int fruitCalories, String fruitVitaminContent) {
     // Calling the superclass constructor using super to assign values to the variables
     // The super keyword is used to:
     // invoke the superclass(parent class) constructor or access it's members (methods and variables).
     super(fruitName, fruitCalories);
     vitaminContent = fruitVitaminContent;
 }

 void display() {
     // Overriding the display method in the superclass Food
     // to include the vitamin content of the fruit
     System.out.println("Name: " + name);
     System.out.println("Calories: " + calories);
     System.out.println("Vitamin Content: " + vitaminContent);
 }
}

class FastFood extends Food {
 double fatPercentage;

 FastFood(String fastFoodName, int fastFoodCalories, double fastFoodFatPercentage) {
     super(fastFoodName, fastFoodCalories);
     fatPercentage = fastFoodFatPercentage;
 }

 void display() {
     System.out.println("Name: " + name);
     System.out.println("Calories: " + calories);
     System.out.println("Fat Percentage: %" + fatPercentage);
 }
}

class Codechef {
 public static void main(String[] args) {
     Fruit fruit = new Fruit("Apple", 95, "Vitamin C");
     fruit.display(); 
     System.out.println();

     FastFood fastFood = new FastFood("Burger", 800, 45.6);
     fastFood.display();
 }
}