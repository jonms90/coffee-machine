package machine;

public class Display {
    public void display(CoffeeMachineState state) {
        switch (state) {
            case MAIN_MENU -> displayActions();
            case BUYING -> menu();
            case FILLING_WATER -> waterPrompt();
            case FILLING_MILK -> milkPrompt();
            case FILLING_COFFEE_BEANS -> coffeeBeansPrompt();
            case FILLING_DISPOSABLE_CUPS -> disposableCupsPrompt();
        }
    }

    public void supplies(Resources resources) {
        System.out.println();
        System.out.println("The coffe machine has:");
        System.out.printf("%d ml of water%n", resources.getWater());
        System.out.printf("%d ml of milk%n", resources.getMilk());
        System.out.printf("%d g of coffee beans%n", resources.getCoffeeBeans());
        System.out.printf("%d disposable cups%n", resources.getDisposableCups());
        System.out.printf("$%d of money%n", resources.getMoney());
        System.out.println();
    }

    private void waterPrompt() {
        System.out.println("Write how many ml of water you want to add:");
    }

    private void milkPrompt() {
        System.out.println("Write how many ml of milk you want to add:");
    }

    private void coffeeBeansPrompt() {
        System.out.println("Write how many grams of coffee beans you want to add:");
    }

    private void disposableCupsPrompt() {
        System.out.println("Write how many disposable cups you want to add:");
    }

    private static void menu() {
        System.out.printf("%nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:%n");
    }

    private static void displayActions() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    public void deposit(int money) {
        System.out.printf("%nI gave you $%d%n%n", money);
    }

    public void insufficientWater() {
        System.out.printf("Sorry, not enough water!%n%n");
    }

    public void insuffientMilk() {
        System.out.printf("Sorry, not enough milk!%n%n");
    }

    public void insufficientCoffeeBeans() {
        System.out.printf("Sorry, not enough coffee beans!%n%n");
    }

    public void insufficientCups() {
        System.out.printf("Sorry, not enough disposable cups!%n%n");
    }

    public void availableResources() {
        System.out.printf("I have enough resources, making you a coffee!%n%n");
    }
}
