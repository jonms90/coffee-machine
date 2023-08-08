package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        System.out.println("Write how many cups of coffee you will need:");
        Scanner scanner = new Scanner(System.in);
        int cups = scanner.nextInt();

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Ingredients ingredients = coffeeMachine.getRequiredIngredientsForCups(cups);
        System.out.printf("For %d cups of coffee you wil need:%n", cups);
        System.out.println(ingredients.getWater());
        System.out.println(ingredients.getMilk());
        System.out.println(ingredients.getCoffeeBeans());
        //makeCoffee();
    }

    private Ingredients getRequiredIngredientsForCups(int cups) {
        int mlWater = 200 * cups;
        int mlMilk = 50 * cups;
        int gramsBeans = 15 * cups;
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
