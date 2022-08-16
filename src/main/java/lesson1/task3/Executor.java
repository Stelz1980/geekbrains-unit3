package lesson1.task3;

import lesson1.task3.exceptions.FruitException;
import lesson1.task3.fruits.Apple;
import lesson1.task3.fruits.Fruit;
import lesson1.task3.fruits.GoldenApple;
import lesson1.task3.fruits.Orange;

public class Executor {


    public static void main(String[] args) throws FruitException {
        Box<Orange> boxOrange = new Box<>();
        Box<Apple> boxApple1 = new Box<>();
        Box<Apple> boxApple = new Box<>();
        Box<GoldenApple> boxGoldenApple = new Box<>();

        boxOrange.addFruits(new Orange(), new Orange());
        boxApple1.addFruits(new Apple(), new Apple(), new Apple());
        boxApple.addFruits(new Apple(), new Apple(), new Apple());
        boxApple.addFruits(new Apple());
        boxGoldenApple.addFruits(new GoldenApple(), new GoldenApple(), new GoldenApple());

        System.out.println(boxApple1.getWeight());
        System.out.println(boxApple.getWeight());
        System.out.println(boxOrange.getWeight());
        System.out.println(boxGoldenApple.getWeight());
        System.out.println("---------------");

        boxApple1.removeFruits(new Apple(), new Apple());
        System.out.println(boxApple1.getWeight());
        System.out.println("---------------");

        moveFruitsFromOneToAnotherBox(boxApple, boxApple1);
        System.out.println(boxApple1.getWeight());
        System.out.println(boxApple.getWeight());
        System.out.println("---------------");
    }

    private static <T extends Fruit> void moveFruitsFromOneToAnotherBox(Box<T> from, Box<T> to) throws FruitException {
        for (T fruit : from.getFruits()) {
            to.addFruits(fruit);
        }
        from.getFruits().clear();
    }
}
