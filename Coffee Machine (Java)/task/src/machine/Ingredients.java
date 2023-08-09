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

    public int getWater(){ return _mlWater; };
    public int getMilk(){ return _mlMilk; };
    public int getCoffeeBeans(){ return _gramsBeans; };

    public String printWater() {
        return String.format("%d ml of water", _mlWater);
    }

    public String printMilk() {
        return String.format("%d ml of milk", _mlMilk);
    }

    public String printCoffeeBeans() {
        return String.format("%d g of coffee beans", _gramsBeans);
    }
}
