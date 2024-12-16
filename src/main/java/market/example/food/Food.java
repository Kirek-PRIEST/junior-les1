package market.example.food;

import market.example.Thing;

public interface Food extends Thing {
    boolean getFats();
    boolean getProteins();
    boolean getCarbohydrates();
}
