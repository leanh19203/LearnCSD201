
package AVLTree;


public class Car {
    String brand;String color; double price;

    public Car(String brand, String color, double price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "(" + brand + "," + color + "," + price + ") ";
    }
    
}
