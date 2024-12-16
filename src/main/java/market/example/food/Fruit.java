package market.example.food;

public class Fruit implements HealthFood {
    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return true;
    }

    @Override
    public String getName() {
        return "Фрукт";
    }
}
