package market.example;

import market.example.food.*;
import market.example.notFood.Notebook;
import market.example.notFood.Pen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class UMarket {

    private final Collection<Thing> things;

    public UMarket() {
        things = new ArrayList<>();
        initializeThings();
    }

    private void initializeThings() {
        things.add(new Pen());
        things.add(new Notebook());

        things.add(new Chicken());
        things.add(new Fruit());
        things.add(new OliveOil());

        things.add(new BalykCheese());
        things.add(new Crisps());
        things.add(new ChocolateBar());

        things.add(new DumplingBerries());
        things.add(new DumplingsMeat());
        things.add(new Cheburek());

    }

    public <T extends Thing> void printThings(Class<T> clazz) {
        int[ ] index = {1};
        things.stream()
                .filter(clazz::isInstance)
                .forEach(thing -> {
                    if (Food.class.isAssignableFrom(thing.getClass()))
                    {
                        Food food = (Food) thing;
                        System.out.printf("[%d] %s = Углеводы: %s, Белки: %s, Жиры: %s\n"
                                , index[0]++, thing.getName()
                                , food.getCarbohydrates() ? "Да" : "Нет"
                                , food.getProteins() ? "Да" : "Нет"
                                , food.getFats() ? "Да" : "Нет");
                    }else{
                        System.out.printf("[%d] %s\n", index[0]++, thing.getName());
                    }
                });
    }

    public <T extends Thing> Collection<T> getThings(Class<T> clazz) {

        return things.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    public <T extends Thing> T getThingByIndex(Class<T> clazz, int index) {
        AtomicInteger counter = new AtomicInteger(1);
        return things.stream()
                .filter(clazz::isInstance)
                .filter(thing -> index == counter.getAndIncrement())
                .map(clazz::cast)
                .findFirst()
                .orElse(null);
    }

}
