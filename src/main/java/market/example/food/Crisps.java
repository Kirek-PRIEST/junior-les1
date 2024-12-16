package market.example.food;

public class Crisps implements Snack {
    @Override
    public boolean getFats() {
        return true;
    }

    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Чипсы";
    }
}
