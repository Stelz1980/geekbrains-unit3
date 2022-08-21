package lesson1.task3;

import lesson1.task3.exceptions.FruitException;
import lesson1.task3.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits = new ArrayList<>();

    public void addFruits(T... setFruits) {
        fruits.addAll(List.of(setFruits));
    }

    public List<T> getFruits() {
        return fruits;
    }

    public void removeFruits(T... setFruits) throws FruitException {
        for (T fruit : setFruits) {
            if (fruits.size() > 0) {
                fruits.remove(fruits.size() - 1);
            } else {
                throw new FruitException("Фруктов не хватает");
            }
        }
    }

    public float getWeight() {
        return fruits.stream().map(Fruit::getWeight).reduce(0f, Float::sum);
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }
}
