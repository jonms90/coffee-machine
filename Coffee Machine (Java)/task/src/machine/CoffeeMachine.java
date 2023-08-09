package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static final int WATER_PER_CUP = 200;
    private static final int MILK_PER_CUP = 50;
    private static final int COFFEE_BEANS_PER_CUP = 15;
    private static final int COST_ESPRESSO = 4;
    private static final int COST_LATTE = 7;
    private static final int COST_CAPPUCCINO = 6;

    private static final Scanner _scanner = new Scanner(System.in);

    private int _mlWaterAvailable;
    private int _mlMilkAvailable;
    private int _gramsBeansAvailable;
    private int _money;
    private int _disposableCupsAvailable;

    public CoffeeMachine(int mlWater, int mlMilk, int gramsBeans, int disposableCupsAvailable, int money){
        _mlWaterAvailable = mlWater;
        _mlMilkAvailable = mlMilk;
        _gramsBeansAvailable = gramsBeans;
        _disposableCupsAvailable = disposableCupsAvailable;
        _money = money;
    }

    public static void main(String[] args) {
        /*
        int initialWater = promptInteger("Write how many ml of water the coffee machine has:", scanner);
        int initialMilk = promptInteger("Write how many ml of milk the coffee machine has:", scanner);
        int initialBeans = promptInteger("Write how many grams of coffee beans the coffee machine has:", scanner);
        int cups = promptInteger("Write how many cups of coffee you will need:", scanner);
        */
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120,9 ,550);
        String input;

        do{
            input = prompt("Write action (buy, fill, take, remaining, exit):");
            switch (input) {
                case "buy" -> coffeeMachine.buy();
                case "fill" -> coffeeMachine.fill();
                case "take" -> coffeeMachine.take();
                case "remaining" -> coffeeMachine.displaySupplies();
            };
        } while(!"exit".equals(input));

        // String available = coffeeMachine.checkAvailability(cups);
        // System.out.println(available);

        /*
        Ingredients ingredients = coffeeMachine.getRequiredIngredientsForCups(cups);
        System.out.printf("For %d cups of coffee you wil need:%n", cups);
        System.out.println(ingredients.printWater());
        System.out.println(ingredients.printMilk());
        System.out.println(ingredients.printCoffeeBeans());
        */

        //makeCoffee();
    }

    private void take() {
        System.out.printf("%nI gave you $%d%n%n", _money);
        _money = 0;
    }

    private void fill() {
        _mlWaterAvailable += promptInteger("Write how many ml of water you want to add:");
        _mlMilkAvailable += promptInteger("Write how many ml of milk you want to add:");
        _gramsBeansAvailable += promptInteger("Write how many grams of coffee beans you want to add:");
        _disposableCupsAvailable += promptInteger("Write how many disposable cups you want to add:");
    }

    private void buy() {
        String order = promptf("%nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:%n");
        if("back".equals(order)){
            return;
        }

        try{
            switch (Integer.parseInt(order)){
                case 1 -> makeEspresso();
                case 2 -> makeLatte();
                case 3 -> makeCappuccino();
            }
        } catch(NumberFormatException ignored){}
    }

    private void makeEspresso() {
        makeBeverage(250, 0, 16, COST_ESPRESSO);
    }

    private void makeLatte() {
        makeBeverage(350, 75, 20, COST_LATTE);
    }

    private void makeCappuccino() {
        makeBeverage(200, 100, 12, COST_CAPPUCCINO);
    }

    private void makeBeverage(int mlWater, int mlMilk, int gramsBeans, int cost) {
        if(_mlWaterAvailable < mlWater){
            System.out.printf("Sorry, not enough water!%n%n");
            return;
        }

        if(_mlMilkAvailable < mlMilk){
            System.out.printf("Sorry, not enough milk!%n%n");
            return;
        }

        if(_gramsBeansAvailable < gramsBeans){
            System.out.printf("Sorry, not enough coffee beans!%n%n");
            return;
        }

        if(_disposableCupsAvailable < 1){
            System.out.printf("Sorry, not enough disposable cups!%n%n");
            return;
        }

        System.out.printf("I have enough resources, making you a coffee!%n%n");
        _mlWaterAvailable -= mlWater;
        _mlMilkAvailable -= mlMilk;
        _gramsBeansAvailable -= gramsBeans;
        _disposableCupsAvailable--;
        _money += cost;
    }

    private void displaySupplies() {
        System.out.println();
        System.out.println("The coffe machine has:");
        System.out.printf("%d ml of water%n", _mlWaterAvailable);
        System.out.printf("%d ml of milk%n", _mlMilkAvailable);
        System.out.printf("%d g of coffee beans%n", _gramsBeansAvailable);
        System.out.printf("%d disposable cups%n", _disposableCupsAvailable);
        System.out.printf("$%d of money%n", _money);
        System.out.println();
    }

    private static String prompt(String prompt) {
        System.out.println(prompt);
        return _scanner.nextLine();
    }

    private static String promptf(String prompt) {
        System.out.printf(prompt);
        return _scanner.nextLine();
    }

    private String checkAvailability(int cups) {
        int maxCupsAvailable = getMaxCupsAvailable();
        if(maxCupsAvailable > cups){
            int extraCups = maxCupsAvailable - cups;
            return String.format("Yes, I can make that amount of coffee (and even %d more than that)", extraCups);
        }
        else if(maxCupsAvailable == cups){
            return "Yes, I can make that amount of coffee";
        }

        return String.format("No, I can make only %d cup(s) of coffee", maxCupsAvailable);
    }

    private int getMaxCupsAvailable() {
        int maxCupsFromWater = _mlWaterAvailable / WATER_PER_CUP;
        int maxCupsFromMilk = _mlMilkAvailable / MILK_PER_CUP;
        int maxCupsFromBeans = _gramsBeansAvailable / COFFEE_BEANS_PER_CUP;
        return Math.min(maxCupsFromWater, Math.min(maxCupsFromMilk, maxCupsFromBeans));
    }

    private static int promptInteger(String x) {
        System.out.println(x);
        return _scanner.nextInt();
    }

    private Ingredients getRequiredIngredientsForCups(int cups) {
        int mlWater = WATER_PER_CUP * cups;
        int mlMilk = MILK_PER_CUP * cups;
        int gramsBeans = COFFEE_BEANS_PER_CUP * cups;
        return new Ingredients(mlWater, mlMilk, gramsBeans);
    }

    private static void makeCoffee() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }
}
