package market.example;

import market.example.food.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart<T extends Food> {
    UMarket market;
    Class<T> clazz;
    Collection<T> foodstuff;

    public Cart( Class<T> clazz, UMarket market) {
        this.market = market;
        this.clazz = clazz;
        this.foodstuff = new ArrayList<>();

    }



    public Collection<T> getFoodstuff() {
        return foodstuff;
    }

    public void printFoodstuff() {
        AtomicInteger counter = new AtomicInteger(1);
        foodstuff.forEach(food -> {
            System.out.printf("[%d] %s (Белки %s, Жиры %s, Углеводы %s\n",
                    counter.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет");
        });
    }

    public void cartBalancing() {
        boolean proteins = false;
        boolean fats = false;
        boolean carbohydrates = false;


        for (var food : foodstuff) {
            if (!proteins && food.getProteins())
                proteins = true;
            else if (!fats && food.getFats())
                fats = true;
            else if (!carbohydrates && food.getCarbohydrates())
                carbohydrates = true;
            if (proteins && fats && carbohydrates)
                break;
        }

        if (proteins && fats && carbohydrates){
            System.out.println("Корзина уже сбалансированна по БЖУ");
            return;
        }
        for (var thing : market.getThings(Food.class)){
            if (!proteins && thing.getProteins()){
                proteins = true;
                foodstuff.add((T)thing);
            }
            else  if (!fats && thing.getFats()){
                fats = true;
                foodstuff.add((T)thing);
            }
            else if (!carbohydrates && thing.getCarbohydrates()){
                carbohydrates = true;
                foodstuff.add((T)thing);
            }
            if (proteins && fats && carbohydrates){
                break;
            }
        }
        if ((proteins && fats && carbohydrates))
            System.out.println("Корзина сбалансированна по БЖУ");
        else
            System.out.println("Нвозможно сбалансировать корзину по БЖУ");
    }


}
