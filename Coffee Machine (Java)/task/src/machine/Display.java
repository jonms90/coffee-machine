package machine;

public class Display {
    public void display(CoffeeMachineState state) {
        switch (state) {
            case MAIN_MENU -> displayActions();
            case BUYING -> displayMenu();
            case FILLING_WATER -> displayWaterPrompt();
            case FILLING_MILK -> displayMilkPrompt();
            case FILLING_COFFEE_BEANS -> displayCoffeeBeansPrompt();
            case FILLING_DISPOSABLE_CUPS -> displayDisposableCupsPrompt();
        };
    }

    public void displaySupplies(Resources resources) {
        System.out.println();
        System.out.println("The coffe machine has:");
        System.out.printf("%d ml of water%n", resources.getWater());
        System.out.printf("%d ml of milk%n", resources.getMilk());
        System.out.printf("%d g of coffee beans%n", resources.getCoffeeBeans());
        System.out.printf("%d disposable cups%n", resources.getDisposableCups());
        System.out.printf("$%d of money%n", resources.getMoney());
        System.out.println();
    }

    private void displayWaterPrompt() {
        System.out.println("Write how many ml of water you want to add:");
    }

    private void displayMilkPrompt() {
        System.out.println("Write how many ml of milk you want to add:");
    }

    private void displayCoffeeBeansPrompt() {
        System.out.println("Write how many grams of coffee beans you want to add:");
    }

    private void displayDisposableCupsPrompt() {
        System.out.println("Write how many disposable cups you want to add:");
    }

    private static void displayMenu() {
        System.out.printf("%nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:%n");
    }

    private static void displayActions() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }
}
