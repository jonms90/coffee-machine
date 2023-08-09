package machine;

public class Resources {
    private int _mlWater;
    private int _mlMilk;
    private int _gramsBeans;
    private int _disposableCups;
    private int _money;

    public Resources(int mlWater, int mlMilk, int gramsBeans, int disposableCups, int money) {
        _mlWater = mlWater;
        _mlMilk = mlMilk;
        _gramsBeans = gramsBeans;
        _disposableCups = disposableCups;
        _money = money;
    }

    public int getWater(){ return _mlWater; }
    public int getMilk(){ return _mlMilk; }
    public int getCoffeeBeans(){ return _gramsBeans; }
    public int getDisposableCups(){ return _disposableCups; }
    public int getMoney(){return _money;}

    public void addMoney(int money){ _money += money; }

    public void fillWater(int water){
        _mlWater += water;
    }

    public void fillMilk(int milk){
        _mlMilk += milk;
    }

    public void fillCoffeeBeans(int coffeeBeans){
        _gramsBeans += coffeeBeans;
    }

    public void fillDisposableCups(int cups){
        _disposableCups += cups;
    }

    public void consumeWater(int water){
        _mlWater -= water;
    }

    public void consumeMilk(int milk){
        _mlMilk -= milk;
    }

    public void consumeCoffeeBeans(int coffeeBeans){
        _gramsBeans -= coffeeBeans;
    }

    public void consumeCup(){
        _disposableCups--;
    }

    public void TakeMoney() { _money = 0; }
}
