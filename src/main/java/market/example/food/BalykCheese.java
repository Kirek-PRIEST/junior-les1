package market.example.food;

public class BalykCheese implements Snack {
    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getProteins() {
        return true;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Сыр-балык";
    }
}
