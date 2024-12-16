package market.example.food;

public class Chicken implements HealthFood {
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
        return "Курица";
    }
}
