package market.example.food;

public class DumplingBerries implements SemiFinishedFood {
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
        return "Замороженные ягоды";
    }
}
