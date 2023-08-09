package machine;

public class InputHandler {

    private final Display _display;

    public InputHandler(Display display){
        _display = display;
    }

    public CoffeeMachineState handle(String input, Resources resources, CoffeeMachineState state) {
        return switch(state){
            case MAIN_MENU -> handleMainMenu(input, resources);
            case BUYING -> handleBuying(input, resources);
            case FILLING_WATER -> handleFillingWater(input, resources);
            case FILLING_MILK -> handleFillingMilk(input, resources);
            case FILLING_COFFEE_BEANS -> handleFillingCoffeeBeans(input, resources);
            case FILLING_DISPOSABLE_CUPS -> handleFillingDisposableCups(input, resources);
        };
    }

    private CoffeeMachineState handleBuying(String input, Resources resources) {
        if("back".equals(input)){
            return CoffeeMachineState.MAIN_MENU;
        }
        else{
            try{
                var options = CoffeeSelection.values();
                CoffeeSelection selectedCoffee = options[Integer.parseInt(input)];
                switch (selectedCoffee){
                    case ESPRESSO -> sellEspresso(resources);
                    case LATTE -> sellLatte(resources);
                    case CAPPUCCINO -> sellCappuccino(resources);
                }

                return CoffeeMachineState.MAIN_MENU;
            } catch(NumberFormatException ignored){
                return CoffeeMachineState.BUYING;
            }
        }
    }

    private CoffeeMachineState handleMainMenu(String input, Resources resources) {
        switch (input) {
            case "buy" -> {return CoffeeMachineState.BUYING;}
            case "fill" -> {return CoffeeMachineState.FILLING_WATER;}
            case "take" -> {
                take(resources);
                return CoffeeMachineState.MAIN_MENU;
            }
            case "remaining" -> {
                _display.supplies(resources);
                return CoffeeMachineState.MAIN_MENU;
            }
            default -> {return CoffeeMachineState.MAIN_MENU;}
        }
    }

    private CoffeeMachineState handleFillingWater(String input, Resources resources) {
        try{
            int water = Integer.parseInt(input);
            resources.fillWater(water);
            return CoffeeMachineState.FILLING_MILK;
        } catch(NumberFormatException ignored){
            return CoffeeMachineState.FILLING_WATER;
        }
    }

    private CoffeeMachineState handleFillingMilk(String input, Resources resources) {
        try{
            int milk = Integer.parseInt(input);
            resources.fillMilk(milk);
            return CoffeeMachineState.FILLING_COFFEE_BEANS;
        } catch(NumberFormatException ignored){
            return CoffeeMachineState.FILLING_MILK;
        }
    }

    private CoffeeMachineState handleFillingCoffeeBeans(String input, Resources resources) {
        try{
            int beans = Integer.parseInt(input);
            resources.fillCoffeeBeans(beans);
            return CoffeeMachineState.FILLING_DISPOSABLE_CUPS;
        } catch(NumberFormatException ignored){
            return CoffeeMachineState.FILLING_COFFEE_BEANS;
        }
    }

    private CoffeeMachineState handleFillingDisposableCups(String input, Resources resources) {
        try{
            int cups = Integer.parseInt(input);
            resources.fillDisposableCups(cups);
            return CoffeeMachineState.MAIN_MENU;
        } catch(NumberFormatException ignored){
            return CoffeeMachineState.FILLING_DISPOSABLE_CUPS;
        }
    }

    private void take(Resources resources) {
        _display.deposit(resources.getMoney());
        resources.TakeMoney();
    }

    private void sellEspresso(Resources resources) {
        makeBeverage(resources, 250, 0, 16, CoffeeMenu.COST_ESPRESSO);
    }

    private void sellLatte(Resources resources) {
        makeBeverage(resources,350, 75, 20, CoffeeMenu.COST_LATTE);
    }

    private void sellCappuccino(Resources resources) {
        makeBeverage(resources,200, 100, 12, CoffeeMenu.COST_CAPPUCCINO);
    }

    private void makeBeverage(Resources resources, int mlWater, int mlMilk, int gramsBeans, int cost) {
        if(resources.getWater() < mlWater){
            _display.insufficientWater();
            return;
        }

        if(resources.getMilk() < mlMilk){
            _display.insuffientMilk();
            return;
        }

        if(resources.getCoffeeBeans() < gramsBeans){
            _display.insufficientCoffeeBeans();
            return;
        }

        if(resources.getDisposableCups() < 1){
            _display.insufficientCups();
            return;
        }

        _display.availableResources();
        consumeResources(resources, mlWater, mlMilk, gramsBeans);
        resources.addMoney(cost);
    }

    private void consumeResources(Resources resources, int mlWater, int mlMilk, int gramsBeans) {
        resources.consumeWater(mlWater);
        resources.consumeMilk(mlMilk);
        resources.consumeCoffeeBeans(gramsBeans);
        resources.consumeCup();
    }
}
