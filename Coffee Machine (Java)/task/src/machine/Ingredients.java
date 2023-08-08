package machine;

public class Ingredients {

    private final int _mlWater;
    private final int _mlMilk;
    private final int _gramsBeans;

    public Ingredients(int mlWater, int mlMilk, int gramsBeans) {
        _mlWater = mlWater;
        _mlMilk = mlMilk;
        _gramsBeans = gramsBeans;
    }

    public String getWater() {
        return String.format("%d ml of water", _mlWater);
    }

    public String getMilk() {
        return String.format("%d ml of milk", _mlMilk);
    }

    public String getCoffeeBeans() {
        return String.format("%d g of coffee beans", _gramsBeans);
    }
}
